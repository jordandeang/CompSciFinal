package com.pewpy.pewp.level.tile;

import com.pewpy.pewp.graphics.Screen;
import com.pewpy.pewp.graphics.Sprite;

public class Tile {
	public int x, y;
	public Sprite sprite;
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static Tile forestcorner1 = new Tile(Sprite.forestcorner1);
	public static Tile foresttop = new Tile(Sprite.foresttop);
	public static Tile forestcorner4 = new Tile(Sprite.forestcorner4);
	public static Tile forestside1 = new Tile(Sprite.forestside1);
	public static Tile forestmiddle = new Tile(Sprite.forestmiddle);
	public static Tile forestside2 = new Tile(Sprite.forestside2);
	public static Tile forestcorner2 = new Tile(Sprite.forestcorner2);
	public static Tile forestbottom = new Tile(Sprite.forestbottom);
	public static Tile forestcorner3 = new Tile(Sprite.forestcorner3);
	public static Tile dirt = new Tile(Sprite.dirt);
	public static Tile shrub = new Tile(Sprite.shrub);
	public static Tile forestwall = new Tile(Sprite.forestwall);
	public static Tile shorttree1 = new Tile(Sprite.shorttree1);
	public static Tile shorttree2 = new Tile(Sprite.shorttree2);
	public static Tile shorttree3 = new Tile(Sprite.shorttree3);
	public static Tile shorttree4 = new Tile(Sprite.shorttree4);
	public static Tile puddle = new Tile(Sprite.puddle);
	public static Tile riververt = new Tile(Sprite.riververt);
	public static Tile riverturn = new Tile(Sprite.riverturn);
	public static Tile riverhor = new Tile(Sprite.riverhor);
	public static Tile log = new Tile(Sprite.log);
	//testicklesno
	//fukthepolis
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
