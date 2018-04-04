/*
 * puCheckBook.java is the pop-up GUI to allow users to check-in or check-out books.
 * check-out works, check-in has not been developed yet.
 * 4-3-2018
 */
import javax.swing.*;
import java.awt.event.*;
class puCheckBook extends JFrame implements ActionListener{
  JRadioButton CheckIn, CheckOut;
  JButton b;
  JTextField searchField;

  puCheckBook(){
    searchField = new JTextField();
    searchField.setBounds(100,100,100,30);

    CheckIn=new JRadioButton("Check In");
    CheckIn.setBounds(100,200,100,30);

    CheckOut=new JRadioButton("Check Out");
    CheckOut.setBounds(100,250,100,30);

    ButtonGroup bg=new ButtonGroup();
    bg.add(CheckIn);
    bg.add(CheckOut);

    b=new JButton("Submit");
    b.setBounds(100,400,100,30);
    b.addActionListener(this);
    add(searchField);
    add(CheckIn);
    add(CheckOut);
    add(b);

    setSize(300,500);
    setLayout(null);
    setTitle("Metro Library");
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e){
    if(CheckIn.isSelected()){
      JOptionPane.showMessageDialog(this,"The check-in feature is not yet available.");
      String Title = searchField.getText();
      String SELECTION = "CheckIn";
      //puCheckResults ci = new puCheckResults();
      // Need to somehow pass a user ID
      //       String UID = "user01";
      //ci.checkBookIn(Title, SELECTION, UID);
    }

    if(CheckOut.isSelected()){
      //JOptionPane.showMessageDialog(this,"You selected AUTHOR.");
      String Title = searchField.getText();
      String SELECTION = "CheckOut";
      puCheckResults co = new puCheckResults();
      // Need to somehow pass a user ID
      String UID = "user01";
      co.checkBookOut(Title, SELECTION, UID);
    }
  }
}
