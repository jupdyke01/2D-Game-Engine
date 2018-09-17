package me.jupdyke01.engine.Game;

import java.awt.Graphics;

import me.jupdyke01.engine.Engine;

public abstract class AbstractGame {

	public abstract int getWidth();
	public abstract int getHeight();
	public abstract String getName();
	
	public abstract void tick(Engine engine);
	public abstract void render(Graphics g);
}
