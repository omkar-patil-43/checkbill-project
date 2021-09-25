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
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import javax.swing.text.Document;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusListener;
import java.util.EventListener;

import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.net.URL;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class createbillQR extends javax.swing.JFrame implements Runnable, ThreadFactory {

    private WebcamPanel panel = null;
    private Webcam webcam = null;

    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    public createbillQR(String lan) {
        this.la = lan;
        initComponents();
        initWebcam();
        createbill();
        if (lan == "Marathi") {
            l2.setText("बिल क्र.");
            l3.setText("ग्राहकाचे नाव");
            l4.setText("उत्पादन आयडी");
            l5.setText("उत्पादनाचे नांव");
            l6.setText("MRP/दर");
            l10.setText("प्रमाण");
            l11.setText("सवलत");
            l12.setText("तारीख");
            l13.setText("किंमत");
            l14.setText(" नग:");
            l15.setText("प्रमाण:");
            l16.setText("एकूण:");
            l17.setText("सवलत:");
            b1.setText("जोडा");
            b2.setText("अद्यतन");
            b3.setText("काढा");
            b4.setText("बिल");
            b5.setText("प्रिंट बिल");
            newbill.setText("नवीन बिल");
            savebill.setText("जतन करा");
            cancel.setText("रद्द करा");
            close.setText("बंद करा");

            //change bill print language
            pn = "उत्पादनाचे नांव";
            mr = "MRP";
            q = "प्रमाण";
            p = "किंमत";
            d = "सवलत";
            ti = "एकूण आयटम:";
            totb = "एकूण बिलाची रक्कम:";
            saved = "आपण एकूण रक्कम जतन केली आहे:";
            customer = "ग्राहक:";
            billno = "बिल क्र.:";
            tim = "वेळ:";
            dat = "तारीख:";
            msg = "खरेदी केल्याबद्दल धन्यवाद, पुन्हा भेट द्या";

        } else {
            //change bill print language
            pn = "Product Name";
            mr = "MRP";
            q = "Quantity";
            p = "Price";
            d = "Discount";
            ti = "Total items:";
            totb = "Total Bill Amount:";
            saved = "YOU HAVE SAVED TOTAL AMOUNT:";
            customer = "Customer:";
            billno = "Bill No.:";
            tim = "Time:";
            dat = "Date:";
            msg = "THANK YOU FOR SHOPPING VISIT AGAIN";
        }
    }

    JPanel p1;
    JScrollPane sp, sp1;
    JTextArea print;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, tot, totitem, totdiscount, totquan;
    JButton b1, b2, b3, b4, b5, b6, newbill, savebill, cancel, close;
    JLabel l2, l3, l4, l5, l6, l10, l11, l12, l13, l14, l15, l16, l17;
    String pn, mr, q, p, d, ti, totb, saved, customer, billno, tim, dat, msg, la;

    private void createbill() {
        JTable tb = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        if (la == "Marathi") {
            String x[] = {"आयटम क्र.", "उत्पादनाचे नांव", "प्रमाण", "MRP/दर", "सवलत", "किंमत"};
            model.setColumnIdentifiers(x);
        } else {
            String x[] = {"Item. No", "Product Name", "Quantity", "MRP", "Discount", "Price"};
            model.setColumnIdentifiers(x);
        }
        tb.setModel(model);

        // Change A JTable Background Color, Font Size, Font Color, Row Height
        tb.setForeground(Color.black);
        tb.setFont(new Font("Tohoma", Font.BOLD, 12));
        tb.setBackground(Color.cyan);
        tb.setRowHeight(30);

        sp = new JScrollPane(tb);
        sp.setBounds(20, 300, 750, 300);
        add(sp);

//Frame coding starts here
        setLayout(null);
        setBounds(0, 100, 1550, 750);

        l2 = new JLabel("Bill no");
        l2.setBounds(20, 20, 150, 30);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l2);

        t1 = new JTextField();
        t1.setBounds(100, 20, 140, 35);
        t1.setFont(new Font("Roboto", Font.BOLD, 15));
        t1.setBackground(Color.yellow);
        add(t1);

        l3 = new JLabel("Customer Name");
        l3.setBounds(270, 20, 180, 30);
        l3.setForeground(Color.white);
        l3.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l3);

        t2 = new JTextField();
        t2.setBounds(460, 20, 200, 35);
        t2.setFont(new Font("Roboto", Font.BOLD, 15));
        add(t2);

        l4 = new JLabel("Product ID");
        l4.setBounds(690, 20, 120, 30);
        l4.setForeground(Color.white);
        l4.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l4);

        t3 = new JTextField();
        t3.setBounds(820, 20, 240, 35);
        t3.setFont(new Font("Roboto", Font.BOLD, 15));
        t3.setBackground(Color.yellow);
        t3.setForeground(Color.red);
        t3.setFocusable(true);
        add(t3);

        l5 = new JLabel("Product Name");
        l5.setBounds(20, 90, 180, 30);
        l5.setForeground(Color.white);
        l5.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l5);

        t4 = new JTextField();
        t4.setFont(new Font("Roboto", Font.BOLD, 15));
        t4.setBounds(200, 90, 240, 40);
        add(t4);

        l6 = new JLabel("MRP/Rate");
        l6.setBounds(470, 90, 150, 30);
        l6.setForeground(Color.white);
        l6.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l6);

        t5 = new JTextField();
        t5.setBounds(600, 90, 150, 35);
        t5.setFont(new Font("Roboto", Font.BOLD, 15));
        add(t5);

        l10 = new JLabel("Quantity");
        l10.setBounds(780, 90, 130, 30);
        l10.setForeground(Color.white);
        l10.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l10);

        t6 = new JTextField();
        t6.setBounds(900, 90, 160, 35);
        t6.setFont(new Font("Roboto", Font.BOLD, 15));
        add(t6);

        l11 = new JLabel("Discount");
        l11.setBounds(20, 170, 130, 30);
        l11.setForeground(Color.white);
        l11.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l11);

        t7 = new JTextField();
        t7.setBounds(150, 170, 200, 35);
        t7.setFont(new Font("Roboto", Font.BOLD, 15));
        add(t7);

        l13 = new JLabel("Price");
        l13.setBounds(390, 170, 130, 30);
        l13.setForeground(Color.white);
        l13.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l13);

        t9 = new JTextField();
        t9.setBounds(480, 170, 240, 35);
        t9.setFont(new Font("Roboto", Font.BOLD, 15));
        add(t9);

        l12 = new JLabel("Date");
        l12.setBounds(820, 170, 100, 30);
        l12.setForeground(Color.white);
        l12.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l12);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        t8 = new JTextField();
        t8.setBounds(900, 170, 160, 35);
        t8.setFont(new Font("Roboto", Font.BOLD, 15));
        t8.setText(formatter.format(date));
        add(t8);

        l14 = new JLabel("Items:");
        l14.setBounds(20, 620, 100, 30);
        l14.setForeground(Color.white);
        l14.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l14);

        totitem = new JTextField();
        totitem.setBounds(100, 620, 50, 35);
        totitem.setFont(new Font("Roboto", Font.BOLD, 15));
        int i = tb.getRowCount();
        add(totitem);

        l15 = new JLabel("Quantity:");
        l15.setBounds(170, 620, 100, 30);
        l15.setForeground(Color.white);
        l15.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l15);

        totquan = new JTextField();
        totquan.setBounds(280, 620, 50, 35);
        totquan.setFont(new Font("Roboto", Font.BOLD, 15));
        add(totquan);

        l16 = new JLabel("Total:");
        l16.setBounds(350, 620, 100, 30);
        l16.setForeground(Color.white);
        l16.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l16);

        tot = new JTextField();
        tot.setBounds(430, 620, 100, 35);
        tot.setFont(new Font("Roboto", Font.BOLD, 15));
        add(tot);

        l17 = new JLabel("Discount:");
        l17.setBounds(550, 620, 110, 30);
        l17.setForeground(Color.white);
        l17.setFont(new Font("Roboto", Font.BOLD, 22));
        add(l17);

        totdiscount = new JTextField();
        totdiscount.setBounds(670, 620, 100, 35);
        totdiscount.setFont(new Font("Roboto", Font.BOLD, 15));
        add(totdiscount);

        b1 = new JButton("Add");
        b1.setBounds(30, 235, 90, 50);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.setFont(new Font("Tohoma", Font.BOLD, 23));
        b1.setMargin(new Insets(0, 0, 0, -45));
        b1.setForeground(Color.yellow);
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
        b2.setBounds(160, 235, 130, 50);
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.setFont(new Font("Tohoma", Font.BOLD, 23));
        b2.setMargin(new Insets(0, 0, 0, -40));
        b2.setForeground(Color.yellow);
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
        b3.setBounds(320, 235, 140, 50);
        b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b3.setFont(new Font("Tohoma", Font.BOLD, 23));
        b3.setMargin(new Insets(0, 0, 0, -40));
        b3.setForeground(Color.yellow);
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

        b4 = new JButton("Bill");
        b4.setBounds(490, 235, 90, 50);
        b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b4.setFont(new Font("Tohoma", Font.BOLD, 23));
        b4.setMargin(new Insets(0, 0, 0, -40));
        b4.setForeground(Color.yellow);
        ImageIcon i14 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/cashericons/upd.png");
        Image i15 = i14.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon i16 = new ImageIcon(i15);
        JLabel l21 = new JLabel(i16);
        l21.setSize(40, 40);
        b4.add(l21);
        b4.setBackground(Color.pink);
        b4.setFocusPainted(false);
        b4.setBorderPainted(false);
        b4.setOpaque(false);
        add(b4);

        b5 = new JButton("Print Bill");
        b5.setBounds(610, 235, 150, 50);
        b5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b5.setFont(new Font("Tohoma", Font.BOLD, 23));
        b5.setMargin(new Insets(0, 0, 0, -50));
        b5.setForeground(Color.yellow);
        ImageIcon i31 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/cashericons/print.png");
        Image i32 = i31.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i32);
        JLabel l34 = new JLabel(i33);
        l34.setSize(45, 45);
        b5.add(l34);
        b5.setBackground(Color.pink);
        b5.setFocusPainted(false);
        b5.setBorderPainted(false);
        b5.setOpaque(false);
        add(b5);

        newbill = new JButton("New Bill");
        newbill.setBounds(1325, 255, 170, 50);
        newbill.setCursor(new Cursor(Cursor.HAND_CURSOR));
        newbill.setFont(new Font("Raleway", Font.BOLD, 26));
        newbill.setMargin(new Insets(0, 0, 0, -52));
        newbill.setForeground(Color.white);
        ImageIcon i35 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/cashericons/plus.png");
        Image i36 = i35.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
        ImageIcon i37 = new ImageIcon(i36);
        JLabel l38 = new JLabel(i37);
        l34.setSize(45, 45);
        newbill.add(l38);
        newbill.setBackground(Color.black);
        newbill.setFocusPainted(false);
        newbill.setBorderPainted(false);
        newbill.setOpaque(false);
        add(newbill);

        savebill = new JButton("Save Bill");
        savebill.setCursor(new Cursor(Cursor.HAND_CURSOR));
        savebill.setBounds(1325, 335, 170, 50);
        savebill.setFont(new Font("Raleway", Font.BOLD, 26));
        savebill.setMargin(new Insets(0, 0, 0, -55));
        savebill.setForeground(Color.white);
        ImageIcon i39 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/icons/stock.png");
        Image i40 = i39.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
        ImageIcon i41 = new ImageIcon(i40);
        JLabel l42 = new JLabel(i41);
        l34.setSize(45, 45);
        savebill.add(l42);
        savebill.setBackground(Color.pink);
        savebill.setFocusPainted(false);
        savebill.setBorderPainted(false);
        savebill.setOpaque(false);
        add(savebill);

        cancel = new JButton("Cancel");
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancel.setBounds(1325, 420, 170, 50);
        cancel.setFont(new Font("Raleway", Font.BOLD, 26));
        cancel.setMargin(new Insets(0, 0, 0, -40));
        cancel.setForeground(Color.white);
        ImageIcon i43 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/cashericons/up.png");
        Image i44 = i43.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
        ImageIcon i45 = new ImageIcon(i44);
        JLabel l46 = new JLabel(i45);
        l34.setSize(45, 45);
        cancel.add(l46);
        cancel.setBackground(Color.pink);
        cancel.setFocusPainted(false);
        cancel.setBorderPainted(false);
        cancel.setOpaque(false);
        add(cancel);

        close = new JButton("Close");
        close.setCursor(new Cursor(Cursor.HAND_CURSOR));
        close.setBounds(1325, 505, 170, 50);
        close.setFont(new Font("Raleway", Font.BOLD, 26));
        close.setMargin(new Insets(0, 0, 0, -32));
        close.setForeground(Color.white);
        ImageIcon i47 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/icons/exit.png");
        Image i48 = i47.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
        ImageIcon i49 = new ImageIcon(i48);
        JLabel l50 = new JLabel(i49);
        l34.setSize(45, 45);
        close.add(l50);
        close.setBackground(Color.pink);
        close.setFocusPainted(false);
        close.setBorderPainted(false);
        close.setOpaque(false);
        add(close);

        print = new JTextArea();

        sp1 = new JScrollPane(print);
        sp1.setBounds(810, 230, 480, 450);
        add(sp1);

        //table process and listener process starts here
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tb.getRowCount() + 1;
                // set the model to the table
                tb.setModel(model);
                Object[] row = new Object[6];
                row[0] = i;
                row[1] = t4.getText();
                row[2] = t6.getText();
                row[3] = t5.getText();
                row[4] = t7.getText();
                row[5] = t9.getText();

                // add row to the model
                model.addRow(row);
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t9.setText("");

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

        //update code
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int i = tb.getSelectedRow();

                // i = the index of the selected row
                int mrp = Integer.parseInt(t5.getText());
                int discount = Integer.parseInt(t7.getText());
                int quantity = Integer.parseInt(t6.getText());

                int dis = discount * quantity;

                int total = (mrp * quantity) - dis;

                t9.setText(String.valueOf(total));
                String d = String.valueOf(dis);
                if (i >= 0) {

                    model.setValueAt(t4.getText(), i, 1);
                    model.setValueAt(t6.getText(), i, 2);
                    model.setValueAt(t5.getText(), i, 3);
                    model.setValueAt(d, i, 4);
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
                    int itm = Integer.parseInt(totitem.getText());
                    itm = itm - 1;
                    totitem.setText(String.valueOf(itm));
                } else {
                    System.out.println("Delete Error");
                }

                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t9.setText("");

            }

        });

        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    print.print();

                } catch (Exception ae) {
                    JOptionPane.showMessageDialog(tb, "Print Error occured");
                }

            }

        });

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from bills");
            while (rs.next()) {
                String bill = rs.getString("bill_no");
                int b = Integer.parseInt(bill);
                b = b + 1;
                t1.setText(String.valueOf(b));
            }
        } catch (Exception ae) {

        }

        result_field.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String product = result_field.getText();
                try {
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from stock where product_id='" + product + "' ");

                    while (rs.next()) {
                        t4.setText(rs.getString("product_name"));
                        t6.setText(rs.getString("quantity"));
                        t5.setText(rs.getString("Mrp"));
                        t7.setText(rs.getString("discount"));

                        int mrp = Integer.parseInt(t5.getText());
                        int discount = Integer.parseInt(t7.getText());
                        int quantity = Integer.parseInt(t6.getText());

                        int total = mrp - discount * quantity;
                        t9.setText(String.valueOf(total));

                        int i = tb.getRowCount() + 1;
                        // set the model to the table
                        tb.setModel(model);
                        Object[] row = new Object[6];
                        row[0] = i;
                        row[1] = t4.getText();
                        row[2] = t6.getText();
                        row[3] = t5.getText();
                        row[4] = t7.getText();
                        row[5] = t9.getText();

                        // add row to the model
                        model.addRow(row);

                        System.out.println("playing clip..");
                        try {
                            URL url = new URL("file:C:/Users/admin/Desktop/checkbill/src/checkbill/sound/bell.wav");
                            Clip clip = AudioSystem.getClip();
                            //getAudioInputStream() can also accepts a File or InputStream
                            AudioInputStream ais = AudioSystem.getAudioInputStream(url);
                            clip.open(ais);
                            //clip.loop(Clip.LOOP_CONTINUOUSLY);
                            clip.start();
                        } catch (Exception er) {
                            er.printStackTrace();
                        }
                        
                        

                        t3.setText("");
                        t4.setText("");
                        t5.setText("");
                        t6.setText("");
                        t7.setText("");
                        t9.setText("");
                    }

                } catch (Exception ae) {
                    ae.printStackTrace();
                    

                }

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //nothing
            }

        });

        t3.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {

                try {
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from stock where product_id='" + t3.getText() + "' ");

                    while (rs.next()) {
                        t4.setText(rs.getString("product_name"));
                        t6.setText(rs.getString("quantity"));
                        t5.setText(rs.getString("Mrp"));
                        t7.setText(rs.getString("discount"));

                    }
                    int mrp = Integer.parseInt(t5.getText());
                    int discount = Integer.parseInt(t7.getText());
                    int quantity = Integer.parseInt(t6.getText());

                    int total = mrp - discount * quantity;
                    t9.setText(String.valueOf(total));

                    int key = e.getKeyCode();
                    if (key == KeyEvent.VK_ENTER) {
                        int i = tb.getRowCount() + 1;
                        // set the model to the table
                        tb.setModel(model);
                        Object[] row = new Object[6];
                        row[0] = i;
                        row[1] = t4.getText();
                        row[2] = t6.getText();
                        row[3] = t5.getText();
                        row[4] = t7.getText();
                        row[5] = t9.getText();

                        // add row to the model
                        model.addRow(row);
                          System.out.println("playing clip..");
                        try {
                            URL url = new URL("file:C:/Users/admin/Desktop/checkbill/src/checkbill/sound/bell.wav");
                            Clip clip = AudioSystem.getClip();
                            //getAudioInputStream() can also accepts a File or InputStream
                            AudioInputStream ais = AudioSystem.getAudioInputStream(url);
                            clip.open(ais);
                            //clip.loop(Clip.LOOP_CONTINUOUSLY);
                            clip.start();
                        } catch (Exception er) {
                            er.printStackTrace();
                        }

                        t3.setText("");
                        t4.setText("");
                        t5.setText("");
                        t6.setText("");
                        t7.setText("");
                        t9.setText("");

                    }

                } catch (Exception ae) {

                }

            }

            @Override
            public void keyTyped(KeyEvent e) {
                //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        tb.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {

                int item = 0;

                for (int i = 0; i < tb.getRowCount(); i++) {
                    item = Integer.parseInt(tb.getValueAt(i, 0).toString());
                    totitem.setText(String.valueOf(item));
                }
                totitem.setBackground(Color.yellow);
                totitem.setFont(new Font("Tohoma", Font.BOLD, 22));

                int quan = 0;

                for (int i = 0; i < tb.getRowCount(); i++) {
                    quan = quan + Integer.parseInt(tb.getValueAt(i, 2).toString());
                }
                totquan.setText(String.valueOf(quan));
                totquan.setBackground(Color.yellow);
                totquan.setFont(new Font("Tohoma", Font.BOLD, 22));

                int total = 0;

                for (int i = 0; i < tb.getRowCount(); i++) {
                    total = total + Integer.parseInt(tb.getValueAt(i, 5).toString());
                }
                tot.setText(String.valueOf(total) + ".00");
                tot.setBackground(Color.yellow);
                tot.setFont(new Font("Tohoma", Font.BOLD, 22));

                int dis = 0;

                for (int i = 0; i < tb.getRowCount(); i++) {
                    dis = dis + Integer.parseInt(tb.getValueAt(i, 4).toString());
                }
                totdiscount.setText(String.valueOf(dis) + ".00");
                totdiscount.setBackground(Color.yellow);
                totdiscount.setFont(new Font("Tohoma", Font.BOLD, 22));
            }

        });

        ImageIcon i23 = new ImageIcon("C:/Users/admin/Desktop/checkbill/src/checkbill/icons/Back3.jpg");
        Image i24 = i23.getImage().getScaledInstance(1600, 700, Image.SCALE_DEFAULT);
        ImageIcon i25 = new ImageIcon(i24);
        JLabel l88 = new JLabel(i25);
        l88.setSize(1600, 700);
        add(l88);

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                print.setText("");

                String total = tot.getText();
                String Discount = totdiscount.getText();
                String totalitems = totitem.getText();

                DefaultTableModel model = new DefaultTableModel();

                model = (DefaultTableModel) tb.getModel();

                print.setText(print.getText() + "***************************************************************************************************\n");
                print.setText(print.getText() + "                                                   Smart Market Billing System                                  \n");
                print.setText(print.getText() + "***************************************************************************************************\n");

                //Heading
                print.setText(print.getText() + pn + "\t\t" + mr + "\t" + q + "\t" + p + "\t" + d + "\n");

                for (int i = 0; i < model.getRowCount(); i++) {
                    String pname = (String) model.getValueAt(i, 1);
                    String quanti = (String) model.getValueAt(i, 2);
                    String MRP = (String) model.getValueAt(i, 3);
                    String disc = (String) model.getValueAt(i, 4);
                    String price = (String) model.getValueAt(i, 5);

                    print.setText(print.getText() + pname + "\t\t" + MRP + "\t" + quanti + "\t    " + price + "\t" + disc + "\n");

                }

                print.setText(print.getText() + "\n");

                print.setText(print.getText() + "\n");
                print.setText(print.getText() + "***************************************************************************************************\n");
                print.setText(print.getText() + ti + totalitems + "\n");
                print.setText(print.getText() + "***************************************************************************************************\n");
                print.setText(print.getText() + totb + total + ".Rs" + "\n");
                print.setText(print.getText() + "----------------------------------------------------------------------------------------------------------------------\n");
                print.setText(print.getText() + "\t" + "            " + saved + Discount + ".Rs" + "\n");

                print.setText(print.getText() + "----------------------------------------------------------------------------------------------------------------------\n");
                print.setText(print.getText() + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

                print.setText(print.getText() + "\t" + "                " + customer + t2.getText());
                print.setText(print.getText() + "\t" + billno + t1.getText() + "\n\n");

                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm");
                Date date = new Date();
                String time = formatter.format(date);
                print.setText(print.getText() + "\t" + "                " + tim + time + "");
                print.setText(print.getText() + "\t" + dat + t8.getText() + "\n");

                print.setText(print.getText() + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                print.setText(print.getText() + "----------------------------------------------------------------------------------------------------------------------\n");

                print.setText(print.getText() + "                  \t              " + msg + "                                \n");

            }
        });

        savebill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    conn c = new conn();
                    String sql = "insert into bills values('" + t1.getText() + "','" + t2.getText() + "','" + tot.getText() + "','" + t8.getText() + "')";
                    c.s.executeUpdate(sql);
                    print.print();
                    JOptionPane.showMessageDialog(tb, "Bill details saved successfully");

                } catch (Exception ae) {
                    JOptionPane.showMessageDialog(tb, "Error occured");
                }

            }

        });
        newbill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == newbill) {

                    try {

                        conn c = new conn();
                        String sql = "insert into bills values('" + t1.getText() + "','" + t2.getText() + "','" + tot.getText() + "','" + t8.getText() + "')";
                        c.s.executeUpdate(sql);
                        JOptionPane.showMessageDialog(tb, "Bill details saved successfully");

                    } catch (Exception ae) {
                        JOptionPane.showMessageDialog(tb, "Error occured");
                    }

                    model.setRowCount(0);
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    t7.setText("");
                    t9.setText("");
                    tot.setText("");
                    totitem.setText("");
                    totdiscount.setText("");
                    totquan.setText("");
                    print.setText("");

                    try {
                        conn c = new conn();
                        ResultSet rs = c.s.executeQuery("select * from bills");
                        while (rs.next()) {
                            String bill = rs.getString("bill_no");
                            int b = Integer.parseInt(bill);
                            b = b + 1;
                            t1.setText(String.valueOf(b));
                        }
                    } catch (Exception ae) {

                    }

                }

            }

        });
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                model.setRowCount(0);
                print.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t9.setText("");
                tot.setText("");
                totitem.setText("");
                totdiscount.setText("");
                totquan.setText("");
            }
        });

        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == close) {
                    setVisible(false);
                    dispose();
                }
            }
        });

        // language changing code
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        result_field = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();

        jSeparator1.setForeground(new java.awt.Color(126, 167, 206));

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1178, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(result_field, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(result_field, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(243, 243, 243)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void result_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_result_fieldActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_result_fieldActionPerformed

    private void result_fieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_result_fieldKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_result_fieldKeyPressed

    private void result_fieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_result_fieldFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_result_fieldFocusGained

    private void result_fieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_result_fieldPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_result_fieldPropertyChange

    private void result_fieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_result_fieldCaretUpdate
        // TODO add your handling code here:

    }//GEN-LAST:event_result_fieldCaretUpdate

    private void result_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_result_fieldKeyTyped
        // TODO add your handling code here:

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
            java.util.logging.Logger.getLogger(createbillQR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            new createbillQR("").setVisible(true);

        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
                t3.setText(result.getText());

                try {
                    Thread.sleep(3000);
                } catch (Exception ae) {

                }

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
