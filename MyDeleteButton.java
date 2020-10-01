package com.ManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class MyDeleteButton extends JFrame implements ActionListener{
    Button b1,b2;
    Label l;
    TextField t;
    JOptionPane mess=new JOptionPane();

    MyDeleteButton()
    {
        setBounds(400,100,600,600);
        setVisible(true);


        setLayout(null);
        l=new Label("Enter Aeroplane ID to Delete ");
        l.setBounds(100,100,200,20);
        add(l);

        t=new TextField();
        t.setBounds(350,100,100,20);
        add(t);

        b1=new Button("Delete");
        b1.setBounds(260,150,80,30);
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
            try{
            String identity=t.getText();


            Conn c=new Conn();
            String str1="select * from aero where id='"+identity+"'";
            ResultSet rs=c.s.executeQuery(str1);

                if(rs.next()) {
                    String str2 = "delete from aero where id='" + identity + "'";
                    c.s.executeUpdate(str2);
                    mess.showMessageDialog(null, "Deleted Successfully");
                }
                else if(identity.isEmpty())
                {
                    mess.showMessageDialog(null,"Please Enter value");
                }
                else
                {
                    mess.showMessageDialog(null,"No Such Data Found");
                }


            }catch (Exception e)
            {
                System.out.println(e);
            }

        }
        else if(ae.getSource()==b2) {
            new ManagementSystem();
            this.setVisible(false);
        }
    }



}
