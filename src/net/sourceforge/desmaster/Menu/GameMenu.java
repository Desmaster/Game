package net.sourceforge.desmaster.Menu;

import java.awt.Graphics;

import net.sourceforge.desmaster.Skyrim.Skyrim;

public class GameMenu extends Menu {

	@SuppressWarnings("static-access")
	public GameMenu(Skyrim game, Graphics g) {
		super(game, g);
		validate();
		game.brightness = 0.6f;
	}
	
}
