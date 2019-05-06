//This the Board class for the Spaceship project, ignore the Star project//
package Spaceship;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
	
	private Timer timer;
	private SpaceShip spaceShip;
	private final int DELAY = 10;
	
	public Board() {
		
		initBoard();
		
	}
	
	private void initBoard() {
		
		addKeyListener(new TAdapter());
		setBackground(Color.black);
		setFocusable(true);
		
		spaceShip = new SpaceShip();
		
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		doDrawing(g);
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void doDrawing(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(spaceShip.getImage(), spaceShip.getX(),spaceShip.getY(), this);
	}
//In the doDrawing() method, we draw the spaceship with the drawImage() method//
//We get the image and the coordinates from the sprite class//
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		step();
	}
//The actionPerformed() method is called every DELAY ms//
//We call the step() method//	
	
	private void step() {
		
		spaceShip.move();
		
		repaint(spaceShip.getX()-1, spaceShip.getY()-1,
				spaceShip.getWidth()+2, spaceShip.getHeight()+2);
	}
//We move the sprite and repaint the part of the board that has changed//
//We use a small optimisation technique that repaints only the small area of the windows that actually changed//
	
	private class TAdapter extends KeyAdapter {
		
		@Override
		public void keyReleased(KeyEvent e) {
			spaceShip.keyReleased(e);
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			spaceShip.keyPressed(e);
		}
	}
}

//This is the Board class//
//In the Board class we listen for key events//
//The overridden methods of the KeyAdapter class delegate the processing to the methods of the Craft class//

