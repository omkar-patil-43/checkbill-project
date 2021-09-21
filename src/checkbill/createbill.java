/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkbill;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 *
 * @author admin
 */
public class createbill extends JFrame{

    createbill(String bar) {
            int i = 0, j = 0;

    JPanel p1;
    JScrollPane sp;

    JTextField t1, t2, t3, t4, t5 ,t6,t7,t8,t9;
    JButton b1, b2, b3, b4;

        System.out.println(bar);
        final JTable tb = new JTable();
        String x[] = {"Item. No", "Product Name", "Quantity", "MRP","Discount", "Price"};
        final DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(x);
        tb.setModel(model);
       
   

        // Change A JTable Background Color, Font Size, Font Color, Row Height
        tb.setForeground(Color.black);
        tb.setFont(new Font("Tohoma", Font.BOLD, 12));
        tb.setBackground(Color.cyan);
        tb.setRowHeight(30);

            sp = new JScrollPane(tb);
            sp.setBounds(500, 200, 500, 400);
            add(sp);
       
//Frame coding starts here
        setLayout(null);
        setBounds(0, 100, 1550, 700);

        JLabel l2 = new JLabel("Bill no");
        l2.setBounds(20, 20, 150, 30);
        l2.setForeground(Color.blue);
        l2.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l2);

        t1 = new JTextField();
        t1.setBounds(220, 20, 140, 35);
        t1.setText(bar);
        t1.setFont(new Font("Roboto", Font.BOLD, 15));
        add(t1);

        JLabel l3 = new JLabel("Customer Name");
        l3.setBounds(20, 90, 200, 30);
        l3.setForeground(Color.blue);
        l3.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l3);

        t2 = new JTextField();
        t2.setBounds(220, 90, 240, 35);
        t2.setFont(new Font("Roboto", Font.BOLD, 15));
        add(t2);

        JLabel l4 = new JLabel("Product ID");
        l4.setBounds(20, 160, 200, 30);
        l4.setForeground(Color.blue);
        l4.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l4);

        t3 = new JTextField();
        t3.setBounds(220, 160, 240, 35);
        t3.setFont(new Font("Roboto", Font.BOLD, 15));
        add(t3);

        JLabel l5 = new JLabel("Product Name");
        l5.setBounds(20, 230, 200, 30);
        l5.setForeground(Color.blue);
        l5.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l5);

        t4 = new JTextField();
        t4.setFont(new Font("Roboto", Font.BOLD, 15));
        t4.setBounds(220, 230, 240, 40);
        add(t4);
        

        JLabel l6 = new JLabel("MRP/Rate");
        l6.setBounds(20, 300, 200, 30);
        l6.setForeground(Color.blue);
        l6.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l6);

        t5 = new JTextField();
        t5.setBounds(220, 300, 240, 35);
        t5.setFont(new Font("Roboto", Font.BOLD, 15));
        add(t5);
        
        JLabel l10 = new JLabel("Quantity");
        l10.setBounds(20, 370, 200, 30);
        l10.setForeground(Color.blue);
        l10.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l10);

        t6 = new JTextField();
        t6.setBounds(220, 370, 240, 35);
        t6.setFont(new Font("Roboto", Font.BOLD, 15));
        add(t6);
        
        JLabel l11 = new JLabel("Discount");
        l11.setBounds(20, 440, 200, 30);
        l11.setForeground(Color.blue);
        l11.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l11);

        t7 = new JTextField();
        t7.setBounds(220, 440, 240, 35);
        t7.setFont(new Font("Roboto", Font.BOLD, 15));
        add(t7);
        
        JLabel l13 = new JLabel("Price");
        l13.setBounds(20, 510, 200, 30);
        l13.setForeground(Color.blue);
        l13.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l13);

        t9 = new JTextField();
        t9.setBounds(220, 510, 240, 35);
        t9.setFont(new Font("Roboto", Font.BOLD, 15));
        add(t9);
        
        JLabel l12 = new JLabel("Date");
        l12.setBounds(500, 20, 100, 30);
        l12.setForeground(Color.blue);
        l12.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l12);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        
        t8 = new JTextField();
        t8.setBounds(600, 20, 160, 35);
        t8.setFont(new Font("Roboto", Font.BOLD, 15));
        t8.setText(formatter.format(date));
        add(t8);
        
        

        b1 = new JButton("Add");
        b1.setBounds(30, 570, 90, 50);
        b1.setFont(new Font("Tohoma", Font.BOLD, 23));
        b1.setMargin(new Insets(0, 0, 0, -45));
        b1.setForeground(Color.black);
        ImageIcon i5 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/cashericons/7-32.png");
        Image i6 = i5.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon i7 = new ImageIcon(i6);
        JLabel l7 = new JLabel(i7);
        l7.setSize(40, 40);
        b1.add(l7);
         b1.setBackground(Color.pink);
        b1.setFocusPainted(false);
        b1.setBorderPainted(false);
        b1.setOpaque(false);
        add(b1);

        b2 = new JButton("Update");
        b2.setBounds(160, 570, 130, 50);
        b2.setFont(new Font("Tohoma", Font.BOLD, 23));
        b2.setMargin(new Insets(0, 0, 0, -40));
        b2.setForeground(Color.black);
        ImageIcon i8 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/cashericons/up.png");
        Image i9 = i8.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon i10 = new ImageIcon(i9);
        JLabel l8 = new JLabel(i10);
        l8.setSize(40, 40);
        b2.add(l8);
        b2.setBackground(Color.pink);
        b2.setFocusPainted(false);
        b2.setBorderPainted(false);
        b2.setOpaque(false);
        add(b2);

        b3 = new JButton("Remove");
        b3.setBounds(320, 570, 140, 50);
        b3.setFont(new Font("Tohoma", Font.BOLD, 23));
        b3.setMargin(new Insets(0, 0, 0, -40));
        b3.setForeground(Color.black);
        ImageIcon i11 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/cashericons/del.png");
        Image i12 = i11.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon i13 = new ImageIcon(i12);
        JLabel l9 = new JLabel(i13);
        l9.setSize(40, 40);
        b3.add(l9);
        b3.setBackground(Color.pink);
        b3.setFocusPainted(false);
        b3.setBorderPainted(false);
        b3.setOpaque(false);
        add(b3);

        
        //table process and listener process starts here
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   int i = tb.getRowCount();
                    // set the model to the table
                    tb.setModel(model);
                    Object[] row = new Object[6];
                    row[0] = i ;
                    row[1] = t4.getText();
                    row[2] = t6.getText();
                    row[3] = t5.getText();
                    row[4] = t7.getText();
                    row[5] = t9.getText();

                    // add row to the model
                    
                    model.addRow(row);
                   

               

            }
        });

        // get selected row data From table to textfields 
        tb.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                // i = the index of the selected row
                int i = tb.getSelectedRow();

               
                t4.setText(model.getValueAt(i, 1).toString());
                t6.setText(model.getValueAt(i, 2).toString());
                t5.setText(model.getValueAt(i, 3).toString());
                t7.setText(model.getValueAt(i, 4).toString());
                t9.setText(model.getValueAt(i, 5).toString());
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                    // i = the index of the selected row
                    int i = tb.getSelectedRow();

                    if (i >= 0) {
                        
                        model.setValueAt(t4.getText(), i, 1);
                        model.setValueAt(t6.getText(), i, 2);
                        model.setValueAt(t5.getText(), i, 3);
                        model.setValueAt(t7.getText(), i, 4);
                        model.setValueAt(t9.getText(), i, 5);
                    } else {
                        System.out.println("Update Error");
                    }
               

            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               
                        // i = the index of the selected row
                        int i = tb.getSelectedRow();
                        if (i >= 0) {
                            // remove a row from jtable
                            model.removeRow(i);
                        } else {
                            System.out.println("Delete Error");
                        }

                        JOptionPane.showMessageDialog(null, "Product Details Deleted Succesfully ");
                        t4.setText("");
                        t5.setText("");
                        t6.setText("");
                        t7.setText("");
                        t9.setText("");

                }


        });
              t3.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                   try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from stock where product_id='"+t3.getText()+"' ");

            while (rs.next()) {
                t4.setText(rs.getString("product_name"));
                t6.setText(rs.getString("quantity"));
                t5.setText(rs.getString("Mrp"));
                t7.setText(rs.getString("discount"));

             

            }
        } catch (Exception ae) {
            ae.printStackTrace();
        }
                   

               

            }

                @Override
                public void keyTyped(KeyEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
        });
        
        
        
        ImageIcon i23 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/icons/bk.jpg");
        Image i24 = i23.getImage().getScaledInstance(1600, 700, Image.SCALE_DEFAULT);
        ImageIcon i25 = new ImageIcon(i24);
        JLabel l88 = new JLabel(i25);
        l88.setSize(1600, 700);
        add(l88);

    }
    public static void main(String args[]){
        new createbill("").setVisible(true);
    }
}
