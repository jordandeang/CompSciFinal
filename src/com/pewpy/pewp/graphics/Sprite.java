package com.pewpy.pewp.graphics;

public class Sprite {
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0xff2E203C);

	public static Sprite forestcorner1 = new Sprite(16,2,0,SpriteSheet.forest);
	public static Sprite foresttop = new Sprite(16,3,0,SpriteSheet.forest);
	public static Sprite forestcorner4 = new Sprite(16,4,0,SpriteSheet.forest);
	public static Sprite forestside1 = new Sprite(16,2,1,SpriteSheet.forest);
	public static Sprite forestmiddle = new Sprite(16,3,1,SpriteSheet.forest);
	public static Sprite forestside2 = new Sprite(16,4,1,SpriteSheet.forest);
	public static Sprite forestcorner2 = new Sprite(16,2,2,SpriteSheet.forest);
	public static Sprite forestbottom = new Sprite(16,3,2,SpriteSheet.forest);
	public static Sprite forestcorner3 = new Sprite(16,4,2,SpriteSheet.forest);
	public static Sprite dirt = new Sprite(16,4,6,SpriteSheet.forest);
	public static Sprite shrub = new Sprite(16,1,5,SpriteSheet.forest);
	public static Sprite forestwall = new Sprite(16,0,1,SpriteSheet.forest);
	public static Sprite shorttree1 = new Sprite(16,0,3,SpriteSheet.forest);
	public static Sprite shorttree2 = new Sprite(16,0,4,SpriteSheet.forest);
	public static Sprite shorttree3 = new Sprite(16,1,3,SpriteSheet.forest);
	public static Sprite shorttree4 = new Sprite(16,1,4,SpriteSheet.forest);
	public static Sprite puddle = new Sprite(16,3,4,SpriteSheet.forest);
	public static Sprite riververt = new Sprite(16,2,5,SpriteSheet.forest);
	public static Sprite riverturn = new Sprite(16,2,6,SpriteSheet.forest);
	public static Sprite riverhor = new Sprite(16,3,5,SpriteSheet.forest);
	public static Sprite log = new Sprite(16,2,3,SpriteSheet.forest);
	
	
	
	
	public static Sprite player_forward = new Sprite(16,1,3, SpriteSheet.tiles);
	public static Sprite player_right = new Sprite(16,1,4, SpriteSheet.tiles);
	public static Sprite player_back = new Sprite(16,1,5, SpriteSheet.tiles);
	public static Sprite player_left = new Sprite(16,1,6, SpriteSheet.tiles);
	
	public static Sprite player_forward_1 = new Sprite(16,0,3, SpriteSheet.tiles);
	public static Sprite player_forward_2 = new Sprite(16,2,3, SpriteSheet.tiles);
	
	public static Sprite player_right_1 = new Sprite(16,0,4, SpriteSheet.tiles);
	public static Sprite player_right_2 = new Sprite(16,2,4, SpriteSheet.tiles);
	
	public static Sprite player_back_1 = new Sprite(16,0,5, SpriteSheet.tiles);
	public static Sprite player_back_2 = new Sprite(16,2,5, SpriteSheet.tiles);
	
	public static Sprite player_left_1 = new Sprite(16,0,6, SpriteSheet.tiles);
	public static Sprite player_left_2 = new Sprite(16,2,6, SpriteSheet.tiles);
	
	
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		pixels = new int[SIZE * SIZE];
		load();
	}

	public Sprite(int size, int color) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}

	private void setColor(int color) {
		for (int i = 0; i < SIZE * SIZE; i++) {
			pixels[i] = color;
		}
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y)
						* sheet.SIZE];

			}
		}
	}
}
