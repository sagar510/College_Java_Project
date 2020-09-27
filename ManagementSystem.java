package com.ManagementSystem;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ManagementSystem extends JFrame implements ActionListener{

    Button b1,b2,b3,b5,b6;

    ManagementSystem()
    {
        setLocation(500,200);
        setSize(400,300);
        setVisible(true);


        setLayout(null);
        b1 = new Button("Insert");
        b1.setBounds(150, 60, 100, 20);
        add(b1);
        b2 = new Button("Delete");
        b2.setBounds(150, 90, 100, 20);
        add(b2);
        b3 = new Button("Update");
        b3.setBounds(150, 120, 100, 20);
        add(b3);
        Button b4 = new Button("Print");
        b4.setBounds(150, 150, 100, 20);
        add(b4);
        b5 = new Button("Exit");
        b5.setBounds(150, 180, 100, 20);
        add(b5);
        b6=new Button("Login");
        b6.setBounds(150,210,100,20);
        add(b6);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1) {
            new MyInsertButton();
            this.setVisible(false);
        }
        else if(e.getSource()==b2)
        {
            new MyDeleteButton();
            this.setVisible(false);
        }
        else if(e.getSource()==b3)
        {
            new MyUpdateButton();
            this.setVisible(false);
        }
        else if(e.getSource()==b5)
        {
            System.exit(0);
        }
        else if(e.getSource()==b6)
        {
            new Login();
            this.setVisible(false);
        }
    }

    public static void main(String args[])
    {
        new ManagementSystem();
    }
}
