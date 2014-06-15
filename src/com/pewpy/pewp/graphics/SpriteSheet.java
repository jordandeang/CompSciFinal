package com.pewpy.pewp.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private String path;
	public final int SIZE;
	public int[] pixels;
	public static SpriteSheet tiles = new SpriteSheet(
			"/textures/sprite_sheet.png", 256);
	public static SpriteSheet characters = new SpriteSheet(
			"/textures/char_sprite_sheet.png", 252);
	public static SpriteSheet forest = new SpriteSheet("/textures/forest.png", 256);
	public static SpriteSheet foresttiles_0 = new SpriteSheet("/textures/foresttiles_0.png", 256);
	
	public SpriteSheet(String path, int size) {
		this.path = path;
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		load();
	}

	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class
					.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
