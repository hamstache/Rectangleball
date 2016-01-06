package fallingball;

//Author: Josh Moynihan
//Email:  jdmoynihan19@csu.fullerton.edu
//Course: CPSC223J
//
//File name: Graphicalpanel.java
//Description: This is one module in the Rectangle Ball program.  This module
//defines the central panel of the user interface.  This central panel contains 
//the Graphic area.

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JFrame;

public class Graphicalpanel extends JPanel
{    int widthofgraphicalarea;
     int heightofgraphicalarea;
     final int ballradius = 15;
     int ballxcoordinate=1002;
     int ballycoordinate=59;
     int coordxstart = 1032;
     int coordystart = 88;
     
     public void paintComponent(Graphics graphicarea)
     {super.paintComponent(graphicarea);
      this.setBackground(Color.BLACK);
      widthofgraphicalarea = getWidth();
      heightofgraphicalarea = getHeight();
      
      
      //Compute value for ballxcoordinate in order to place the ball at top center of the graphic area.
      //This value does not change in this program because this ball moves only in a vertical direction.
      
       
      //ballxcoordinate = 1010;
      //ballycoordinate = 68;
      
      //Give the ball a red color
      graphicarea.setColor(Color.GREEN);
      //The 3rd and 4th parameters below represent the diameter of the ball.
      graphicarea.fillOval(ballxcoordinate,ballycoordinate,2*ballradius,2*ballradius);
      
     }//End of method paintComponent for ball

     //The next method lowers the ball by 1 pixel.
     public boolean moveball()
     {
         boolean result = false;
         if (ballxcoordinate+2*ballradius < 88){
             result = raiseballpixel();
         }
         if (ballycoordinate+2*ballradius == coordystart && ballxcoordinate+2*ballradius == coordxstart){
             result = lowerball1pixel();
         }
         if (ballycoordinate+2*ballradius < 483 && ballycoordinate+2*ballradius > 88){
            
            result = lowerball1pixel();
             
             
         }
         if (ballycoordinate+2*ballradius == 88){
             result = moveballright();
         }
         if (ballycoordinate+2*ballradius >= 483){
             result = moveballleft();
             
         }
         if (ballxcoordinate+2*ballradius < 88){
             result = raiseballpixel();
         }
         
         
         
        
         
         /*if( ballycoordinate+2*ballradius < 84){
             result = moveballright();
         }*/
         
         return result;
     }
     public void reset(){
         ballxcoordinate=1002;
         ballycoordinate=59;
     }
     public int sendXCoord(){
         return ballxcoordinate+2*ballradius;
     }
     public int sendYCoord(){
         return ballycoordinate+2*ballradius;
     }
     public String sendDirection(){
         String direction = "null";
         if (ballxcoordinate+2*ballradius < 88){
             direction = "Up";
         }
         if (ballycoordinate+2*ballradius == coordystart && ballxcoordinate+2*ballradius == coordxstart){
             direction = "Down";
         }
         if (ballycoordinate+2*ballradius < 483 && ballycoordinate+2*ballradius > 88){
             direction = "Down";
             
         }
         if (ballycoordinate+2*ballradius == 88){
             direction = "Right";
         }
         if (ballycoordinate+2*ballradius >= 483){
             direction = "Left";
             
         }
         if (ballxcoordinate+2*ballradius < 88){
             direction = "Up";
         }
         return direction;
     }    
     public boolean lowerball1pixel()
     {    boolean successfulmove = false; //Assume no move unless proven otherwise.
          ballycoordinate = ballycoordinate + 1;
          successfulmove = true;
          return successfulmove;
     }
     public boolean moveballleft()
     {
         boolean successfulmove = false;
         ballxcoordinate = ballxcoordinate - 1;
         successfulmove = true;
         return successfulmove;
     }
     public boolean raiseballpixel()
     {
         boolean successfulmove = false;
         ballycoordinate = ballycoordinate - 1;
         successfulmove = true;
         return successfulmove;
     }
     public boolean moveballright()
     {
         boolean successfulmove = false;
         ballxcoordinate = ballxcoordinate + 1;
         successfulmove = true;
         return successfulmove;
     }
     public void paintChildren(Graphics graphicarea){
         graphicarea.drawRect (75, 75, 943, 395);
     }
     
}//End of Graphicalpanel
