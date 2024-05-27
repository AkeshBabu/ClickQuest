package Event;

import Main.GameManager;

public class Event03 {
	
	GameManager gm;
	
	public Event03(GameManager gm) {
		
		this.gm = gm;		
	}
	
	public void lookMonster() {
		
		if(gm.player.defeatWerewolf==true) {
			gm.ui.messageText.setText("The monster is dead...");
		}
		else {
			gm.ui.messageText.setText("It's a monster!");
		}
	}
	public void talkMonster() {
		
		if(gm.player.defeatWerewolf==true) {
			gm.ui.messageText.setText("Monster: .......");
		}
		else {
			gm.ui.messageText.setText("Monster: DIE YOU FOOL!");
		}
	}
	public void attackMonster() {
		
		if(gm.player.defeatWerewolf==true) {
			gm.ui.messageText.setText("He is already dead...");
		}
		else {
			gm.bm.setMonster();
		}
		
	}
}
