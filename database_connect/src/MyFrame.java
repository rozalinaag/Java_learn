import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class MyFrame extends JFrame implements ActionListener{

    private JTextArea F;
    private JLabel WhatDoYouWant;
    private JButton Del;
    private JButton ADD;
    private JButton SORT;
    private JButton SEARCH;
    private String name = "Arial";
    private int size = 15;

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == ADD) {
            ButtonAction.add();
            F.setText(ButtonAction.select_all_books());
        }
        else if (e.getSource() == Del){
            ButtonAction.delete_book();
            F.setText(ButtonAction.select_all_books());
        }
        else if (e.getSource() == SEARCH){
            ButtonAction.search_book();
        }
        else {
            //sort
            F.setText(ButtonAction.sort_book());
        }
    }


    MyFrame() {
        super("FIO of people");
        setBounds(500, 250, 600, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        F = new JTextArea(ButtonAction.select_all_books()); //можно передать по умолчанию текст, например получить из бд его чтобы он сохранился!
        F.setBounds(10, 200, 565, 200);
        F.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        JScrollPane scrollPane = new JScrollPane(F);
        scrollPane.setBounds(10,200,565,200);


        Del = new JButton("DELETE");
        Del.setBounds(200, 60, 175, 30);
        Del.setFocusPainted(false);
        Del.setFont(new Font(name, Font.PLAIN, size));
        Del.setForeground(Color.RED);
        Del.addActionListener(this);

        ADD = new JButton("ADD");
        ADD.setBounds(200, 20, 175, 30);
        ADD.setFocusPainted(false);
        ADD.setFont(new Font(name, Font.PLAIN, size));
        ADD.setForeground(Color.GREEN);
        ADD.addActionListener(this);

        SORT = new JButton("SORT");
        SORT.setBounds(200, 100, 175, 30);
        SORT.setFocusPainted(false);
        SORT.setFont(new Font(name, Font.PLAIN, size));
        SORT.setForeground(Color.BLUE);
        SORT.addActionListener(this);

        SEARCH = new JButton("SEARCH");
        SEARCH.setBounds(200, 140, 175, 30);
        SEARCH.setFocusPainted(false);
        SEARCH.setFont(new Font(name, Font.PLAIN, size));
        SEARCH.setForeground(Color.DARK_GRAY);
        SEARCH.addActionListener(this);

        WhatDoYouWant = new JLabel("What do you want?");
        WhatDoYouWant.setBounds(230, 0, 175, 20);

        add(scrollPane, F);
        add(WhatDoYouWant);
        add(Del);
        add(ADD);
        add(SORT);
        add(SEARCH);
        setVisible(true);
    }
}
