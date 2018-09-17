package me.jupdyke01.engine;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import me.jupdyke01.engine.Display.Window;
import me.jupdyke01.engine.Game.AbstractGame;
import me.jupdyke01.engine.GamePlay.KeyInput;
import me.jupdyke01.engine.Utils.FileUtils;


public class Engine extends Canvas implements Runnable {


	private static final long serialVersionUID = 1L;

	private Thread thread;
	private boolean running = false;
	private AbstractGame game;
	
	public int width, height;
	public String name;
	public int frames;

	private KeyInput ki;
	private FileUtils fu;

	
	
	public Engine(AbstractGame game) {
		this.game = game;
		
		this.width = game.getWidth();
		this.height = game.getHeight();
		this.name = game.getName();
		
		new Window(this);
		ki = new KeyInput(this);
		fu = new FileUtils();

	}



	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		game.render(g);

		g.dispose();
		bs.show();
	}

	public void tick() {
		game.tick(this);
		ki.tick();
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now-lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;

			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	public KeyInput getKeyInput() {
		return this.ki;
	}

	public static int clamp(int var, int min, int max) {
		if (var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else
			return var;
	}

	public FileUtils getFileUtils() {
		return fu;
	}
	
	public KeyInput getKi() {
		return ki;
	}



	public int getWidth() {
		return width;
	}



	public int getHeight() {
		return height;
	}


	public String getName() {
		return name;
	}

}
