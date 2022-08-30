package com.pingPong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;

public class gamePanel extends JPanel implements KeyListener{

	Random r=new Random();
	int min=0,max1=400,max2=800;
	int rect1=170;
	int rect2=170;
	int ballX=(int)(Math.random()*(max2-min+1)+min),ballY=(int)(Math.random()*(max1-min+1)+min),SpeedX=10,SpeedY=10;
	int score1=0,score2=0;
	public void paint(Graphics g) {
		
		
		super.paint(g);
		g.setColor(Color.WHITE);
		g.drawString("Player 1: "+String.valueOf(score1),getWidth()/2-125, 100);
		g.drawString("Player 2: "+String.valueOf(score2), getWidth()/2+50, 100);
		g.setColor(Color.WHITE);
		g.drawLine(getWidth()/2,0, getWidth()/2, getHeight());
		g.setColor(Color.red);
		if(rect1<0)
			rect1=0;
		if(rect1>360)
			rect1=360;
		
		g.fillRect(0, rect1, 30, 100);
		
		g.setColor(Color.blue);
		
		if(rect2<0)
			rect2=0;
		if(rect2>360)
			rect2=360;
		g.fillRect(getWidth()-30, rect2, 30, 100);
		
		g.setColor(Color.green);
		
		
		
		if(ballX>=0) {
		g.fillOval(ballX, ballY, 35, 35);
		
		
		
		
		if(ballY>420||ballY<0) {
			SpeedY=-SpeedY;
		}
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ballX=ballX+SpeedX;
		ballY=ballY+SpeedY;
		
		Rectangle ballRect=new Rectangle(ballX,ballY,35,35);
		
		Rectangle paddleRect=new Rectangle(getWidth()-30,rect2,30,100);
		
		Rectangle paddleRect2=new Rectangle(0,rect1,30,100);
		
		if(ballRect.intersects(paddleRect)) {
			SpeedX=-SpeedX;
			SpeedY=-SpeedY;
			score2++;
		}
		if(ballRect.intersects(paddleRect2)) {
			SpeedX=-SpeedX;
			SpeedY=-SpeedY;
			score1++;
		}
	
		repaint();
		}
		
		if(ballX<0||ballX>980)
		{
			ballX=(int)(Math.random()*(max2-min+1)+min);
			ballY=(int)(Math.random()*(max1-min+1)+min);
			repaint();
			
		}
		
	}
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_E) {
			rect1-=50;
			repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_D) {
			rect1+=50;
			repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_R) {
			rect2-=50;
			repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_F) {
			rect2+=50;
			repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
