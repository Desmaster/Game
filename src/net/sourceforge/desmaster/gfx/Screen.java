package net.sourceforge.desmaster.gfx;

import javax.swing.JFrame;

import net.sourceforge.desmaster.Skyrim.Skyrim;

public class Screen {

	public static Skyrim game;
	
	public Screen() {
		game = new Skyrim();
		JFrame frame = new JFrame("Stibb's Adventures");
		frame.add(game);
		frame.setTitle("Stibb's Adventures");
		frame.setSize(Skyrim.size);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		game.start();
	}
}
