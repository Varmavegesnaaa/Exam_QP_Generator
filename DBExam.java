import java.sql.*;
import java.io.*;
import java.util.*;

public class DBExam {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/exam";
        String user = "root";
        String password ="";
        int n,in=0;
        Scanner sc = new Scanner(System.in);        
        System.out.println("Enter no.of Questions");
        n = sc.nextInt();

        String[] questions = new String[n];
        String[][] options = new String[n][4];
        String[] answers = new String[n];

        String take="",oin="";
        for(int i=0;i<n;i++){
            System.out.println("Enter Question "+(i+1));
            // qin = sc.nextLine();
            oin = sc.nextLine();
            take = sc.nextLine();
            questions[i] = "'"+take+"'";
            System.out.println("Enter Options for Question "+(i+1));
            for(int j=0;j<4;j++){
                oin = sc.nextLine();
                options[i][j] = "'"+oin+"'";
            }
            System.out.println("Enter correct option for Question "+(i+1)+" (1,2,3,4)");
            in = sc.nextInt();
            answers[i] = options[i][in-1];
        }
        try {
            int row=0;
        	//Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            for(int i=0;i<questions.length;i++){
                String ques = questions[i],ans=answers[i],opt1 = options[i][0],opt2 = options[i][1],opt3 = options[i][2],opt4 = options[i][3];
                String sql = "INSERT INTO exam VALUES ("+ques+","+ans+","+opt1+","+opt2+","+opt3+","+opt4+")";
                Statement statement = conn.createStatement();

                //Statement
                row = statement.executeUpdate(sql);
            }
            //PreparedStatment
            //int row = statement.executeUpdate();
            if (row > 0) {
                System.out.println("Recode updated.");
            }
            conn.close();
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
