package com.ManagementSystem;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MyInsertButton extends JFrame implements ActionListener{

    Button b1,b2;
    TextField t1,t2,t3,t4,t5;

    MyInsertButton()
    {


        setBounds(400,100,600,600);
        setVisible(true);

        setLayout(null);
        Label l=new Label("Enter Your Details");
        l.setBounds(250,50,100,20);
        add(l);

        Label l1=new Label("Aeroplane ID (Unique)");
        l1.setBounds(100,150,200,20);
        add(l1);

        Label l2=new Label("Source");
        l2.setBounds(100,200,100,20);
        add(l2);

        Label l3=new Label("Destination");
        l3.setBounds(100,250,100,20);
        add(l3);

        Label l4=new Label("Arrival Time");
        l4.setBounds(100,300,100,20);
        add(l4);

        Label l5=new Label("Departure Time");
        l5.setBounds(100,350,100,20);
        add(l5);


        t1=new TextField();
        t1.setBounds(350,150,100,20);
        add(t1);

        t2=new TextField();
        t2.setBounds(350,200,100,20);
        add(t2);

        t3=new TextField();
        t3.setBounds(350,250,100,20);
        add(t3);

        t4=new TextField();
        t4.setBounds(350,300,100,20);
        add(t4);

        t5=new TextField();
        t5.setBounds(350,350,100,20);
        add(t5);

        b1=new Button("Submit");
        b1.setBounds(260,400,80,30);
        add(b1);

        b2=new Button("Back");
        b2.setBounds(480,500,80,30);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            String id = t1.getText();
            String source = t2.getText();
            String dest = t3.getText();
            String arr = t4.getText();
            String dept = t5.getText();

            Conn c = new Conn();

            String str = "insert into aero values('" + id + "','" + source + "','" + dest + "','" + arr + "','" + dept + "')";

            try {
                c.s.executeUpdate(str);
            } catch (Exception e) {
                System.out.println(e);
            }

            JOptionPane.showMessageDialog(null,"Details Added Successfully");
        }

        else if(ae.getSource()==b2)
        {
            new ManagementSystem();
            this.setVisible(false);

        }

    }

    public static void main()
    {
        new MyInsertButton();
    }
}
