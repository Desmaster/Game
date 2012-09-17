package net.sourceforge.desmaster.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import net.sourceforge.desmaster.Skyrim.Skyrim;
import net.sourceforge.desmaster.gfx.Screen;
import net.sourceforge.desmaster.level.Level;
import net.sourceforge.desmaster.level.Level.Block;

public class Player extends Entity {
	
	public int x;
	public int y;
	public int drop = 0;
	
	public int playerHeight = 40;
	public int playerWidth = 20;
	public int playerLimit = Skyrim.HEIGHT / 100 * 60 - playerHeight;
	
	Rectangle playerRect;
	
	public BufferedImage player0 = imgContainer.player;
	public BufferedImage player1 = imgContainer.playerLeft;
	protected BufferedImage player2 = imgContainer.playerRight;
	
	public BufferedImage fight1 = imgContainer.fightLeft;
	public BufferedImage fight2 = imgContainer.fightRight;
	
	int levels = 2;
	
	public Player(int x, int y) {
		entitySprite = player0;
		playerRect = new Rectangle(x, y, playerWidth, playerHeight);
		this.x = x;
		this.y = y;
	}
	
	@SuppressWarnings("unused")
	public void tick() {
		y = y + drop;
		
		for (Block blocks: Level.grassBlocks) {
			if (playerRect.intersects(blocks)) {
				playerRect.y = blocks.y;
				Skyrim.say("DERPPP");
			}
		}
		
		if (x > Skyrim.WIDTH - playerWidth  && Screen.game.level.id <= levels) {
			x = 0;
			Screen.game.level = new Level(2);
		} else if (x > Skyrim.WIDTH - playerWidth + 4) {
			x = Skyrim.WIDTH - playerWidth + 4;
		}
		if (x < 0 && Screen.game.level.id > 1) {
			x = Skyrim.WIDTH - playerWidth;
			Screen.game.level = new Level(1);
		} else if (x < 0) {
			x = -4;
		}
		drop = 0;
	}
	
	public void render(Graphics g) {
		BufferedImage player = entitySprite;
		g.drawImage(player, x, y, 20, 40, null);
	}
	
	public boolean reachesLimit() {
	    if (y >= Skyrim.HEIGHT / 100 * 60 - 100) {
	    	return true;
	    }
		return false;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public BufferedImage getSprite() {
		return entitySprite;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setSprite(BufferedImage sprite) {
		entitySprite = sprite;
	}
}
