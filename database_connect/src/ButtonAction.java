import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ButtonAction {

    public static void add(){
        DatabaseHandler dbHandler = new DatabaseHandler();

        String author = JOptionPane.showInputDialog("Author of book:");
        String name = JOptionPane.showInputDialog("Name of Book:");
        String in_stock = JOptionPane.showInputDialog("Entered: 1 - in library, 2 - in reading");

        if (in_stock.equals("1")){
            in_stock = "in library";
        }
        else
            in_stock = "in reading";
        try {
            dbHandler.insert_book(author, name, in_stock);
        }
        catch (NullPointerException e){
            System.out.println("You didn't enter correct values!!!!!!!!!!!!!");
        }
    }

    public static void search_book(){
        DatabaseHandler dbHandler = new DatabaseHandler();
        String name = JOptionPane.showInputDialog("Name of book:");
        ResultSet res =  dbHandler.search(name);

        int counter_in_library = 0;
        int counter_in_reading = 0;
        String text = "WE FOUND: \n";
            try {
                while(res.next()) {
                    text += res.getString("idbooks") + " " + res.getString("author") +" - "
                            +res.getString("name") + "\n";

                    if (res.getString("in_stock").equals("in library")) counter_in_library ++;
                    else counter_in_reading ++;
                }
                text += "Count books in library - " + counter_in_library;
                text += "\nCount books in reading - " +  counter_in_reading;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        JOptionPane.showMessageDialog(null,  text);
    }

    public static String select_all_books(){
        DatabaseHandler dbHandler = new DatabaseHandler();

        ResultSet resSel = dbHandler.selectAll();
        String books ="";
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

    public static void delete_book(){
        DatabaseHandler dbHandler = new DatabaseHandler();
        String id = JOptionPane.showInputDialog("Entered ID of delete book:");
        dbHandler.delete_book(id);
    }

    public static String sort_book(){
        DatabaseHandler dbHandler = new DatabaseHandler();
        String text = "";
        int reply = JOptionPane.showConfirmDialog(null, "Do you want sort by name?", "Sort", JOptionPane.YES_NO_OPTION);

        if (reply == JOptionPane.YES_OPTION) {
            text = dbHandler.sort_book("name");
        } else {
            reply = JOptionPane.showConfirmDialog(null, "Do you want sort by author?", "Sort", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION){
                text = dbHandler.sort_book("author");
            }
        }
        return text;
    }
}
