import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class TicTacToeApplet extends JApplet implements MouseListener
{
    private static final String PLAYERX = "Player X";
    private static final String PLAYERO = "Player O";
	
	
    private String playerName = PLAYERX;
	
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JButton button4;
    private javax.swing.JButton button5;
    private javax.swing.JButton button6;
    private javax.swing.JButton button7;
    private javax.swing.JButton button8;
    private javax.swing.JButton button9;
    private javax.swing.JButton buttonReset;
    private javax.swing.JButton buttonGenerate;
    private javax.swing.JLabel playerNumber;
    private java.awt.Panel buttonsPanel;
    JButton [] buttons;

    public void init(){
        initComponents();
    }

    private void initComponents(){
        buttonsPanel = new java.awt.Panel();
        button1 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
        button4 = new javax.swing.JButton();
        button5 = new javax.swing.JButton();
        button6 = new javax.swing.JButton();
        button7 = new javax.swing.JButton();
        button8 = new javax.swing.JButton();
        button9 = new javax.swing.JButton();
        buttonReset = new javax.swing.JButton("Reset");
        buttonGenerate = new javax.swing.JButton("Generate move");
        playerNumber = new javax.swing.JLabel(playerName, SwingConstants.CENTER);
	    
        buttons = new JButton[9];
        buttons[0] = button1;
        buttons[1] = button2;
        buttons[2] = button3;
        buttons[3] = button4;
        buttons[4] = button5;
        buttons[5] = button6;
        buttons[6] = button7;
        buttons[7] = button8;
        buttons[8] = button9;
        
        
        for(int i = 0;i<9;i++) {
        	buttons[i].addMouseListener(this);
        }
        buttonReset.addMouseListener(this);
        buttonGenerate.addMouseListener(this);
       /* button1.addMouseListener(this);
        button2.addMouseListener(this);
        button3.addMouseListener(this);
        button4.addMouseListener(this);
        button5.addMouseListener(this);
        button6.addMouseListener(this);
        button7.addMouseListener(this);
        button8.addMouseListener(this);
        button9.addMouseListener(this);*/
    
        Font buttonFont = new Font("Times New Roman", Font.PLAIN, 60);
	    
        
        for(int i = 0;i<9;i++) {
        	buttons[i].setFont(buttonFont);
        }
        
       /* button1.setFont(buttonFont);
        button2.setFont(buttonFont);
        button3.setFont(buttonFont);
        button4.setFont(buttonFont);
        button5.setFont(buttonFont);
        button6.setFont(buttonFont);
        button7.setFont(buttonFont);
        button8.setFont(buttonFont);
        button9.setFont(buttonFont);*/
	    
        buttonsPanel.setLayout(new java.awt.GridLayout(4, 3));
        
        
        for(int i = 0;i<9;i++) {
        	buttonsPanel.add(buttons[i]);
        }
        buttonsPanel.add(buttonReset);
        buttonsPanel.add(buttonGenerate);
        /*buttonsPanel.add(button1);
        buttonsPanel.add(button2);
        buttonsPanel.add(button3);
        buttonsPanel.add(button4);
        buttonsPanel.add(button5);
        buttonsPanel.add(button6);
        buttonsPanel.add(button7);
        buttonsPanel.add(button8);
        buttonsPanel.add(button9);*/
        
        setPlayerName(PLAYERX); 
        buttonsPanel.add(playerNumber);
        
        add(buttonsPanel);
    }
	
    private void setPlayerName(String playerName){
        this.playerName = playerName;
        playerNumber.setText(playerName  + " ,your turn bitch!");
    }
	
    private void reset(){

        for(int i = 0; i < 9; i++) {
        	buttons[i].setText("");
        	buttons[i].setBackground(null);
        }
       
        setPlayerName(PLAYERX);
    }
	
   public void checkForWinner(){
        String [] str = {"OK"};
        
        if(findThreeInARow()){
            String winnerName=(playerName == PLAYERX)?PLAYERO:PLAYERX;
            highlight(Color.green);
            playerNumber.setText(winnerName + " Won!");
         JOptionPane.showOptionDialog(this, winnerName.concat(" won!!! Congratulations!!!"),
        "Congratulations!", JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, str, "OK");
            reset();
        }    
        
    }
    
	
   public void mouseClicked(MouseEvent e) {
       javax.swing.JButton currentButton = (JButton)e.getComponent();
       if (currentButton.getText() == ""){	   
    	   	currentButton.setText("X");
    	   	setPlayerName(PLAYERO);
       }
       
       else if (currentButton.getText() == "Generate move"){
     	  generateMove(9);
        }
       
       else if(currentButton.getText() == "Reset") {
       	reset();
       }
       	
       	
      
       checkForWinner();
   }
    
    
    //Generator of numbers

   private int generate(int limit) {
		Random randoms = new Random();
		int random = randoms.nextInt(limit);
		return random;
	}
	
	//Generator of move
	
	private void generateMove(int limit) {
		int random = generate(limit);
		if(buttons[random].getText() == "") {
			buttons[random].setText("O");
			setPlayerName(PLAYERX);
		}
		else {
			return;
		}
		
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
	
	private void highlight(Color color) {
		if(button1.getText() == button2.getText() && button2.getText() == button3.getText() && button1.getText() != "") {
			button1.setBackground(color);
			button2.setBackground(color);
			button3.setBackground(color);
		}
		
		else if(button4.getText() == button5.getText() && button5.getText() == button6.getText() && button4.getText() != "") {
			button4.setBackground(Color.green);
			button5.setBackground(Color.green);
			button6.setBackground(Color.green);
		}
		
		else if(button7.getText() == button8.getText() && button8.getText() == button9.getText() && button7.getText() != "") {
			button7.setBackground(Color.green);
			button8.setBackground(Color.green);
			button9.setBackground(Color.green);
		}
		
		else if(button1.getText() == button4.getText() && button4.getText() == button7.getText() && button1.getText() != "") {
			button1.setBackground(Color.green);
			button4.setBackground(Color.green);
			button7.setBackground(Color.green);
		}
		
		else if(button2.getText() == button5.getText() && button5.getText() == button8.getText() && button2.getText() != "") {
			button2.setBackground(Color.green);
			button5.setBackground(Color.green);
			button8.setBackground(Color.green);
		}
		
		else if(button3.getText() == button6.getText() && button6.getText() == button9.getText() && button3.getText() != "") {
			button3.setBackground(Color.green);
			button6.setBackground(Color.green);
			button9.setBackground(Color.green);
		}
		
		else if(button1.getText() == button5.getText() && button5.getText() == button9.getText() && button1.getText() != "") {
			button1.setBackground(Color.green);
			button5.setBackground(Color.green);
			button9.setBackground(Color.green);
		}
		
		else if(button3.getText() == button5.getText() && button5.getText() == button7.getText() && button3.getText() != "") {
			button3.setBackground(Color.green);
			button5.setBackground(Color.green);
			button7.setBackground(Color.green);
		}
	}
	
	private boolean findThreeInARow(){
	    if ((button1.getText() == button2.getText() && button2.getText() == button3.getText() && button1.getText() != "") ||
	    	(button4.getText() == button5.getText() && button5.getText() == button6.getText() && button4.getText() != "") || 
	        (button7.getText() == button8.getText() && button8.getText() == button9.getText() && button7.getText() != "") ||
            (button1.getText() == button4.getText() && button4.getText() == button7.getText() && button1.getText() != "") ||
            (button2.getText() == button5.getText() && button5.getText() == button8.getText() && button2.getText() != "") ||
            (button3.getText() == button6.getText() && button6.getText() == button9.getText() && button3.getText() != "") ||
            (button1.getText() == button5.getText() && button5.getText() == button9.getText() && button1.getText() != "") ||
            (button3.getText() == button5.getText() && button5.getText() == button7.getText() && button3.getText() != "")
        )
	        return true;
	    else
	        return false;
    }
}