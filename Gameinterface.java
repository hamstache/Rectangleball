package fallingball;

//Author: Josh Moynihan
//Email:  jdmoynihan19@csu.fullerton.edu
//Course: CPSC223J
//
//File name: Gameinterface.java
//Description: This is one module in the Rectangle Ball program.  This module
//defines the user interface.
//
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Timer;


public class Gameinterface extends JFrame
{    JPanel titlepanel;
     JLabel titlelabel;
     
     Graphicalpanel graphicalpanel;
     
     JPanel buttonpanel;
     
     //JButton setspeed;
     JButton gobutton;
     JButton pausebutton;
     JButton resetbutton;
     JButton exitbutton;
     
     JLabel speedlabel;
     JTextField speedinput;
     String speedstring;
     int speed;
     
     JLabel directionindicator;
     JTextField directionoutput;
     
     JLabel coordtitle;
     JLabel xcoord;
     JTextField xoutput;
     private int x;
     JLabel ycoord;
     JTextField youtput;
     private int y;
     
     Timer systemclock;
     Buttonhandlerclass buttonhandler;
     Clockhandlerclass clockhandler;
     //private Timer delayedclosing;
     //private final int length_of_delay = 2500;
     public float clockspeed = 223.1f; //Sets the number of clock tics per second.
     int delayinterval; //The units are ms (milliseconds).
     float millisecondpersecond = 1000.0f;

     public Gameinterface()
         {super("Falling Ball");
          //Do not use FlowLayout when working with Graphical objects.
          //Make 3 panels and place them from top to bottom onto any object of type Gameinterface.
          //Make the 1st panel
          titlelabel = new JLabel("Rectangle Ball by Josh Moynihan");
          titlepanel = new JPanel();
          titlepanel.add(titlelabel);
          add(titlepanel,BorderLayout.NORTH);
          titlepanel.setPreferredSize(new Dimension(1094,25));
          
          //Make the 2nd panel///////////////////////////////////////
          graphicalpanel = new Graphicalpanel();
          graphicalpanel.setBackground(Color.BLUE);
          add(graphicalpanel,BorderLayout.CENTER);
          graphicalpanel.setPreferredSize(new Dimension(1094,620));
          
          
          
          //Make the 3rd panel//////////////////////////////////////
          //buttonhandler = new Buttonhandlerclass();
          //setspeed = new JButton("Submit");
          //setspeed.addActionListener(buttonhandler);
          
          buttonhandler = new Buttonhandlerclass();
          gobutton = new JButton("Go");
          gobutton.addActionListener(buttonhandler);
          
          pausebutton = new JButton("Pause");
          pausebutton.addActionListener(buttonhandler);
          pausebutton.setVisible(false);
          
          resetbutton = new JButton("Reset");
          resetbutton.addActionListener(buttonhandler);
          
          exitbutton = new JButton("Exit");
          exitbutton.addActionListener(buttonhandler);
          
          speedlabel = new JLabel("Speed (Hz) ");
          speedinput = new JTextField(20);
          speedinput.setText("100");
          
          
          directionindicator = new JLabel("Direction ");
          directionoutput = new JTextField(5);
          directionoutput.setEditable(false);
          
          coordtitle = new JLabel("Coordinates of Center of Ball");
          xcoord = new JLabel("X = ");
          xoutput = new JTextField(4);
          xoutput.setText("1032");
          xoutput.setEditable(false);
          ycoord = new JLabel("Y = ");
          youtput = new JTextField(4);
          youtput.setText("88");
          youtput.setEditable(false);
          
          
          buttonpanel = new JPanel();
          buttonpanel.add(speedlabel);
          buttonpanel.add(speedinput);
          
          buttonpanel.add(gobutton);
          buttonpanel.add(pausebutton);
          buttonpanel.add(resetbutton);
          buttonpanel.add(exitbutton);
          buttonpanel.add(directionindicator);
          buttonpanel.add(directionoutput);
          buttonpanel.add(coordtitle);
          buttonpanel.add(xcoord);
          buttonpanel.add(xoutput);
          buttonpanel.add(ycoord);
          buttonpanel.add(youtput);
          
          
          
          add(buttonpanel,BorderLayout.SOUTH);
          buttonpanel.setPreferredSize(new Dimension(1094,123));
          
          //Make a clock that says tic tock.////////////////////////
          clockhandler = new Clockhandlerclass();
          
          //Convert clockspeed to delayinterval.////////////////////
          delayinterval = (int)Math.floor(millisecondpersecond/clockspeed + 0.5f);
          systemclock = new Timer(delayinterval,clockhandler);
         }//End of Gameinterface constructor.

     private class Buttonhandlerclass implements ActionListener
     {    public void actionPerformed(ActionEvent event)
              {
                  /*if(event.getSource() == setspeed){
                      speedstring = speedinput.getText();
                      speed = Float.parseFloat(speedstring);
                      millisecondpersecond = speed;
                  }*/
                  if(event.getSource() == gobutton){
                      speedstring = speedinput.getText();
                      speed = Integer.parseInt(speedstring);
                      
                      speed = 1000/speed;
                      systemclock.setDelay((int) speed);
                      gobutton.setVisible(false);
                      pausebutton.setVisible(true);
                      systemclock.start();
                  
                  
              }
                else if(event.getSource() == pausebutton){
                    systemclock.stop();
                    pausebutton.setVisible(false);
                    gobutton.setVisible(true);
                } 
                else if (event.getSource() == resetbutton){
                    
                    systemclock.stop();
                    graphicalpanel.reset();
                    xoutput.setText(Integer.toString(1032));
                    youtput.setText(Integer.toString(88));
                    graphicalpanel.repaint();
                    pausebutton.setVisible(true);
                    gobutton.setVisible(false);
                    systemclock.start();
                    
                    
                }
                else if (event.getSource() == exitbutton) {
                    System.exit(0);
                    //message.setText("Message: this program will now close");
                    //exitbutton.setEnabled(false);
                    //delayedclosing.start();//delays closing of program
                }
                /*else if(event.getSource() == delayedclosing){
                    System.exit(0);
                }*/
                else
                    System.out.printf("%s\n","An unknown error ocurred in a button.");
              }
     }//End of Buttonhandlerclass

     private class Clockhandlerclass implements ActionListener
     {    public void actionPerformed(ActionEvent event)
              {
               boolean result = false;
               
               if(event.getSource() == systemclock)
                  {
                   result = graphicalpanel.moveball();
                   if(result){
                        graphicalpanel.repaint();
                        directionoutput.setText(graphicalpanel.sendDirection());
                        x = graphicalpanel.sendXCoord();
                        y = graphicalpanel.sendYCoord();
                        xoutput.setText(Integer.toString(x));
                        youtput.setText(Integer.toString(y));
                  }
                   else
                        {systemclock.stop();
                         System.out.printf("%s\n","The clock has stopped.");
                        }
                  }
               else
                  System.out.printf("%s\n","There is a bug in the clock.");
              }
     }//End of Clockhandlerclass

}//End of Gameinterface
              