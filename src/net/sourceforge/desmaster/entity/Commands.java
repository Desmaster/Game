package net.sourceforge.desmaster.entity;

public class Commands extends Player implements Runnable {
	
	protected Player player;

	public int dir;
	
	public Commands(Player player, int x, int y) {
		super(x, y);
		this.player = player;
		dir = 0;
	}
	
	public void walk(boolean left, int speed) {
		if (left) {
			dir = 1;
		} else {
			player.x += speed;
			dir = 2;
		}
	}

	public void run() {
		
	}

	public void fight() {
		if (dir != 0) {
		entitySprite = player0;
		}
	}
	
	public void tick() {
			switch(dir) {
			case 0:
				entitySprite = player0;
				break;
			case 1:
				entitySprite = player1;
				break;
			case 2:
				entitySprite = player2;
				break;
			}
	}

	public void walkLeft(int speed) {
		player.x -= speed;
	}

	public void walkRight(int speed) {
		player.x += speed;
	}
}
