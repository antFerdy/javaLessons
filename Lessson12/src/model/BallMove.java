package model;

import ui.PingPongGameTable;
import constants.GameConstants;
import engine.PingPongGameEngine;

public class BallMove implements Runnable,GameConstants {
    int xBall;
    int yBall;
    int dx = 2;
    int dy = 2;
    PingPongGameEngine engine;
    PingPongGameTable ui;

    //�����������
    public BallMove(PingPongGameEngine engine, PingPongGameTable ui) {
        this.engine = engine;
        this.ui = ui;
        xBall = ui.getXBall();
        yBall = ui.getYBall();
    }
    
    
    @Override
    public void run() {
        while(true) {
        xBall += dx;
        yBall -= dy;
        
        /*//�������� ������� ����������
        ui.setCompCoordinates(yBall);*/
        
        //������ �� ������� �����
        if(yBall == TABLE_TOP) {
            dy = - dy;
        }
        //������ �� ������� �����
        else if(yBall == TABLE_BOTTOM) {
            dy = -dy;
        }
        
        //����� �� ������ �������
        else if(xBall == KID_RACKET_X_START) {
            
        	//����� �� ������� ������
            if(yBall >= ui.getKidRacketY() && 
            	       yBall <= (ui.getKidRacketY() + RACKET_LENGHT)) {
                dx = -dx;
                
            }
            
            //��������� ������
            else {
                // ���������� ����
                engine.computerScore +=1;
            	 //������������� ����� � ����
                ui.setLabelText("The computer win. " + "Score Computer: " + engine.computerScore + " Kid: " + engine.kidScore);
                //��������� ����
                break;
            }
        }
        
        
      //����� �� ����� �������
        else if(xBall == ComputerRacketX) {
            
        	//����� �� ������� ������
            if(yBall < ui.getComRacketY() || yBall > (ui.getComRacketY() + RACKET_LENGHT)) {
               
                // ���������� ����
                engine.kidScore +=1;
            	 //������������� ����� � ����
                ui.setLabelText("The user win. " + "Score Computer: " + engine.computerScore + " Kid: " + engine.kidScore);
                //��������� ����
                break;
            }
            
            //��������� ������
            else {
            	 dx = - dx;
                
            }
        }
        
       

        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ui.setCoordinates(xBall, yBall);
       }  
    }
} 



