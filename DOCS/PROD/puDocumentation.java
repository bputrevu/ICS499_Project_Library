/*
 * puDocumentation.java - Uses JEditorPane to display user documentation using HTML.
 * 4-2-2018
 */
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
//import java.awt.Dimension;

 public class puDocumentation {
 JFrame myFrame = null;

   public puDocumentation() {

        myFrame = new JFrame("Metro Library");
        myFrame.setSize(400, 1000);

        JEditorPane myPane = new JEditorPane();

        JScrollPane scrollPane = new JScrollPane(myPane);
         myFrame.getContentPane().add(scrollPane);
         myFrame.setBounds( 0, 0, 1000, 500);

        myPane.setContentType("text/html");
        myPane.setText("<h1>Metro Library Documentation</h1>"
          + "<p> <img src='file:images/books.png' width='100' height='100'>           </p> "
          + "<h2>Table of contents           </h2>"
          + "<p> 1.     Introduction, purpose and summary of features </p>        "
          + "<p> 2.     User Functions with examples       </p>   "
          + "<p> 3. Frequently Asked Questions          </p>"
          + "<p> 4.     Troubleshooting          </p>"
          + "<p> 5.     Glossary          </p>"
          + "<p> 6.     Index          </p>"
          + "          "

          + "<h2>1.     Introduction, purpose and summary of features         </h2> "
          + "<p>The Metro Library is an online application used to manage books you wish to check-out, put a hold on (reserve) or to return. The features of this application may be run anywhere at your convenience. Books can then be physically picked up/dropped off from our many locations or you may opt to have them shipped instead.            </p> "

          + "<h2>2.     User Functions with examples          </h2> "
          + "<h3>Logging into Metro Library           </h3>"
          + "<p>To login, enter your user-id and password into the application login dialog box.            </p> "
          + "<p>Figure 1: <img src='file:images/login.png' width='200' height='200'>           </p> "
          + "<p>Once logged in you may access Metro Library functions by selecting the menu button located at the upper left part of the application panel.            </p> "
          + "<p>Figure 2: <img src='file:images/menu.png' width='200' height='100'>           </p> "
          + "<p>Next select the My Metro Library button to see all the available features available to you.            </p> "
          + "<p>Figure 3: <img src='file:images/MyMenu.png' width='200' height='100'>           </p> "
          + "<p>            </p> "

          + "<h3>Searching for a book           </h3>"
          + "<p>You have the option to search by book title or book author. To search for a book, select the search catalog item from the Metro Library menu (see figure 3). Select the title or author radio button and enter the search word in the text box. For example, if you wanted to see all available books authored by George Bernard Shaw, you enter shaw in the search box, select the author radio button and select the search button, as depicted in figure 4. <b>Tip:</b> If you are not sure of the name or spelling you can try to enter the parts that are known (without wildcards) with better results.            </p> "
          + "<p>Figure 4: <img src='file:images/search.png' width='100' height='150'>           </p> "
          + "<p>You will receive a list of available books based on your selection.            </p> "
          + "<p>Figure 5: <img src='file:images/searchResult.png' width='200' height='100'>           </p> "

          + "<h3>Check a book out           </h3>"
          + "<p>To check out a book select the check out a book item from the menu. Select the book to check out and select the check-out button. </p> "
          + "<p>            </p> "

          + "<h3>Check a book back in           </h3>"
          + "<p>When returning a book back to the library, you can physically return it to the library or check it in online and either ship the book to the library.            </p> "
          + "<p>            </p> "

          + "<h3>Add a hold on a book           </h3>"
          + "<p>            </p> "
          + "<p>            </p> "

          + "<h3>Remove a hold on a book           </h3>"
          + "<p>            </p> "
          + "<p>            </p> "

          + "<h3>Renewing a book           </h3>"
          + "<p>            </p> "
          + "<p>            </p> "

          + "<h3>Printing a transactions           </h3>"
          + "<p>            </p> "
          + "<p>            </p> "



          + "<h2>3. Frequently Asked Questions          </h2> "
          + "<p><b>How can I get help:</b> Metro Library Support line: 1-800-232-7682  </p> "
          + "<p>            </p> "

          + "<h2>4.     Troubleshooting          </h2> "
          + "<p><b>What do I do if I can't login?</b> This could mean one of the following:            </p> "
          + "<p>Figure 6: <img src='file:images/passIncorrect.png' width='200' height='100'>           </p> "
          + "<p> • The user ID or password you entered is incorrect. If you click ok, you will be prompted to try reentering your information.            </p> "
          + "<p> • Your account has been locked due to too many failed login attempts. See how to contact support in section #3.            </p> "
          + "<p> • You don’t currently have an account setup. See how to contact support in section #3.           </p> "
          + "<p>            </p> "


          + "<h2>5.     Glossary          </h2> "
          + "<p><b>Dialog box </b> A dialog box is any graphics (GUI) box that asks for information requesting you to enter information into text boxes and then clicking a button to continue processing.            </p> "
          + "<p><b> GUI (Graphical User Interface)</b> -  This refers to any of the application graphics used for the purpose of running program features and functions.            </p> "
          + "<p><b>Radio button </b> -  Radio buttons are push buttons that select an item from a list in GUI applications.            </p> "
          + "<p><b>Text box </b> -  A text box is a box that you can type information into that the application uses to process, as when searching for a book.            </p> "
          + "<p><b>Wildcards </b> -  Wildcards are symbols (examples: ? * [1-4]) that some systems use to indicate one or more letters that are unknown when performing functions such as searching. The Metro Library system has built-in search capability, so wildcards are not necessary.            </p> "
          + "<p>            </p> "


          + "<h2>6.     Index          </h2> "
          + "<p>            </p> "
          + "<p>            </p> "
          + "          "




);

        myFrame.setVisible(true);
  }
 }
