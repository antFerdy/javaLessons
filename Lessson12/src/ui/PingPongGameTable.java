package ui;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;



import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import constants.GameConstants;
import engine.PingPongGameEngine;


public class PingPongGameTable extends JPanel implements GameConstants {
    JLabel label;
    
    private int kidRacketY = KID_RACKET_X_START;
    private int compRacketY = 100;
    private int x = 60;
    private int y = 110;
    private int startGame = 1;
    
    //cеттер для запуска чтения потоков клиента и сервера 
    public void setStartGame() {
    	startGame = 0;
    }
  
    //Устанавливаем координаты мяча
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
        repaint();
    }
    
    
    //Геттер координат мяча x
    public int getXBall() {
    	return x;
    }
    //Геттер координат  мяча у
    public int getYBall() {
    	return y;
    }
    
    //Устанавливаем координаты клиента
    public void setCompCoordinates(int yBallMove) {
    	compRacketY = yBallMove;
    	repaint();
    }
    
    //Устанавливаем координаты сервера
    public void setKidRacketY(int xCoordinate) {
        this.kidRacketY = xCoordinate;
    }
    
    //Геттер координат ракетки сервера
    public int getKidRacketY() {
        return kidRacketY;
    }
    
    //Геттер координат ракетки клиента
    public int getComRacketY() {
    	return compRacketY;
    }
    
    
    //Устанавливаем счет игры
    public void setLabelText(String str) {
        label.setText(str);
        repaint();
    }
    
    
    Dimension prefferedSize = new Dimension(TABLE_WIDTH,TABLE_HEIGHT);
    
    
    //Set size of frame
    public Dimension getPrefferedSize() {
        return prefferedSize;
    }
    
    //Constructor instaniates the engine
    PingPongGameTable() {
        PingPongGameEngine gameEngine = new PingPongGameEngine(this);
        addMouseMotionListener(gameEngine);
        addKeyListener(gameEngine);
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
        g.fillRect(ComputerRacketX,compRacketY,5,30);
        
        // Draw the white lines on the table
        g.setColor(Color.white);
        g.drawRect(10,10,300,200);
        g.drawLine(160,10,160,210);
        // Display the ball
        g.setColor(Color.red);
        g.fillOval(x,y,XSIZE,YSIZE);
        
        requestFocus();
        
        }
    

    
    
    
    
    public static void main(String[] args) {
        JFrame f = new JFrame("Ping Pong Green Table");
        
        //cross at window corner
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        PingPongGameTable table = new PingPongGameTable();
        table.addPaneltoFrame(f.getContentPane());
        
        //size and visible
        f.setBounds(0, 0, 400,300);
        f.setVisible(true);
        
        //Создаем ссылки на сервер и клиент
        ServerSocket server = null;
        Socket client = null;
        
        //Создаем потоки 
        BufferedReader readIn = null;
        OutputStream out = null;
        
        try {
        	//Инициализируем сервер и сокет
			server = new ServerSocket(3000);
			
			while(true) {
				//Ждем запроса
				client = server.accept();
				
				//Получаем потоки
				readIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
				out = client.getOutputStream();
				
				//Получаем координаты ракетки
				int yCompRacket = readIn.read();
				table.setCompCoordinates(yCompRacket);
				//Отправляем старт игры
				out.write(table.startGame);
				
				//Отправляем координаты своей ракетки
				out.write(table.kidRacketY);
				//Отправляем координаты мяча
				out.write(table.x);
				out.write(table.y);
				//Отправляем счет 
				//out.write((table.label.getText()).getBytes());
				//Отключаем игру при нажатии Q
				if(table.startGame == 0) {
					break;
				}

			}

			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			
			try {
				out.close();
				readIn.close();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			
		}
        

    }

}

