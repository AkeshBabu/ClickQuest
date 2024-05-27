package Main;

public class SceneChanger{
	
	GameManager gm;
	
	public SceneChanger(GameManager gm) {
		
		this.gm = gm;
	}

	public void showScene1() {		

		gm.ui.bgPanel[1].setVisible(true);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.messageText.setText("Let's defeat the Demon Lord and save the world!");
			
		gm.stopMusic(gm.currentMusic);
		gm.currentMusic = gm.fieldMusic;
		gm.playMusic(gm.currentMusic);
	}
	public void showScene2() {

		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[2].setVisible(true);	
		gm.ui.messageText.setText("");
		
		gm.stopMusic(gm.currentMusic);
		gm.currentMusic = gm.fieldMusic2;
		gm.playMusic(gm.currentMusic);
		
		gm.bm.resetMonsterLife();
	}
	public void showScene3() {

		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(true);	
					
		gm.stopMusic(gm.currentMusic);	
		
		if(gm.player.defeatWerewolf==false) {
			gm.ui.messageText.setText("OMG the cave is inhabited by a werewolf!");
			gm.currentMusic = gm.battleMusic;
			gm.playMusic(gm.currentMusic);
		}
		else {
			gm.ui.messageText.setText("");
					
		}	
//		gm.ui.messageText.setText("You enter the cave. What is waiting for you inside...?\n\n"
//		+ "*** This is the end of the Demo. Thank you for playing! ***");
//		gm.ui.choiceB1.setVisible(true);
//		gm.ui.choiceB2.setVisible(true);
	}
	public void showGameOverScreen(int currentBgNum) {
		
		gm.ui.bgPanel[currentBgNum].setVisible(false);
		gm.ui.titleLabel.setVisible(true);
		gm.ui.titleLabel.setText("YOU DIED");
		gm.ui.restartButton.setVisible(true);
//		gm.ui.choiceB1.setVisible(false);
//		gm.ui.choiceB2.setVisible(false);
		
		gm.stopMusic(gm.fieldMusic);
//		gm.playSE(gm.deathSound);
	}
	public void exitGameOverScreen() {
		
		gm.ui.titleLabel.setVisible(false);
		gm.ui.restartButton.setVisible(false);
		gm.bm.resetMonsterLife();
		gm.player.setPlayerDefaultStatus();
	}
	public void showEndScreen(int currentBgNum) {
		
		gm.ui.bgPanel[currentBgNum].setVisible(false);
		gm.ui.titleLabel.setVisible(true);
		gm.ui.titleLabel.setText("Congratz!");
		gm.ui.messageText.setText("You have completed the Click Quest!\nThanks for playing!");
//		gm.ui.restartButton.setVisible(true);
		
		gm.stopMusic(gm.fieldMusic);
//		gm.playSE(gm.awesome);
	}
}

