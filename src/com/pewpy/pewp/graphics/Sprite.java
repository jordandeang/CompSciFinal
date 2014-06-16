package com.pewpy.pewp.graphics;

public class Sprite {
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
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
	public static Sprite mesh1 = new Sprite(16, 0, 0, SpriteSheet.foresttiles);
	public static Sprite mesh2 = new Sprite(16, 1, 0, SpriteSheet.foresttiles);
	public static Sprite mesh3 = new Sprite(16, 0, 1, SpriteSheet.foresttiles);
	public static Sprite mesh4 = new Sprite(16, 1, 1, SpriteSheet.foresttiles);
	public static Sprite mesh5 = new Sprite(16, 0, 2, SpriteSheet.foresttiles);
	public static Sprite mesh6 = new Sprite(16, 1, 2, SpriteSheet.foresttiles);
	public static Sprite mesh7 = new Sprite(16, 0, 5, SpriteSheet.foresttiles);
	
	
	public static Sprite knight_forward = new Sprite(18,1,0, SpriteSheet.characters);
	public static Sprite knight_right = new Sprite(18,1,1, SpriteSheet.characters);
	public static Sprite knight_back = new Sprite(18,1,2, SpriteSheet.characters);
	public static Sprite knight_left = new Sprite(18,1,3, SpriteSheet.characters);
	
	public static Sprite knight_forward_1 = new Sprite(18,0,0, SpriteSheet.characters);
	public static Sprite knight_forward_2 = new Sprite(18,2,0, SpriteSheet.characters);
	
	public static Sprite knight_right_1 = new Sprite(18,0,1, SpriteSheet.characters);
	public static Sprite knight_right_2 = new Sprite(18,2,1, SpriteSheet.characters);
	
	public static Sprite knight_back_1 = new Sprite(18,0,2, SpriteSheet.characters);
	public static Sprite knight_back_2 = new Sprite(18,2,2, SpriteSheet.characters);
	
	public static Sprite knight_left_1 = new Sprite(18,0,3, SpriteSheet.characters);
	public static Sprite knight_left_2 = new Sprite(18,2,3, SpriteSheet.characters);
	
	public static Sprite knight_punch1 = new Sprite(18,3,0, SpriteSheet.characters);
	public static Sprite knight_punch2 = new Sprite(18,4,0, SpriteSheet.characters);
	public static Sprite knight_punch3 = new Sprite(18,5,0, SpriteSheet.characters);
	public static Sprite knight_punch4 = new Sprite(18,6,0, SpriteSheet.characters);
	
	public static Sprite knight_cast1 = new Sprite(18,3,1,SpriteSheet.characters);
	public static Sprite knight_cast2 = new Sprite(18,4,1,SpriteSheet.characters);
	public static Sprite knight_cast3 = new Sprite(18,5,1,SpriteSheet.characters);
	public static Sprite knight_cast4 = new Sprite(18,6,1,SpriteSheet.characters);
	
	public static Sprite mage_forward1 = new Sprite(18,0,4,SpriteSheet.characters);
	public static Sprite mage_forward2 = new Sprite(18,1,4,SpriteSheet.characters);
	public static Sprite mage_forward3 = new Sprite(18,2,4,SpriteSheet.characters);
	
	public static Sprite mage_right1 = new Sprite(18,0,5,SpriteSheet.characters);
	public static Sprite mage_right2 = new Sprite(18,1,5,SpriteSheet.characters);
	public static Sprite mage_right3 = new Sprite(18,2,5,SpriteSheet.characters);
	
	public static Sprite mage_back1 = new Sprite(18,0,6,SpriteSheet.characters);
	public static Sprite mage_back2 = new Sprite(18,1,6,SpriteSheet.characters);
	public static Sprite mage_back3 = new Sprite(18,2,6,SpriteSheet.characters);
	
	public static Sprite mage_left1 = new Sprite(18,0,7,SpriteSheet.characters);
	public static Sprite mage_left2 = new Sprite(18,1,7,SpriteSheet.characters);
	public static Sprite mage_left3 = new Sprite(18,2,7,SpriteSheet.characters);
	
	public static Sprite mage_punch1 = new Sprite(18,3,4,SpriteSheet.characters);
	public static Sprite mage_punch2 = new Sprite(18,4,4,SpriteSheet.characters);
	public static Sprite mage_punch3 = new Sprite(18,5,4,SpriteSheet.characters);
	public static Sprite mage_punch4 = new Sprite(18,6,4,SpriteSheet.characters);
	
	public static Sprite mage_cast1 = new Sprite(18,3,5,SpriteSheet.characters);
	public static Sprite mage_cast2 = new Sprite(18,4,5,SpriteSheet.characters);
	public static Sprite mage_cast3 = new Sprite(18,5,5,SpriteSheet.characters);
	public static Sprite mage_cast4 = new Sprite(18,6,5,SpriteSheet.characters);
	
	public static Sprite archer_forward1 = new Sprite(18,0,8,SpriteSheet.characters);
	public static Sprite archer_forward2 = new Sprite(18,1,8,SpriteSheet.characters);
	public static Sprite archer_forward3 = new Sprite(18,2,8,SpriteSheet.characters);
	
	public static Sprite archer_right1 = new Sprite(18,0,9,SpriteSheet.characters);
	public static Sprite archer_right2 = new Sprite(18,1,9,SpriteSheet.characters);
	public static Sprite archer_right3 = new Sprite(18,2,9,SpriteSheet.characters);
	
	public static Sprite archer_back1 = new Sprite(18,0,10,SpriteSheet.characters);
	public static Sprite archer_back2 = new Sprite(18,1,10,SpriteSheet.characters);
	public static Sprite archer_back3 = new Sprite(18,2,10,SpriteSheet.characters);
	
	public static Sprite archer_left1 = new Sprite(18,0,11,SpriteSheet.characters);
	public static Sprite archer_left2 = new Sprite(18,1,11,SpriteSheet.characters);
	public static Sprite archer_left3 = new Sprite(18,2,11,SpriteSheet.characters);
	
	public static Sprite archer_punch1 = new Sprite(18,3,8,SpriteSheet.characters);
	public static Sprite archer_punch2 = new Sprite(18,4,8,SpriteSheet.characters);
	public static Sprite archer_punch3 = new Sprite(18,5,8,SpriteSheet.characters);
	public static Sprite archer_punch4 = new Sprite(18,6,8,SpriteSheet.characters);
	
	public static Sprite archer_cast1 = new Sprite(18,3,9,SpriteSheet.characters);
	public static Sprite archer_cast2 = new Sprite(18,4,9,SpriteSheet.characters);
	public static Sprite archer_cast3 = new Sprite(18,5,9,SpriteSheet.characters);
	public static Sprite archer_cast41 = new Sprite(18,6,9,SpriteSheet.characters);
	
	public static Sprite ghost_forward1 = new Sprite(18,7,0,SpriteSheet.characters);
	public static Sprite ghost_forward2 = new Sprite(18,8,0,SpriteSheet.characters);
	public static Sprite ghost_forward3 = new Sprite(18,9,0,SpriteSheet.characters);
	
	public static Sprite ghost_right1 = new Sprite(18,7,1,SpriteSheet.characters);
	public static Sprite ghost_right2 = new Sprite(18,8,1,SpriteSheet.characters);
	public static Sprite ghost_right3 = new Sprite(18,9,1,SpriteSheet.characters);
	
	public static Sprite ghost_back1 = new Sprite(18,7,2,SpriteSheet.characters);
	public static Sprite ghost_back2 = new Sprite(18,8,2,SpriteSheet.characters);
	public static Sprite ghost_back3 = new Sprite(18,9,2,SpriteSheet.characters);
	
	public static Sprite ghost_left1 = new Sprite(18,7,3,SpriteSheet.characters);
	public static Sprite ghost_left2 = new Sprite(18,8,3,SpriteSheet.characters);
	public static Sprite ghost_left3 = new Sprite(18,9,3,SpriteSheet.characters);
	
	public static Sprite ghost_punch1 = new Sprite(18,10,0,SpriteSheet.characters);
	public static Sprite ghost_punch2 = new Sprite(18,11,0,SpriteSheet.characters);
	public static Sprite ghost_punch3 = new Sprite(18,12,0,SpriteSheet.characters);
	public static Sprite ghost_punch4 = new Sprite(18,13,0,SpriteSheet.characters);
	
	public static Sprite ghost_cast1 = new Sprite(18,10,1,SpriteSheet.characters);
	public static Sprite ghost_cast2 = new Sprite(18,11,1,SpriteSheet.characters);
	public static Sprite ghost_cast3 = new Sprite(18,12,1,SpriteSheet.characters);
	public static Sprite ghost_cast4 = new Sprite(18,13,1,SpriteSheet.characters);
	
	public static Sprite hotman_forward1 = new Sprite(18,7,4,SpriteSheet.characters);
	public static Sprite hotman_forward2 = new Sprite(18,8,4,SpriteSheet.characters);
	public static Sprite hotman_forward3 = new Sprite(18,9,4,SpriteSheet.characters);
	
	public static Sprite hotman_right1 = new Sprite(18,7,5,SpriteSheet.characters);
	public static Sprite hotman_right2 = new Sprite(18,8,5,SpriteSheet.characters);
	public static Sprite hotman_right3 = new Sprite(18,9,5,SpriteSheet.characters);
	
	public static Sprite hotman_back1 = new Sprite(18,7,6,SpriteSheet.characters);
	public static Sprite hotman_back2 = new Sprite(18,8,6,SpriteSheet.characters);
	public static Sprite hotman_back3 = new Sprite(18,9,6,SpriteSheet.characters);
	
	public static Sprite hotman_left1 = new Sprite(18,7,7,SpriteSheet.characters);
	public static Sprite hotman_left2 = new Sprite(18,8,7,SpriteSheet.characters);
	public static Sprite hotman_left3 = new Sprite(18,9,7,SpriteSheet.characters);
	
	public static Sprite hotman_punch1 = new Sprite(18,10,4,SpriteSheet.characters);
	public static Sprite hotman_punch2 = new Sprite(18,11,4,SpriteSheet.characters);
	public static Sprite hotman_punch3 = new Sprite(18,12,4,SpriteSheet.characters);
	public static Sprite hotman_punch4 = new Sprite(18,13,4,SpriteSheet.characters);
	
	public static Sprite hotman_cast1 = new Sprite(18,10,5,SpriteSheet.characters);
	public static Sprite hotman_cast2 = new Sprite(18,11,5,SpriteSheet.characters);
	public static Sprite hotman_cast3 = new Sprite(18,12,5,SpriteSheet.characters);
	public static Sprite hotman_cast4 = new Sprite(18,13,5,SpriteSheet.characters);
	
	public static Sprite pirate_forward1 = new Sprite(18,7,8,SpriteSheet.characters);
	public static Sprite pirate_forward2 = new Sprite(18,8,8,SpriteSheet.characters);
	public static Sprite pirate_forward3 = new Sprite(18,9,8,SpriteSheet.characters);
	
	public static Sprite pirate_right1 = new Sprite(18,7,9,SpriteSheet.characters);
	public static Sprite pirate_right2 = new Sprite(18,8,9,SpriteSheet.characters);
	public static Sprite pirate_right3 = new Sprite(18,9,9,SpriteSheet.characters);
	
	public static Sprite pirate_back1 = new Sprite(18,7,10,SpriteSheet.characters);
	public static Sprite pirate_back2 = new Sprite(18,8,10,SpriteSheet.characters);
	public static Sprite pirate_back3 = new Sprite(18,9,10,SpriteSheet.characters);
	
	public static Sprite pirate_left1 = new Sprite(18,7,11,SpriteSheet.characters);
	public static Sprite pirate_left2 = new Sprite(18,8,11,SpriteSheet.characters);
	public static Sprite pirate_left3 = new Sprite(18,9,11,SpriteSheet.characters);
	
	public static Sprite pirate_punch1 = new Sprite(18,10,8,SpriteSheet.characters);
	public static Sprite pirate_punch2 = new Sprite(18,11,8,SpriteSheet.characters);
	public static Sprite pirate_punch3 = new Sprite(18,12,8,SpriteSheet.characters);
	public static Sprite pirate_punch4 = new Sprite(18,13,8,SpriteSheet.characters);
	
	public static Sprite pirate_cast1 = new Sprite(18,10,9,SpriteSheet.characters);
	public static Sprite pirate_cast2 = new Sprite(18,11,9,SpriteSheet.characters);
	public static Sprite pirate_cast3 = new Sprite(18,12,9,SpriteSheet.characters);
	public static Sprite pirate_cast4 = new Sprite(18,13,9,SpriteSheet.characters);
	
	public static Sprite pointer_right = new Sprite(18, 0, 13, SpriteSheet.characters);
	public static Sprite pointer_left = new Sprite(18, 1, 13, SpriteSheet.characters);
	public static Sprite knight_name = new Sprite(36, 2, 1, SpriteSheet.characters);
	public static Sprite mage_name = new Sprite(36, 2, 3, SpriteSheet.characters);
	public static Sprite archer_name = new Sprite(36, 2, 5, SpriteSheet.characters);

	public static Sprite attack = new Sprite(36, 5, 1, SpriteSheet.characters);
	public static Sprite defend = new Sprite(36, 5, 3, SpriteSheet.characters);
	public static Sprite spell = new Sprite(36, 5, 5, SpriteSheet.characters);
	public static Sprite item = new Sprite(36, 6, 5, SpriteSheet.characters);
	public static Sprite underline = new Sprite(36, 6, 1, SpriteSheet.characters);
	public static Sprite wand = new Sprite(36, 2, 6 , SpriteSheet.characters);
	public static Sprite bow = new Sprite(36, 3, 6 , SpriteSheet.characters);
	public static Sprite arrow = new Sprite(36, 4, 6 , SpriteSheet.characters);
	public static Sprite fireball = new Sprite(36, 5, 6 , SpriteSheet.characters);
	public static Sprite sword = new Sprite(36, 6, 6 , SpriteSheet.characters);
	public static Sprite boss = new Sprite(225,0,0,SpriteSheet.boss);

	
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
