package Main;

public class Player {
	
	GameManager gm;
	
	// PLAYER STATUS
	public int playerMaxLife = 5;
	public int playerLife = 3;
	public int playerStrength = 3;
	public int playerEndurance = 1;
	public int playerAttack;
	public int playerDefense;
	
	public int hasSword;
	public int hasShield;
	public int hasLantern;
	public int weaponPower;
	public int shieldPower;
	
	public boolean defeatWerewolf = false;

	
	public Player(GameManager gm) {
		
		this.gm = gm;		
	}
	public void setPlayerDefaultStatus() {
		
		playerMaxLife = 5;
		playerLife=3;
		playerStrength = 3;
		playerEndurance = 1;
		hasSword=0;
		hasShield=0;
		hasLantern=0;
		weaponPower=0;
		shieldPower=0;
		
		defeatWerewolf = false;
		updatePlayerStatus();
	}
	public void updatePlayerStatus() {
		
		// REMOVE ALL LIFE FIRST
		int i=1;
		while(i<6) { 
			gm.ui.life[i].setVisible(false);
			i++;
		}	
		// RESET LIFE
		int lifeCount = playerLife;
		while(lifeCount!=0) {
			gm.ui.life[lifeCount].setVisible(true);
			lifeCount--;
		}
		playerAttack = playerStrength + weaponPower;
		playerDefense = playerEndurance + shieldPower;
		
		// CHECK PLAYER ITEMS
		if(hasSword==0) {
			gm.ui.sword.setVisible(false);			
		}
		if(hasSword==1) {
			gm.ui.sword.setVisible(true);
		}
		if(hasShield==0) {
			gm.ui.shield.setVisible(false);
		}
		if(hasShield==1) {
			gm.ui.shield.setVisible(true);
		}
		if(hasLantern==0) {
			gm.ui.lantern.setVisible(false);
		}
		if(hasLantern==1) {
			gm.ui.lantern.setVisible(true);
		}
	}

}