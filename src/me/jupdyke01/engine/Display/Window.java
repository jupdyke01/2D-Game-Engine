package me.jupdyke01.engine.Display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import me.jupdyke01.engine.Engine;

public class Window extends Canvas {

	private static final long serialVersionUID = 1L;

	public Window(Engine engine) {
		JFrame frame = new JFrame(engine.getName());
		Dimension d = new Dimension(engine.getWidth(), engine.getHeight());

		frame.setPreferredSize(d);
		frame.setSize(d);
		frame.setMaximumSize(d);
		frame.setMinimumSize(d);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(engine);
		frame.pack();
		frame.setVisible(true);
		engine.start();
	}

}
