package com.pewpy.pewp.entity.mob;

import com.pewpy.pewp.entity.Entity;
import com.pewpy.pewp.graphics.Sprite;

public abstract class Mob extends Entity {
	
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;

	public void move(int xa, int ya) {
		if(xa != 0 && ya != 0){
			moving = false;
			return;
		}
		
		if (xa > 0) dir = 1;
		if (xa < 0) dir = 3;
		if (ya > 0) dir = 2;
		if (ya < 0) dir = 0;
		
		
		
		if(!collision(0,ya)){
			y += ya;
		}
		
		if(!collision(xa,0)){
			x += xa;
		}
	}

	public void update() {

	}

	private boolean collision(int xa, int ya) {
		boolean solid = false;
		if(level.getTile((x+xa)/16,(y+ya)/16).solid()) solid = true;
		return solid;
	}
	
	public void render(){
		
	}
}
