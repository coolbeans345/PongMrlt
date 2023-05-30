package com.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Paddle {
	// Initialize variables for constructors
	private int x, y;
	private int vel = 0;
	private int speed = 10;
	private int width = 22;
	private int height = 85;
	private int score = 0;
	private Color color;
	private boolean left;
	
	
	
	// paddle colors nad width
	public Paddle(Color colo, boolean left) {
		color = colo;
		
		this.left = left;
		
		if (left)
			x = 0;
		else 
			x = Game.WIDTH - width;
			y = Game.HEIGHT / 2 - height / 2 + 100;
			
	}

	//Adds point (to their side) if player wins a match
	public void addPoint() {
		score = score + 1;
	}

//Draws and gives visual representation to paddle
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
		
		int stringX;
		String scoreText = Integer.toString(score);
		Font font = new Font("Roboto", Font.PLAIN, 50);
		
		int stringWidth = g.getFontMetrics(font).stringWidth(scoreText) + 1;
		int padding = 25;
		
		if (left)
			stringX = Game.WIDTH / 2 - padding - stringWidth;
		else 
			stringX = Game.WIDTH / 2 + padding;
		
		g.setFont(font);
		g.drawString(scoreText, stringX, 50);
		
	}

//Resets paddle position after point is played
	public void update(Ball ba) {
		y = Game.ensureRange(y + vel, 0, Game.HEIGHT - height);
			
			int ballX = ba.getX();
			int ballY = ba.getY();
			
			
			// Collison testing w/ ball and paddles
			
			if(left) {
					
					if (ballX <= width && ballY + Ball.SIZE >= y && ballY <= y + height)
						ba.changeXDir();
					
			} else {
					if (ballX + Ball.SIZE >= Game.WIDTH - width && ballY + Ball.SIZE >= y && ballY <= y + height)
						ba.changeXDir();
				
			}
	}

//Ball switches directions subsequent to being hit.
	public void switchDirection(int i) {
		vel = speed * i;
	}
	
	public void stop() {
		vel = 0;
		
	}

}
