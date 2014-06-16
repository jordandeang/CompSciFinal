package battle;

import com.pewpy.pewp.entity.mob.Player;
import com.pewpy.pewp.graphics.Screen;
import com.pewpy.pewp.graphics.Sprite;

public class Attack extends Command {
	public int damage;

	public Attack() {
	}
	
	public void renderAttack(Screen screen, int turnnumber){
		if(turnnumber == 0){
			sprite = Sprite.sword;
			damage = 10;
		}
		if(turnnumber == 1){
			sprite = Sprite.wand;
			damage = 10;
		}

		if(turnnumber == 2){
			sprite = Sprite.bow;
			damage = 10;
		}
		screen.attackRender(turnnumber,sprite);
	}
}
