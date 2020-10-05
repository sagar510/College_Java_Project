package com.ManagementSystem;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ManagementSystem extends JFrame implements ActionListener{

    Label l;
    Button b1,b2,b3,b4,b5;

    ManagementSystem()
    {
        setLocation(500,200);
        setSize(400,300);
        setVisible(true);
        setLayout(null);
        l=new Label("Airline Management System");
        l.setBounds(125,50,300,20);
        add(l);

        b1 = new Button("Insert");
        b1.setBounds(150, 100, 100, 20);
        add(b1);
        b2 = new Button("Delete");
        b2.setBounds(150, 130, 100, 20);
        add(b2);
        b3 = new Button("Update");
        b3.setBounds(150, 160, 100, 20);
        add(b3);
        b4 = new Button("Print");
        b4.setBounds(150, 190, 100, 20);
        add(b4);
        b5 = new Button("Exit");
        b5.setBounds(150, 220, 100, 20);
        add(b5);
      
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
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
        else if(e.getSource()==b4)
        {
            new MyPrintButton();
            this.setVisible(false);
        }
        else if(e.getSource()==b5)
        {
            System.exit(0);
        }
    }

    public static void main(String args[])
    {
        new ManagementSystem();
    }
}


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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyUpdateButton extends JFrame implements ActionListener{
    Button b1,b2;
    Label l1,l2,l3;
    TextField t1,t2;
    JComboBox jc;

    MyUpdateButton()
    {
        setBounds(400,100,600,600);
        setVisible(true);
        setLayout(null);
        l1=new Label("Enter Aeroplane ID ");
        l1.setBounds(100,100,200,20);
        add(l1);

        t1=new TextField();
        t1.setBounds(350,100,100,20);
        add(t1);

        l2=new Label("What to Update ? ");
        l2.setBounds(100,200,200,20);
        add(l2);

        String str[]={"Source","Destination","Arrival Time","Departure Time"};
        jc=new JComboBox(str);
        jc.setBounds(350,200,100,20);
        add(jc);

        l3=new Label("Enter Updated Value ");
        l3.setBounds(100,300,200,20);
        add(l3);

        t2=new TextField();
        t2.setBounds(350,300,100,20);
        add(t2);

        b1=new Button("Update");
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

            try
            {
                String identity=t1.getText();
                String updated_value=t2.getText();
                String wtu=(String) jc.getSelectedItem();
                String str;
                if(identity.isEmpty() || updated_value.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Please! Enter Value");
                }

                else {
                    Conn c = new Conn();
                    if (wtu == "Source") {
                        str = "update aero set source='" + updated_value + "' where id='" + identity + "'";
                        c.s.executeUpdate(str);
                    } else if (wtu == "Destination") {
                        str = "update aero set destination='" + updated_value + "' where id='" + identity + "'";
                        c.s.executeUpdate(str);
                    } else if (wtu == "Arrival Time") {
                        str = "update aero set arrival='" + updated_value + "' where id='" + identity + "'";
                        c.s.executeUpdate(str);
                    } else if (wtu == "Departure Time") {
                        str = "update aero set departure='" + updated_value + "' where id='" + identity + "'";
                        c.s.executeUpdate(str);
                    }
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                }
            }
            catch (Exception e)
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


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection c;
    Statement s;

    public Conn()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql:///managementsystem","root","Password");
            s=c.createStatement();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}



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
