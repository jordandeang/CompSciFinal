package battle;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.pewpy.pewp.Game;
import com.pewpy.pewp.entity.mob.Enemy;
import com.pewpy.pewp.entity.mob.Mob;
import com.pewpy.pewp.entity.mob.Player;
import com.pewpy.pewp.graphics.Screen;
import com.pewpy.pewp.input.Keyboard;

public class Battle {
	private static String battleImagePath = "/textures/battle_background.png";
	public static int animationCounter;
	public static boolean inBattleAnimation;
	public int[] pixels;
	public Player player1,player2,player3;
	public Mob mob1,mob2,mob3;
	private Keyboard key;
	
	public Battle(){
		player1 = new Player();
		player2 = new Player();
		player3 = new Player();
		mob1 = new Enemy((int) (Math.random()*3)+1);
		mob2= new Enemy((int) (Math.random()*3)+1);
		mob3 = new Enemy((int) (Math.random()*3)+1);
		pixels = new int[Game.width*Game.height];
		load();

	}
	
	
	
	public void render(Screen screen){

		screen.renderBattle(pixels);
		player1.renderInBattle(screen, 1);
		player2.renderInBattle(screen, 2);
		player3.renderInBattle(screen, 3);
		mob1.renderInBattle(screen, 1);
		mob2.renderInBattle(screen, 2);
		mob3.renderInBattle(screen, 3);

	}
	public void enterBattleAnimation(){
		if (animationCounter < 180){
			animationCounter++;
		}
	
	}
	private void load() {
		try {
			BufferedImage image = ImageIO.read(Battle.class
					.getResource(battleImagePath));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
