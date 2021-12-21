import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser,
                dbPass);
        return dbConnection;
    }

    public void signUpUser(String firstName, String lastName, String userName,
                           String password, String location, String gender){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USER_FIRSTNAME + "," + Const.USER_LASTNAME + "," +
                Const.USER_USERNAME + "," + Const.USER_PASSWORD + "," +
                Const.USER_LOCATION + "," + Const.USER_GENDER + ")" +
                "VALUES(?,?,?,?,?,?)";


        PreparedStatement prST = null;
        try {
            prST = getDbConnection().prepareStatement(insert);
            prST.setString(1,firstName);
            prST.setString(2,lastName);
            prST.setString(3,userName);
            prST.setString(4,password);
            prST.setString(5,location);
            prST.setString(6,gender);

            prST.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(String username, String password){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE +
                " WHERE " + Const.USER_USERNAME + "=? AND " + Const.USER_PASSWORD + "=?";

        try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);
            prST.setString(1,username);
            prST.setString(2,password);

            resSet = prST.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
            System.out.println("");

        return resSet;
    }
}
