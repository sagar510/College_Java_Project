package com.ManagementSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;



public class Login extends JFrame implements ActionListener {
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b;

    public Login()
    {
        setBounds(500,200,400,300);
        setVisible(true);


        setLayout(null);
        l1=new JLabel("User");
        l1.setBounds(100,100,100,20);
        add(l1);

        l2=new JLabel("Password");
        l2.setBounds(100,200,100,20);
        add(l2);

        t1=new JTextField();
        t1.setBounds(200,100,100,20);
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(200,200,100,20);
        add(t2);

        b=new JButton("Login");
        b.setBounds(200,0,80,30);
        add(b);


       b.addActionListener(this);


    }

    public void actionPerformed(ActionEvent ae)
    {
        String username=t1.getText();
        String password=t2.getText();

        Conn c=new Conn();

        String str="select * from login where username='"+username+"'and password='"+password+"'";

        try{
            ResultSet rs=c.s.executeQuery(str);

            if(rs.next())
            {
                new ManagementSystem().setVisible(true);
                this.setVisible(false);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String args[])
    {
        new Login();
    }


}
