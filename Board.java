//The following project revolves around a website called zetcode, at which this is a Board
class in Java that mainly helps animate a star image//

package Animation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel
  implements ActionListener {

//In the Board class we move a star that from the upper-left corner to the right-bottom corner//
 private final int B_WIDTH = 350;
 private final int B_HEIGHT = 350;
 private final int INITIAL_X = -40;
 private final int INITIAL_Y = -40;
 private final int DELAY = 25;
 
 private Image star;
 private Timer timer;
 private int x, y;
 
 //Five constants are defined. The first two constants are the board width and height. The
// fourth are the initial coordinates of the star. The last one determines the speed of the animation//
 
 public Board() {
      initBoard();
 }
//NOTE! The png file must be created inside of folder named 'resources' that resides in the src folder of the package, at which
//the image must have a size of at least 3KB with small enough dimensions that will fit into the screen//
 private void loadImage() {
    ImageIcon ii = new ImageIcon("src/resources/star.png");
    star = ii.getImage();
 }

//In the loadImage() method we create an instance of the ImageIcon class. The image is located 
//in the project directory. The getImage() method will return the Image object from this class. This object will be drawn on the board//
 private void initBoard() {
     setBackground(Color.BLACK);
     setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
     
     loadImage();
     
     x = INITIAL_X;
     y = INITIAL_Y;

     timer = new Timer(DELAY, this);
     timer.start();
//Here we create a Swing Timer class and call its start() method. Every DELAY minutes/second the timer will call the 
//the actionPerformed() method. In order to use the actionPerformed() method, we must implement the ActionListener interface//

  }
  
  @Override
  public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        drawStar(g); 
      }
//Custom painting is done in the paintComponent() method. Note that we also call the paintComponent()
//method of its parent. The actual painting is delegated to the drawStar() method//
      
      private void drawStar(Graphics g) {
        g.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync();
      }
//In the drawStar() method, we draw the image on the windows with the usage of the
//drawImage() method. The Toolkit.getDefaultToolkit().sync() synchronises the painting on systems that buffer graphic systems
//Without this line, the animation might not be smooth on Linux//
   
      @Override
      public void actionPerformed(ActionEvent e) {
          x += 1;
          y += 1;
          
          if (y > B_HEIGHT) {
          
            y = INITIAL_Y;
            x = INITIAL_X;
         }
         
         repaint();
      }
}
      
//The actionPerformed() method is repeatedly called by the timer. Inside the method, we increase the x and y values of the star object.
//Then we call the repaint() method which will cause the paintComponent() to be called. This way we regularly repaint the Board thuus making the animation//
