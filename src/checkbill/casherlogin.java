
package checkbill;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
public class casherlogin extends JFrame implements ActionListener {
    JButton b1,b2,b3;
    JTextField t1;
    JPasswordField t2;
    casherlogin(){
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(330 ,200, 900, 400);
       
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 400, 400);
        p1.setBackground(Color.pink);
        
        JLabel l7=new JLabel("Casher Login");
        l7.setFont(new Font("Raleway",Font.BOLD,30));
        l7.setForeground(Color.yellow);
        l7.setBounds(100,10,400,50);
        
        p1.add(l7);
        add(p1);
        
      ImageIcon i1=new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/icons/login.png");
        JLabel l1=new JLabel(i1);
        l1.setBounds(40, 30 ,300 ,300);
        p1.add(l1); 
        
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 10,470, 340);
        p2.setBackground(Color.CYAN);
        
        JLabel l2=new JLabel("Username");
        l2.setBounds(60, 20, 100,25);
        l2.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        p2.add(l2);
        
        t1=new JTextField();
        t1.setBounds(60, 60, 300, 30);
        t1.setBorder(null);
        t1.setFont(new Font("Tohoma",Font.BOLD,14)); 
        p2.add(t1);
        
        
        
        JLabel l3=new JLabel("Password");
        l3.setBounds(60, 110, 100,25);
        l3.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        p2.add(l3);
        
        t2=new JPasswordField();
        t2.setBounds(60, 150, 300, 30);
        t2.setBorder(null);
        t2.setFont(new Font("Tohoma",Font.BOLD,14)); 
        p2.add(t2);
        
        b1=new JButton("Login");
        b1.setBounds(60, 200, 130, 30);
        b1.setBackground(new Color(133, 193, 233));
        b1.setForeground(Color.white);
        b1.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        b1.setBorder(BorderFactory.createEmptyBorder());
        
        b1.addActionListener(this);
        p2.add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(230, 200, 130, 30);
        b2.setForeground(new Color(133, 193, 233));
        b2.setBackground(Color.white);
        b2.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        b2.setBorder(new LineBorder(new Color(133, 193, 233)));
        
        b2.addActionListener(this);
        p2.add(b2);
        
        
        b3=new JButton("Forgot Password");
        b3.setBounds(130, 250, 160, 30);
        b3.setForeground(new Color(133, 193, 233));
        b3.setBackground(Color.white);
        b3.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        b3.setBorder(new LineBorder(new Color(133, 193, 233)));
        
        b3.addActionListener(this);
        p2.add(b3);
        
        
        JLabel l4=new JLabel("Trouble in Login..");
        l4.setForeground(Color.red);
        l4.setBounds(300, 250, 100, 20);
        p2.add(l4);
        
        add(p2);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
           try{
               conn c=new conn();
               String username=t1.getText();
               String password=t2.getText();
               
               String sql="Select * from casheraccount where username= '"+username+"'  AND password='"+password+"' ";
              ResultSet rs= c.s.executeQuery(sql);
               if(rs.next()){
                   this.setVisible(false);
                   new loading1(username).setVisible(true);
               }
               else{
                   JOptionPane.showMessageDialog(null, "Invalid Login");
               }
               
           }catch(Exception e){
               
           }
        }else if(ae.getSource()==b2)
        {
            this.setVisible(false);
            new spalsh().setVisible(true);
            
          
        }else if(ae.getSource()==b3){
            this.setVisible(false);
            new forgotcasher().setVisible(true);
           
            
        }
    }
    public static void main(String[] args){
        new casherlogin();
    }
}
