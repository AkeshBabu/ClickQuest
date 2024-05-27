package Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener{
	
	GameManager gm;

	public ActionHandler(GameManager gm) {
		
		this.gm = gm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("here?");
		
		String yourChoice = e.getActionCommand();
		
		switch(yourChoice) {
		// Screen 1
		case "lookCabin": gm.ev1.lookCabin();break;
		case "restCabin": gm.ev1.restCabin();break;
		case "talkCabin": gm.ev1.talkCabin();break;
		case "lookChest": gm.ev1.lookChest();break;
		case "openChest": gm.ev1.openChest();break;
		case "talkChest": gm.ev1.talkChest();break;
		case "lookGuard": gm.ev1.lookGuard();break;
		case "attackGuard": gm.ev1.attackGuard();break;
		case "talkGuard": gm.ev1.talkGuard();break;			
		// Screen 2
		case "lookCave": gm.ev2.lookCave();break;
		case "enterCave": gm.ev2.enterCave();break;
		case "talkCave": gm.ev2.talkCave();break;
		case "lookRoot": gm.ev2.lookRoot();break;
		case "searchRoot": gm.ev2.searchRoot();break;
		case "talkRoot": gm.ev2.talkRoot();break;
		// Scene 3
//		case "noway": gm.sChanger.showGameOverScreen(3); gm.ui.messageText.setText("What a fool...");break;
		case "lookMonster": gm.ev3.lookMonster();break;
		case "talkMonster": gm.ev3.talkMonster();break;
		case "attackMonster": gm.ev3.attackMonster();break;
		// Change Screen
		case "goScreen1": gm.sChanger.showScene1();break;
		case "goScreen2": gm.sChanger.showScene2();break;
		// Others
		case "restart": gm.sChanger.exitGameOverScreen(); gm.player.setPlayerDefaultStatus(); gm.sChanger.showScene1();break;			
		}
	}

}
