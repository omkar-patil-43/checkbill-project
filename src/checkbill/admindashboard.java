package checkbill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class admindashboard extends JFrame implements ActionListener {
JButton b1,b2,b3,b4,b5,b6,b7,logout;
Choice ch;
    admindashboard() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,1550,80);
        p1.setBackground(Color.PINK);
        add(p1);
         JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(1340, 80, 300, 100);
        p2.setBackground(Color.yellow);
        add(p2);
        //langauge label 
        JLabel lan = new JLabel("Langauge:");
        lan.setBounds(10, 10, 100, 30);
        lan.setFont(new Font("Tohoma", Font.BOLD, 17));
        lan.setForeground(Color.black);
        p2.add(lan);
        ch = new Choice();
        ch.add("English");
        ch.add("Marathi");
        ch.setBounds(110, 15, 80, 40);
        p2.add(ch);
        
        logout=new JButton("Logout");
        logout.setBounds(20,50,160,40);
        logout.setForeground(Color.CYAN);
        logout.setBackground(Color.black);
        logout.setFont(new Font("Tohoma",Font.BOLD,17));
        logout.addActionListener(this);
        p2.add(logout);
        
                
        
        
        ImageIcon i1 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/icons/check.png");
        Image i2 = i1.getImage().getScaledInstance(200,60, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(10, 10, 200, 60);
        p1.add(l1); 
       
        b1=new JButton("Cashier Details");
        b1.setBounds(260,0,220,90);
        b1.setFont(new Font("Tohoma",Font.BOLD,22));
        b1.setMargin(new Insets(0, 0, 0, -50));
        b1.setBackground(Color.pink);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        ImageIcon i5=new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/icons/new-32.png");
        Image i6=i5.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
        ImageIcon i7=new ImageIcon(i6);
        JLabel l2=new JLabel(i7);
        l2.setSize(50,50);       
        b1.add(l2);
        b1.setFocusPainted(false);
        b1.setBorderPainted(false);
        b1.setOpaque(false);
        p1.add(b1);
        
        b2=new JButton("Product Details");
        b2.setBounds(510,0,220,90);
        b2.setFont(new Font("Tohoma",Font.BOLD,22));
        b2.setMargin(new Insets(0, 0, 0, -55));
        b2.setBackground(Color.pink);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        ImageIcon i8=new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/icons/tran.png");
        Image i9=i8.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
        ImageIcon i10=new ImageIcon(i9);
        JLabel l3=new JLabel(i10);
        l3.setSize(50,50);       
        b2.add(l3);
        b2.setFocusPainted(false);
        b2.setBorderPainted(false);
        b2.setOpaque(false);
        p1.add(b2);
        
        b3=new JButton("Stock");
        b3.setBounds(760,0,130,90);
        b3.setFont(new Font("Tohoma",Font.BOLD,22));
        b3.setMargin(new Insets(0, 0, 0, -50));
        b3.setBackground(Color.pink);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        ImageIcon i11=new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/icons/Stock.png");
        Image i12=i11.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
        ImageIcon i13=new ImageIcon(i12);
        JLabel l4=new JLabel(i13);
        l4.setSize(50,50);       
        b3.add(l4);
        b3.setFocusPainted(false);
        b3.setBorderPainted(false);
        b3.setOpaque(false);
        p1.add(b3);
        
        b4=new JButton("Sales");
        b4.setBounds(920,0,120,90);
        b4.setFont(new Font("Tohoma",Font.BOLD,22));
        b4.setMargin(new Insets(0, 0, 0, -50));
        b4.setBackground(Color.pink);
        b4.setForeground(Color.white);
        b4.addActionListener(this);
        ImageIcon i14=new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/icons/sale.png");
        Image i15=i14.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
        ImageIcon i16=new ImageIcon(i15);
        JLabel l5=new JLabel(i16);
        l5.setSize(50,50);       
        b4.add(l5);
        b4.setFocusPainted(false);
        b4.setBorderPainted(false);
        b4.setOpaque(false);
        p1.add(b4);
        
        
        b7=new JButton("Search Bill");
        b7.setBounds(1060,0,165,90);
        b7.setFont(new Font("Tohoma",Font.BOLD,22));
        b7.setMargin(new Insets(0, 0, 0, -50));
        b7.setBackground(Color.pink);
        b7.setForeground(Color.white);
        b7.addActionListener(this);
        ImageIcon i41=new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/cashericons/search-32.png");
        Image i42=i41.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
        ImageIcon i43=new ImageIcon(i42);
        JLabel l09=new JLabel(i43);
        l09.setSize(50,50);       
        b7.add(l09);
        b7.setFocusPainted(false);
        b7.setBorderPainted(false);
        b7.setOpaque(false);
        p1.add(b7);
        
        
        
        b5=new JButton("About Us");
        b5.setBounds(1240,0,180,90);
        b5.setFont(new Font("Tohoma",Font.BOLD,22));
        b5.setMargin(new Insets(0, 0, 0, -50));
        b5.setBackground(Color.pink);
        b5.setForeground(Color.white);
        b5.addActionListener(this);
        ImageIcon i17=new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/icons/7-32.png");
        Image i18=i17.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
        ImageIcon i19=new ImageIcon(i18);
        JLabel l6=new JLabel(i19);
        l6.setSize(50,50);       
        b5.add(l6);
        b5.setFocusPainted(false);
        b5.setBorderPainted(false);
        b5.setOpaque(false);
        p1.add(b5);
        
        
        
      
        
        
        
        b6=new JButton("Exit");
        b6.setBounds(1430,0,100,90);
        b6.setFont(new Font("Tohoma",Font.BOLD,22));
        b6.setMargin(new Insets(0, 0, 0, -50));
        b6.setBackground(Color.pink);
        b6.setForeground(Color.white);
        b6.addActionListener(this);
        ImageIcon i20=new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/icons/exit.png");
        Image i21=i20.getImage().getScaledInstance(43, 43, Image.SCALE_DEFAULT);
        ImageIcon i22=new ImageIcon(i21);
        JLabel l7=new JLabel(i22);
        l7.setSize(50,50);       
        b6.add(l7);
        b6.setFocusPainted(false);
        b6.setBorderPainted(false);
        b6.setOpaque(false);
        p1.add(b6);

        ImageIcon i23 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/icons/back3.jpg");
        Image i24 = i23.getImage().getScaledInstance(1700, 850, Image.SCALE_DEFAULT);
        ImageIcon i25 = new ImageIcon(i24);
        JLabel l8 = new JLabel(i25);
        l8.setBounds(0,80,1550,850);
        add(l8);
        
        ImageIcon i26 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/icons/back.jpg");
        Image i27 = i26.getImage().getScaledInstance(1550, 90, Image.SCALE_DEFAULT);
        ImageIcon i28 = new ImageIcon(i27);
        JLabel l9 = new JLabel(i28);
        l9.setBounds(0,0,1550,90);
        p1.add(l9);
            
        ch.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                    
                    if (ch.getSelectedItem() == "English") {
                        b1.setText("Cashier Details");
                        b2.setText("Products Details");
                        b3.setText("Stock");
                        b4.setText("Sales");
                        b5.setText("About Us");
                        b6.setText("Exit");
                        b7.setText("Search Bill");
                    }
                    else if(ch.getSelectedItem() == "Marathi"){
                        b1.setText("रोखपाल तपशील");
                        b1.setMargin(new Insets(0, 0, 0, -50));
			b2.setText("उत्पादने तपशील");
			b3.setText("साठा");
			b4.setText("विक्री");
			b5.setText("आमच्याबद्दल");
			b6.setText("बाहेर");
                        b7.setText("बिल शोधा");     
                        
                    }
            }
        });
    }

    public void actionPerformed(ActionEvent ae){
        String lang=ch.getSelectedItem();
        if(ae.getSource() == b1){
            new addcasher(lang).setVisible(true);
        }
        else if( ae.getSource() == b6){
            int a= JOptionPane.showConfirmDialog(this, "Exit from software ?");
            if(a == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }else if(ae.getSource() == b3){
               java.awt.EventQueue.invokeLater(() -> {
            new addstockQR(lang).setVisible(true);
          
        });
        }else if(ae.getSource() == b4){
            new sales(lang).setVisible(true);
        }else if(ae.getSource() == b2){
            new productinfo(lang).setVisible(true);
        }else if(ae.getSource() == b5){
            new about().setVisible(true);
        }
        else if(ae.getSource() == b7){
            new searchbill(lang).setVisible(true);
        }else if(ae.getSource()==logout){
            this.dispose();
            new spalsh().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new admindashboard().setVisible(true);
    }
}
