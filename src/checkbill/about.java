/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkbill;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class about extends JFrame implements ActionListener {

    JButton b1;
    JLabel l1;
    Font f, f1, f2;
    TextArea t1;
    String s;

    public about() {

        setLayout(null);
        JButton b1 = new JButton("Exit");
        add(b1);
        b1.setBounds(180, 430, 120, 30);
        b1.addActionListener(this);
        b1.setBackground(Color.blue);
        b1.setForeground(Color.CYAN);
        b1.setFont(new Font("Tohoma",Font.BOLD,17));
        

        Font f = new Font("RALEWAY", Font.BOLD, 180);
        setFont(f);

        s = "                                    About Projects          \n  "
                + "\nThe objective of the CheckBill Smart Market Billing System "
                + "  project is to develop a system that automates the processes "
                + "and activities of a Billing and the purpose is to design a "
                + "system using which one can perform all operations related to "
                + "Shop Billing.\n\n"
                + "This application will help in accessing the information related "
                + "to the Products in your shop and their details with great ease. "
                + "Using this application shopkeepers can reduce their manual work of "
                + " managing products stock ,Manual billing and many more things  "
                + "can also be obtained through this application.\n\n"
                + "Advantages of Project:"
                + "\nGives accurate information"
                + "\nSimplifies the manual work"
                + "\nIt minimizes the billing related work"
                + "\nProvides up to date information"
                + "\nFriendly Environment by providing warning messages."
                + "\nCustomers bill details also provided"
                + "\nPrinting bills service also added"
                + "\n\nDesigned & Developed By Omkar Patil"
                + "\n\nAll Rights Reserved @Om Infotech"
                ;

        TextArea t1 = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        t1.setEditable(false);
        t1.setBounds(20, 100, 450, 300);

        add(t1);

        Font f1 = new Font("RALEWAY", Font.BOLD, 16);
        t1.setFont(f1);

        Container contentPane = this.getContentPane();
        t1 = new TextArea();

        JLabel l1 = new JLabel("About Project");
        add(l1);
        l1.setBounds(170, 10, 180, 80);
        l1.setForeground(Color.red);

        Font f2 = new Font("RALEWAY", Font.BOLD, 20);
        l1.setFont(f2);

        setBounds(600, 150, 500, 550);

        setLayout(null);
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        dispose();
    }

    public static void main(String args[]) {
        new about().setVisible(true);
    }

}
