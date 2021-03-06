package battle;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.pewpy.pewp.Game;
import com.pewpy.pewp.entity.mob.Enemy;
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
	public static MyQueue battleQueue;
	public static int selectorNumber;
	public static Command[] commands;

	public Battle(Keyboard key) {
		battleQueue = new MyQueue();
		this.key = key;
		players = new Player[numberOfMobs];
		enemies = new Enemy[numberOfMobs];
		commands = new Command[4];
		commands[0] = new Attack();
		commands[1] = new Spell();
		commands[2] = new Item();
		commands[3] = new Defend();
		selectorNumber = 0;
		for (int i = 0; i < numberOfMobs; i++) {
			players[i] = new Player(i, key);
			enemies[i] = new Enemy((int) (Math.random() * 3) + 1, i + 3);
		}

		pixels = new int[Game.width * Game.height];
		setTurn(0);
		load();

	}

	public void render(Screen screen) {
		if ((enemies[0].hp < 0 && enemies[1].hp < 0 && enemies[2].hp < 0) || (players[0].hp < 0 && players[1].hp < 0 && players[2].hp <2) ){
			Game.inBattle = false;
			Game.sound.snd.stop();
			Game.sound.snd2.play();
		}
		screen.renderBattle(pixels);
		for (int i = 0; i < numberOfMobs; i++) {
			players[i].renderInBattle(screen, i + 1);
			enemies[i].renderInBattle(screen, i + 1);
			if (players[i].attacking){
				players[i].a.renderAttack(screen,players[i].turnNumber);
				for (int j = 0; j < numberOfMobs;j++){
					enemies[j].hp-=1;
				}
				if (players[i].animate % 100 < 2){
				players[i].attacking = false;
				}
				
			
			}
			if (enemies[i].attacking){
				for (int j = 0; j < numberOfMobs;j++){
					players[j].hp-=1;
				}
				if (enemies[i].animate % 100 < 2){
				enemies[i].attacking = false;
				}
				
			
			}
		}
		for (int j = 0; j < commands.length; j++) {
			commands[j].render(screen);
		}
		screen.renderSelector(selectorNumber);

	}

	public void enterBattleAnimation() {
		if (animationCounter < 180) {
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

	public void setTurn(int t) {
		turnCounter = t;
		for (int i = 0; i < numberOfMobs; i++) {
			if (players[i].turnNumber == turnCounter) {
				players[i].isTurn = true;
			} else {
				players[i].isTurn = false;
			}
			if (enemies[i].turnNumber == turnCounter) {
				enemies[i].isTurn = true;
			} else {
				enemies[i].isTurn = false;
			}
		}
	}

	public void nextTurn() {

		if (turnCounter < 5) {
			turnCounter++;
			setTurn(turnCounter);
		}

		if (turnCounter == 5) {
			turnCounter = 0;
			setTurn(turnCounter);
		}
	}

	public void changeSelectorNumberRight() {
		if (selectorNumber == 1 || selectorNumber == 3) {
			changeSelectorNumberLeft();
		} else {
			selectorNumber++;
		}
	}

	public void changeSelectorNumberLeft() {
		if (selectorNumber == 0 || selectorNumber == 2) {
			changeSelectorNumberRight();
		} else {
			selectorNumber--;
		}
	}

	public void changeSelectorNumberUp() {
		if (selectorNumber == 0 || selectorNumber == 1) {
			changeSelectorNumberDown();
		} else {
			selectorNumber -= 2;
		}
	}

	public void changeSelectorNumberDown() {
		if (selectorNumber == 2 || selectorNumber == 3) {
			changeSelectorNumberUp();
		} else {
			selectorNumber += 2;
		}
	}

	public int getSelectorNumber() {
		return selectorNumber;
	}


}
