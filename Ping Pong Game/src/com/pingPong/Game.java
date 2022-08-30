package com.pingPong;

import java.awt.Color;

import javax.swing.JFrame;

public class Game extends JFrame{
	JFrame frame;
	public Game() {
		frame=new JFrame();
		frame.setSize(1000, 500);
		frame.setVisible(true);
		frame.setTitle("Ping Pong Game");
		frame.setLocationRelativeTo(null);//To get Frame in Middle...
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		gamePanel gp=new gamePanel();
		gp.setBackground(Color.black);
		frame.add(gp);
		frame.addKeyListener(gp);
	}
	public static void main(String[] args) {
		new Game();
	}
	
}
