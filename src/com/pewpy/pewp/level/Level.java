package com.pewpy.pewp.level;

import com.pewpy.pewp.graphics.Screen;
import com.pewpy.pewp.level.tile.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	protected void loadLevel(String path) {

	}
	
	protected void generateLevel() {

	}

	public void update() {

	}

	private void time() {
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x,  y, screen);
			
				}
			}
		}
	
		//treecorner1 70eb1d
		//dirt 22b14c
		//shrub ed1c24
		//forestwall 428249
		//treeside1 12bc26
		//treecorner2 32cf44
		//treebottom 0f911f
		//treetop 1e5a41
		//treemiddle 
		//treeside2 237c58
		//treecorner3 199d66
		//treecorner4 5cb08d
		//shorttree 7bd5fe
		//shorttree3 86b4e7
		//shorttree2 25384e
		//shorttree4 1c4676
		//puddle 1c7eed
		//riververt 5ca2f1
		//riverturn 437fc3
		//riverhor 1a569b
		//forestmiddle 1a9b32;
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if (tiles[x + y * width] == 0xff70eb1d) return Tile.forestcorner1;
		if (tiles[x + y * width] == 0xff22b14c) return Tile.dirt;
		if (tiles[x + y * width] == 0xffed1c24) return Tile.shrub;
		if (tiles[x + y * width] == 0xff428249) return Tile.forestwall;
		if (tiles[x + y * width] == 0xff12bc26) return Tile.forestside1;
		if (tiles[x + y * width] == 0xff32cf44) return Tile.forestcorner2;
		if (tiles[x + y * width] == 0xff0f911f) return Tile.forestbottom;
		if (tiles[x + y * width] == 0xff1e5a41) return Tile.foresttop;
		if (tiles[x + y * width] == 0xff237c58) return Tile.forestside2;
		if (tiles[x + y * width] == 0xff199d66) return Tile.forestcorner3;
		if (tiles[x + y * width] == 0xff5cb08d) return Tile.forestcorner4;
		if (tiles[x + y * width] == 0xff7bd5fe) return Tile.shorttree1;
		if (tiles[x + y * width] == 0xff86b4e7) return Tile.shorttree3;
		if (tiles[x + y * width] == 0xff25384e) return Tile.shorttree2;
		if (tiles[x + y * width] == 0xff1c4676) return Tile.shorttree4;
		if (tiles[x + y * width] == 0xff1c7eed) return Tile.puddle;
		if (tiles[x + y * width] == 0xff5ca2f1) return Tile.riververt;
		if (tiles[x + y * width] == 0xff437fc3) return Tile.riverturn;
		if (tiles[x + y * width] == 0xff1a569b) return Tile.riverhor;
		if (tiles[x + y * width] == 0xff1a9b32) return Tile.forestmiddle;
		return Tile.voidTile;
	}
}
