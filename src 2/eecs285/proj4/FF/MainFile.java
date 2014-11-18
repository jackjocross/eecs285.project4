package eecs285.proj4.FF;

import javax.swing.*;
import java.awt.*;

public class MainFile {
  public static HomeScreen win;
  public static StartScreen start;

  public static void main( String[] args )
  {
    start= new StartScreen();
    start.setMinimumSize(new Dimension(400, 400));
    start.pack();
    start.setVisible(true);
    start.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
    /*
    win = new HomeScreen();
    win.setMinimumSize(new Dimension(1000, 600));
    win.pack();
    win.setVisible(true);
    win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    */
  }
}
