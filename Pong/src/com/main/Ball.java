package com.main;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	// constructors
	// Remember to have a constant size because ball doesn't change in size
	// have x and y velocities because of this
	public static final int SIZE = 16;
	private int x;
	private int y;
	private int xVel;
	private int yVel;
	private int speed = 7;
	
	public Ball() {
		// intialize velocities and of ball
		reset();
	
	}

	private void reset() {
// Ball width and height after game resets when player misses ball
		x = Game.WIDTH / 2 - SIZE/2;
		y = Game.HEIGHT / 2 - SIZE/2;
		
		
		//velocities
		
		
		//Randomly generates a number between 0 and 1 and then multiplies it by and finds out if negative # or not
		// will go either left or right depending on this
		xVel = Game.sign(Math.random() * 2.0 - 1);
		yVel =  Game.sign(Math.random() * 2.0 - 1);
	
	}
	
	// Ball changes vertical position as its moving across window
	public void changeYDir() {
		yVel = yVel * -1;
	}
	// Ball changes horizontal position as its moving across window
	public void changeXDir() {
		xVel = xVel * -1;
	}
// Ball needs to be drawn and creates (gives ball graphical representation)
	public void draw(Graphics g) {
			g.setColor(Color.blue);
			g.fillRect(x, y, SIZE, SIZE);
	}

	//Updates ball position and velo subsequent ot being hit
	public void update(Paddle paddle1, Paddle paddle2) {
			
		
		//Updates x and y velocities of ball depending on paddle
			x += xVel * speed;
			y += yVel * speed;
		
			// collison testing
			
			if (y + SIZE >= Game.HEIGHT || y <= 0) {
				changeYDir();
			}
			
			if (x + SIZE >= Game.WIDTH) {
				paddle1.addPoint();
				reset();
				}
			if( x<= 0) {
				paddle2.addPoint();
				reset();
			}
	}
// Gets x position and y position
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
