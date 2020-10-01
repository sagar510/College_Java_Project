package com.ManagementSystem;

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
