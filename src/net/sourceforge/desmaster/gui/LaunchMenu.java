package net.sourceforge.desmaster.gui;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import net.sourceforge.desmaster.gfx.Screen;

public class LaunchMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	
	protected JPanel window = new JPanel();
	protected JButton start, options, help, quit, ok;

	protected Rectangle rStart, rOptions, rHelp, rQuit, rOk;
	
	protected int width = 240;
	protected int height = 320;
	protected int button_width = 80;
	protected int button_height = 40;
	
	public LaunchMenu(int id) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSize(width, height);
		setTitle("Skyrim2D Launcher");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(window);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		window.setLayout(null);
		if (id == 0)
		init();
		window.repaint();
	}

	private void init() {
		
		start = new JButton("Start");
		rStart = new Rectangle((width / 2) - (button_width / 2), 50, button_width, button_height);
		start.setBounds(rStart);
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Screen();
				dispose();
			}
		});
		
		window.add(start);
		
		options = new JButton("Options");
		rOptions = new Rectangle((width / 2) - (button_width / 2), 100, button_width, button_height);
		options.setBounds(rOptions);
		options.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OptionsMenu(1);
				dispose();
			}
		});
		window.add(options);
		
		help = new JButton("Help");
		rHelp = new Rectangle((width / 2) - (button_width / 2), 150, button_width, button_height);
		help.setBounds(rHelp);
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HelpMenu();
				dispose();
			}
		});
		window.add(help);
		
		quit = new JButton("Quit");
		rQuit = new Rectangle((width / 2) - (button_width / 2), 200, button_width, button_height);
		quit.setBounds(rQuit);
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				stop();
			}
		});
		window.add(quit);
	}
	
	private void stop() {
		System.exit(0);
	}
}
