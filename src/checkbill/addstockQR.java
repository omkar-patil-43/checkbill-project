package checkbill;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class addstockQR extends javax.swing.JFrame implements Runnable, ThreadFactory {

    private WebcamPanel panel = null;
    private Webcam webcam = null;

    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    public addstockQR(String lan) {
        this.la=lan;
        initComponents();
        initWebcam();
        addstock();
        if (lan == "Marathi") {
            l1.setText("स्टॉक तपशील अद्यतनित करा");
            l2.setText("उत्पादन आयडी");
            l3.setText("उत्पादनाचे नांव");
            l4.setText("प्रमाण");
            l5.setText("MRP/दर");
            l6.setText("सवलत");
            b1.setText("नवीन जोडा");
            b2.setText("अद्यतन");
            b3.setText("हटवा");

        }else{
            //nothing
        }

    }
    int i = 0, j = 0;

    JPanel p1;
    JScrollPane sp;
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2, b3, b4;
    String la;

    public void addstock() {

        final JTable tb = new JTable();
        final DefaultTableModel model = new DefaultTableModel();
        if(la=="Marathi"){
            String x[] = {"उत्पादन आयडी", "उत्पादनाचे नांव", "उत्पादन प्रमाण", "MRP/दर", "सवलत"};
            model.setColumnIdentifiers(x);
        }else{
            String x[] = {"Product Id", "Product Name", "Product Quantity", "MRP/Rate", "Discount"};
            model.setColumnIdentifiers(x);
        }
        

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
            sp.setBounds(890, 20, 580, 400);
            add(sp);
        } catch (Exception e) {
            e.printStackTrace();
        }
//Frame coding starts here
        setLayout(null);
        setBounds(15, 150, 1490, 600);

        l1 = new JLabel("Update Stock Details");
        l1.setBounds(460, 10, 400, 40);
        l1.setForeground(Color.yellow);
        l1.setFont(new Font("Tohoma", Font.BOLD, 30));

        add(l1);

        l2 = new JLabel("Product Id");
        l2.setBounds(380, 100, 200, 30);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Tohoma", Font.BOLD, 22));
        add(l2);

        t1 = new JTextField();
        t1.setBounds(620, 100, 240, 35);
        t1.setFont(new Font("Tohoma", Font.BOLD, 15));
        add(t1);

        l3 = new JLabel("Product Name");
        l3.setBounds(380, 160, 200, 30);
        l3.setForeground(Color.white);
        l3.setFont(new Font("Tohoma", Font.BOLD, 22));
        add(l3);

        t2 = new JTextField();
        t2.setBounds(620, 160, 240, 35);
        t2.setFont(new Font("Tohoma", Font.BOLD, 15));
        add(t2);

        l4 = new JLabel("Quantity");
        l4.setBounds(380, 220, 200, 30);
        l4.setForeground(Color.white);
        l4.setFont(new Font("Tohoma", Font.BOLD, 22));
        add(l4);

        t3 = new JTextField();
        t3.setBounds(620, 220, 240, 35);
        t3.setFont(new Font("Tohoma", Font.BOLD, 15));
        add(t3);

        l5 = new JLabel("MRP/Rate");
        l5.setBounds(380, 280, 200, 30);
        l5.setForeground(Color.white);
        l5.setFont(new Font("Tohoma", Font.BOLD, 22));
        add(l5);

        t4 = new JTextField();
        t4.setFont(new Font("Tohoma", Font.BOLD, 15));
        t4.setBounds(620, 280, 240, 40);
        add(t4);

        l6 = new JLabel("Discount");
        l6.setBounds(380, 340, 200, 30);
        l6.setForeground(Color.white);
        l6.setFont(new Font("Tohoma", Font.BOLD, 22));
        add(l6);

        t5 = new JTextField();
        t5.setBounds(620, 340, 240, 35);
        t5.setFont(new Font("Tohoma", Font.BOLD, 15));
        add(t5);

        b1 = new JButton("Add New");
        b1.setBounds(380, 460, 130, 40);
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
        b2.setBounds(560, 460, 120, 40);
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
        b3.setBounds(730, 460, 110, 40);
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

        t5.addKeyListener(new KeyListener() {
            @Override

            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {

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
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                    JOptionPane.showMessageDialog(null, "Please enter product details carefully");
                }

            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String productid = t1.getText();
                int a = JOptionPane.showConfirmDialog(sp, "Are you sure to delete product details ?");
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

        ImageIcon i23 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/icons/back3.jpg");
        Image i24 = i23.getImage().getScaledInstance(1600, 700, Image.SCALE_DEFAULT);
        ImageIcon i25 = new ImageIcon(i24);
        JLabel l88 = new JLabel(i25);
        l88.setSize(1600, 700);
        add(l88);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        result_field = new javax.swing.JTextField();

        jSeparator1.setForeground(new java.awt.Color(126, 167, 206));

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(105, 105, 105));
        jLabel1.setText("Barcode");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 70, 30));

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 210));

        result_field.setBorder(null);
        result_field.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                result_fieldCaretUpdate(evt);
            }
        });
        result_field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                result_fieldFocusGained(evt);
            }
        });
        result_field.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                result_fieldMouseClicked(evt);
            }
        });
        result_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                result_fieldActionPerformed(evt);
            }
        });
        result_field.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                result_fieldPropertyChange(evt);
            }
        });
        result_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                result_fieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                result_fieldKeyTyped(evt);
            }
        });
        jPanel1.add(result_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 250, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void result_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_result_fieldActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_result_fieldActionPerformed

    private void result_fieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_result_fieldKeyPressed
        // TODO add your handling code here:
        String bar = result_field.getText();
        t1.setText(bar);
    }//GEN-LAST:event_result_fieldKeyPressed

    private void result_fieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_result_fieldFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_result_fieldFocusGained

    private void result_fieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_result_fieldPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_result_fieldPropertyChange

    private void result_fieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_result_fieldCaretUpdate
        // TODO add your handling code here:
        String bar = result_field.getText();
        t1.setText(bar);
    }//GEN-LAST:event_result_fieldCaretUpdate

    private void result_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_result_fieldKeyTyped
        // TODO add your handling code here:
        String bar = result_field.getText();
        t1.setText(bar);
    }//GEN-LAST:event_result_fieldKeyTyped

    private void result_fieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_result_fieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_result_fieldMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addstockQR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new addstockQR("").setVisible(true);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField result_field;
    // End of variables declaration//GEN-END:variables

    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(1); //0 is default webcam
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 300));
        result_field.setFont(new Font("Tohoma", Font.BOLD, 30));
        executor.execute(this);
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                //No result...
            }

            if (result != null) {

                result_field.setText(result.getText());
                t1.setText(result.getText());

            }
        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
}
