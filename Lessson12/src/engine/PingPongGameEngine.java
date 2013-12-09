package engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


import model.BallMove;
import ui.PingPongGameTable;
import constants.GameConstants;

public class PingPongGameEngine implements MouseMotionListener,GameConstants, KeyListener
{
    PingPongGameTable table;
    public int kidRacketY = KID_RACKET_Y_START;
    public int computerScore = 0;
    public int kidScore = 0;
    


    public PingPongGameEngine(PingPongGameTable greenTable) {
        table = greenTable;

    }



    @Override
    public void mouseDragged(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int mouseY = e.getY();
        if (mouseY < kidRacketY && kidRacketY > TABLE_TOP){
            kidRacketY -= RACKET_INCREMENT;
        }
        else if (kidRacketY < TABLE_BOTTOM) {
            kidRacketY += RACKET_INCREMENT;
        }
        
        // Set the new position of the racket table class
        table.setKidRacketY(kidRacketY);
        table.repaint();
        
       
        
    }



    @Override
    public void keyPressed(KeyEvent e) {
     int key = e.getKeyCode();
        if(key == e.VK_N) {
            //Запускаем мяч, обнуляем счетчик, ставим ракетки по дефолту.
            table.setLabelText("Score Computer: " + computerScore + " Kid: " + kidScore);
            
            //Поток
            BallMove ball = new BallMove(this,table);
            Thread move = new Thread(ball);
            move.start();
        }
        
        else if(key == e.VK_Q) {
        	computerScore = 0;
        	kidScore = 0;
        	//Устанавливаем параметр для цикла чтения и записи потоков.
            table.setStartGame();
            System.exit(0);
        }
        
        else if(key == e.VK_S) {
        	table.setCoordinates(60, 110);
        	table.setLabelText("Score Computer: " + computerScore + " Kid: " + kidScore);
        }
        
    }



    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

}

