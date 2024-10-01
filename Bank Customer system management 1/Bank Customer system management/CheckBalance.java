import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;

public class CheckBalance extends MainMenu {
    JFrame frame4= new JFrame("Bank System");
    JLabel l1 = new JLabel("Your Current Balance is : ");
    
   
    JTextField balance = new JTextField();
    JButton returnButton = new JButton("Return to MainMenu");
    
    CheckBalance(){

      frame4.setResizable(true);
      frame4.setSize(800, 700);
      frame4.setVisible(true);
      frame4.setLocationRelativeTo(null);
      frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame4.setLayout(null);
      frame4.setBackground(Color.BLUE);

      returnButton.setBounds(250,460,300,50);

      balance.setBounds(250,360,250,50);

      returnButton.setFocusable(false);
      returnButton.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e){
               
           if(e.getSource()==returnButton){
           
                  
               frame4.setVisible(false);
               new MainMenu();
                   
                   
                   
                    }}
                   });    

     l1.setFont(new Font("Comic Sans MS",Font.BOLD,30));
      l1.setForeground(Color.BLACK);
      l1.setBounds(230,150,400,150);
      
      frame4.add(l1);
      frame4.add(returnButton);
      frame4.add(balance);
      showbal();

    }
    public void showbal(){
      File readbal = new File("E:\\Coding\\Java\\Bank Customer system management\\Admin panel\\store.txt");
      try(Scanner s1 = new Scanner(readbal)){
        while( s1.hasNext()){
          String line = s1.nextLine();
        if (line.contains("Balance:")){
          balance.setText(line);
        }
      }}
      catch(Exception ioe){
        System.out.println("Error");
        
      }
    }
    public static void main(String[] args) {
        new CheckBalance();
        
    }
}

