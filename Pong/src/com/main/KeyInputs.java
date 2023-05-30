package com.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInputs extends KeyAdapter{
//Constructors
// All about how code works relative towards paddle
//Initialize paddle constructors
	private Paddle paddle1;
	private boolean up1 = false;
	private boolean down1 = false;

	private Paddle paddle2;
	private boolean up2 = false;
	private boolean down2 = false;
	
	
	
	
	public KeyInputs(Paddle pd1, Paddle pd2) {
	this.paddle1 = pd1;
	this.paddle2 = pd2;
	
	
	}
	
	
	// When key is pressed run these commands
	// SEE STACKOVERFLOW COMMENT ON KEYPRESSED COMMANDS
	
	public void keyPressed(KeyEvent e) {
	int key = e.getKeyCode();
	// Right Paddle
	if (key == KeyEvent.VK_UP) {
		paddle2.switchDirection(-1);
		
		up2 = true;
	}
	if (key == KeyEvent.VK_DOWN) {
		paddle2.switchDirection(1);
		down2 = true;
	}
	//Left Paddle
	if (key == KeyEvent.VK_W) {
		paddle1.switchDirection(-1);
		up1 = true;
	}
	if (key == KeyEvent.VK_S) {
		paddle1.switchDirection(1);
		down1 = true;
	}
}
	
	// When key is released run these commands
	// SEE STACKOVERFLOW KEYRELEASED
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		// Right Paddle
		if (key == KeyEvent.VK_UP) {
			up2 = false;
		}
		if (key == KeyEvent.VK_DOWN) {
			down2 = false;
		}
		//Left Paddle
		if (key == KeyEvent.VK_W) {
			up1 = false;
		}
		if (key == KeyEvent.VK_S) {
			down1 = false;
		}
		
		if (!up1 && !down1) {
			paddle1.stop();
		}
		
		if (!up2 && !down2) {
			paddle2.stop();

			}	
		
	}
}
