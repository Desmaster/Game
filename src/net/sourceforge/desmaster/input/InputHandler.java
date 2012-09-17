package net.sourceforge.desmaster.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import net.sourceforge.desmaster.Skyrim.Skyrim;

public class InputHandler implements KeyListener {
	
	public static int leftb = KeyEvent.VK_LEFT;
	public static int rightb = KeyEvent.VK_RIGHT;
	
	public class Key {
		
		public int presses, absorbs;
		public boolean down, clicked;
		
		public void tick() {
			
			if (absorbs < presses) {
				absorbs++;
				clicked = true;
			} else {
				clicked = false;
			}
		}
		
		public void toggle(boolean pressed) {
			if (pressed != down) {
				down = pressed;
			}
			
			if (pressed) {
				presses++;
			}
		}
		
		public Key() {
			keys.add(this);
		}
	}
	
	public List <Key> keys = new ArrayList<Key>();
	
	public Key left = new Key();
	public Key right = new Key();
	public Key jump = new Key();
	public Key menu = new Key();
	public Key exit = new Key();
	public Key fight = new Key();
	public Key toggleFPS = new Key();
	
	public void releaseAll() {
		for (int i = 0; i < keys.size(); i++) {
			keys.get(i).down = false;
		}
	}
	
	public void tick() {
		for (int i = 0; i < keys.size(); i++) {
			keys.get(i).tick();
		}
		//Skyrim2D.say("input");
	}
	
	public InputHandler(Skyrim game) {
		game.addKeyListener(this);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		toggle(e, true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		toggle(e, false);
	}
	
	public void toggle(KeyEvent e, boolean pressed) {
		if (e.getKeyCode() == leftb) left.toggle(pressed);
		if (e.getKeyCode() == rightb) right.toggle(pressed);
		if (e.getKeyCode() == KeyEvent.VK_SPACE) jump.toggle(pressed);
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) exit.toggle(pressed);
		if (e.getKeyCode() == KeyEvent.VK_Q) fight.toggle(pressed);
		if (e.getKeyCode() == KeyEvent.VK_F) toggleFPS.toggle(pressed);
		if (e.getKeyCode() == KeyEvent.VK_M) menu.toggle(pressed);
	}
}
