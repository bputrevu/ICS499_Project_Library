/*
 * checkUser.java -
 * See if a user-id and password exist in MariaDB AUTH table.
 * If exists, authentication is successful & retrun success
 * otherwise return failed authentication.
 * 4-23-2018
 */
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;
 import java.sql.PreparedStatement;

 public class checkUser {
  private ResultSet rs = null;
  private Connection conn = null;
  PreparedStatement stmt = null;
  String RESULT = null;

        public String verifyUser(String UserName, String Password) {
        String searchUser = UserName;
        String searchPass = Password;
        String sql, sql_A, sql_B;
        System.out.printf("searchUser is: %s \n",  searchUser);
        System.out.printf("searchPass: %s \n",  searchPass);
        // See if user & password are in AUTH table.
        sql = "select * from AUTH where name = ? and pass = ?";
        //sql_A = "%" + searchUser + "%";
        //sql_B = "%" + searchPass + "%";
        sql_A = searchUser;
        sql_B = searchPass;
        try {
          Class.forName("org.mariadb.jdbc.Driver").newInstance();
          String connectionUrl = "jdbc:mysql://localhost:3306/prod";
          String connectionUser = "user01";
          String connectionPassword = "password";
          conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
          stmt = conn.prepareStatement(sql);
          stmt.setString(1, sql_A);
          stmt.setString(2, sql_B);
          rs = stmt.executeQuery();
          if (rs.next()) {
          // If rs.next() returns a result, it indicates a row has been matched
          // in SQL table AUTH. This means the user and pass exists.
              System.out.printf("%s exists. \n", searchUser);
              System.out.printf("%s Returning TRUE. \n", searchUser);
              RESULT = "TRUE";
          } else {
              System.out.printf("%s is NOT! in the database. \n", searchUser);
              System.out.printf("%s Returning FALSE. \n", searchUser);
              RESULT = "FALSE";
          }
        } catch (Exception e) {
        e.printStackTrace();
        }
      finally {
              try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
              try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
              try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
          System.out.printf("User or password does not exist. \n");
        }
        return RESULT;
    }
  }
