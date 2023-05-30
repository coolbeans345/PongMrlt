package com.main;

import javax.swing.JFrame;

public class Window {
// ALl this initializes how the game will work and how to game will run depending on the class
// Opens a window for which the game can run on.
// Is present for most games. 
	public Window(String title, Game game) {
		JFrame frame = new JFrame(title);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(game);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
	}

}
