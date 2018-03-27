
import javax.swing.*;
import java.awt.event.*;
class puSearchBook extends JFrame implements ActionListener{
  JRadioButton ISBN_ID, TITLE, AUTHOR;
  JButton b;
  JTextField searchField;

  puSearchBook(){
    searchField = new JTextField();
    searchField.setBounds(100,100,100,30);

    ISBN_ID=new JRadioButton("ISBN_ID");
    ISBN_ID.setBounds(100,150,100,30);

    TITLE=new JRadioButton("TITLE");
    TITLE.setBounds(100,200,100,30);

    AUTHOR=new JRadioButton("AUTHOR");
    AUTHOR.setBounds(100,250,100,30);

    ButtonGroup bg=new ButtonGroup();
    bg.add(ISBN_ID);
    bg.add(TITLE);
    bg.add(AUTHOR);

    b=new JButton("Search");
    b.setBounds(100,400,100,30);
    b.addActionListener(this);
    add(searchField);
    add(ISBN_ID);
    add(TITLE);
    add(AUTHOR);
    add(b);

    setSize(300,500);
    setLayout(null);
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Metro Library");
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e){
    if(ISBN_ID.isSelected()){
      //JOptionPane.showMessageDialog(this,"You selected ISBN_ID.");
      int ISBN_ID  = Integer.parseInt(searchField.getText());

    }

    if(TITLE.isSelected()){
      //JOptionPane.showMessageDialog(this,"You selected TITLE.");
      String TITLE = searchField.getText();
      String SELECTION = "TITLE";
      puSearchResults sb = new puSearchResults();
      sb.search(TITLE, SELECTION);
    }

    if(AUTHOR.isSelected()){
      //JOptionPane.showMessageDialog(this,"You selected AUTHOR.");
      String AUTHOR = searchField.getText();
      String SELECTION = "AUTHOR";
      puSearchResults sb = new puSearchResults();
      sb.search(AUTHOR, SELECTION);
    }
  }
}
