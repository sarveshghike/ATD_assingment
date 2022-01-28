package AnytimeDeveloper;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Assignement
{

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println(" driver loaded... ");
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        Connection con = DriverManager.getConnection(url, "system", "orcl");
        System.out.println("Connected successfully .... ");

        Statement st = con.createStatement();

//      Insert student data into Student table
        int k = st.executeUpdate("insert into student values(101,'Omkar','02-10-2002','01-01-2022')");
        System.out.println(k + "Value Inserted");


//        Update student data into Student table
           int s= st.executeUpdate("Update student set student_no = 102 where student_no =101");
           System.out.println(s+"row updated");


//        Delete student data from Student table
          int n  =st.executeUpdate("delete student where student_no=102");
          System.out.println(n+" rows deleted ");

        //Get a list of all students
        ResultSet rs = st.executeQuery("select * from student");
        while (rs.next())
        {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDate(3) + " " + rs.getDate(4));
        }
        rs.close();

        //Get one student information depending on the student id filter.
        System.out.println("Student By ID");
        ResultSet rd = st.executeQuery("select * from student where student_no=101");
        while (rd.next())
        {
            System.out.println(rd.getInt(1) + " " + rd.getString(2) + " " + rd.getDate(3) + " " + rd.getDate(4));
            rs.close();
        }

    }
}
