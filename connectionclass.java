package staff;

import java.sql.*;
public class connectionclass {
    Connection con;
    public Statement stm;
    public connectionclass()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql:///staffattendance","root","root@98");
            stm=con.createStatement();
        }
        catch (Exception ex){
            ex.printStackTrace();

        }}
}
//
//
//}

