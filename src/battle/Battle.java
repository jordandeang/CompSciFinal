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
	public Player[] players;
	public Enemy[] enemies;
	public static int numberOfMobs = 3;
	private Keyboard key;
	public int turnCounter;
	
	public Battle(){
		players = new Player[numberOfMobs];
		enemies = new Enemy[numberOfMobs];
		for (int i = 0; i < players.length; i++){
			players[i] = new Player(i);
		}
		for (int j = 0; j < players.length; j++){
			enemies[j] = new Enemy((int) (Math.random()*3)+1, j+3);
		}
		pixels = new int[Game.width*Game.height];
		setTurn(0);
		load();

	}
	
	
	
	public void render(Screen screen){

		screen.renderBattle(pixels);
		for (int i = 0; i < numberOfMobs; i++){
			players[i].renderInBattle(screen, 3-i);
			enemies[i].renderInBattle(screen, 3-i);
		}

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
	public void setTurn(int t){
		turnCounter = t;
		for (int i = 0; i< numberOfMobs; i++){
			if (players[i].turnNumber == turnCounter){
				players[i].isTurn = true;
			}
			if (enemies[i].turnNumber == turnCounter){
				enemies[i].isTurn = true;
			}
		}
	}
	public void nextTurn(){
		turnCounter++;
		setTurn(turnCounter);
	}
}
