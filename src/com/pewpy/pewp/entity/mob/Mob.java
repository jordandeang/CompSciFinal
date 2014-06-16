package com.pewpy.pewp.entity.mob;

import com.pewpy.pewp.Game;
import com.pewpy.pewp.entity.Entity;
import com.pewpy.pewp.graphics.Screen;
import com.pewpy.pewp.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	public int animate = 0;
	public int turnNumber;
	public boolean isTurn;
	public int hp;

	public void move(int xa, int ya) {
		if (xa != 0 && ya != 0) {
			moving = false;
			return;
		}

		if (xa > 0)
			dir = 1;
		if (xa < 0)
			dir = 3;
		if (ya > 0)
			dir = 2;
		if (ya < 0)
			dir = 0;

		if (!collision(0, ya)) {
			y += ya;
		}

		if (!collision(xa, 0)) {
			x += xa;
		}
	}

	public void update() {
		if (animate < 7500)
			animate++;
		else
			animate = 0;
	}

	private boolean collision(int xa, int ya) {
		boolean solid = false;
		for (int i = 0; i < 4; i++) {
			int xt = ((x + xa) + i % 2 * 10 + 2) / 16;
			int yt = ((y + ya) + i / 2 * 10 + 5) / 16;
			if (level.getTile(xt, yt).solid())
				solid = true;
		}

		return solid;
	}



	public void renderInBattle(Screen screen, int place) {

	}

	public void render() {

	}

}
