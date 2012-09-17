package net.sourceforge.desmaster.level;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import net.sourceforge.desmaster.Skyrim.Skyrim;
import net.sourceforge.desmaster.gfx.Screen;
import net.sourceforge.desmaster.image.ImageContainer;
import net.sourceforge.desmaster.tile.DirtTile;
import net.sourceforge.desmaster.tile.GrassTile;

public class Level {
	
	public class Block extends Rectangle {
		
		public Block(int x, int y) {
			setBounds(x, y, tileSize, tileSize);
		}
		
	}
	
	public List<Block> dirtBlocks = new ArrayList<Block>();
	public static List<Block> grassBlocks = new ArrayList<Block>();
	
	ImageContainer imgContainer = Skyrim.imgContainer;
	
	Skyrim game = Screen.game;
	
	public BufferedImage backGround = null;
	public int id;
	
	public int levels;
	
	public static int groundLevel = Skyrim.HEIGHT / 100 * 60;
	
	public int tileSize = 16;
	
	public Level(int id) {
		this.id = id;
		backGround = imgContainer.backGround[id];
	}
	
	public void tick() {
		
	}
	
	public void renderBackGround(Graphics g) {
		g.drawImage(backGround, 0, 0, Skyrim.WIDTH, Skyrim.HEIGHT, null);
	}

	public void renderBlocks(Graphics g) {
		int groundLevel = Skyrim.HEIGHT / 100 * 60;
		for (int x = 0; x < Skyrim.WIDTH; x += tileSize) {
			for (int y = groundLevel + tileSize; y < Skyrim.HEIGHT; y += tileSize) {
				new DirtTile(x, y).render(g);
				dirtBlocks.add(new Block(x, y));
				for (int yGrass = groundLevel; yGrass < groundLevel + tileSize; yGrass += tileSize) {
					new GrassTile(x, yGrass).render(g);
					grassBlocks.add(new Block(x, yGrass));
				}
			}
		}
	}
}
