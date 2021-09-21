/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkbill;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class productinfo extends JFrame {

    JButton b1,b2;
    JLabel l1,l2,l3,l4,l5,l6;
    public productinfo(String lan) {
        setLayout(null);
        setBounds(400, 100, 800, 730);
        

        //searching starts here
        
        
        
        
        l2 = new JLabel();
        l2.setBounds(60, 30, 210, 30);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l2);

        JTextField t1 = new JTextField();
        t1.setBounds(290, 30, 200, 30);
        t1.setFont(new Font("Roboto", Font.BOLD, 16));
        t1.setBackground(Color.red);
        t1.setForeground(Color.white);
        add(t1);

        b1 = new JButton("");
        b1.setBounds(530, 25, 150, 40);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.setFont(new Font("Tohoma", Font.BOLD, 23));
        b1.setMargin(new Insets(0, 0, 0, -20));
        b1.setForeground(Color.yellow);
        ImageIcon i5 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/cashericons/search-32.png");
        Image i6 = i5.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon i7 = new ImageIcon(i6);
        JLabel l7 = new JLabel(i7);
        l7.setSize(40, 40);
        b1.add(l7);
        b1.setBackground(Color.red);
        b1.setFocusPainted(false);
        b1.setBorderPainted(false);
        b1.setOpaque(false);
        add(b1);

        //craeting jtable
        final JTable tb = new JTable();
        final DefaultTableModel model = new DefaultTableModel();
        if(lan=="Marathi"){
             String x[] = {"उत्पादन आयडी", "उत्पादनाचे नांव", "प्रमाण", "Mrp", "सवलत"};
             model.setColumnIdentifiers(x);
        }else{
             String x[] = {"Product ID", "Product Name", "Quantity", "Mrp", "Discount"};
             model.setColumnIdentifiers(x);
            }
       

        // Change A JTable Background Color, Font Size, Font Color, Row Height
        tb.setForeground(Color.black);
        tb.setFont(new Font("Tohoma", Font.BOLD, 12));
        tb.setBackground(Color.cyan);
        tb.setRowHeight(30);
        JScrollPane sp = new JScrollPane(tb);
        sp.setBounds(50, 80, 680, 400);
        add(sp);

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

        } catch (Exception e) {
            e.printStackTrace();
        }

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String productid = t1.getText(); //making table null first
                if (ae.getSource() == b1) {
                    model.setRowCount(0);
                    try {
                        conn c1 = new conn();
                        String s1 = "select * from stock where product_id='" + productid + "'";
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

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        //searching ends here
        
        //total products
        l3 = new JLabel("Total Products:");
        l3.setBounds(80, 510, 170, 30);
        l3.setForeground(Color.white);
        l3.setFont(new Font("Roboto", Font.BOLD, 20));
        add(l3);

        JTextField t2 = new JTextField();
        t2.setBounds(240, 510, 100, 30);
        t2.setBackground(Color.yellow);
        t2.setFont(new Font("Roboto", Font.BOLD, 16));
        int s = model.getRowCount();
        t2.setText(String.valueOf(s));
        add(t2);
        
        //total quantity

        l4 = new JLabel("Total Quantity:");
        l4.setBounds(420, 510, 170, 30);
        l4.setForeground(Color.white);
        l4.setFont(new Font("Roboto", Font.BOLD, 20));
        add(l4);

        JTextField t3 = new JTextField();
        t3.setBounds(570, 510, 100, 30);
        t3.setBackground(Color.yellow);
        t3.setFont(new Font("Roboto", Font.BOLD, 16));
        int quan = 0;
        for (int i = 0; i < tb.getRowCount(); i++) {
            quan = quan + Integer.parseInt(tb.getValueAt(i, 2).toString());
        }
        t3.setText(String.valueOf(quan));
        add(t3);

        //total price
        l5 = new JLabel("Total Price:");
        l5.setBounds(80, 580, 170, 30);
        l5.setForeground(Color.white);
        l5.setFont(new Font("Roboto", Font.BOLD, 20));
        add(l5);

        JTextField t5 = new JTextField();
        t5.setBounds(240, 580, 100, 30);
        t5.setBackground(Color.yellow);
        t5.setFont(new Font("Roboto", Font.BOLD, 16));
        add(t5);
        int price = 0;
        for (int i = 0; i < tb.getRowCount(); i++) {
            price = price + Integer.parseInt(tb.getValueAt(i, 3).toString());
        }
        t5.setText(String.valueOf(price)+".Rs");

        //total discount
        l6 = new JLabel("Total Discount:");
        l6.setBounds(420, 580, 170, 30);
        l6.setForeground(Color.white);
        l6.setFont(new Font("Roboto", Font.BOLD, 20));
        add(l6);

        JTextField t6 = new JTextField();
        t6.setBounds(570, 580, 100, 30);
        t6.setBackground(Color.yellow);
        t6.setFont(new Font("Roboto", Font.BOLD, 16));
        add(t6);
        int discount = 0;
        for (int i = 0; i < tb.getRowCount(); i++) {
            discount = discount + Integer.parseInt(tb.getValueAt(i, 4).toString());
        }
        t6.setText(String.valueOf(discount)+".Rs");
        
        //printing products details
        b2 = new JButton("Print Details");
        b2.setBounds(280, 635, 230, 40);
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.setFont(new Font("Tohoma", Font.BOLD, 23));
        b2.setMargin(new Insets(0, 0, 0, -30));
        b2.setBackground(Color.red);
        b2.setForeground(Color.white);
        ImageIcon i8 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/cashericons/print.png");
        Image i9 = i8.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon i10 = new ImageIcon(i9);
        JLabel l11 = new JLabel(i10);
        l11.setSize(40, 40);
        b2.add(l11);
        
        b2.setFocusPainted(false);
        b2.setBorderPainted(false);
        b2.setOpaque(false);
        add(b2);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if(ae.getSource() == b2){
                   try{
                    tb.print();
                   }
                   catch(Exception e){
                       e.printStackTrace();
                   }
                }
            }
        });
        
        //adding background image
        ImageIcon i100 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/icons/back3.jpg");
        Image i101 = i100.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i102 = new ImageIcon(i101);
        JLabel i103 = new JLabel(i102);
        i103.setBounds(0, 0, 800, 700);
        add(i103);
        
                //change language code
        
        if(lan=="Marathi"){
            l2.setText("उत्पादन आयडी प्रविष्ट करा:");
            l3.setText("एकूण उत्पादने:");
            l4.setText("एकूण प्रमाण:");
            l5.setText("एकूण किंमत:");
            l6.setText("एकूण सवलत:");
            b1.setText("शोधा");
            b2.setText("तपशील प्रिंट करा");
        }
        else{
            l2.setText("Enter Product ID:");
            b1.setText("Search");
        }

    }

    public static void main(String args[]) {
        new productinfo("").setVisible(true);
    }
}
