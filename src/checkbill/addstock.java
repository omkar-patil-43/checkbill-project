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

public class addstock extends JFrame {

    int i = 0, j = 0;

    JPanel p1;
    JScrollPane sp;

    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2, b3, b4;

    public addstock(String bar) {
        super("Add Cashier Details");
        System.out.println(bar);
        final JTable tb = new JTable();
        String x[] = {"Product Id", "Product Name", "Product Quantity", "MRP/Rate", "Discount on Product"};
        final DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(x);

        // Change A JTable Background Color, Font Size, Font Color, Row Height
        tb.setForeground(Color.black);
        tb.setFont(new Font("Tohoma", Font.BOLD, 12));
        tb.setBackground(Color.cyan);
        tb.setRowHeight(30);

        try {
            conn c1 = new conn();
            String s1 = "select * from stock";
            ResultSet rs = c1.s.executeQuery(s1);
            tb.setModel(model);
            Object[] row = new Object[5];
            while (rs.next()) {
                row[0] = rs.getString("product_id");
                row[1] = rs.getString("product_name");
                row[2] = rs.getString("quantity");
                row[3] = rs.getString("MRP");
                row[4] = rs.getString("discount");
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

        JLabel l1 = new JLabel("Update Stock");
        l1.setBounds(140, 20, 400, 40);
        l1.setFont(new Font("Tohoma", Font.BOLD, 26));
        add(l1);

        JLabel l2 = new JLabel("Product Id");
        l2.setBounds(90, 100, 200, 30);
        l2.setFont(new Font("Tohoma", Font.BOLD, 22));
        add(l2);

        t1 = new JTextField();
        t1.setBounds(340, 100, 240, 35);
        t1.setText(bar);
        t1.setFont(new Font("Tohoma", Font.BOLD, 15));
        add(t1);

        JLabel l3 = new JLabel("Product Name");
        l3.setBounds(90, 160, 200, 30);
        l3.setFont(new Font("Tohoma", Font.BOLD, 22));
        add(l3);

        t2 = new JTextField();
        t2.setBounds(340, 160, 240, 35);
        t2.setFont(new Font("Tohoma", Font.BOLD, 15));
        add(t2);

        JLabel l4 = new JLabel("Quantity Available");
        l4.setBounds(90, 220, 200, 30);
        l4.setFont(new Font("Tohoma", Font.BOLD, 22));
        add(l4);

        t3 = new JTextField();
        t3.setBounds(340, 220, 240, 35);
        t3.setFont(new Font("Tohoma", Font.BOLD, 15));
        add(t3);

        JLabel l5 = new JLabel("MRP/Rate");
        l5.setBounds(90, 280, 200, 30);
        l5.setFont(new Font("Tohoma", Font.BOLD, 22));
        add(l5);

        t4 = new JTextField();
        t4.setFont(new Font("Tohoma", Font.BOLD, 15));
        t4.setBounds(340, 280, 240, 40);
        add(t4);
        

        JLabel l6 = new JLabel("Discount");
        l6.setBounds(90, 340, 200, 30);
        l6.setFont(new Font("Tohoma", Font.BOLD, 22));
        add(l6);

        t5 = new JTextField();
        t5.setBounds(340, 340, 240, 35);
        t5.setFont(new Font("Tohoma", Font.BOLD, 15));
        add(t5);

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
                String productid = t1.getText();
                String productname = t2.getText();
                String quantity = t3.getText();
                String MRP = t4.getText();
                String discount = t5.getText();

                String query = "insert into stock values('" + productid + "','" + productname + "','" + quantity + "','" + MRP + "','" + discount + "')";
                try {
                    conn c = new conn();
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "New Product Added Successfully ");
                       
                    // set the model to the table
                    tb.setModel(model);
                    Object[] row = new Object[5];
                    row[0] = t1.getText();
                    row[1] = t2.getText();
                    row[2] = t3.getText();
                    row[3] = t4.getText();
                    row[4] = t5.getText();

                    // add row to the model
                    model.addRow(row);

                } catch (Exception ae) {
                    JOptionPane.showMessageDialog(null, "Product already exists !");
                }
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        t5.setText("");

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
                t4.setText(model.getValueAt(i, 3).toString());
                t5.setText(model.getValueAt(i, 4).toString());
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productid = t1.getText();
                String productname = t2.getText();
                String quantity = t3.getText();
                String MRP = t4.getText();
                String discount = t5.getText();

                String query = "update stock set product_id='" + productid + "', product_name= '" + productname + "', quantity= '" + quantity + "', MRP='" + MRP + "' ,discount= '" + discount + "'where product_id='" + productid + "'";
                try {
                    conn c = new conn();
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Product Details Updated Succesfully");
                    // i = the index of the selected row
                    int i = tb.getSelectedRow();

                    if (i >= 0) {
                        model.setValueAt(t1.getText(), i, 0);
                        model.setValueAt(t2.getText(), i, 1);
                        model.setValueAt(t3.getText(), i, 2);
                        model.setValueAt(t4.getText(), i, 3);
                        model.setValueAt(t5.getText(), i, 4);
                    } else {
                        System.out.println("Update Error");
                    }
                } catch (Exception ae) {
                    JOptionPane.showMessageDialog(null, "Please enter product destails carefully");
                }

            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String productid = t1.getText();
                int a = JOptionPane.showConfirmDialog(sp, "Are you sure to delete customer details ?");
                if (a == JOptionPane.YES_OPTION) {

                    try {
                        conn c = new conn();
                        c.s.executeUpdate("Delete from stock where product_id='" + productid + "'");

                        // i = the index of the selected row
                        int i = tb.getSelectedRow();
                        if (i >= 0) {
                            // remove a row from jtable
                            model.removeRow(i);
                        } else {
                            System.out.println("Delete Error");
                        }

                        JOptionPane.showMessageDialog(null, "Product Details Deleted Succesfully ");
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        t5.setText("");

                    } catch (Exception ae) {
                        JOptionPane.showMessageDialog(null, "Product details doesn't exists ");
                    }
                }

            }
        });
        ImageIcon i23 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/icons/bk.jpg");
        Image i24 = i23.getImage().getScaledInstance(1250, 600, Image.SCALE_DEFAULT);
        ImageIcon i25 = new ImageIcon(i24);
        JLabel l88 = new JLabel(i25);
        l88.setSize(1250, 600);
        add(l88);

    }

    public static void main(String args[]) {
        new addstock("").setVisible(true);

    }
}
