package net.sourceforge.desmaster.entity;

public class Fight extends Commands implements Runnable {

	private Thread thread;
	public boolean k = false;
	public boolean h = false;
	boolean done = false;
	
	public Fight(Player player, int x, int y) {
		super(player, x, y);
	}

	public void validate() {
		k = true;
		thread = new Thread(this, "Fight");
		thread.start();
	}
	
	@SuppressWarnings("static-access")
	public void run() {
		long beforeTime, timeDiff, sleep;
		beforeTime = System.currentTimeMillis();
		while (!done) {
			cycle();
			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = 8 - timeDiff;
			if (sleep < 0)
				sleep = 1;
			try {
				thread.sleep(sleep);
			} catch (Exception e) {
				e.printStackTrace();
			}
			beforeTime = System.currentTimeMillis();
		}
		done = false;
		h = false;
		k = false;
	}
	
	public void cycle() {
		int i = 500;
		if (!h) {
			i--;
			if (i > 0)
				entitySprite = fight1;
			if (i == 0) {
				h = true;
				done = true;
				entitySprite = player1;
			}
		}
	}
	
}
