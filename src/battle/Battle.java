package battle;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.pewpy.pewp.Game;
import com.pewpy.pewp.entity.mob.Mob;
import com.pewpy.pewp.entity.mob.Player;
import com.pewpy.pewp.graphics.Screen;
import com.pewpy.pewp.graphics.SpriteSheet;

public class Battle {
	private static String battleImagePath = "/textures/battle_background.png";
	public static int animationCounter;
	public static boolean inBattleAnimation;
	public int[] pixels;
	private Player player1,player2,player3;
	private Mob mob1,mob2,mob3;
	public Battle(){
		player1 = new Player();
	/*	player2 = new Player();
		player3 = new Player();
		mob1 = new Player();
		mob2= new Player();
		mob3 = new Player();*/
		pixels = new int[Game.width*Game.height];
		load();
	
		
	}
	
	public void render(Screen screen){
		System.out.println("battle.render");
		screen.renderBattle(pixels);
		player1.renderInBattle(screen, 1);
	/*	player2.renderInBattle(screen, 2);
		player3.renderInBattle(screen, 3);
		mob1.renderInBattle(screen, 1);
		mob2.renderInBattle(screen, 2);
		mob3.renderInBattle(screen, 3);*/

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
