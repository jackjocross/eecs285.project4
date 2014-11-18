package eecs285.proj4.FF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.EventListener;



public class HomeScreen extends JFrame {
  private static JTextArea team_info = new JTextArea();
  
  
  public HomeScreen() {
    JTabbedPane tabbedPane = new JTabbedPane();

    DefaultListModel<String> team_model = new DefaultListModel<String>();
    JList<String> team_list = new JList<String>(team_model);
    
//    team_list.addListSelectionListener(new ListSelectionListener(){
//      public void valueChanged(ListSelectionEvent e){
//            int selectedIndex = this.getSelectedIndex();
//            //refresh the content based on the index
//            setContent(selectedIndex);
//      }
//    }
    
    
    team_model.addElement("Team 1");
    team_model.addElement("Team 2");
    team_model.addElement("Team 3");
    JPanel team_info_container = new JPanel();
    team_info_container.add(team_info);
    JPanel panel1 = new JPanel();
    
    panel1.setLayout(new GridLayout(1,2));
    panel1.add(team_list);
    panel1.add(team_info_container);
    tabbedPane.addTab("League", panel1);

    JComponent panel2 = makeTextPanel("My Team");
    
    
    tabbedPane.addTab("My Team", panel2);
    
    this.add(tabbedPane);
    
  }
  
  protected JComponent makeTextPanel(String text) {
    JPanel panel = new JPanel(false);
    JLabel filler = new JLabel(text);
    filler.setHorizontalAlignment(JLabel.CENTER);
    panel.setLayout(new GridLayout(1, 1));
    panel.add(filler);
    return panel;
}
  
  
}
