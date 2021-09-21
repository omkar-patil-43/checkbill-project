package checkbill;

import javax.swing.*;
import java.awt.*;
import static java.awt.Image.SCALE_DEFAULT;
import java.awt.event.*;
import java.sql.*;

public class forgotcasher extends JFrame implements ActionListener {

    JButton b1, b2, b3;
    JTextField t1, t2, t3, t4, t5;

    public forgotcasher() {
        setBounds(350, 200, 1100, 440);
        setLayout(null);
        getContentPane().setBackground(Color.pink);

       /* ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(760, 60, 250, 250);
        add(l6);
        */

        JPanel p1 = new JPanel();
        p1.setBounds(20, 20, 660, 370);
        p1.setLayout(null);
        p1.setVisible(true);
        add(p1);

        JLabel l1 = new JLabel("Username");
        l1.setBounds(40, 20, 90, 30);
        l1.setFont(new Font("Tohoma", Font.BOLD, 17));
        p1.add(l1);

        t1 = new JTextField();
        t1.setBounds(270, 20, 220, 30);
        t1.setBorder(null);
        t1.setFont(new Font("Tohoma", Font.BOLD, 14));
        p1.add(t1);

        b1 = new JButton("Search");
        b1.setBounds(520, 20, 120, 30);
        b1.setBackground(Color.gray);
        b1.setForeground(Color.white);
        b1.setFont(new Font("Tohoma", Font.BOLD, 14));
        b1.addActionListener(this);
        p1.add(b1);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(40, 70, 90, 30);
        l2.setFont(new Font("Tohoma", Font.BOLD, 17));
        p1.add(l2);

        t2 = new JTextField();
        t2.setBounds(270, 70, 220, 30);
        t2.setBorder(null);
        t2.setFont(new Font("Tohoma", Font.BOLD, 14));
        p1.add(t2);

        JLabel l3 = new JLabel("Your Security Question");
        l3.setBounds(40, 120, 190, 30);
        l3.setFont(new Font("Tohoma", Font.BOLD, 17));
        p1.add(l3);

        t3 = new JTextField();
        t3.setBounds(270, 120, 360, 30);
        t3.setBorder(null);
        t3.setFont(new Font("Tohoma", Font.BOLD, 14));
        p1.add(t3);

        JLabel l4 = new JLabel("Answer");
        l4.setBounds(40, 170, 90, 30);
        l4.setFont(new Font("Tohoma", Font.BOLD, 17));
        p1.add(l4);

        t4 = new JTextField();
        t4.setBounds(270, 170, 220, 30);
        t4.setBorder(null);
        t4.setFont(new Font("Tohoma", Font.BOLD, 14));
        p1.add(t4);

        b2 = new JButton("Retrive");
        b2.setBounds(520, 170, 120, 30);
        b2.setBackground(Color.gray);
        b2.setForeground(Color.white);
        b2.setFont(new Font("Tohoma", Font.BOLD, 14));
        b2.addActionListener(this);
        p1.add(b2);

        JLabel l5 = new JLabel("Password");
        l5.setBounds(40, 220, 90, 30);
        l5.setFont(new Font("Tohoma", Font.BOLD, 17));
        p1.add(l5);

        t5 = new JTextField();
        t5.setBounds(270, 220, 220, 30);
        t5.setBorder(null);
        t5.setFont(new Font("Tohoma", Font.BOLD, 14));
        p1.add(t5);

        b3 = new JButton("Back To Login");
        b3.setBounds(200, 290, 165, 35);
        b3.setBackground(Color.gray);
        b3.setForeground(Color.white);
        b3.setFont(new Font("Tohoma", Font.BOLD, 14));
        b3.addActionListener(this);
        p1.add(b3);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        conn c = new conn();
        if (ae.getSource() == b1) {
            try {
                String sql = "select * from casheraccount where username = '" + t1.getText() + "'";
                ResultSet rs = c.s.executeQuery(sql);

                while (rs.next()) {
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("security"));
                }

            } catch (Exception e) {

            }

        } else if (ae.getSource() == b2) {

            try {
                String sql = "select * from casheraccount where answer = '" + t4.getText() + "' AND username = '" + t1.getText() + "' ";
                ResultSet rs = c.s.executeQuery(sql);

                while (rs.next()) {
                    t5.setText(rs.getString("password"));
                }
                JOptionPane.showMessageDialog(null, "Password retrived sucessfully");
            }
        catch(Exception e){
               JOptionPane.showMessageDialog(null, " Customer details not found");  
            }

    }

    else if(ae.getSource () == b3){
            this.setVisible(false);
             new casherlogin().setVisible(true);
    }
}

public static void main(String args[]) {
        new forgotcasher();
    }
}
