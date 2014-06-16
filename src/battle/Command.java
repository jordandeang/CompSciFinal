package battle;

import com.pewpy.pewp.graphics.Screen;
import com.pewpy.pewp.graphics.Sprite;

public class Command {
	public Sprite sprite;
	public int sN;
	public Screen screen;
	public Command(){
		
	}
	public void render(Screen screen){
		screen.renderCommand(sprite);
	}
}
