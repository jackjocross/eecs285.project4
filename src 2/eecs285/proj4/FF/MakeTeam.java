package eecs285.proj4.FF;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class MakeTeam extends JFrame {

  
  private JPanel lPanel;
  private JLabel Title;
  private JButton confirm;
  private JButton cancel;
  private JLabel nameLabel;
  private JTextField name;
  private JLabel leagueLabel;
  static public JTextField league;
  private JCheckBox commissioner;
  private String nameStr;
  private String leagueStr;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          MakeTeam frame = new MakeTeam();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public MakeTeam() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    lPanel = new JPanel();
    lPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    lPanel.setLayout(new BorderLayout(0, 0));
    setContentPane(lPanel);
    Title = new JLabel("Welcome to team creation!");
    TeamListener hush = new TeamListener();
    NameListener hush2 = new NameListener();
    LeagueNameListener hush3 = new LeagueNameListener();

    
    commissioner = new JCheckBox("Make yourself commissioner");
    commissioner.setMnemonic(KeyEvent.VK_C); 
    commissioner.setSelected(false);
    
////Advance Number input////////
    leagueLabel = new JLabel("Enter League Name to Enter:");
    league = new JTextField(6); 

  nameLabel = new JLabel("Enter Team Name:");
  name = new JTextField(6); 
  
  confirm = new JButton("Create");
  cancel = new JButton("Cancel");
  /////ADD ALL LISTENERS/////////////
  commissioner.addActionListener(hush);
  confirm.addActionListener(hush);
  cancel.addActionListener(hush);
  name.addFocusListener(hush2);
  league.addFocusListener(hush3);
  getContentPane().add(Title, "North");
  JPanel buttons = new JPanel();
  name.add(nameLabel);
  league.add(leagueLabel);
  JPanel fields = new JPanel();
  buttons.add(cancel);
  buttons.add(confirm);
  fields.add(leagueLabel);
  fields.add(league);
  fields.add(nameLabel);
  fields.add(name);
  fields.add(commissioner);
  
  fields.setLayout(new BoxLayout(fields, getDefaultCloseOperation()));
  lPanel.add(fields);
  getContentPane().add(buttons, "South");


  }
public class NameListener implements FocusListener{

  @Override
  public void focusGained(FocusEvent e) {
    //Let user edit
  }

  @Override
  public void focusLost(FocusEvent e) {
    nameStr = name.getText();
  }
  }
public class LeagueNameListener implements FocusListener{

  @Override
  public void focusGained(FocusEvent e) {
    //Let user edit
  }

  @Override
  public void focusLost(FocusEvent e) {
    leagueStr = league.getText();
  }
  }
public class TeamListener implements ActionListener 
{
  public boolean found = false; 
  public boolean bComm = false;
public void actionPerformed(ActionEvent e)
{
  if (e.getSource() == confirm)
  {
    if(nameStr.isEmpty()){
      JOptionPane.showMessageDialog(null, "Team Name is Empty.", 
          "Error", JOptionPane.OK_OPTION);
}
    else if(leagueStr.isEmpty()){
      JOptionPane.showMessageDialog(null, "League Name is Empty.", 
          "Error", JOptionPane.OK_OPTION);
}
    else{
      Team tempTeam = new Team(nameStr);
      tempTeam.commissioner=true;
      /*
      for(League tempLeague: Database.leagues){
        if(tempLeague.leagueName == leagueStr){
          found = true;
          tempLeague.addteam(tempTeam);
      }
      */
      found = true;
      if(!found){
        JOptionPane.showMessageDialog(null, "League Not Found.", 
            "Error", JOptionPane.OK_OPTION);
      }
      HomeScreen win = new HomeScreen();
      win.setMinimumSize(new Dimension(1000, 600));
      win.pack();
      win.setVisible(true);
      win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    //System.exit(0);
    dispose();
    }
  else if (e.getSource() == cancel)
  {
    System.exit(0);
  }
  else if (e.getSource() == commissioner)
  {
    if(commissioner.isSelected())
      bComm = true;
    else
      bComm = false;
  }
}
}

}