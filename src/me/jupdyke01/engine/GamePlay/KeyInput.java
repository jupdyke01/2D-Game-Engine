package me.jupdyke01.engine.GamePlay;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import me.jupdyke01.engine.Engine;

public class KeyInput implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
	
	private final int NUM_KEYS = 400;
	private boolean[] keys = new boolean[NUM_KEYS];

	private final int NUM_BUTTONS = 10;
	private boolean[] buttons = new boolean[NUM_BUTTONS];
	
	private int mouseX, mouseY;
	private int scroll;
	
	public KeyInput(Engine engine) {
		mouseX = 0;
		mouseY = 0;
		scroll = 0;
		
		engine.addKeyListener(this);
		engine.addMouseMotionListener(this);
		engine.addMouseListener(this);
		engine.addMouseWheelListener(this);
	}
	
	public void tick() {
		scroll = 0;
	}
	
	public boolean isKeyDown(int keyCode) {
		return keys[keyCode];
	}

	public boolean isButtonDown(int button) {
		return keys[button];
	}


	public int getMouseX() {
		return mouseX;
	}



	public int getMouseY() {
		return mouseY;
	}



	public int getScroll() {
		return scroll;
	}



	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		scroll = e.getWheelRotation();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = (int) (e.getX());
		mouseY = (int) (e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = (int) (e.getX());
		mouseY = (int) (e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		buttons[e.getButton()] = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		buttons[e.getButton()] = false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	
	
}
