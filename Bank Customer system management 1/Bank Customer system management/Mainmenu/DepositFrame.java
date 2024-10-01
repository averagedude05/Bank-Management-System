import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.font.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.border.Border;
import java.lang.*;


public class DepositFrame extends MainMenu {
  
  JButton okBtn = new JButton("OK");
  JButton DltBtn = new JButton("Delete");
  public JFrame frame = new JFrame();
  public JTextField depositField;
  public String depoString;
  

  
    DepositFrame(){
     
      
      frame.setResizable(false);
      frame.setSize(800, 700);
      frame.setVisible(true);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(null);
      frame.setBackground(new Color(255,255,255));

       depositField = new JTextField();
      depositField.setBounds(250,200,300,40);
      JLabel depositText = new JLabel("Ammount:");
      depositText.setFont(new Font("Courier",Font.PLAIN,14));
      depositText.setBounds(180,200,300,40);
      JPanel buttonPanel = new JPanel();

      JButton b1 =new JButton("1");
      JButton b2 =new JButton("2");
      JButton b3 =new JButton("3");
      JButton b4 =new JButton("4");
      JButton b5 =new JButton("5");
      JButton b6 =new JButton("6");
      JButton b7 =new JButton("7");
      JButton b8 =new JButton("8");
      JButton b9 =new JButton("9");
      JButton b0 =new JButton("0");

      
      okBtn.setBounds(250,520,140,50);
      okBtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
      
        if(e.getSource()==okBtn){
         
          frame.setVisible(false);
          JOptionPane.showMessageDialog(null, "Deposit Successful","Bank System", JOptionPane.PLAIN_MESSAGE);
          frame2.setVisible(false);
            new MainMenu();
            
          try( FileWriter Depositfile = new FileWriter("E:\\Coding\\Java\\Bank Customer system management\\All the textsfiles\\Depositammount.txt");){ 
           depoString = depositField.getText();
           Depositfile.write(depoString+"\n");
           
           
  
          }
          catch(IOException ioe) {
            ioe.printStackTrace();
          }
        getDepammount();
       
  
    }}});
      
      DltBtn.setBounds(410,520,140,50);

      DltBtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent f){
            if(f.getSource()==DltBtn){
                String deposittext = depositField.getText();
                if (!deposittext.isEmpty()){
                    deposittext = deposittext.substring(0,deposittext.length()-1);
                    depositField.setText(deposittext);
                }
            }
        }
     });

      b1.addActionListener(e-> depositField.setText(depositField.getText()+"1"));
      b2.addActionListener(e-> depositField.setText(depositField.getText()+"2"));
      b3.addActionListener(e-> depositField.setText(depositField.getText()+"3"));
      b4.addActionListener(e-> depositField.setText(depositField.getText()+"4"));
      b5.addActionListener(e-> depositField.setText(depositField.getText()+"5"));
      b6.addActionListener(e-> depositField.setText(depositField.getText()+"6"));
      b7.addActionListener(e-> depositField.setText(depositField.getText()+"7"));
      b8.addActionListener(e-> depositField.setText(depositField.getText()+"8"));
      b9.addActionListener(e-> depositField.setText(depositField.getText()+"9"));
      b0.addActionListener(e-> depositField.setText(depositField.getText()+"0"));


     // String Depositamt = depositField.getText();
      // File Depositfile = new File("E:\\Coding\\Java\\Bank Customer system management\\All the textsfiles\\Depositammunt.txt");

     

       

      b0.setBounds(250,460,300,50);
      
      
      buttonPanel.setLayout(new GridLayout(3,3,10,10));
      buttonPanel.setBounds(250,250,300,200);
      frame.add(buttonPanel);
      buttonPanel.add(b1);
      buttonPanel.add(b2);
      buttonPanel.add(b3);
      buttonPanel.add(b4);
      buttonPanel.add(b5);
      buttonPanel.add(b6);
      buttonPanel.add(b7);
      buttonPanel.add(b8);
      buttonPanel.add(b9);
      frame.add(b0);
      frame.add(okBtn);
      frame.add(DltBtn);
      frame.add(depositField);
      frame.add(depositText);
          

      frame.revalidate();
      frame.repaint();

    }
    
    
      public static void main(String[] args) {
        new DepositFrame();
      }
    
    }
  
