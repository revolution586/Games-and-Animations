//We will use a Swing timer to create animation. This is the easiest but also the least effective way of animating objects in Java games//

package Animation;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class SwingTimerEx extends JFrame {
    public SwingTimerEx() {
    
    initUI();
  
  }
  
  private void initUI() {
  
      add(new Board());
      
      setResizable(false);
      pack();
//The setResizable() sets whether the frame can be resized. The pack() method causes this window to be sized
//to fit the preferred size and layouts of its children. Note that the order in which these two methods are called is important.//
//(The setResizable() changes the insets of the frame on some platforms; calling this method after the pack() method
//might lead to incorrect results - the star would not go precisely into the right-bottom border of the window)
      setTitle("Star");
      setLocationRelativeTo(null);
      setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE);
      
   }
   
   public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            SwingTimerEx ex = new SwingTimerEx();
            ex.setVisible(true);
        });
     }
}
