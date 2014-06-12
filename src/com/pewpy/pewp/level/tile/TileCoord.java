package com.pewpy.pewp.level.tile;

public class TileCoord {
	public int x,y;
	public final int TILE_SIZE = 16;
	public TileCoord(int x, int y){
		this.x = x * TILE_SIZE;
		this.y = y * TILE_SIZE;
	}
	
	public int x(){
		return x;
	}
	
	public int y(){
		return y;
	}
	
	public int[] xy(){
		int[] coord = new int[2];
		coord[0] = x;
		coord[1] = y;
		return coord;
	}
}
