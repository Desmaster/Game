package net.sourceforge.desmaster.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import net.sourceforge.desmaster.Skyrim.Skyrim;
import net.sourceforge.desmaster.image.ImageContainer;

public class Tile {
	
	BufferedImage sprite = null;
	
	protected ImageContainer imgContainer = Skyrim.imgContainer;
	
	protected int tileSize = 16;

	public int x;
	public int y;

	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void render(Graphics g) {
		g.drawImage(sprite, x, y, tileSize, tileSize, null);
	}
	
}
