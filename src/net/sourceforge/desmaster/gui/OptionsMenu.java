package net.sourceforge.desmaster.gui;

import java.awt.Choice;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

import net.sourceforge.desmaster.Skyrim.Skyrim;
import net.sourceforge.desmaster.input.InputHandler;

public class OptionsMenu extends LaunchMenu {

	private static final long serialVersionUID = 1L;

	private int	width = 550;
	private int	height = 450;
	
	private Rectangle rKeys, rControls;
	private Choice keys;
	private JLabel controls;

	public OptionsMenu(int id) {
		super(1);
		setTitle("Skyrim2D Launcher - Options");
		setSize(width, height);
		setLocationRelativeTo(null);
		init();
	}

	private void init() {
		rKeys = new Rectangle(50, 80, 80, 25);
		
		keys = new Choice();
		
		rControls = new Rectangle(50, 55, 50, 25);
		controls = new JLabel("Controls:");
		controls.setBounds(rControls);
		window.add(controls);
		
		if (Skyrim.selection == 0) {
		keys.add("A & D");
		keys.add("Left & Right");
		}
		if (Skyrim.selection == 1) {
		keys.add("Left & Right");
		keys.add("A & D");
		}
		keys.select(0);
		keys.setBounds(rKeys);
		window.add(keys);
		
		ok = new JButton("OK");
		rOk = new Rectangle((width - 100), (height - 70), button_width, button_height);
		ok.setBounds(rOk);
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (keys.getSelectedIndex() == 0 && Skyrim.selection == 0) {
					InputHandler.leftb = KeyEvent.VK_A;
					InputHandler.rightb = KeyEvent.VK_D;
					Skyrim.say("AD!");
				}
				if (keys.getSelectedIndex() == 1 && Skyrim.selection == 0) {
					InputHandler.leftb = KeyEvent.VK_LEFT;
					InputHandler.rightb = KeyEvent.VK_RIGHT;
					Skyrim.selection = 1;
					Skyrim.say("Arrows!");
				} else if (keys.getSelectedIndex() == 1 && Skyrim.selection == 1) {
					InputHandler.leftb = KeyEvent.VK_A;
					InputHandler.rightb = KeyEvent.VK_D;
					Skyrim.selection = 0;
					Skyrim.say("AD!");
				} else if (keys.getSelectedIndex() == 0 && Skyrim.selection == 1) {
					InputHandler.leftb = KeyEvent.VK_LEFT;
					InputHandler.rightb = KeyEvent.VK_RIGHT;
					Skyrim.selection = 1;
					Skyrim.say("Arrows!");
				}
				
				new LaunchMenu(0);
				dispose();
			}
		});
		window.add(ok);
	}
}
