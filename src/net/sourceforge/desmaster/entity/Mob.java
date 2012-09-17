package net.sourceforge.desmaster.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Mob extends Entity implements Runnable {
	
	protected int health;

	String name;
	
	public Mob(int x, int y, String name) {
		this.x = x;
		this.y = y;
		new Thread(this, name).start();
	}
	
	public void render(Graphics g) {
		BufferedImage mob = entitySprite;
		g.drawImage(mob, x, y, null);
	}
	
	public int random(int a, int b) {
		int dif = Math.abs(a-b);
		return Math.min(a, b) + (dif <= 0 ? 0 : new Random().nextInt(dif)); 
	}
	
	public void run() {
		
	}
	
}
