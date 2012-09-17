package net.sourceforge.desmaster.entity;

import net.sourceforge.desmaster.Skyrim.Skyrim;

public class Jump extends Commands implements Runnable {

	private Thread thread;
	public boolean k = false;
	public boolean h = false;
	boolean done = false;
	
	public Jump(Player player, int x, int y) {
		super(player, x, y);
	}

	public void validate() {
		k = true;
		thread = new Thread(this, "Jump");
		thread.start();
	}
	
	@SuppressWarnings("static-access")
	public void run() {
		long beforeTime, timeDiff, sleep;
		beforeTime = System.currentTimeMillis();
		while(!done) {
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
		if (!h)
			player.y--;
		if (player.y == Skyrim.HEIGHT / 100 * 60 - 80)
			h = true;
		if (h && player.y <= playerLimit) {
			player.y++;
			if (player.y == playerLimit) {
				done = true;
			}
		}
	}
}
