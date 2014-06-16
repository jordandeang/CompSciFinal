package com.pewpy.pewp.entity.mob;

import battle.Attack;
import battle.Battle;

import com.pewpy.pewp.Game;
import com.pewpy.pewp.graphics.Screen;
import com.pewpy.pewp.graphics.Sprite;
import com.pewpy.pewp.input.Keyboard;
import com.pewpy.pewp.sound.Sound;

public class Player extends Mob {

	public static Keyboard input;
	protected Sprite sprite;

	protected boolean walking = false;
	protected double battleCounter = 0;
	


	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.knight_forward;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.knight_forward;
	}

	public Player(int i, Keyboard input) {
		turnNumber = i;
		sprite = Sprite.knight_right;
		isTurn = false;
		hp = 100;
		
		
		
		
		this.input = input;
		a = new Attack();
	}

	public void update() {
		int xa = 0, ya = 0;
		super.update();
		if (!Game.inBattle) {

			if (input.up)
				ya--;
			if (input.down)
				ya++;
			if (input.left)
				xa--;
			if (input.right)
				xa++;
			battleCounter = Math.random() * 1000;
			if (battleCounter <= 20) {
				Game.sound.snd2.stop();
				Game.sound.snd.play();
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

		}else{
			if (input.up)
				Game.currentBattle.changeSelectorNumberUp();
			if (input.down)
				Game.currentBattle.changeSelectorNumberDown();
			if (input.left)
				Game.currentBattle.changeSelectorNumberLeft();
			if (input.right)
				Game.currentBattle.changeSelectorNumberRight();
			if (input.enter){
				
				Battle.battleQueue.enqueue(new Attack());
				attacking = true;
				
				isTurn=false;
				Game.currentBattle.nextTurn();
			}
		}

	}

	public void render(Screen screen) {
		if (dir == 0) {
			sprite = Sprite.knight_forward;
			if (walking) {
				if (animate % 20 > 10) {
					sprite = Sprite.knight_forward_1;
				} else {
					sprite = Sprite.knight_forward_2;
				}
			}
		}

		if (dir == 1) {
			sprite = Sprite.knight_right;
			if (walking) {
				if (animate % 20 > 10) {
					sprite = Sprite.knight_right_1;
				} else {
					sprite = Sprite.knight_right_2;
				}
			}
		}
		if (dir == 2) {
			sprite = Sprite.knight_back;
			if (walking) {
				if (animate % 20 > 10) {
					sprite = Sprite.knight_back_1;
				} else {
					sprite = Sprite.knight_back_2;
				}
			}
		}
		if (dir == 3) {
			sprite = Sprite.knight_left;
			if (walking) {
				if (animate % 20 > 10) {
					sprite = Sprite.knight_left_1;
				} else {
					sprite = Sprite.knight_left_2;

				}
			}
		}
		screen.renderPlayer(sprite.SIZE, x, y, sprite);
	}

	public void renderInBattle(Screen screen, int i) {
		int xa = 30;
		int ya = (i * 25 - 10);
		if (i == 1) {
			sprite = Sprite.knight_right_1;
			if (animate % 30 < 10) {
				sprite = Sprite.knight_right;
			}
			if (animate % 30 > 20) {
				sprite = Sprite.knight_right_2;
			}
			if(attacking){
				xa += 30;
				sprite = Sprite.knight_punch1;
				if (animate % 40 < 10) {
					sprite = Sprite.knight_punch2;
				}
				if (animate % 40 > 10 && animate % 40 <20) {
					sprite = Sprite.knight_punch3;
				}
				if(animate % 40 > 20 && animate % 40 < 30){
					sprite = Sprite.knight_punch4;
				}
			}
		}
		if (i == 2) {
			sprite = Sprite.mage_right1;
			if (animate % 30 < 10) {
				sprite = Sprite.mage_right2;
			}
			if (animate % 30 > 20) {
				sprite = Sprite.mage_right3;
			}
			if(attacking){
				xa += 30;
				sprite = Sprite.mage_punch1;
				if (animate % 40 < 10) {
					sprite = Sprite.mage_punch2;
				}
				if (animate % 40 > 10 && animate % 40 <20) {
					sprite = Sprite.mage_punch3;
				}
				if(animate % 40 > 20 && animate % 40 < 30){
					sprite = Sprite.mage_punch4;
				}
			}
		}
		if (i == 3) {
			sprite = Sprite.archer_right1;
			if (animate % 30 < 10) {
				sprite = Sprite.archer_right2;
			}
			if (animate % 30 > 20) {
				sprite = Sprite.archer_right3;
			}
			if(attacking){
				xa += 30;
				sprite = Sprite.archer_punch1;
				if (animate % 40 < 10) {
					sprite = Sprite.archer_punch2;
				}
				if (animate % 40 > 10 && animate % 40 <20) {
					sprite = Sprite.archer_punch3;
				}
				if(animate % 40 > 20 && animate % 40 < 30){
					sprite = Sprite.archer_punch4;
				}
			}
		}
		
		
		screen.renderMobInBattle(sprite, xa, ya, isTurn);
		screen.renderNameAndHealthBar(hp);
	}

}
