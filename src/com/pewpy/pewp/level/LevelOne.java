package com.pewpy.pewp.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LevelOne extends Level	{

	
	public LevelOne(String path) {
		super(path);
	}

	
	
	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(LevelOne.class.getResource(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tiles = new int[w*h];
			image.getRGB(0,0,w,h,tiles, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception!");
		}
	}

	
	protected void generateLevel() {
		
	}
	
	
}
