package Main;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class UI {
	
	// MAIN UI
	JFrame window;
	public JTextArea messageText;	
	public JPanel bgPanel[] = new JPanel[20];
	JLabel bgLabel[] = new JLabel[20];
	public JButton choiceB1,choiceB2;
	
	// PLAYER UI
	JPanel lifePanel;
	JLabel life[] = new JLabel[6];	
	JPanel inventoryPanel;
	public JLabel sword;
	public JLabel lantern;
	public JLabel shield;
	
	// GAME OVER UI
	public JLabel titleLabel;
	public JButton restartButton;	
	
	// CLASS
	GameManager gm;
	
	public UI(GameManager gm) {
		
		this.gm = gm;
		
		createMainField();
		createPlayerField();
		createGameOverField();
		generateScreen();							
	}
	public void createMainField() {
		
		window = new JFrame("Click Quest");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
							
		messageText = new JTextArea();
		messageText.setBounds(50,410,700,150);
		messageText.setBackground(Color.black);
		messageText.setForeground(Color.white);
		messageText.setEditable(false);
		messageText.setLineWrap(true);
		messageText.setWrapStyleWord(true); 
		messageText.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		window.add(messageText);
		choiceB1 = new JButton("Add to your wishlist");
		choiceB1.setBounds(190,320,200,50);
		choiceB1.setBackground(new Color(39,67,89));
		choiceB1.setForeground(new Color(97,195,240));
		choiceB1.setFocusPainted(false);
		choiceB1.setFont(new Font("Arial", Font.PLAIN, 17));
		choiceB1.setVisible(false);
		window.add(choiceB1);
		choiceB2 = new JButton("No way");
		choiceB2.setBounds(400,320,200,50);
		choiceB2.setBackground(new Color(39,67,89));
		choiceB2.setForeground(new Color(97,195,240));
		choiceB2.setFocusPainted(false);
		choiceB2.setFont(new Font("Arial", Font.PLAIN, 17));
		choiceB2.addActionListener(gm.aHandler);
		choiceB2.setActionCommand("noway");
		choiceB2.setVisible(false);
		window.add(choiceB2);
		
	}
	public void createBackgroundImage(int num, String bgFileName) {
		
		bgPanel[num] = new JPanel();
		bgPanel[num].setBounds(50,50,700,350);
		bgPanel[num].setBackground(Color.black);
		bgPanel[num].setLayout(null);
		bgPanel[num].setVisible(false); // So panel 2 or later panels doesn't show up at the beginning
		window.add(bgPanel[num]);
		
		bgLabel[num] = new JLabel();
		bgLabel[num].setBounds(0,0,700,350);	
		
		ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFileName));
		Image image = bgIcon.getImage().getScaledInstance(700, 350, Image.SCALE_DEFAULT); // Adjust the size to the label
		bgIcon = new ImageIcon(image);
		bgLabel[num].setIcon(bgIcon);
		
//		bgPanel[num].add(bgLabel[num]);  DON'T ADD Background image to the panel yet!!!!
	}
	public void createObject(int bgNum, int objX, int objY, int objWidth, int objHeight, String objFileName, 
			String choice1Name, String choice2Name, String choice3Name, String choice1Command, String choice2Command, String choice3Command) {
		
		// CREATE POP MENU
		JPopupMenu popMenu = new JPopupMenu(); 
		
		// CREATE POP MENU ITEMS
		JMenuItem menuItem[] = new JMenuItem[4]; // Use [1], [2], [3] 				
		menuItem[1] = new JMenuItem(choice1Name);
		menuItem[1].addActionListener(gm.aHandler);
		menuItem[1].setActionCommand(choice1Command);
		popMenu.add(menuItem[1]);
		
		menuItem[2] = new JMenuItem(choice2Name);
		menuItem[2].addActionListener(gm.aHandler);
		menuItem[2].setActionCommand(choice2Command);
		popMenu.add(menuItem[2]);
		
		menuItem[3] = new JMenuItem(choice3Name);
		menuItem[3].addActionListener(gm.aHandler);
		menuItem[3].setActionCommand(choice3Command);
		popMenu.add(menuItem[3]);
		
		// CREATE OBJECTS
		JLabel objectLabel = new JLabel();
		objectLabel.setBounds(objX,objY,objWidth,objHeight);
//		objectLabel.setOpaque(true);  // Use this when you want to check where the blank object is
//		objectLabel.setBackground(Color.blue);  // Use this when you want to check where the blank object is
		
		ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objFileName));
		Image image = objectIcon.getImage().getScaledInstance(objWidth, objHeight, Image.SCALE_DEFAULT);
		objectIcon = new ImageIcon(image);
		objectLabel.setIcon(objectIcon);
		
		objectLabel.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {				
				if(SwingUtilities.isRightMouseButton(e)){					
					popMenu.show(objectLabel, e.getX(), e.getY());
				}	
			}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			
		});
		bgPanel[bgNum].add(objectLabel);						
	}
	public void createArrowButton(int bgNum, int x, int y, int width, int height, String arrowFileName, String command) {
				
		ImageIcon arrowIcon = new ImageIcon(getClass().getClassLoader().getResource(arrowFileName));
		Image image = arrowIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		arrowIcon = new ImageIcon(image);
		
		JButton arrowButton = new JButton();
		arrowButton.setBounds(x,y,width,height);
		arrowButton.setBackground(Color.black);
		arrowButton.setContentAreaFilled(false);
		arrowButton.setIcon(arrowIcon);
		arrowButton.setBorderPainted(false);
		arrowButton.addActionListener(gm.aHandler);
		arrowButton.setActionCommand(command);
		arrowButton.setVisible(true);
		
		bgPanel[bgNum].add(arrowButton);
	}
	public void createPlayerField() {
		
		lifePanel = new JPanel();
		lifePanel.setBounds(50,0,250,50);
		lifePanel.setBackground(Color.black);
		lifePanel.setLayout(new GridLayout(1,5));
		window.add(lifePanel);
		
		ImageIcon lifeICon = new ImageIcon(getClass().getClassLoader().getResource("heart.png"));
		Image image = lifeICon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
		lifeICon = new ImageIcon(image);
		
		int i =1;
		while(i<6) {
			life[i] = new JLabel();
			life[i].setIcon(lifeICon);
			lifePanel.add(life[i]);
			i++;
		}				
		
		inventoryPanel = new JPanel();
		inventoryPanel.setBounds(650,0,100,50);
		inventoryPanel.setBackground(Color.black);
		inventoryPanel.setLayout(new GridLayout(1,3));
		window.add(inventoryPanel);
				
		// CREATE SWORD
		sword = new JLabel();
		ImageIcon swordIcon = new ImageIcon(getClass().getClassLoader().getResource("plain-dagger.png"));
		image = swordIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
		swordIcon = new ImageIcon(image);
		sword.setIcon(swordIcon);
		inventoryPanel.add(sword);
		
		shield = new JLabel();
		ImageIcon shieldIcon = new ImageIcon(getClass().getClassLoader().getResource("dragon-shield.png"));
		image = shieldIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
		shieldIcon = new ImageIcon(image);
		shield.setIcon(shieldIcon);
		inventoryPanel.add(shield);
		
		lantern = new JLabel();
		ImageIcon lanternIcon = new ImageIcon(getClass().getClassLoader().getResource("lantern-flame.png"));
		image = lanternIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
		lanternIcon = new ImageIcon(image);
		lantern.setIcon(lanternIcon);
		inventoryPanel.add(lantern);
	}
	public void createGameOverField() {
		
		titleLabel = new JLabel("",JLabel.CENTER);
		titleLabel.setBounds(200,150,400,200);
		titleLabel.setFont(new Font("Times New Roman",Font.PLAIN,70));
		titleLabel.setForeground(Color.red);
		titleLabel.setVisible(false);
		window.add(titleLabel);
		
		restartButton = new JButton("Click here to restart");
		restartButton.setBounds(340,320,120,50);
		restartButton.setBorder(null);
		restartButton.setBackground(null);
		restartButton.setForeground(Color.white);
		restartButton.setFocusPainted(false);
		restartButton.addActionListener(gm.aHandler);
		restartButton.setActionCommand("restart");
		restartButton.setVisible(false);
		window.add(restartButton);	
	}
	
	// SCREEN GENERATION
	public void generateScreen() {
		// SCREEN1
		createBackgroundImage(1,"greenbg700x350.png"); // bgPanelNum, fileName
		createObject(1,450,130,250,200,"hut 200x200.png","Look","Talk","Rest","lookCabin","talkCabin","restCabin");
		createObject(1,300,285,70,52,"chest 70x70 .png","Look","Talk","Open","lookChest","talkChest","openChest");
		createObject(1,70,180,136,150,"guard 150x150.png","Look","Talk","Attack","lookGuard","talkGuard","attackGuard");
		createArrowButton(1,0,170,50,50,"leftarroww.png","goScreen2"); 			
		bgPanel[1].add(bgLabel[1]);  // IMPORTANT!  ADD background after objects otherwise it hides all the objects. ADD background image IN THE END!
	    
		// SCREEN2
		createBackgroundImage(2,"cave222.png");
		createObject(2,0,100,70,300,"Blank.png","Look","Talk","Enter","lookCave","talkCave","enterCave");
		createObject(2,355,250,50,50,"Blank.png","Look","Talk","Search","lookRoot","talkRoot","searchRoot");
		createArrowButton(2,650,170,50,50,"rightarroww.png","goScreen1"); 			
		bgPanel[2].add(bgLabel[2]);	
		
		// SCREEN3
		createBackgroundImage(3,"cave.png");
//		createObject(3,250,80,270,250,"halloween-3973250_1280.png","Look","Talk","Enter","lookCave","talkCave","enterCave");
		createObject(3,250,80,200,250,"wirewolf 200x300 .png","Look","Talk","Attack","lookMonster","talkMonster","attackMonster");
		createArrowButton(3,650,170,50,50,"rightarroww.png","goScreen2"); 		
//		createArrowButton(3,325,50,50,50,"uparrow50x50.png","goScreen1"); 		
		bgPanel[3].add(bgLabel[3]);	
	}

}
