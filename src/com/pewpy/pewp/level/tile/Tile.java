package com.pewpy.pewp.level.tile;

import com.pewpy.pewp.graphics.Screen;
import com.pewpy.pewp.graphics.Sprite;

public class Tile {
	public int x, y;
	public Sprite sprite;
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static TreeTile forestcorner1 = new TreeTile(Sprite.forestcorner1);
	public static TreeTile foresttop = new TreeTile(Sprite.foresttop);
	public static TreeTile forestcorner4 = new TreeTile(Sprite.forestcorner4);
	public static TreeTile forestside1 = new TreeTile(Sprite.forestside1);
	public static TreeTile forestmiddle = new TreeTile(Sprite.forestmiddle);
	public static TreeTile forestside2 = new TreeTile(Sprite.forestside2);
	public static TreeTile forestcorner2 = new TreeTile(Sprite.forestcorner2);
	public static TreeTile forestbottom = new TreeTile(Sprite.forestbottom);
	public static TreeTile forestcorner3 = new TreeTile(Sprite.forestcorner3);
	public static Tile dirt = new Tile(Sprite.dirt);
	public static GrassTile shrub = new GrassTile(Sprite.shrub);
	public static TreeTile forestwall = new TreeTile(Sprite.forestwall);
	public static TreeTile shorttree1 = new TreeTile(Sprite.shorttree1);
	public static TreeTile shorttree2 = new TreeTile(Sprite.shorttree2);
	public static TreeTile shorttree3 = new TreeTile(Sprite.shorttree3);
	public static TreeTile shorttree4 = new TreeTile(Sprite.shorttree4);
	public static Tile puddle = new Tile(Sprite.puddle);
	public static Tile riververt = new Tile(Sprite.riververt);
	public static Tile riverturn = new Tile(Sprite.riverturn);
	public static Tile riverhor = new Tile(Sprite.riverhor);
	public static Tile log = new Tile(Sprite.log);
	
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

	public boolean solid() {
		return false;
	}
}
