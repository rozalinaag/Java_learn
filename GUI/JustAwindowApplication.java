package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends JFrame{

    MyFrame(String name){
        super(name);
        setBounds(250,250,300,200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel label = new JLabel("Push button - close window");
        label.setBounds(10,30,280,50);
        add(label);

        JButton btn = new JButton("push");
        btn.setBounds(50, 120, 200, 30);

        MyHandler hnd = new MyHandler();
        btn.addActionListener(hnd);
        add(btn);

        setVisible(true);
    }
}

class MyHandler implements ActionListener {
    public void actionPerformed(ActionEvent e){
        System.exit(0);
    }
}

public class JustAwindowApplication {
    public static void main(String[] args) {
        new MyFrame("Just Window");
    }
}
