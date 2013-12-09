package client;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import client.GameConstants;



public class clientUI extends JPanel implements GameConstants,MouseMotionListener {
    JLabel label;
    
    private int kidRacketY = KID_RACKET_Y_START;
    public int clientRacketY;
    public int x = 60;
    public int y = 110;
    public int startGame = 1;
  
    //Устанавливаем координаты мяча
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
        repaint();
    }
    
    //Сеттер координат ракетки сервера
    public void setCompCoordinates(int YServerRacket) {
    	kidRacketY = YServerRacket;
    	repaint();
    }
    
    //Сеттер координат клиентской ракетки
    public void setClientRacketY(int yCoordinate) {
        this.clientRacketY = yCoordinate;
        
    }
    
    //Получить координаты клиента
    public int getClientRacketY() {
        return clientRacketY;
    }
    
    
    Dimension prefferedSize = new Dimension(TABLE_WIDTH,TABLE_HEIGHT);
    
    
    //Set size of frame
    public Dimension getPrefferedSize() {
        return prefferedSize;
    }
    
    //Constructor instaniates the engine
    clientUI() {
        //clientEngine gameEngine = new clientEngine(this);
        addMouseMotionListener(this);

    }
    
    //Add a panel and layout
    void addPaneltoFrame(Container container) {
        container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
        container.add(this);
        
        label = new JLabel("Press N for a new game, S to serve or Q to quit");
        container.add(label);
    }
    
    //Paint all graphics
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // paint the table green
        g.setColor(Color.GREEN);
        g.fillRect(0,0,TABLE_WIDTH,TABLE_HEIGHT);
        
        // paint the right racket
        g.setColor(Color.yellow);
        g.fillRect(KID_RACKET_X_START,kidRacketY,5,30);
       
        // paint the left racket
        g.setColor(Color.blue);
        g.fillRect(ComputerRacketX,clientRacketY,5,30);
        
        // Draw the white lines on the table
        g.setColor(Color.white);
        g.drawRect(10,10,300,200);
        g.drawLine(160,10,160,210);
        
         
        //Display the ball
        g.setColor(Color.red);
        g.fillOval(x,y,XSIZE,YSIZE);
        
        requestFocus();
        
        }
    
   
    
    
    //Устанавливаем счет игры
    public void setLabelText(String str) {
        label.setText(str);
        repaint();
    }
    
    
    
    
    public static void main(String[] args) {
        JFrame f = new JFrame("Ping Pong Green Table");
        
        //cross at window corner
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        clientUI table = new clientUI();
        table.addPaneltoFrame(f.getContentPane());
        
        //size and visible
        f.setBounds(0, 0, 400,300);
        f.setVisible(true);
        
        BufferedReader readIn = null;
    	OutputStream out = null;
    	Socket client = null;
        
        try {
        	
        	while(true) {
        	//Инициализируем клиентский сокет 
    		client = new Socket("localhost",3000);
    		//System.out.println("Socket: " + client);
    		
    		//Получаем потоки 
    		readIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
    		out = client.getOutputStream();
    		
    		
    		//Отправляем координаты ракетки 
    		out.write(table.clientRacketY);
    		
    		//Получаем команду начала игры
    		table.startGame = readIn.read();
    		
    		//Получаем координаты рокетки сервера
    		table.setCompCoordinates(readIn.read());
    		//Получаем координаты мяча
    		table.setCoordinates(readIn.read(), readIn.read());
    		//Получаем счет игры
    		//table.label.setText(readIn.readLine());
    		if(table.startGame == 0) {
    			break;
    		}
    			
    		}
    		
    	} catch (UnknownHostException e1) {
    		System.out.println("Проверьте соединение");
    		
    	} catch (IOException e1) {
    		System.out.println("Проверьте сокет");
    	} finally {
    		try {
    			out.close();
    			readIn.close();
    			client.close();
    		} catch (IOException e2) {
    			System.out.println("Проверьте закрытие соединения");
    		}
    		
    	}
        
        
    }

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int mouseY = e.getY();
        if (mouseY < clientRacketY && clientRacketY > TABLE_TOP){
        	clientRacketY -= RACKET_INCREMENT;
        }
        else if (clientRacketY < TABLE_BOTTOM) {
        	clientRacketY += RACKET_INCREMENT;
        }
        
        // Set the new position of the racket table class
        this.setClientRacketY(clientRacketY);
        this.repaint();
        
		
	}
    
}