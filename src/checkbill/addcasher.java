package checkbill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class addcasher extends JFrame {

    int i = 0, j = 0;

    JPanel p1;
    JScrollPane sp;

    JTextField t1, t2, t3, t4;
    Choice ch1;
    JButton b1, b2, b3, b4;

    public addcasher(String lan) {
        super("Add Cashier Details");
        final JTable tb = new JTable();
        final DefaultTableModel model = new DefaultTableModel();
        if(lan=="Marathi"){
              String x[] = {"Username", "रोखपाल नाव", "पासवर्ड", "सुरक्षा प्रश्न", "उत्तर"};  
              model.setColumnIdentifiers(x);
        }else{
              String x[] = {"Username", "Cashier Name", "Password", "Security Question", "Answer"};  
              model.setColumnIdentifiers(x);
        }

        // Change A JTable Background Color, Font Size, Font Color, Row Height
        tb.setForeground(Color.black);
        tb.setFont(new Font("Tohoma", Font.BOLD, 12));
        tb.setBackground(Color.cyan);
        tb.setRowHeight(30);

        try {
            conn c1 = new conn();
            String s1 = "select * from casheraccount";
            ResultSet rs = c1.s.executeQuery(s1);
            tb.setModel(model);
            Object[] row = new Object[5];
            while (rs.next()) {
                row[0] = rs.getString("username");
                row[1] = rs.getString("name");
                row[2] = rs.getString("password");
                row[3] = rs.getString("security");
                row[4] = rs.getString("answer");
                model.addRow(row);
            }

            sp = new JScrollPane(tb);
            sp.setBounds(600, 20, 630, 400);
            add(sp);
        } catch (Exception e) {
            e.printStackTrace();
        }
//Frame coding starts here
        setLayout(null);
        setBounds(150, 150, 1250, 600);

        JLabel l1 = new JLabel("Add Cashier Login Details");
        l1.setForeground(Color.yellow);
        l1.setBounds(140, 20, 400, 40);
        l1.setFont(new Font("Tohoma", Font.BOLD, 26));
        add(l1);

        JLabel l2 = new JLabel("Username");
        l2.setForeground(Color.WHITE);
        l2.setBounds(90, 100, 200, 30);
        l2.setFont(new Font("Tohoma", Font.BOLD, 22));
        add(l2);

        t1 = new JTextField();
        t1.setBounds(340, 100, 240, 35);
        t1.setFont(new Font("Tohoma", Font.BOLD, 15));
        add(t1);

        JLabel l3 = new JLabel("Cashier Name");
        l3.setForeground(Color.WHITE);
        l3.setBounds(90, 160, 200, 30);
        l3.setFont(new Font("Tohoma", Font.BOLD, 22));
        add(l3);

        t2 = new JTextField();
        t2.setBounds(340, 160, 240, 35);
        t2.setFont(new Font("Tohoma", Font.BOLD, 15));
        add(t2);

        JLabel l4 = new JLabel("Password");
        l4.setForeground(Color.WHITE);
        l4.setBounds(90, 220, 200, 30);
        l4.setFont(new Font("Tohoma", Font.BOLD, 22));
        add(l4);

        t3 = new JTextField();
        t3.setBounds(340, 220, 240, 35);
        t3.setFont(new Font("Tohoma", Font.BOLD, 15));
        add(t3);

        JLabel l5 = new JLabel("Security Question");
        l5.setForeground(Color.WHITE);
        l5.setBounds(90, 280, 200, 35);
        l5.setFont(new Font("Tohoma", Font.BOLD, 22));
        add(l5);

        ch1 = new Choice();
        ch1.add("Your Favourite Food ?");
        ch1.add("Your Lucky Number ?");
        ch1.add("Your Favourite Superhero ?");
        ch1.add("Your Nickname in School ?");
        ch1.setBounds(340, 280, 240, 40);
        add(ch1);

        JLabel l6 = new JLabel("Your Answer");
        l6.setForeground(Color.WHITE);
        l6.setBounds(90, 340, 200, 35);
        l6.setFont(new Font("Tohoma", Font.BOLD, 22));
        add(l6);

        t4 = new JTextField();
        t4.setBounds(340, 340, 240, 35);
        t4.setFont(new Font("Tohoma", Font.BOLD, 15));
        add(t4);

        b1 = new JButton("Add New");
        b1.setBounds(90, 460, 130, 40);
        b1.setFont(new Font("Tohoma", Font.BOLD, 20));
        b1.setMargin(new Insets(0, 0, 0, -20));
        b1.setForeground(Color.black);
        ImageIcon i5 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/cashericons/an.png");
        Image i6 = i5.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i7 = new ImageIcon(i6);
        JLabel l7 = new JLabel(i7);
        l7.setSize(25, 25);
        b1.add(l7);
        b1.setFocusPainted(false);
        add(b1);

        b2 = new JButton("Update");
        b2.setBounds(270, 460, 120, 40);
        b2.setFont(new Font("Tohoma", Font.BOLD, 20));
        b2.setMargin(new Insets(0, 0, 0, -20));
        b2.setForeground(Color.black);
        ImageIcon i8 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/cashericons/up.png");
        Image i9 = i8.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i10 = new ImageIcon(i9);
        JLabel l8 = new JLabel(i10);
        l8.setSize(25, 25);
        b2.add(l8);
        b2.setFocusPainted(false);
        add(b2);

        b3 = new JButton("Delete");
        b3.setBounds(440, 460, 130, 40);
        b3.setFont(new Font("Tohoma", Font.BOLD, 20));
        b3.setMargin(new Insets(0, 0, 0, -20));
        b3.setForeground(Color.black);
        ImageIcon i11 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/cashericons/del.png");
        Image i12 = i11.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i13 = new ImageIcon(i12);
        JLabel l9 = new JLabel(i13);
        l9.setSize(25, 25);
        b3.add(l9);
        b3.setFocusPainted(false);
        add(b3);

        //table process and listener process starts here
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = t1.getText();
                String name = t2.getText();
                String password = t3.getText();
                String security = ch1.getSelectedItem();
                String answer = t4.getText();

                String query = "insert into casheraccount values('" + username + "','" + name + "','" + password + "','" + security + "','" + answer + "')";
                try {
                    conn c = new conn();
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Cashier Details Added Succesfully");
                    // set the model to the table
                    tb.setModel(model);
                    Object[] row = new Object[5];
                    row[0] = t1.getText();
                    row[1] = t2.getText();
                    row[2] = t3.getText();
                    row[3] = ch1.getSelectedItem();
                    row[4] = t4.getText();

                    // add row to the model
                    model.addRow(row);

                } catch (Exception ae) {
                    JOptionPane.showMessageDialog(null, "Username already exists ! enter another Username");
                }

            }
        });

        // get selected row data From table to textfields 
        tb.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                // i = the index of the selected row
                int i = tb.getSelectedRow();

                t1.setText(model.getValueAt(i, 0).toString());
                t2.setText(model.getValueAt(i, 1).toString());
                t3.setText(model.getValueAt(i, 2).toString());
                t4.setText(model.getValueAt(i, 4).toString());

            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = t1.getText();
                String name = t2.getText();
                String password = t3.getText();
                String security = ch1.getSelectedItem();
                String answer = t4.getText();

                String query = "update casheraccount set username='" + username + "', name= '" + name + "', password= '" + password + "', security='" + security + "' ,answer= '" + answer + "'where username='" + username + "'";
                try {
                    conn c = new conn();
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Cashier Details Updated Succesfully");
                    // i = the index of the selected row
                    int i = tb.getSelectedRow();

                    if (i >= 0) {
                        model.setValueAt(t1.getText(), i, 0);
                        model.setValueAt(t2.getText(), i, 1);
                        model.setValueAt(t3.getText(), i, 2);
                        model.setValueAt(ch1.getSelectedItem(), i, 3);
                        model.setValueAt(t4.getText(), i, 4);
                    } else {
                        System.out.println("Update Error");
                    }
                } catch (Exception ae) {
                    JOptionPane.showMessageDialog(null, "Please enter details carefully");
                }

            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = t1.getText();
                int a = JOptionPane.showConfirmDialog(sp, "Are you sure to delete customer details ?");
                if (a == JOptionPane.YES_OPTION) {

                    try {
                        conn c = new conn();
                        c.s.executeUpdate("Delete from casheraccount where username='" + username + "'");

                        // i = the index of the selected row
                        int i = tb.getSelectedRow();
                        if (i >= 0) {
                            // remove a row from jtable
                            model.removeRow(i);
                        } else {
                            System.out.println("Delete Error");
                        }

                        JOptionPane.showMessageDialog(null, "Customer Details Deleted Succesfully ");

                    } catch (Exception ae) {
                        JOptionPane.showMessageDialog(null, "Cashier account doesn't exists ");
                    }
                }

            }
        });

        if (lan == "Marathi") {
            l1.setText("कॅशियर लॉगिन तपशील जोडा");
            l2.setText("Username");
            l3.setText("रोखपाल नाव");
            l4.setText("पासवर्ड");
            l5.setText("सुरक्षा प्रश्न");
            l6.setText("तुमचे उत्तर");
            b1.setText("नवीन जोडा");
            b2.setText("अद्यतन");
            b3.setText("हटवा");

        }
        ImageIcon i23 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/icons/back3.jpg");
        Image i24 = i23.getImage().getScaledInstance(1250, 600, Image.SCALE_DEFAULT);
        ImageIcon i25 = new ImageIcon(i24);
        JLabel l88 = new JLabel(i25);
        l88.setSize(1250, 600);
        add(l88);

    }

    public static void main(String args[]) {
        new addcasher("").setVisible(true);

    }
}
