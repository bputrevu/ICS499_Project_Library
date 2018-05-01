/*
 *sessionTester.java tests session.java
 *
 */

public class sessionTester {
  public static void main(String[] args){

    session trackID = new session();

    String mySetID = "testUser";
    trackID.setID(mySetID);
    String myGetID;
    myGetID = trackID.getID();
    System.out.printf("mySetID : %s \n",  mySetID);
    System.out.printf("myGetID : %s \n",  myGetID);
  }
}
