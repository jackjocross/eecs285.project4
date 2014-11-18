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

public class MakeLeague extends JFrame {

  
  private JPanel lPanel;
  private JButton confirm;
  private JButton cancel;
  private JLabel nameLabel;
  private JTextField name;
  private String nameStr;
  private JLabel Title;
  

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          MakeLeague frame = new MakeLeague();
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
  public MakeLeague() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    lPanel = new JPanel();
    lPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    lPanel.setLayout(new BorderLayout(0, 0));
    setContentPane(lPanel);
    LeagueListener hush = new LeagueListener();
    NameListener hush2 = new NameListener();
    Title = new JLabel("Welcome to League creation!");
    
////Advance Number input////////
    nameLabel = new JLabel("Enter League Name:");
    name = new JTextField(6); 
    name.addFocusListener(hush2);
    
    confirm = new JButton("Create");
    cancel = new JButton("Cancel");
    confirm.addActionListener(hush);
    cancel.addActionListener(hush);
    /////ADD ALL LISTENERS/////////////
    getContentPane().add(Title, "North");
    JPanel buttons = new JPanel();

    JPanel field = new JPanel();
    field.add(nameLabel);
    field.add(name);
    field.setLayout(new BoxLayout(field, getDefaultCloseOperation()));
    buttons.add(cancel);
    buttons.add(confirm);
    getContentPane().add(buttons, "South");
    getContentPane().add(field);
    //frame.add(lPanel);
    
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
  
  public class LeagueListener implements ActionListener 
  {
  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource() == confirm)
    {
      if(nameStr.isEmpty()){
        JOptionPane.showMessageDialog(null, "League Name is Empty.", 
            "Error", JOptionPane.OK_OPTION);
  }
      else{
        League newLeague = new League(nameStr);
        MakeTeam win = new MakeTeam();
        MakeTeam.league.setText(nameStr);
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
  }
  }
  }
