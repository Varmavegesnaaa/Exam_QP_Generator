import java.sql.*;
import java.io.*;

public class DBExam {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/exam";
        String user = "root";
        String password ="";
        String[] questions={"'Who Invented python?'", "'Who is tejasree'", "'who invented Love'","'What is Ravi Teja Hit movie?'"}; 
        String[][] options={{"'charless babbage'","'modi'", "'jagan'", "'none'"},{ "'a teacher'", "'a sadist'", "'a physco'", "'not a human'"}, {"'pavan'", "'lovers'", "'romeo'", "'chilika ran'"},{"'Idiot'","'Kick'","'Vikramarkudu'","'Krack'"}};
        String[] answers={options[0][3],options[1][1],options[2][3],options[3][1]};
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
