package fallingball;

//Author: Josh Moynihan
//Email: jdmoynihan19@csu.fullerton.edu
//Course: CPSC223J
//
//Usage: This program creates a clock inside my program and uses it to refresh
//the position of a ball in my frame. The constant refreshing creates an animation
//where the ball moves in a rectangle around the screen
//File name: Fallingball.java
//Purpose for this file: The main driver for a program showing a small object in motion.

//There are three files that must be compiled -- preferrably in this order:
//    Graphicalpanel.java
//    Gameinterface.java
//    Fallingball.java
//and, of course, Fallingball.class is actually executed by the JVM (Java Virtual Machine).

import javax.swing.JFrame;

public class Fallingball
{    public static void main(String[] args)
         {JFrame myframe = new Gameinterface();
          myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          myframe.setSize(1094,768);
          myframe.setVisible(true);
         }//End of main
}//End of class Fallingball
