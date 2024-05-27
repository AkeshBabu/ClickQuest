package Main;

import java.util.Random;

import Monster.Monster;
import Monster.Werewolf;

public class BattleManager {
	
	GameManager gm;
	Monster monster;
	Werewolf werewolf = new Werewolf();
	Random randomDie = new Random();
	
	public BattleManager(GameManager gm) {
		
		this.gm = gm;
	}
	public void resetMonsterLife() {
		// add all the monsters if needed
		werewolf.monsterLife = werewolf.monsterMaxLife;
	}
	
	public void setMonster() {		
		monster = werewolf;
		attack();
	}
	
	public void attack() {
		
		int playerDamage = randomDie.nextInt(gm.player.playerAttack)- monster.monsterDefense;
		if(playerDamage<0) {
			playerDamage=0;
		}
		gm.ui.messageText.setText("");
		gm.ui.messageText.append("You attack the " + monster.monsterName + " and give " + playerDamage + " damage!");
		monster.monsterLife -= playerDamage;
		if(monster.monsterLife<1) {
			win();
		}
		else {			
			int monsterDamage = randomDie.nextInt(monster.monsterAttack)-gm.player.playerDefense;
			if(monsterDamage<0) {
				monsterDamage=0;
			}
			gm.player.playerLife -= monsterDamage;
			gm.ui.messageText.append("\nThe " + monster.monsterName + " attacks you and give " + monsterDamage + " damage!");
			if(gm.player.playerLife<1) {
				gm.player.playerLife =0;
				gm.player.updatePlayerStatus();
				lose();
			}	
			else {
				gm.player.updatePlayerStatus();
			}					
		}
//		gm.playSE(gm.hitSound);
	}
	public void win() {
		
		gm.ui.messageText.append("\nYou have defeated the monster!");
		
		if(monster==werewolf) {
			gm.player.defeatWerewolf = true;
//			gm.stopMusic(gm.currentMusic);
		}
		else {			
		}
	}
	public void lose() {
	
		gm.ui.messageText.append("\nYou died!!");
		gm.sChanger.showGameOverScreen(3);
	}

}

