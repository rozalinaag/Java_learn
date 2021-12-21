import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        //dbHandler.signUpUser("Denis", "Kornienko", "denis2000@mail.ru", "Pass623", "Moscow", "Male");

        ResultSet res =  dbHandler.getUser("ivan2000@mail.ru", "Pass123");
        int counter = 0;

            try {
                while(res.next()) {
                    counter ++;
                    System.out.println(res.getString("firstname"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        System.out.println(counter);
        if (counter>0) System.out.println("SUCCESS!" + res);

    }
}
