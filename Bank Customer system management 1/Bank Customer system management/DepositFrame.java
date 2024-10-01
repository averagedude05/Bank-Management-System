import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

public class DepositFrame extends MainMenu  {

  JButton okBtn = new JButton("OK");
  JButton DltBtn = new JButton("Delete");
  public JFrame frame = new JFrame();
  public JTextField depositField;
  public String depoString;
  public double result;
  
  
  String pinS=new String();
  String passcode=new String("1234");
  double rs;
  DepositFrame() {
    
    frame.setResizable(true);
    frame.setSize(800, 700);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(null);
    frame.getContentPane().setBackground(new Color(0,128,255));

    depositField = new JTextField();
    depositField.setBounds(250, 200, 300, 40);
    JLabel depositText = new JLabel("Amount:");
    depositText.setFont(new Font("Courier", Font.PLAIN, 14));
    depositText.setBounds(180, 200, 300, 40);
    JPanel buttonPanel = new JPanel();
    

  


    JButton b1 = new JButton("1");
    JButton b2 = new JButton("2");
    JButton b3 = new JButton("3");
    JButton b4 = new JButton("4");
    JButton b5 = new JButton("5");
    JButton b6 = new JButton("6");
    JButton b7 = new JButton("7");
    JButton b8 = new JButton("8");
    JButton b9 = new JButton("9");
    JButton b0 = new JButton("0");

    okBtn.setBounds(250, 520, 140, 50);
    okBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okBtn) {
          rs=Double.parseDouble(depositField.getText());
          JOptionPane.showMessageDialog(null, "Deposit Successful","Bank System", JOptionPane.PLAIN_MESSAGE);
          deposit();
          writeBalanceTxt();
          frame.setVisible(false);

          new MainMenu();
        }
      }
    });

    DltBtn.setBounds(410, 520, 140, 50);
    DltBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent f) {
        if (f.getSource() == DltBtn) {
          String deposittext = depositField.getText();
          if (!deposittext.isEmpty()) {
            deposittext = deposittext.substring(0, deposittext.length() - 1);
            depositField.setText(deposittext);
          }
        }
      }
    });
    JButton backButton1 = new JButton("Back");
      backButton1.setBounds(5,5,140,50);
      backButton1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent g){
            if(g.getSource()==backButton1){
                frame.setVisible(false);
                frame2.setVisible(true);
                }
            }
        }
     );

    b1.addActionListener(e -> depositField.setText(depositField.getText() + "1"));
    b2.addActionListener(e -> depositField.setText(depositField.getText() + "2"));
    b3.addActionListener(e -> depositField.setText(depositField.getText() + "3"));
    b4.addActionListener(e -> depositField.setText(depositField.getText() + "4"));
    b5.addActionListener(e -> depositField.setText(depositField.getText() + "5"));
    b6.addActionListener(e -> depositField.setText(depositField.getText() + "6"));
    b7.addActionListener(e -> depositField.setText(depositField.getText() + "7"));
    b8.addActionListener(e -> depositField.setText(depositField.getText() + "8"));
    b9.addActionListener(e -> depositField.setText(depositField.getText() + "9"));
    b0.addActionListener(e -> depositField.setText(depositField.getText() + "0"));

    buttonPanel.setLayout(new GridLayout(3, 3, 10, 10));
    buttonPanel.setBounds(250, 250, 300, 200);
    buttonPanel.setBackground(new Color(0,128,255));
    b0.setBounds(250,460,300,50);
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
    frame.add(backButton1);

    frame.revalidate();
    frame.repaint();
  }
 

   public void deposit() {
     
    transactionpg.balance +=rs;  // Update the static balance in transactionpg
     System.out.println("New Balance: " + transactionpg.getUpdateBalance());  // Print updated balance
   // depositField.setText("");  // Clear the deposit field after a successful deposit
  }
  public void writeBalanceTxt()
  {
    File read= new File("E:\\Coding\\Java\\Bank Customer system management\\Admin panel\\store.txt");
    StringBuffer buffer=new StringBuffer();
    try(Scanner scanner=new Scanner(read)){
      while(scanner.hasNext())
      {
        String line=scanner.nextLine();
         if(line.contains("Balance:"))
         {
          line = "Balance:" + transactionpg.getUpdateBalance();
         }
         buffer.append(line+"\n");
      }

    }catch(IOException e)
    {
      System.out.println("error");
    }
    try (FileWriter writeBalance = new FileWriter(read)) {
      writeBalance.write(buffer.toString());
  } catch (IOException ioe) {
      ioe.printStackTrace();
  }

  }

  public static void main(String[] args) {
    new DepositFrame();
  }
}
