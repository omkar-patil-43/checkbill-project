
package checkbill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class spalsh extends JFrame implements ActionListener{
    JButton b1,b2;
    public spalsh(){
    setLayout(null);  
    setVisible(true);
    setBounds(300,100,1000,500);
    getContentPane().setBackground(Color.pink);
    
    
    JLabel l1=new JLabel("Welcome To Super Market Billing System");
    l1.setBounds(180,20,700,50);
    l1.setForeground(Color.white);
    l1.setFont(new Font("Tohoma",Font.BOLD,32));
    add(l1);
    
    b1=new JButton("Admin Login");
    b1.setBounds(600,150,200,50);
    b1.setBackground(Color.orange);
    b1.setForeground(Color.white);
    b1.setFont(new Font("Raleway",Font.BOLD,22));
    b1.addActionListener(this);
    add(b1);
    
    b2=new JButton("Casher Login");
    b2.setBounds(600,250,200,50);
    b2.setBackground(Color.orange);
    b2.setForeground(Color.white);
    b2.setFont(new Font("Raleway",Font.BOLD,22));
    b2.addActionListener(this);
    add(b2);
    JPanel p1=new JPanel(); 
    p1.setBounds(50, 110 ,500 ,400);
    p1.setBackground(Color.pink);
    add(p1);
        ImageIcon i1=new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/icons/checkbill.png");
        JLabel l2=new JLabel(i1);
        l2.setBounds(0,0 ,500 ,500);
        p1.add(l2);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            this.setVisible(false);
            new adminlogin().setVisible(true);
        }
        else if(ae.getSource() == b2){
            this.setVisible(false);
            new casherlogin().setVisible(true);
        }
    }
    public static void main(String[] args){
          new spalsh();   
    }
    
}
