import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.Date;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.SwingConstants;
//import javax.swing.event.AncestorListener;
import javax.swing.JPanel;
import java.awt.Color;


//import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class MyGame extends JFrame implements ActionListener{

    JLabel heading,clockLabel;
    Font font= new Font(" ",Font.BOLD,40);
    JPanel mainPanel;

    JButton[] btns= new JButton[9];


    //game instance variable..
    int gameChances[] = {2,2,2,2,2,2,2,2,2};
    int activePlayer = 0;
    int wps[] [] = {

        {0,1,2},
        {3,4,5},
        {6,7,8},
        {0,3,6},
        {1,4,7},
        {2,5,8},
        {0,4,8},
        {2,4,6},
        

    };
    int winner = 2;

    boolean gameOver = false;
    
    MyGame(){
        System.out.println("creating instance of game...");
        setTitle("My Tic Tac Toe Game..");
        setSize(850,850);
        ImageIcon icon = new ImageIcon("C:\\Users\\HOME\\Desktop\\Tic Tac Toe\\1267357-200.png ");
        setIconImage(icon.getImage());


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        createGUI();

    }

    private void createGUI() {
        this.getContentPane().setBackground(Color.decode("#2196f3"));
        this.setLayout(new BorderLayout());

        //north heading/...

        heading= new JLabel("TIC TAC TOE");
        heading.setFont(font);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setForeground(Color.white);
       heading.setIcon(new ImageIcon("C:\\Users\\HOME\\Desktop\\Tic Tac Toe\\icon.jpeg"));
        heading.setHorizontalTextPosition(SwingConstants.CENTER);
        heading.setVerticalTextPosition(SwingConstants.BOTTOM);




        this.add(heading,BorderLayout.NORTH);
        
        //creating object of JLabel for clock
        clockLabel = new JLabel("CLOCK");
        clockLabel.setFont(font);
        clockLabel.setForeground(Color.white);
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(clockLabel,BorderLayout.SOUTH);


        Thread t = new Thread(){

            public void run (){

             try{

                while(true){

                    String datetime= new Date ().toLocaleString();
                    clockLabel.setText(datetime);
                    

                    Thread.sleep(1000);
                }

             }
             catch(Exception e){

                e.printStackTrace();

             }
            }
        };
        t.start();


        mainPanel= new JPanel();

        mainPanel.setLayout(new GridLayout(3,3));

        for(int i=1; i<=9; i++){

            JButton btn = new JButton ();
            //btn.setIcon(new ImageIcon("C:\\Users\\HOME\\Desktop\\Tic Tac Toe\\0.jpeg"));
            btn.setBackground(Color.decode("#1600ed"));
            btn.setFont(font);
            mainPanel.add(btn);
            btns [i-1] = btn;
            btn.addActionListener(this);
            btn.setName(String.valueOf(i-1));





        }

        this.add(mainPanel,BorderLayout.CENTER);

        

    }
    @Override

    public void actionPerformed (ActionEvent e){
        JButton currentButton = (JButton)e.getSource();

        String nameStr =currentButton.getName();
        //System.out .println(nameStr);
        int name = Integer.parseInt(nameStr.trim());


        if (gameOver==true){

            JOptionPane.showMessageDialog(this, "game already over");
            return;

        }

         
 
         
          if (gameChances[name]==2)
          {
            if (activePlayer==1){
                currentButton.setIcon(new ImageIcon("C:\\Users\\HOME\\Desktop\\Tic Tac Toe\\1.jpeg"));
                 gameChances[name] = activePlayer;
                activePlayer = 0;
           }
              else{
                currentButton.setIcon(new ImageIcon("C:\\Users\\HOME\\Desktop\\Tic Tac Toe\\0.jpeg"));

                
                gameChances[name] = activePlayer;
                activePlayer = 1;
                
                //JOptionPane.showMessageDialog(this,"position already occupied");
            }

        }
        

    
        

      
    

    
            //find the winner....
        
       
            for(int[]temp: wps){

                if ((gameChances[temp[0]]==gameChances[temp[1]])&& (gameChances[temp[1]]==gameChances[temp[2]]&&gameChances[temp[2]]!=2)){
                     
                    winner = gameChances[temp[0]];
                    gameOver = true;

                    JOptionPane.showMessageDialog(null,"player"+winner+" has won the game.." );
                    int i = JOptionPane.showConfirmDialog(this, "do you want to play more");

                    if(i==0){
                        this.setVisible(false);
                        new MyGame();
                    }
                    else if (i==1){

                        System.exit(34234);

                    }
                    else {

                    }
                    System.out.println(i);
                    break;
                 

                }
             
                  //draw logic

                  int c =0;
                  for(int x: gameChances){

                    if (x==2){
                        c++;
                        break;
                    }
                  }

                  if(c==0&&gameOver==false){

                    JOptionPane.showMessageDialog(null,"Its draw..");
                     int i =JOptionPane.showConfirmDialog(this,"Play more??");

                     if (i==0){
                        this.setVisible(false);

                        new MyGame();


                     }
                     else if (i==1){

                        System.exit(1212);
                     }
                     else{


                     }

                     gameOver = true;
                  }


             
    
            }

        }
        
         
    
        
    }



    

            
        
            
       
    

    


    
    

