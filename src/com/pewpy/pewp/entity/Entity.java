package com.pewpy.pewp.entity;

import java.util.Random;

import com.pewpy.pewp.graphics.Screen;
import com.pewpy.pewp.level.Level;

public abstract class Entity {

	public int x, y;
	private boolean removed = false;
	protected Level level;


	public void update() {

	}

	public void render(Screen screen) {
		
	}

	public void remove() {
		removed = true;
	}

	public boolean isRemoved() {
		return removed;
	}
	
	public void init(Level level){
		this.level = level;
	}
}
