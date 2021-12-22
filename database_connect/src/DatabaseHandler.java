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

    public void insert_book(String author, String name, String in_stock){
        String insert = "INSERT INTO " + Const.BOOKS_TABLE + "(" +
                Const.BOOKS_AUTHOR + "," + Const.BOOKS_NAME + "," +
                Const.BOOKS_IN_STOCK + ")" +
                "VALUES(?,?,?)";

        PreparedStatement prST = null;
        try {
            prST = getDbConnection().prepareStatement(insert);
            prST.setString(1,author);
            prST.setString(2,name);
            prST.setString(3,in_stock);

            prST.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet selectAll(){
        ResultSet resSel = null;
        String select = "SELECT * FROM " + Const.BOOKS_TABLE + ";";
        try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);

             resSel= prST.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSel;
    }

    public ResultSet search(String name){
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.BOOKS_TABLE +
                " WHERE " + Const.BOOKS_NAME + "=?";

        try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);
            prST.setString(1,name);

            resSet = prST.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
            System.out.println("");

        return resSet;
    }

    public void delete_book(String id){
        String delete = "DELETE FROM " + Const.BOOKS_TABLE + " WHERE " + Const.BOOKS_ID + "=?";

        PreparedStatement prST = null;
        try {
            prST = getDbConnection().prepareStatement(delete);
            prST.setString(1,id);

            prST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String sort_book(String field){
        ResultSet resSel = null;
        String sort = "SELECT * FROM " + Const.BOOKS_TABLE + " ORDER BY " + field;

        try {
            PreparedStatement prST = getDbConnection().prepareStatement(sort);

            resSel = prST.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String books = "";
        try{
            while (resSel.next()){
                books += resSel.getString("idbooks") + "\t | " + resSel.getString("author") +"\t | "
                        +resSel.getString("name") + "\t - " + resSel.getString("in_stock") + "\n";
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return books;
    }
}
