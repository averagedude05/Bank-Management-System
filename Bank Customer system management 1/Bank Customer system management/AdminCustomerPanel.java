import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;


public class AdminCustomerPanel  {
    JFrame AdminCustomerFrame = new JFrame("Bank System");
    

    JButton Customerlogin = new JButton ("Customer");
    JButton Adminlogin = new JButton ("Admin");
    
    JLabel Iconlabel = new JLabel();
    JLabel l1 = new JLabel("Login As");

    AdminCustomerPanel(){

    AdminCustomerFrame.setResizable(true);
    AdminCustomerFrame.setTitle("Bank System");
    AdminCustomerFrame.setSize(800, 700);
    AdminCustomerFrame.setVisible(true);
    AdminCustomerFrame.setLocationRelativeTo(null);
    AdminCustomerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    AdminCustomerFrame.setLayout(null);
    AdminCustomerFrame.setBackground(new Color(160,160,160));
    Iconlabel.setBounds(260,60,220,250);
    Customerlogin.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
    Customerlogin.setForeground(Color.BLACK);
    
    ImageIcon I1=new ImageIcon("Banklogo-removebg-preview.png");
      Image I2=I1.getImage().getScaledInstance(220,250,Image.SCALE_DEFAULT);
      ImageIcon I=new ImageIcon(I2);
    Adminlogin.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
    l1.setFont(new Font("Comic Sans MS",Font.BOLD,30));

    Adminlogin.setForeground(Color.BLACK);

    Customerlogin.setBounds(220,400,120,50);
    Customerlogin.addActionListener(new ActionListener() {
        
      public void actionPerformed(ActionEvent e){
      
        if(e.getSource()==Customerlogin){
          AdminCustomerFrame.setVisible(false);
          Login l1 =new Login();
          l1.setVisible(true);

        }}});
    Adminlogin.setBounds(420,400,120,50);

    Adminlogin.addActionListener(new ActionListener() {
        
      public void actionPerformed(ActionEvent e){
      
        if(e.getSource()==Adminlogin){
          AdminCustomerFrame.setVisible(false);
          new adminlog();

        }}});
        l1.setBounds(310,300,1600,50);
     
     Iconlabel.setIcon(I);
     AdminCustomerFrame.add(Customerlogin);
     AdminCustomerFrame.add(Adminlogin);
     AdminCustomerFrame.add(Iconlabel);
     Customerlogin.setBorder(BorderFactory.createRaisedBevelBorder());
     Customerlogin.setBackground(new Color(128,128,128));
     Adminlogin.setBorder(BorderFactory.createRaisedBevelBorder());
     Adminlogin.setBackground(new Color(128,128,128));
     Customerlogin.setFocusable(false);
     Adminlogin.setFocusable(false);
     AdminCustomerFrame.add(l1);

     AdminCustomerFrame.revalidate();
     AdminCustomerFrame.repaint();

     
    }
    public static void main(String[] args) {
        new AdminCustomerPanel();
      }
}
