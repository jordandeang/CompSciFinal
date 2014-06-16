package com.pewpy.pewp;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import battle.Battle;

import com.pewpy.pewp.entity.mob.Player;
import com.pewpy.pewp.graphics.Screen;
import com.pewpy.pewp.input.Keyboard;
import com.pewpy.pewp.level.Level;
import com.pewpy.pewp.level.LevelOne;
import com.pewpy.pewp.level.tile.TileCoord;
import com.pewpy.pewp.sound.Sound;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	private JFrame frame;
	private Thread thread;
	private boolean running = false;
	private BufferedImage image = new BufferedImage(width, height,
			BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer())
			.getData();
	private Screen screen;
	public static final String title = "Pewp";
	int x = 0, y = 0;
	private Keyboard key;
	private Level level;
	private Player player;
	public static boolean inBattle;
	public Battle currentBattle;
	public static Sound sound;

	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		frame = new JFrame();
		screen = new Screen(width, height);
		key = new Keyboard();
		TileCoord playerSpawn = new TileCoord(8,12);
		level = new LevelOne("/textures/LevelOne.png");
		player = new Player(playerSpawn.x(), playerSpawn.y(), key);
		player.init(level);
		addKeyListener(key);
		currentBattle = new Battle();
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				ticks++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(ticks + "ticks, " + frames + "fps");
				frame.setTitle(title + " | " + ticks + " ticks, " + frames
						+ " fps");
				ticks = 0;
				frames = 0;
			}
		}
	}

	private void tick() {

		if (inBattle) {
			
			if (currentBattle.inBattleAnimation) {
				currentBattle.enterBattleAnimation();
				for (int i = (pixels.length* (currentBattle.animationCounter-1))/180;i < (pixels.length* currentBattle.animationCounter)/180; i++) {
					pixels[i] = 0xff000000;
					if (pixels[pixels.length-1] ==0xff000000){
						currentBattle.inBattleAnimation = false;
						System.out.println("NO LONGER IN BATTLE ANIMATION");
					}
				}
			}
		} else {
			key.update();
			
		}
		player.update();

	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		if (!inBattle) {
			int xScroll = player.x - screen.width / 2;
			int yScroll = player.y - screen.height / 2;
			level.render(xScroll, yScroll, screen);
			player.render(screen);
			for (int i = 0; i < pixels.length; i++) {
				pixels[i] = screen.pixels[i];
			}
			
		} 
		if (inBattle && !currentBattle.inBattleAnimation){
			System.out.println("in battle and no longer in battle animation");
			currentBattle.render(screen);
			for (int i = 0; i < pixels.length; i++) {
				pixels[i] = screen.pixels[i];
			}
		}


		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(Game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		game.start();

	}
}
