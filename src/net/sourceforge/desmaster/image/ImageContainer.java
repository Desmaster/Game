package net.sourceforge.desmaster.image;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

import net.sourceforge.desmaster.Skyrim.Skyrim;
import net.sourceforge.desmaster.gfx.Screen;

public class ImageContainer {
	
	private ImageLoader imageLoader;
	
	public BufferedImage player;
	public BufferedImage playerLeft;
	public BufferedImage playerRight;
	public BufferedImage fightLeft;
	public BufferedImage fightRight;
	
	public BufferedImage dirt;
	public BufferedImage grass;
	
	public BufferedImage[] backGround;
	
	Skyrim game = Screen.game;

	private int	backgrounds = 2;
	
	
	public ImageContainer() {
		imageLoader = new ImageLoader();
		backGround = new BufferedImage[16];

		player = imageLoader.loadImage("player0.png");
		playerLeft = imageLoader.loadImage("player1.png");
		playerRight = imageLoader.loadImage("player2.png");
		
		fightLeft = imageLoader.loadImage("fight1.png");
		fightRight = imageLoader.loadImage("fight2.png");
		
		dirt = imageLoader.loadImage("dirt.png");
		grass = imageLoader.loadImage("grass.png");
		
		for (int i = 1; i <= backgrounds; i++) {
			backGround[i] = imageLoader.loadImage("background" + i + ".png");
		}
	}
	
	@SuppressWarnings("static-access")
	public void tick() {
		RescaleOp op = new RescaleOp(game.brightness, 170.0f, null);
	
		player = op.filter(player, null);
	}
	
}
