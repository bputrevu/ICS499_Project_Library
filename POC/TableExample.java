import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
public class TableExample extends JFrame
{
    public TableExample()
    {
        //headers for the table
        String[] columns = new String[] {
            "Grade", "Title", "Author", "ISBN"
        };

        //actual data for the table in a 2d array
        /*
        Object[][] data = new Object[][] {
            {1, "John", 40.0, false },
            {2, "Rambo", 70.0, false },
            {3, "Zorro", 60.0, true },
        };
        */

        //Get Object array from RecomendList.java
        RecomendList recomend = new RecomendList();
        Object[][] data = recomend.getResultSet();


        //create table with data
        JTable table = new JTable(data, columns);

        //add the table to the frame
        this.add(new JScrollPane(table));

        this.setTitle("Recomended Books");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TableExample();
            }
        });
    }
}
