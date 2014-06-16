package com.pewpy.pewp.entity.mob;

import battle.Battle;

import com.pewpy.pewp.Game;
import com.pewpy.pewp.graphics.Screen;
import com.pewpy.pewp.graphics.Sprite;
import com.pewpy.pewp.input.Keyboard;
import com.pewpy.pewp.sound.Sound;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;

	private boolean walking = false;
	private double battleCounter = 0;
	public static Sound sound;

	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.player_forward;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_forward;
	}

	public void update() {
		super.update();
		if (!Game.inBattle) {
			int xa = 0, ya = 0;

			if (input.up)
				ya--;
			if (input.down)
				ya++;
			if (input.left)
				xa--;
			if (input.right)
				xa++;
			battleCounter = Math.random() * 1000;// 22000
			if (battleCounter <= 20) {
				sound = new Sound(1);
				System.out.println("IN BATTLE");
				Game.inBattle = true;
				Battle.inBattleAnimation = true;

			}

			if (xa != 0 || ya != 0) {
				move(xa, ya);
				walking = true;
			} else {
				walking = false;
			}
		}
	}

	public void render(Screen screen) {
		if (dir == 0) {
			sprite = Sprite.player_forward;
			if (walking) {
				if (animate % 20 > 10) {
					sprite = Sprite.player_forward_1;
				} else {
					sprite = Sprite.player_forward_2;
				}
			}
		}

		if (dir == 1) {
			sprite = Sprite.player_right;
			if (walking) {
				if (animate % 20 > 10) {
					sprite = Sprite.player_right_1;
				} else {
					sprite = Sprite.player_right_2;
				}
			}
		}
		if (dir == 2) {
			sprite = Sprite.player_back;
			if (walking) {
				if (animate % 20 > 10) {
					sprite = Sprite.player_back_1;
				} else {
					sprite = Sprite.player_back_2;
				}
			}
		}
		if (dir == 3) {
			sprite = Sprite.player_left;
			if (walking) {
				if (animate % 20 > 10) {
					sprite = Sprite.player_left_1;
				} else {
					sprite = Sprite.player_left_2;
				}
			}
		}
		screen.renderPlayer(sprite.SIZE, x, y, sprite);
	}

}
