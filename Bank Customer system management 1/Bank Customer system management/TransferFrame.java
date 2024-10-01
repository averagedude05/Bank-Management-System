import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.font.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.border.Border;
import java.lang.*;


public class TransferFrame extends MainMenu{
  
  JButton okBtn2 = new JButton("OK");
  JButton DltBtn2 = new JButton("Delete");
  public JFrame frame3 = new JFrame();
  public JTextField transferField;

 
    
  
    TransferFrame(){
     
      
      frame3.setResizable(false);
      frame3.setSize(800, 700);
      frame3.setVisible(true);
      frame3.setLocationRelativeTo(null);
      frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame3.setLayout(null);
      frame3.setBackground(new Color(192,192,192));

      transferField = new JTextField();
      transferField.setBounds(250,200,300,40);
      JLabel transferText = new JLabel("Ammount:");
      transferText.setFont(new Font("Courier",Font.PLAIN,14));
      transferText.setBounds(180,200,300,40);
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

      
      okBtn2.setBounds(250,520,140,50);
      DltBtn2.setBounds(410,520,140,50);

      b1.addActionListener(e-> transferField.setText(transferField.getText()+"1"));
      b2.addActionListener(e-> transferField.setText(transferField.getText()+"2"));
      b3.addActionListener(e-> transferField.setText(transferField.getText()+"3"));
      b4.addActionListener(e-> transferField.setText(transferField.getText()+"4"));
      b5.addActionListener(e-> transferField.setText(transferField.getText()+"5"));
      b6.addActionListener(e-> transferField.setText(transferField.getText()+"6"));
      b7.addActionListener(e-> transferField.setText(transferField.getText()+"7"));
      b8.addActionListener(e-> transferField.setText(transferField.getText()+"8"));
      b9.addActionListener(e-> transferField.setText(transferField.getText()+"9"));
      b0.addActionListener(e-> transferField.setText(transferField.getText()+"0"));


      okBtn2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
      
        if(e.getSource()==okBtn2){
         
          frame3.setVisible(false);
          JOptionPane.showMessageDialog(null, "Withdraw Successful","Bank System", JOptionPane.PLAIN_MESSAGE);
          frame2.setVisible(false);
            new MainMenu();
  
            try (FileWriter newfile = new FileWriter("E:\\Coding\\Java\\Bank Customer system management\\All the textsfiles\\Withdrawammount.txt",true);){
              
              String transferString =  transferField.getText();
             newfile.write(transferString+"\n");
             System.out.println("Successful!");
  
            }
            catch (Exception Ioe){
              System.out.println("Error");
            }
  
  
          }
        
  
        }});

     DltBtn2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent f){
            if(f.getSource()==DltBtn2){
                String transfertext = transferField.getText();
                if (!transfertext.isEmpty()){
                    transfertext = transfertext.substring(0,transfertext.length()-1);
                    transferField.setText(transfertext);
                }
            }
        }
     });

       

      b0.setBounds(250,460,300,50);
      
      
      JButton backButton = new JButton("Back");
      backButton.setBounds(5,5,140,50);
      backButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent g){
            if(g.getSource()==backButton){
                frame3.setVisible(false);
                frame2.setVisible(true);
                }
            }
        }
     );;


      buttonPanel.setLayout(new GridLayout(3,3,10,10));
      buttonPanel.setBounds(250,250,300,200);
      frame3.add(buttonPanel);
      buttonPanel.add(b1);
      buttonPanel.add(b2);
      buttonPanel.add(b3);
      buttonPanel.add(b4);
      buttonPanel.add(b5);
      buttonPanel.add(b6);
      buttonPanel.add(b7);
      buttonPanel.add(b8);
      buttonPanel.add(b9);
      frame3.add(b0);
      frame3.add(okBtn2);
      frame3.add(DltBtn2);
      frame3.add(transferField);
      frame3.add(transferText);
      frame3.add(backButton);
      
      

      frame3.revalidate();
      frame3.repaint();




    }
   
      public static void main(String[] args) {
        new TransferFrame();
      }
    
    }