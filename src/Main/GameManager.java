package Main;

import java.net.URL;
import Event.Event01;
import Event.Event02;
import Event.Event03;

public class GameManager{
		
	// MAIN CLASS
	ActionHandler aHandler = new ActionHandler(this);	// Instantiate before UI class otherwise action won't work
	public UI ui = new UI(this);
	public Player player = new Player(this);
	public SceneChanger sChanger = new SceneChanger(this);		
	Music music = new Music();
	SE se = new SE();
	public BattleManager bm = new BattleManager(this);
	
	// EVENT CLASS
	public Event01 ev1 = new Event01(this);
	public Event02 ev2 = new Event02(this);
	public Event03 ev3 = new Event03(this);

	
	// SOUND
	public URL fieldMusic  = getClass().getClassLoader().getResource("audio//screen1bg.wav");
	public URL fieldMusic2  = getClass().getClassLoader().getResource("audio//greenbg.wav");
	public URL battleMusic  = getClass().getClassLoader().getResource("audio//wirewolfbg.wav");
	/*
	public URL deathSound  = getClass().getClassLoader().getResource("audio//darksoulsdeath.mp3");
	public URL hitSound  = getClass().getClassLoader().getResource("audio//hit.mp3");
	public URL healSound  = getClass().getClassLoader().getResource("audio//healSound.mp3");
	public URL guard01  = getClass().getClassLoader().getResource("audio//guard01.mp3");
	public URL guard02  = getClass().getClassLoader().getResource("audio//guard02.mp3");
	public URL guard03  = getClass().getClassLoader().getResource("audio//guard03.mp3");
	public URL guard03b  = getClass().getClassLoader().getResource("audio//guard03b.mp3");
	public URL guard04  = getClass().getClassLoader().getResource("audio//guard04.mp3");
	public URL guard05  = getClass().getClassLoader().getResource("audio//guard05.mp3");
	public URL guard06  = getClass().getClassLoader().getResource("audio//guard06.mp3");
	public URL awesome  = getClass().getClassLoader().getResource("audio//awesome.mp3");
	public URL chestopen  = getClass().getClassLoader().getResource("audio//dqchestopen.mp3");
	public URL enter  = getClass().getClassLoader().getResource("audio//dqstairs.mp3");
*/
	URL currentMusic;
	

	public static void main(String[] args) {
		
		new GameManager();	
	}
	public GameManager() {
		
		// SET MUSIC
		currentMusic = fieldMusic; // Do this before showScreen1 otherwise you get NullPointer to stop the current audio
		playMusic(currentMusic);
				
		// SET SCREEN
		player.setPlayerDefaultStatus();
		sChanger.showScene1();	
		
		ui.window.setVisible(true);
	
	}
	
	
	public void playSE(URL url){

		se.setFile(url);
		se.play(url);
	}
	public void playMusic(URL url) {
		
		music.setFile(url);
		music.play(url);
		music.loop(url);
	}
	public void stopMusic(URL url) {
		
		music.stop(url);
	}
	

}