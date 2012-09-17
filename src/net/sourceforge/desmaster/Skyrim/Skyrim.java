package net.sourceforge.desmaster.Skyrim;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import net.sourceforge.desmaster.Menu.GameMenu;
import net.sourceforge.desmaster.Menu.Menu;
import net.sourceforge.desmaster.entity.Commands;
import net.sourceforge.desmaster.entity.Fight;
import net.sourceforge.desmaster.entity.Jump;
import net.sourceforge.desmaster.entity.Player;
import net.sourceforge.desmaster.image.ImageContainer;
import net.sourceforge.desmaster.input.InputHandler;
import net.sourceforge.desmaster.level.Level;
import net.sourceforge.desmaster.physx.AABB;
import net.sourceforge.desmaster.physx.Circle;
import net.sourceforge.desmaster.physx.CollisionLibrary;
import net.sourceforge.desmaster.physx.Vector;

public class Skyrim extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	private static int w = 806;
	private static int h = 628;
	public static float brightness = 1.0f;
	private Menu activeMenu = null;
	public static int selection = 1;
	private int fps;
	private boolean fpsVisible = true;
	
	private boolean running = false;
	private int speed = 5;
	private int	walkingSpeed = 5;
	
	public static Dimension size = new Dimension(w, h);
	
	private Thread thread;
	private Graphics g;
	public static ImageContainer imgContainer = new ImageContainer();
	private InputHandler input = new InputHandler(this);
	public static Player player = new Player(WIDTH / 2 - 20, Skyrim.HEIGHT / 100 * 60 - 40);
	public static Commands cmds = new Commands(player, player.x, player.y);
	private BufferedImage img;
	public Level level = new Level(1);
	public Jump jump;
	public Fight fight;
	
	public Skyrim() {
		img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		jump = new Jump(player, player.x, player.y);
		fight = new Fight(player, player.x, player.y);
	}
	
	public void start() {
		if (running)
			return;
		thread = new Thread(this, "Game");
		thread.start();
		running = true;
	}
	
	public void stop() {
		if (!running)
			return;
		running = false;
		System.exit(0);
	}
	
	@SuppressWarnings("static-access")
	public void run() {
		
		long lastTime = System.nanoTime();
		double nsPerTick = 16666666.666666666D;
		double unprocessed = 0.0D;
		int frames = 0;
		int ticks = 0;
		long lastTimer1 = System.currentTimeMillis();
		
		while(running) {
			requestFocus();
			long now = System.nanoTime();
			unprocessed += (now - lastTime) / nsPerTick;
			lastTime = now;
			while (unprocessed >= 1) {
				ticks++;
				frames++;
				inputScanner();
				tick();
				render();
				unprocessed -= 1;
			}
			if (System.currentTimeMillis() - lastTimer1 > 1000) {
				lastTimer1 += 1000;
				fps = frames;
				say(frames + " fps, ticks: " + ticks);
				frames = 0;
				ticks = 0;
			}
			//say("Size: " + getWidth() + ", " + getHeight());
			
			
			//say("Level:" + level.id);
			try {
				thread.sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void tick() {
		input.tick();
		imgContainer.tick();
		cmds.tick();
		player.tick();
	}
	
	private void inputScanner() {
		if (input.exit.down) {
			//stop();
			if (activeMenu != null) {
				activeMenu.close();
			}
		}
		if (input.menu.clicked)
			new GameMenu(this, g);
		if (input.left.down) {
			cmds.walkLeft(walkingSpeed);
			player.setSprite(imgContainer.playerLeft);
			cmds.dir = 1;
		}
		if (input.right.down) {
			cmds.walkRight(walkingSpeed);
			player.setSprite(imgContainer.playerRight);
			cmds.dir = 2;
		}
		if (input.jump.down && !jump.k)
			jump.validate();
		if (input.fight.clicked) {
			if (cmds.dir == 1) {
				player.setSprite(imgContainer.fightLeft);
				fight.validate();
			} else if (cmds.dir == 2) {
				player.setSprite(imgContainer.fightRight);
				fight.validate();
			}
		}
		if (input.toggleFPS.clicked)
			fpsVisible = !fpsVisible;
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		
		if (bs == null) {
			createBufferStrategy(3);
			say("Herp" + (4 & 8));
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(img, 0, 0, WIDTH, HEIGHT, null);
		
		level.renderBackGround(g);
		level.renderBlocks(g);
		player.render(g);
		
		g.setColor(Color.yellow);
		g.setFont(new Font("Verdana", 0, 20));
		if (fpsVisible)
		g.drawString("FPS: " + fps, 2, 18);
		
		g.dispose();
		bs.show();
	}
	
	public static void say(String s) {
		System.out.println(s);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//Launcher launcher = new Launcher();
		Circle circle = new Circle(5);
	      AABB box = new AABB(10, 5);
	      Vector somePosition = new Vector();
	      somePosition.x = 10;
	      somePosition.y = 5;
	      
	      // make sure to update the position of the colliders before testing for them
	      box.update(somePosition);
	      circle.update(somePosition);
	      
	      // test for overlap
	      if(CollisionLibrary.testCircleAABB(circle, box)) {
	         say("collision!");
	      } else {
	         say("no collision!");
	      }
	}
}
