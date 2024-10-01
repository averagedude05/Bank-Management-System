import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;


 class MyJButton extends JButton {

  MyJButton() {

      super();
      
      setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
 }
}

public class MainMenu {
  MyJButton TransferButton = new MyJButton();
  MyJButton DepositButton = new MyJButton();
  MyJButton WithdrawButton = new MyJButton();
  MyJButton CheckbalButton = new MyJButton();
  public double DepoBalupdate;
  public double TransBalupdate;
  public String s1;
  public double d;
  
 public JFrame frame2 = new JFrame();
  JPanel panel1 = new JPanel();
    MainMenu(){
      
     
      
      frame2.setResizable(true);
      frame2.setSize(800, 700);
      frame2.setVisible(true);
      frame2.setLocationRelativeTo(null);
      frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame2.setLayout(null);
      frame2.setBackground(new Color(160,160,160));

      
    
      JLabel MainMenu = new JLabel("Main Menu");
      MainMenu.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
      MainMenu.setForeground(new Color(160,160,160));
      
    
      panel1.setLayout(new FlowLayout());
     

      TransferButton.setText("Transfer");
      DepositButton.setText("Deposit");
      WithdrawButton.setText("Withdraw");
      CheckbalButton.setText("Check Balance");
      
      DepositButton.addActionListener(new ActionListener() {
        
      public void actionPerformed(ActionEvent e){
      
        if(e.getSource()==DepositButton){
  
         
          frame2.setVisible(false);
          new DepositFrame();
          
          
          
           }}
          });

          WithdrawButton.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent e){
            
              if(e.getSource()==WithdrawButton){
        
               
                frame2.setVisible(false);
               new TransferFrame();
                
                
                
                 }}
                });    

      TransferButton.setFocusable(false);
      DepositButton.setFocusable(false);
      WithdrawButton.setFocusable(false);
      CheckbalButton.setFocusable(false);

      TransferButton.setBounds(60,160,300,180);
      DepositButton.setBounds(400,160,300,180);
      WithdrawButton.setBounds(60,390,300,180);
      CheckbalButton.setBounds(400,390,300,180);

      ImageIcon i=new ImageIcon("money-transfer.png");
      Image i2=i.getImage().getScaledInstance(100,90,Image.SCALE_DEFAULT);
      ImageIcon TransIcon=new ImageIcon(i2);

      ImageIcon i3=new ImageIcon("4171947_cash_currency_down_money_pay_icon.png");
      Image i4=i3.getImage().getScaledInstance(100,90,Image.SCALE_DEFAULT);
      ImageIcon DepositIcon=new ImageIcon(i4);

      ImageIcon i5=new ImageIcon("money-withdrawal.png");
      Image i6=i5.getImage().getScaledInstance(100,90,Image.SCALE_DEFAULT);
      ImageIcon WithdrawIcon=new ImageIcon(i6);

      ImageIcon i7=new ImageIcon("money-bag.png");
      Image i8=i7.getImage().getScaledInstance(100,90,Image.SCALE_DEFAULT);
      ImageIcon CheckBalIcon=new ImageIcon(i8);

      ImageIcon i9 = new ImageIcon("Banklogo-removebg-preview.png");
      ImageIcon i10 = new ImageIcon("Banklogo-removebg-preview.png");
      Image i11 = i10.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT);
      ImageIcon i12 = new ImageIcon(i11);
      
      MainMenu.setIcon(i12);

      
      frame2.setIconImage(i9.getImage());
      
      
      TransferButton.setIcon(TransIcon);
      DepositButton.setIcon(DepositIcon);
      WithdrawButton.setIcon(WithdrawIcon);
      CheckbalButton.setIcon(CheckBalIcon);

      TransferButton.setHorizontalTextPosition(JButton.CENTER);
      DepositButton.setHorizontalTextPosition(JButton.CENTER);
      WithdrawButton.setHorizontalTextPosition(JButton.CENTER);
      CheckbalButton.setHorizontalTextPosition(JButton.CENTER);


      TransferButton.setVerticalTextPosition(JButton.BOTTOM);
      DepositButton.setVerticalTextPosition(JButton.BOTTOM);
      WithdrawButton.setVerticalTextPosition(JButton.BOTTOM);
      CheckbalButton.setVerticalTextPosition(JButton.BOTTOM);

      TransferButton.setIconTextGap(-5);
      DepositButton.setIconTextGap(-5);
      WithdrawButton.setIconTextGap(-5);
      CheckbalButton.setIconTextGap(-5);

      TransferButton.setForeground(Color.black);
      DepositButton.setForeground(Color.black);
      WithdrawButton.setForeground(Color.black);
      CheckbalButton.setForeground(Color.black);

      TransferButton.setBorder(BorderFactory.createRaisedBevelBorder());
      DepositButton.setBorder(BorderFactory.createRaisedBevelBorder());
      WithdrawButton.setBorder(BorderFactory.createRaisedBevelBorder());
      CheckbalButton.setBorder(BorderFactory.createRaisedBevelBorder());
      
      TransferButton.setBackground(new Color(128,128,128));
      DepositButton.setBackground(new Color(128,128,128));
      WithdrawButton.setBackground(new Color(128,128,128));
      CheckbalButton.setBackground(new Color(128,128,128));
    
      
     
      panel1.setBackground(new Color(0,128,255));
      panel1.setBounds(0,0,800,120);
      
      

      frame2.add(panel1);
      panel1.add(MainMenu);
      
      
      frame2.add(DepositButton);
      frame2.add(WithdrawButton);
      frame2.add(TransferButton);
      frame2.add(CheckbalButton);


      frame2.revalidate();
      frame2.repaint();
      
     
    }
    public void getDepammount(){
      
			File newfile = new File("E:\\Coding\\Java\\Bank Customer system management\\All the textsfiles\\Depositammount.txt");
      
		   try(Scanner sc = new Scanner(newfile)){
        while(sc.hasNext())
        {
          s1 = sc.nextLine();
          
           
        }
        
       }
       catch(IOException ioe){
        ioe.printStackTrace();
       }
       
			
			
			
		
    }
    public double deposit1(){
       d = Double.parseDouble(s1);
       return transactionpg.balance +=d;
       
    }
    public static void main(String[] args) {
      new MainMenu();
    }
  }
    


