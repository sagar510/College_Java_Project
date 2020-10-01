package com.ManagementSystem;

import java.applet.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;

public class MyPrintButton extends JFrame implements ActionListener {
    JTable t;
    Button b;
    Label l1,l2,l3,l4,l5;

    MyPrintButton()
    {
        setBounds(400,100,600,600);
        setVisible(true);

        setLayout(null);
        t=new JTable();
        t.setBounds(0,100,600,300);
        add(t);
        b=new Button("Back");
        b.setBounds(480,500,80,30);
        add(b);
        b.addActionListener(this);

        l1=new Label("ID");
        l1.setBounds(0,70,120,20);
        add(l1);

        l2=new Label("Source");
        l2.setBounds(120,70,120,20);
        add(l2);

        l3=new Label("Destination");
        l3.setBounds(240,70,120,20);
        add(l3);

        l4=new Label("Arrival Time");
        l4.setBounds(360,70,120,20);
        add(l4);

        l5=new Label("Departure Time");
        l5.setBounds(480,70,120,20);
        add(l5);




        Conn c=new Conn();
        String str="select * from aero";

        try {
            ResultSet rs = c.s.executeQuery(str);
            t.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }


    public void actionPerformed(ActionEvent ae)
    {
        new ManagementSystem();
        this.setVisible(false);
    }

    public static void main(String args[])
    {
        new MyPrintButton();
    }

}
