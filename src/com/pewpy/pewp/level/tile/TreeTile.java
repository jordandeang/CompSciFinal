package com.pewpy.pewp.level.tile;

import com.pewpy.pewp.graphics.Screen;
import com.pewpy.pewp.graphics.Sprite;

public class TreeTile extends Tile {

	public TreeTile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean solid(){
		return true;
	}
}
