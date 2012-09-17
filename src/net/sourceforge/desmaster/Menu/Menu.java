package net.sourceforge.desmaster.Menu;

import java.awt.Graphics;
import java.awt.Rectangle;

import net.sourceforge.desmaster.Skyrim.Skyrim;

public class Menu {
	
	protected Skyrim game;
	protected Graphics g;
	protected Rectangle size;
	
	@SuppressWarnings("static-access")
	public Menu(Skyrim game, Graphics g) {
		this.game = game;
		this.g = g;
		size = new Rectangle(game.WIDTH, game.HEIGHT);
	}
	

	protected void validate() {
		render(g);
	}
	
	public void render(Graphics g) {
		
	}


	public void close() {
		
	}

}
