import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LibraryGUI extends JFrame {
        public JFrame frame;
        public JPanel panel;
        public JScrollPane tableContainer;
        public JButton btn1;
        public JLabel  lab1;
        public JTextField  txt1;
        public ImageIcon image1;
        public JLabel imglab1;
        public JTable table;

   public LibraryGUI() {

        setLayout(new FlowLayout());
        //setLayout(new BorderLayout());

        btn1 = new JButton("Recommended Books");
        add(btn1);

        //lab1 = new JLabel("Search for Book");
        //lab1 = new JLabel("");
        //add(lab1);

        //txt1 = new JTextField(15);
        //add(txt1);

        //image1 = new ImageIcon(getClass().getResource("books.png"));
        //imglab1 = new JLabel(image1);
        //add(imglab1);

        panel = new JPanel();
        add(panel);
        //panel.setVisible(true);
        //panel.setLayout(new BorderLayout());

        event e = new event();
        btn1.addActionListener(e);
   }

   public class event implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           //lab1.setText("Click adds this text...");
        String[] columns = new String[] {
        "Grade", "Title", "Author", "ISBN"
        };

        RecomendList recomend = new RecomendList();
        Object[][] data = recomend.getResultSet();

        table = new JTable(data, columns);
        tableContainer = new JScrollPane(table);

        //panel.setLayout(new BorderLayout());
        //panel.add(tableContainer, BorderLayout.CENTER);


        panel.add(tableContainer);



        //tableContainer.setVisible(true);

        //panel.setVisible(true);


        //frame.getContentPane().add(panel);
        //frame.pack();
        //frame.setVisible(true);



        //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //lab1.add(new JScrollPane(table));
        //table.setVisible(true);


        //lab1.setText(data);
        //lab1.add(new JScrollPane(table));
        //lab1.setTitle("Recomended Books");
        //lab1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //lab1.pack();
        //lab1.setVisible(true);
        }

    }

    public static void main(String[] args) {

        LibraryGUI gui = new LibraryGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(1200,600);
        //gui.pack();
        gui.setVisible(true);
        gui.setTitle("Library Tester");
    }

}
