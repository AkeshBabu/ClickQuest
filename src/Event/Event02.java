package Event;

import Main.GameManager;

public class Event02 {
	
	public GameManager gm;
	
	public Event02(GameManager gm) {
		
		this.gm = gm;		
	}
	
	public void lookCave() {
		gm.ui.messageText.setText("It's a cave!"); 
	}
	public void talkCave() {
		gm.ui.messageText.setText("You hear the echo of your voice.");
	}
	public void enterCave() {
		if(gm.player.hasLantern==0) {
			gm.ui.messageText.setText("It's too dark to enter, Find a Lantern to enter the cave");
		}
		else {
			gm.sChanger.showScene3();
//			gm.playSE(gm.enter);
		}
	}
	public void lookRoot() {
		gm.ui.messageText.setText("There is something at the tree.");
	}
	public void talkRoot() {
		gm.ui.messageText.setText("They say plants grow well if you talk to them but this tree doesn't look like it needs encouragement.");
	}	
	public void searchRoot() {
		gm.ui.messageText.setText("You find a lantern!"); 
		gm.ui.lantern.setVisible(true);
		gm.player.hasLantern=1;
//		gm.playSE(gm.chestopen);
	}
		
}