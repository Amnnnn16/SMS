import java.sql.*;
import java.util.Scanner;

public class App {
    static void display() throws Exception
    {
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_jdbc", "root", "");
        Statement stml=con.createStatement();
        ResultSet rs=stml.executeQuery("select * from students;");
        while(rs.next())
        {
            System.out.print(rs.getInt(1)+" ");
            System.out.print(rs.getString(2)+" ");
            System.out.println(rs.getInt(3));
        }
    }
    static void insert() throws Exception
    {
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_jdbc", "root", "");
        Statement stml=con.createStatement();
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter SAP -");
        int sap=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Name -");
        String name=sc.nextLine();
        System.out.println("Enter Percentage - ");
        int percentage=sc.nextInt();
        sc.nextLine();
        String query="insert into students values("+sap+",'"+name+"',"+percentage+");";
        stml.executeUpdate(query);
        System.out.println("Updated Successfully...");
    }
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        while(true)
        {
            try{
                display();
                break;
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}
