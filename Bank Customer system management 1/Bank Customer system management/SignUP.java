import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;


public class SignUP extends JFrame implements ActionListener {


    JPanel panel;
    ImageIcon imgE;
    JLabel lNameLabel,fNameLabel,dobLabel, genderLabel,nidLabel,accLabel,mailLabel,mblLabel,cpassLabel,passLabel;
    JTextField nameText1,nameText2,dobText,nidText,accText,mailText,mblText;
    JPasswordField passPF, passPF1;
    JButton sgnUpBtn, exitBtn;
    boolean check;
    String name,name2, dob, nid, acc, mail, mobile, pf, pf1;
    JRadioButton   genderBtn1,genderBtn2,genderBtn3;
    Font myFont;
    ButtonGroup grp;

    public SignUP(){
        super("Sign UP");
        setBounds(300,60,1100,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFont = new Font("Cambria", Font.PLAIN, 18);
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(30, 144, 255));


        fNameLabel = new JLabel("FIRST NAME :");
        fNameLabel.setBounds(200, 150 , 150, 30);
        fNameLabel.setForeground(Color.BLACK);
        fNameLabel.setFont(myFont);
        panel.add(fNameLabel);

        nameText1 = new JTextField();
        nameText1.setBounds(320, 150, 200, 30);
        nameText1.setFont(myFont);
        nameText1.setBackground(Color.WHITE);
        panel.add(nameText1);

        lNameLabel = new JLabel("LAST NAME :");
        lNameLabel.setBounds(550, 150 , 150, 30);
        lNameLabel.setForeground(Color.BLACK);
        lNameLabel.setFont(myFont);
        panel.add(lNameLabel);

        nameText2 = new JTextField();
        nameText2.setBounds(670, 150, 200, 30);
        nameText2.setFont(myFont);
        nameText2.setBackground(Color.WHITE);
        panel.add(nameText2);

        dobLabel = new JLabel("DOB                :");
        dobLabel.setBounds(200, 200 , 150, 30);
        dobLabel.setForeground(Color.BLACK);
        dobLabel.setFont(myFont);
        panel.add(dobLabel);

        dobText = new JTextField();
        dobText.setBounds(320, 200, 200, 30);
        dobText.setFont(myFont);
        dobText.setBackground(Color.WHITE);
        panel.add(dobText);

        genderLabel = new JLabel("GENDER     :");
        genderLabel.setBounds(550, 200 , 150, 30);
        genderLabel.setForeground(Color.BLACK);
        genderLabel.setFont(myFont);
        panel.add(genderLabel);


        grp= new ButtonGroup();
        
        genderBtn1 =new JRadioButton("Male");
        genderBtn1.setBounds(700,200,100,30);
        genderBtn1.setFont(myFont);
        panel.add(genderBtn1);
      
        genderBtn2 =new JRadioButton("Female");
        genderBtn2.setBounds(810,200,100,30);
        genderBtn2.setFont(myFont);
        panel.add(genderBtn2); 
        
        genderBtn3 =new JRadioButton("Others");
        genderBtn3.setBounds(920,200,100,30);
        genderBtn3.setFont(myFont);
        panel.add(genderBtn3);
       
        grp.add(genderBtn1);
        grp.add(genderBtn2);
        grp.add(genderBtn3);


        nidLabel = new JLabel("NID                 :");
        nidLabel.setBounds(200, 250 , 150, 30);
        nidLabel.setForeground(Color.BLACK);
        nidLabel.setFont(myFont);
        panel.add(nidLabel);

        nidText = new JTextField();
        nidText.setBounds(320, 250, 200, 30);
        nidText.setFont(myFont);
        nidText.setBackground(Color.WHITE);
        panel.add(nidText);



        accLabel = new JLabel("ACCOUNT NO    :");
        accLabel.setBounds(550, 250 , 150, 30);
        accLabel.setForeground(Color.BLACK);
        accLabel.setFont(myFont);
        panel.add(accLabel);

        accText = new JTextField();
        accText.setBounds(700, 250, 200, 30);
        accText.setFont(myFont);
        accText.setBackground(Color.WHITE);
        panel.add(accText);

        mailLabel = new JLabel("E-MAIL   :");
        mailLabel.setBounds(200, 300 , 150, 30);
        mailLabel.setForeground(Color.BLACK);
        mailLabel.setFont(myFont);
        panel.add(mailLabel);

        mailText = new JTextField();
        mailText.setBounds(320, 300, 200, 30);
        mailText.setFont(myFont);
        mailText.setBackground(Color.WHITE);
        panel.add(mailText);

        mblLabel = new JLabel("MOBILE NO.    :");
        mblLabel.setBounds(550, 300 , 150, 30);
        mblLabel.setForeground(Color.BLACK);
        mblLabel.setFont(myFont);
        panel.add(mblLabel);

        mblText = new JTextField();
        mblText.setBounds(700, 300, 200, 30);
        mblText.setFont(myFont);
        mblText.setBackground(Color.WHITE);
        panel.add(mblText);

                 
        cpassLabel = new JLabel("CONFIRM PASSWORD:");
        cpassLabel.setBounds(550, 350 , 200, 30);
        cpassLabel.setForeground(Color.BLACK);
        cpassLabel.setFont(myFont);
        panel.add(cpassLabel);
        passPF1=new JPasswordField();
        passPF1.setBounds(730,350,200,30);
        panel.add(passPF1);
        
        
        passLabel = new JLabel("PASSWORD:");
        passLabel.setBounds(200, 350 , 150, 30);
        passPF=new JPasswordField();
        passPF.setBounds(320,350,200,30);
        panel.add(passPF);
        passLabel.setForeground(Color.BLACK);
        passLabel.setFont(myFont);
        panel.add(passLabel);
        
        sgnUpBtn = new JButton("SignUp");
        sgnUpBtn.setBounds(500, 450, 100, 40);
        sgnUpBtn.setBackground(Color.BLUE);
        sgnUpBtn.setForeground(Color.WHITE);
        sgnUpBtn.setFont(myFont);
        panel.add(sgnUpBtn);
        
        sgnUpBtn.addActionListener(this);
        

        //imgE = new ImageIcon("E:\\JAVA PROJECT\\Image\\Exit.png");
		exitBtn = new JButton();
		exitBtn.setIcon(imgE);
		exitBtn.setBounds(20,20,50,50);
		exitBtn.setFocusPainted(false);
		exitBtn.setContentAreaFilled(false);
		panel.add(exitBtn);
        exitBtn.addActionListener(this);

        this.add(panel);
      

    }
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource()==exitBtn) {
            this.setVisible(false);
            Login back =  new Login();
            back.setVisible(true);

        }
        

        if(e.getSource()==sgnUpBtn)
        {
             name = new String(nameText1.getText());
             name2 = new String(nameText2.getText());
             dob = new String(dobText.getText());
             nid = new String(nidText.getText());
             acc = new String(accText.getText());
             mail = new String(mailText.getText());
             mobile = new String(mblText.getText());

             pf = new String();
             pf = String.valueOf(passPF.getPassword());
             pf1 = new String();
             pf1 = String.valueOf(passPF1.getPassword());

            if(nid.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Fill Up All The Fields.");
            }
            else if(name.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Fill Up All The Fields.");
            }
            else if(name2.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Fill Up All The Fields.");
            }
            else if(dob.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Fill Up All The Fields.");
            }
            else if(mail.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Fill Up All The Fields.");
            }
            else if(mobile.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Fill Up All The Fields.");
            }
            else if(acc.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Fill Up All The Fields.");
            }
            else if(pf.isEmpty() && (pf == null))
            {
                JOptionPane.showMessageDialog(null, "Fill Up All The Fields.");
            }
            else if(pf1.isEmpty() && (pf1 == null))
            {
                JOptionPane.showMessageDialog(null, "Fill Up All The Fields.");
            }
           
  
            if(genderBtn1.isSelected() || genderBtn2.isSelected() || genderBtn3.isSelected())
              {            
                check=true;
               }
            
           
        
        if(e.getSource() == sgnUpBtn)
        {
            checkPass();
            StoreInfo();
        }

        
    }
    
   
  }
 
public void checkPass()
    {
    if(pf.equals(pf1) && (check == true))
    {
        this.setVisible(false);
        JOptionPane.showMessageDialog(null,"Sign Up Successful");
        Login l1=new Login();
        l1.setVisible(true);
    }
       else if(!pf.equals(pf1))
    {
       JOptionPane.showMessageDialog(null,"Password Doesn't Match");
       this.setVisible(true);

    }

    
  }
  public void StoreInfo(){
    try(FileWriter newFile= new FileWriter("Data.txt",true)){
      newFile.write("Name:"+name+" "+name2+"\n");
      newFile.write("Account no:"+acc+"\n");
      newFile.write("Balance"+"\n");
      newFile.write("Passcode:"+pf+"\n");
      System.out.println("Successful");
    }
    catch(IOException io)
    {
        io.printStackTrace();
    }
  }
  public static void main(String[] args) {
    new SignUP();
  }

}
   


    

