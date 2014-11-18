package eecs285.proj4.FF;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StartScreen extends JFrame {

  static private JButton createTeam = new JButton("Create Team");
  static private JButton createLeague = new JButton("Create League");
  static private JButton login = new JButton("Login");
  
  StartScreen() {
    JPanel screenPanel = new JPanel();
    screenPanel.setLayout(new BoxLayout(screenPanel, BoxLayout.Y_AXIS));
    MainListener hush = new MainListener();
    login.addActionListener(hush);
    createTeam.addActionListener(hush);
    createLeague.addActionListener(hush);
    screenPanel.add(login);
    screenPanel.add(createTeam);
    screenPanel.add(createLeague);
    
    this.add(screenPanel);
  
  }
  
  public class MainListener implements ActionListener 
  {
  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource() == login)
    {
      try {
        Login loginFrame = new Login();
        loginFrame.setVisible(true);
      } catch (Exception e2) {
        e2.printStackTrace();
      }
      dispose();
    }
    else if (e.getSource() == createTeam)
    {
      try {
        MakeTeam teamFrame = new MakeTeam();
        teamFrame.setVisible(true);
      } catch (Exception e3) {
        e3.printStackTrace();
      }
      dispose();
    }
    else if (e.getSource() == createLeague)
    {
      try {
        MakeLeague leagueFrame = new MakeLeague();
        leagueFrame.setVisible(true);
      } catch (Exception e4) {
        e4.printStackTrace();
      }
      dispose();
    }
    
  
}
  }
}