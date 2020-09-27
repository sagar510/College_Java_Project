package com.ManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyUpdateButton extends JFrame implements ActionListener{
    Button b1,b2;
    Label l;
    TextField t;

    MyUpdateButton()
    {
        setBounds(400,100,600,600);
        setVisible(true);

        setLayout(null);
        l=new Label("Enter Aeroplane ID to Update ");
        l.setBounds(100,100,200,20);
        add(l);

        t=new TextField();
        t.setBounds(350,100,100,20);
        add(t);

        b1=new Button("Update");
        b1.setBounds(260,150,80,30);
        add(b1);

        b2=new Button("Back");
        b2.setBounds(480,500,80,30);
        add(b2);

        b2.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae)
    {
        new ManagementSystem();
        this.setVisible(false);
    }



}
