package com.ManagementSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;




public class Login extends JFrame implements ActionListener {
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b;
    JOptionPane mess=new JOptionPane();

    public Login()
    {
        setBounds(500,200,400,300);
        setVisible(true);


        setLayout(null);
        l1=new JLabel("User");
        l1.setBounds(100,50,100,20);
        add(l1);

        l2=new JLabel("Password");
        l2.setBounds(100,100,100,20);
        add(l2);

        t1=new JTextField();
        t1.setBounds(200,50,100,20);
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(200,100,100,20);
        add(t2);

        b=new JButton("Login");
        b.setBounds(150,150,80,30);
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
                //mess.showMessageDialog(null,"Login Successful");
                new ManagementSystem();
                this.setVisible(false);
            }
            else
            {
                mess.showMessageDialog(null,"Login Denied");
                System.exit(0);
            }

        }catch (Exception e){
            e .printStackTrace();
        }
    }

    public static void main(String args[])
    {
        new Login();
    }


}
