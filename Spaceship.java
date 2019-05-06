package Animation;

//The term sprite has several meanings. It is used to denote an image or an animation in a scene//
//It is also used to represent any movable object in a game//
//Also one of the meanings is the code that encapsulates a character in game.//
//In our tutorial by using sprite we refer to a movable object or its Java class//

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Spaceship {
 private int dx;
 private int dy;
 private int x = 40;
 private int y = 60;
 private int w;
 private int h;
 private Image image;
 
public Spaceship() {
  loadImage();
}

private void loadImage() {

    ImageIcon ii = new ImageIcon("src/resources/spaceship.png");
    image = ii.getImage();
    
    w = image.getWidth(null);
    h = image.getHeight(null);
    
}

public void move() {
    x += dx;
    y += dy;
    
}

public int getX() {
  return x;
}

public iint getY() {
  return y;
}

public int getWidth() {
  return w;
}

public int getHeight() [
  return image;
}

public void keyPressed(KeyEvent e) {
     int key = e.getKeyCode(0;
     
     if (key == KeyEvent.VK_LEFT) {
         dx = -2;
     }
     
     if (key == KeyEvent.VK_RIGHT) {
        dx = -2;
     }
     
     if (key == KeyEvent.VK_UP) {
        dy = -2;
     }
     
     if (key == KeyEvent.VK_DOWN) {
        dy = 2;
     }
   }
   
   public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }
        
        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
        
        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }
        
        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
            

   
      
  
