/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkbill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;


public class searchbill extends JFrame {
JButton b1;
String x[];
 public searchbill(String lan){
     setLayout(null);
     setBounds(400,100,800,700);
     
     
     
      JLabel l2 = new JLabel("");
        l2.setBounds(100, 30, 170, 30);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l2);
        
        JTextField t1=new JTextField();
        t1.setBounds(290,30,200,30);
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
        
         final JTable tb = new JTable();
         final DefaultTableModel model = new DefaultTableModel();
         if(lan=="Marathi"){
              String x[] = {"बिल क्र.", "ग्राहकाचे नाव", "बिल रक्कम", "तारीख"};
              model.setColumnIdentifiers(x);
         }
         else{
              String x[] = {"Bill no", "Customer Name", "Bill Amount", "Date"};
              model.setColumnIdentifiers(x);
         }
         
         

        // Change A JTable Background Color, Font Size, Font Color, Row Height
        tb.setForeground(Color.black);
        tb.setFont(new Font("Tohoma", Font.BOLD, 12));
        tb.setBackground(Color.cyan);
        tb.setRowHeight(30);
        JScrollPane sp = new JScrollPane(tb);
            sp.setBounds(50, 80, 680, 500);
            add(sp);
            
            try {
            conn c1 = new conn();
            String s1 = "select * from bills";
            ResultSet rs = c1.s.executeQuery(s1);
            tb.setModel(model);
            Object[] row = new Object[4];
            while (rs.next()) {
                row[0] = rs.getString("bill_no");
                row[1] = rs.getString("Customer_name");
                row[2] = rs.getString("bill_amount");
                row[3] = rs.getString("bill_date"); 
                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
     
     ImageIcon i100=new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/icons/back3.jpg");
     Image i101=i100.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
     ImageIcon i102=new ImageIcon(i101);
     JLabel i103=new JLabel(i102);
     i103.setBounds(0,0,800,700);
     add(i103);
 
     b1.addActionListener(new ActionListener(){
     @Override
     public void actionPerformed(ActionEvent ae){
         String billno=t1.getText(); //making table null first
         if(ae.getSource() == b1){
              model.setRowCount(0);
                 try {
            conn c1 = new conn();
            String s1 = "select * from bills where bill_no='"+billno+"'";
            ResultSet rs = c1.s.executeQuery(s1);
            tb.setModel(model);
            Object[] row = new Object[4];
            while (rs.next()) {
                row[0] = rs.getString("bill_no");
                row[1] = rs.getString("Customer_name");
                row[2] = rs.getString("bill_amount");
                row[3] = rs.getString("bill_date"); 
                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
         } 
     }
     });
     
         if(lan=="Marathi"){
         l2.setText("बिल क्रमांक प्रविष्ट करा");
         b1.setText("शोधा");
      
        }
        else{
           l2.setText("Enter Bill No:"); 
           b1.setText("Search");
        }

 }
 
public static void main(String args[]){
    new searchbill("").setVisible(true);
    
}    
}
