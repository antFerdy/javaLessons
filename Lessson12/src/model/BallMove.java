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

    //Конструктор
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
        
        /*//Движения ракетки компьютера
        ui.setCompCoordinates(yBall);*/
        
        //Отскок от верхней грани
        if(yBall == TABLE_TOP) {
            dy = - dy;
        }
        //Отскок от верхней грани
        else if(yBall == TABLE_BOTTOM) {
            dy = -dy;
        }
        
        //Отбой от правой ракетки
        else if(xBall == KID_RACKET_X_START) {
            
        	//Отбой от ракетки игрока
            if(yBall >= ui.getKidRacketY() && 
            	       yBall <= (ui.getKidRacketY() + RACKET_LENGHT)) {
                dx = -dx;
                
            }
            
            //Поражение игрока
            else {
                // Запоминаем счет
                engine.computerScore +=1;
            	 //Устанавливаем текст и счет
                ui.setLabelText("The computer win. " + "Score Computer: " + engine.computerScore + " Kid: " + engine.kidScore);
                //Прерываем игру
                break;
            }
        }
        
        
      //Отбой от левой ракетки
        else if(xBall == ComputerRacketX) {
            
        	//Отбой от ракетки игрока
            if(yBall < ui.getComRacketY() || yBall > (ui.getComRacketY() + RACKET_LENGHT)) {
               
                // Запоминаем счет
                engine.kidScore +=1;
            	 //Устанавливаем текст и счет
                ui.setLabelText("The user win. " + "Score Computer: " + engine.computerScore + " Kid: " + engine.kidScore);
                //Прерываем игру
                break;
            }
            
            //Поражение игрока
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



