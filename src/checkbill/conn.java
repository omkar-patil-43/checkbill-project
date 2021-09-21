
package checkbill;

import java.sql.*;

public class conn {
    Connection c;
    Statement s;
    public conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
          c = DriverManager.getConnection("jdbc:mysql://localhost:3306/checkbill","root","root");
          s = c.createStatement();
        }
    catch(Exception e){
        
    }
   }
    public static void main(String args[]){
        new conn();
    }
}
