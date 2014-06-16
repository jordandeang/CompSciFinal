package com.pewpy.pewp.graphics;

import java.awt.Color;
import java.util.Random;

import com.pewpy.pewp.level.tile.Tile;

public class Screen {
	public int width, height;
	public int[] pixels;
	public final int MAP_SIZE = 16;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	public int xOffset, yOffset;

	public Screen(int w, int h) {
		width = w;
		height = h;
		pixels = new int[width * height];
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0
						|| ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y
						* tile.sprite.SIZE];
			}
		}
	}

	public void renderPlayer(int size, int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < size; y++) {
			int ya = y + yp;
			for (int x = 0; x < size; x++) {
				int xa = x + xp;
				if (xa < -size || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				int col = sprite.pixels[x + y * size];
				if (col != 0xFF7bd5fe)
					pixels[xa + ya * width] = col;
			}
		}
	}

	public void renderMobInBattle(Sprite sprite, int x, int y, boolean turnCheck) {
		for (int xa = 0; xa < sprite.SIZE; xa++) {
			int xp = xa + x;
			for (int ya = 0; ya < sprite.SIZE; ya++) {
				int yp = ya + y;
				int col = sprite.pixels[xa + ya * sprite.SIZE];
				if (col != 0xFF7bd5fe)
					pixels[xp + yp * width] = col;
			}
		}
		if (turnCheck) {
			renderTurnIndicator(x,y);
		}

	}

	public void renderBattle(int[] p) {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				pixels[x + y * width] = p[x + y * width];
			}
		}
	}

	public void renderTurnIndicator(int x, int y) {
		if (x < 150){
		for (int xa = 0; xa < Sprite.pointer_right.SIZE; xa++) {
			int xp = xa + x-16;
			for (int ya = 0; ya < Sprite.pointer_right.SIZE; ya++) {
				int yp = ya + y;
				int col = Sprite.pointer_right.pixels[xa + ya * Sprite.pointer_right.SIZE];
				if (col != 0xFF7bd5fe)
					pixels[xp + yp * width] = col;
			}
		}
		}
		if (x > 150){
		for (int xa = 0; xa < Sprite.pointer_left.SIZE; xa++) {
			int xp = xa + x+16;
			for (int ya = 0; ya < Sprite.pointer_left.SIZE; ya++) {
				int yp = ya + y;
				int col = Sprite.pointer_left.pixels[xa + ya * Sprite.pointer_left.SIZE];
				if (col != 0xFF7bd5fe)
					pixels[xp + yp * width] = col;
			}
		}
		}
	}
	public void renderNameAndHealthBar(int h){
		for (int xa = 0; xa < Sprite.knight_name.SIZE; xa++) {
			int xp = xa + 20;
			for (int ya = 0; ya < Sprite.knight_name.SIZE; ya++) {
				int yp = ya + 90;
				int col = Sprite.knight_name.pixels[xa + ya * Sprite.knight_name.SIZE];
				if (col != 0xFF7bd5fe)
					pixels[xp + yp * width] = col;
			}
		}
		for (int xa = 0; xa < Sprite.mage_name.SIZE; xa++) {
			int xp = xa + 20;
			for (int ya = 0; ya < Sprite.mage_name.SIZE; ya++) {
				int yp = ya + 106;
				int col = Sprite.mage_name.pixels[xa + ya * Sprite.mage_name.SIZE];
				if (col != 0xFF7bd5fe)
					pixels[xp + yp * width] = col;
			}
		}
		for (int xa = 0; xa < Sprite.archer_name.SIZE; xa++) {
			int xp = xa + 20;
			for (int ya = 0; ya < Sprite.archer_name.SIZE; ya++) {
				int yp = ya + 122;
				int col = Sprite.archer_name.pixels[xa + ya * Sprite.archer_name.SIZE];
				if (col != 0xFF7bd5fe)
					pixels[xp + yp * width] = col;
			}
		}
		for (int x = 59; x < 61 + (60*h/100); x++) {
			for (int y = 122; y <129 ; y++) {
				pixels[x + y * width] = 0xffC0C0C0;
			}
		}
		for (int x = 59; x < 61 + (60*h/100); x++) {
			for (int y = 137; y <144 ; y++) {
				pixels[x + y * width] = 0xffC0C0C0;
			}
		}
		
		for (int x = 59; x < 61 + (60*h/100); x++) {
			for (int y = 107; y <114 ; y++) {
				pixels[x + y * width] = 0xffC0C0C0;
			}
		}
		for (int x = 59; x < 61 + (60*h/100); x++) {
			for (int y = 122; y <129 ; y++) {
				pixels[x + y * width] = 0xffC0C0C0;
			}
		}
		for (int x = 59; x < 61 + (60*h/100); x++) {
			for (int y = 137; y <144 ; y++) {
				pixels[x + y * width] = 0xffC0C0C0;
			}
		}
		for (int x = 60; x < 60 + (60*h/100); x++) {
			for (int y = 108; y <113 ; y++) {
				pixels[x + y * width] = 0xffFF0000;
			}
		}
		for (int x = 60; x < 60 + (60*h/100); x++) {
			for (int y = 123; y <128 ; y++) {
				pixels[x + y * width] = 0xffFF0000;
			}
		}
		for (int x = 60; x < 60 + (60*h/100); x++) {
			for (int y = 138; y <143 ; y++) {
				pixels[x + y * width] = 0xffFF0000;
			}
		}
	}

	public void renderSelector(int position){
		if (position == 0){
		for (int xa = 0; xa < Sprite.underline.SIZE; xa++) {
			int xp = xa + 148;
			for (int ya = 0; ya < Sprite.underline.SIZE; ya++) {
				int yp = ya + 110;
				int col = Sprite.underline.pixels[xa + ya * Sprite.underline.SIZE];
				if (col != 0xFF7bd5fe)
					pixels[xp + yp * width] = col;
			}
		}
		}
		if (position == 1){
		for (int xa = 0; xa < Sprite.underline.SIZE; xa++) {
			int xp = xa + 198;
			for (int ya = 0; ya < Sprite.underline.SIZE; ya++) {
				int yp = ya + 110;
				int col = Sprite.underline.pixels[xa + ya * Sprite.underline.SIZE];
				if (col != 0xFF7bd5fe)
					pixels[xp + yp * width] = col;
			}
		}
		}
		if (position == 2){
		for (int xa = 0; xa < Sprite.underline.SIZE; xa++) {
			int xp = xa + 148;
			for (int ya = 0; ya < Sprite.underline.SIZE; ya++) {
				int yp = ya + 130;
				int col = Sprite.underline.pixels[xa + ya * Sprite.underline.SIZE];
				if (col != 0xFF7bd5fe)
					pixels[xp + yp * width] = col;
			}
		}
		}
		if (position == 3){
		for (int xa = 0; xa < Sprite.underline.SIZE; xa++) {
			int xp = xa + 198;
			for (int ya = 0; ya < Sprite.underline.SIZE; ya++) {
				int yp = ya + 130;
				int col = Sprite.underline.pixels[xa + ya * Sprite.underline.SIZE];
				if (col != 0xFF7bd5fe)
					pixels[xp + yp * width] = col;
			}
		}
		}
	}
	public void renderCommand(Sprite sprite){
		for (int xa = 0; xa < Sprite.attack.SIZE; xa++) {
			int xp = xa + 150;
			for (int ya = 0; ya < Sprite.attack.SIZE; ya++) {
				int yp = ya + 105;
				int col = Sprite.attack.pixels[xa + ya * Sprite.attack.SIZE];
				if (col != 0xFF7bd5fe)
					pixels[xp + yp * width] = col;
			}
		}
		for (int xa = 0; xa < Sprite.spell.SIZE; xa++) {
			int xp = xa + 200;
			for (int ya = 0; ya < Sprite.spell.SIZE; ya++) {
				int yp = ya + 105;
				int col = Sprite.spell.pixels[xa + ya * Sprite.spell.SIZE];
				if (col != 0xFF7bd5fe)
					pixels[xp + yp * width] = col;
			}
		}
		for (int xa = 0; xa < Sprite.item.SIZE; xa++) {
			int xp = xa + 150;
			for (int ya = 0; ya < Sprite.item.SIZE; ya++) {
				int yp = ya + 125;
				int col = Sprite.item.pixels[xa + ya * Sprite.item.SIZE];
				if (col != 0xFF7bd5fe)
					pixels[xp + yp * width] = col;
			}
		}
		for (int xa = 0; xa < Sprite.defend.SIZE; xa++) {
			int xp = xa + 200;
			for (int ya = 0; ya < Sprite.defend.SIZE; ya++) {
				int yp = ya + 125;
				int col = Sprite.defend.pixels[xa + ya * Sprite.def.SIZE];
				if (col != 0xFF7bd5fe)
					pixels[xp + yp * width] = col;
			}
		}
	}
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
}
