package net.sourceforge.desmaster.gui;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class HelpMenu extends LaunchMenu {
	
	private static final long serialVersionUID = 1L;

	private int width = 450;
	private int height = 350;
	private JTextArea text;
	private Rectangle rText;
	private String s = "Start - Start the game." + "\n\nOptions - Set options to your preferences." + "\n\nQuit - Quit the game.";
	
	public HelpMenu() {
		super(1);
		setTitle("Skyrim2D Launcher - Help");
		setSize(width, height);
		setLocationRelativeTo(null);
		init();
	}
	
	private void init() {
		rText = new Rectangle(0, 0, width, height - button_height * 6);
		text = new JTextArea();
		text.setText(s);
		text.setBounds(rText);
		text.setEditable(false);
		window.add(text);

		
		ok = new JButton("OK");
		rOk = new Rectangle((width / 2) - (button_width / 2), (height - button_height * 2) , button_width, button_height);
		ok.setBounds(rOk);
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LaunchMenu(0);
				dispose();
			}
		});
		window.add(ok);
	}
}
