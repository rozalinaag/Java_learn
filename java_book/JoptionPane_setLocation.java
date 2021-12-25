/*
    how to set the position of the window - JoptionPane java?
*/

public class JoptionPane_setLocation{
    public static void main(String[] args) {
        int k= 1000;
        while(k>0) {
            k--;
            final JOptionPane pane = new JOptionPane("ОТКРОЙТЕ ЛИФТ!!!!!");
            final JDialog d = pane.createDialog((JFrame) null, "HELP!");
            int x = 10 + (int) ( Math.random() * 600 );
            int y = 10 + (int) ( Math.random() * 600 );
            d.setLocation(x, y);
            d.setVisible(true);
        }
    }
}
