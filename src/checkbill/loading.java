
package checkbill;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;

public class loading extends JFrame implements Runnable{
    JProgressBar p;
   String user;
    Thread t;
    public void run(){
        int i;
        try{
            for( i = 1 ; i<=101 ; i++ ){
                int m=p.getMaximum();
                int n=p.getMinimum();
                if(n < m){
                    p.setValue(p.getValue() + 1);
                   
                }
                else{
                   //nothing
                }
                   
                Thread.sleep(50);
            }
                    i=101;
                    this.setVisible(false);
                    new admindashboard().setVisible(true);
        }catch(Exception e){
            
        }
    }
    
    loading(String username){
        this.user=username;
        t=new Thread(this);    
    setLayout(null);
    setBounds(350, 150, 800, 500);
    setVisible(true);
    getContentPane().setBackground(Color.gray);
   
    
    JLabel l1=new JLabel("Smart Market Billing System ");
    l1.setBounds(140, 20, 600, 50);
    l1.setFont(new Font("Raleway", Font.BOLD, 37));
    l1.setForeground(Color.cyan);
    add(l1);
    
    p = new JProgressBar();
    p.setBounds(200, 110,400,35);
    p.setStringPainted(true);
    p.setForeground(Color.orange);
    add(p);
   
        
    JLabel l2=new JLabel("Please Wait...");
    l2.setBounds(350, 150,150,30);
    l2.setFont(new Font("Tohoma", Font.BOLD, 20));
    l2.setForeground(Color.yellow);
    add(l2);
    
        
    JLabel l3=new JLabel("Welcome " + username);
    l3.setBounds(20, 400,200,40);
    l3.setFont(new Font("Tohoma", Font.BOLD, 22));
    l3.setForeground(Color.yellow);
    add(l3);
     
    t.start();
    
    
    }
    public static void main(String args[]){
        new loading("").setVisible(true);
    }
}
