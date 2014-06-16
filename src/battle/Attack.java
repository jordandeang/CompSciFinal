package battle;

import com.pewpy.pewp.graphics.Screen;
import com.pewpy.pewp.graphics.Sprite;

public class Attack extends Command {
	public int damage;
	public int turnnumber;
	public Attack(int i) {
		turnnumber = i;
	}
	
	public void render(Screen screen){
		if(turnnumber == 1){
			sprite = Sprite.sword;
			
		}else if(turnnumber == 2){
			//sprite = Sprite.wand;
		}else if(turnnumber == 3){
			//sprite = Sprite.bow;
		}
		screen.attackRender(turnnumber);
	}
}
