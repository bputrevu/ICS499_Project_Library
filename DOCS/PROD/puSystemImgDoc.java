/*
 * puSystemImgDoc.java - Uses JEditorPane to display System Implementation.
 * 4-3-2018
 */
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
//import java.awt.Dimension;

 public class puSystemImgDoc {
 JFrame myFrame = null;

   public puSystemImgDoc() {

        myFrame = new JFrame("Metro Library");
        myFrame.setSize(400, 1000);

        JEditorPane myPane = new JEditorPane();

        JScrollPane scrollPane = new JScrollPane(myPane);
         myFrame.getContentPane().add(scrollPane);
         myFrame.setBounds( 0, 0, 1000, 500);

        myPane.setContentType("text/html");
        myPane.setText("<h1>Metro Library Documentation System Implementation</h1>"
          + "<p>            </p> "
          //+ "<p> <img src='file:images/systemDiagram.png' width='300' height='200'>  </p> "
          + "<p> <img src='file:images/systemDiagram.png' width='600' height='400'>  </p> "
          + "<p>            </p> "
          );
        myFrame.setVisible(true);
  }
 }
