package com.pewpy.pewp.entity.mob;

import com.pewpy.pewp.Game;
import com.pewpy.pewp.graphics.Screen;
import com.pewpy.pewp.graphics.Sprite;

public class Enemy extends Mob{
int number;
	public Enemy(int i){
		number = i;
		sprite = Sprite.knight_right;
	}
	public void renderInBattle(Screen screen, int placement) {
		int xa = Game.width-30-sprite.SIZE;
		int ya = (placement*25-10);
		if (number == 1) {
			sprite = Sprite.ghost_left1;
			if (animate % 30 < 10) {
				sprite = Sprite.ghost_left2;
			}
			if (animate % 30 > 20) {
				sprite = Sprite.ghost_left3;
			}
		}
		if (number == 2) {
			sprite = Sprite.hotman_left1;
			if (animate % 30 < 10) {
				sprite = Sprite.hotman_left2;
			}
			if (animate % 30 > 20) {
				sprite = Sprite.hotman_left3;
			}
		}
		if (number == 3) {
			sprite = Sprite.pirate_left1;
			if (animate % 30 < 10) {
				sprite = Sprite.pirate_left2;
			}
			if (animate % 30 > 20) {
				sprite = Sprite.pirate_left3;
			}
		}
		screen.renderMobInBattle(sprite, xa, ya);
	}

}
