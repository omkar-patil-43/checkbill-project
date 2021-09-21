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
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class sales extends JFrame {
    JButton b2;
    public sales(String lan){
          
      
        setLayout(null);
        setBounds(400, 100, 800, 730); 
        
        
        JLabel title=new JLabel("-- Complete Sales Details --");
        title.setBounds(240,20,400,40);
        title.setFont(new Font("Tohoma",Font.BOLD,26));
        title.setForeground(Color.YELLOW);
        add(title);
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
            sp.setBounds(50, 80, 680, 400);
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
            
        JLabel l3 = new JLabel("Total Bills:");
        l3.setBounds(80, 510, 170, 30);
        l3.setForeground(Color.white);
        l3.setFont(new Font("Roboto", Font.BOLD, 20));
        add(l3);

        JTextField t2 = new JTextField();
        t2.setBounds(260, 510, 100, 30);
        t2.setBackground(Color.yellow);
        t2.setFont(new Font("Roboto", Font.BOLD, 16));
        int s = model.getRowCount();
        t2.setText(String.valueOf(s));
        add(t2);
        
        //total quantity

        JLabel l4 = new JLabel("Customers Visited:");
        l4.setBounds(420, 510, 250, 30);
        l4.setForeground(Color.white);
        l4.setFont(new Font("Roboto", Font.BOLD, 20));
        add(l4);

        JTextField t3 = new JTextField();
        t3.setBounds(610, 510, 100, 30);
        t3.setBackground(Color.yellow);
        t3.setFont(new Font("Roboto", Font.BOLD, 16));
        int bills=model.getRowCount();  
        t3.setText(String.valueOf(bills));
        add(t3);

        //total price
        JLabel l5 = new JLabel("Total Bill Amount:");
        l5.setBounds(80, 580, 250, 30);
        l5.setForeground(Color.white);
        l5.setFont(new Font("Roboto", Font.BOLD, 20));
        add(l5);

        JTextField t5 = new JTextField();
        t5.setBounds(260, 580, 100, 30);
        t5.setBackground(Color.yellow);
        t5.setFont(new Font("Roboto", Font.BOLD, 16));
        add(t5);
        Double price=0.00;
        for (int i = 0; i < tb.getRowCount(); i++) {
            price = price + Double.parseDouble(tb.getValueAt(i, 2).toString());
        }
        t5.setText(String.valueOf(price)+"Rs");

        //total discount
        
        
        //printing products details
        b2 = new JButton("Print Details");
        b2.setBounds(410, 580, 230, 40);
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
        
        if(lan=="Marathi"){
            title.setText("--संपूर्ण विक्री तपशील--");
            l3.setText("एकूण बिले:");
            l4.setText("भेट दिलेले ग्राहक:");
            l5.setText("एकूण बिलाची रक्कम:");
            b2.setText("तपशील प्रिंट करा");
            
        }
        
        //adding background image
        ImageIcon i100 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/icons/back3.jpg");
        Image i101 = i100.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i102 = new ImageIcon(i101);
        JLabel i103 = new JLabel(i102);
        i103.setBounds(0, 0, 800, 700);
        add(i103);
    }
    public static void main(String args[]){
        new sales("").setVisible(true);
    }
}
