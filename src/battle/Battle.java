package battle;

public class Battle {

	public static int animationCounter;
	public static boolean inBattleAnimation;
	public Battle(){
		enterBattleAnimation();
		
	}
	
	public void update(){
		
	}
	public void render(){
		
	}
	public void enterBattleAnimation(){
		if (animationCounter == 180){
			animationCounter = 0;
			inBattleAnimation = false;
		}
		inBattleAnimation = true;
		if (animationCounter < 180){
			animationCounter++;
		}
	
	}
}
