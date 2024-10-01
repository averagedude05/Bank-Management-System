import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
public class Login extends JFrame implements ActionListener 
{
    JLabel userLabel1,userLabel2, userLabel4;
    JTextField userTF;
    JPasswordField passPF;
    JButton loginBtn, sgnUpBtn;
    JPanel panel;
    Font myFontSmall;
    String entUser=new String();
    String entPass=new String();
    public Login()
    {
        super("Login");
        setBounds(300,60,1100,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
        myFontSmall = new Font("Cambria", Font.PLAIN, 18);
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(30, 144, 255)); 
       
        JLabel Iconlabel = new JLabel();
        Iconlabel.setBounds(460,60,220,250);

        ImageIcon I1=new ImageIcon("Banklogo-removebg-preview.png");
      Image I2=I1.getImage().getScaledInstance(220,250,Image.SCALE_DEFAULT);
      ImageIcon I=new ImageIcon(I2);
      Iconlabel.setIcon(I);
      
        userLabel1 = new JLabel("USER NAME :");
        userLabel1.setBounds(280, 320 , 150, 30);
        userLabel1.setForeground(Color.BLACK);
        userLabel1.setFont(myFontSmall);
        panel.add(userLabel1);
       
        userLabel2 = new JLabel("PIN :");
        userLabel2.setBounds(350, 380, 300, 30);
        userLabel2.setForeground(Color.BLACK);
        userLabel2.setFont(myFontSmall);
        panel.add(userLabel2);
 
        userLabel4 = new JLabel("Don't Have An Account ?");
        userLabel4.setBounds(460, 490, 300, 30);
        userLabel4.setForeground(Color.BLACK);
        userLabel4.setFont(new Font ("Cambria", Font.PLAIN, 15));
        panel.add(userLabel4);
		
        userTF = new JTextField();
        userTF.setBounds(400, 320, 350, 40);
        userTF.setBackground(Color.WHITE);
        userTF.setFont(myFontSmall);
        panel.add(userTF);
 
        passPF = new JPasswordField();
        passPF.setBounds(400, 380, 350, 40);
        passPF.setBackground(Color.WHITE);
        passPF.setEchoChar('*');
        passPF.setFont(myFontSmall);
        panel.add(passPF);


        loginBtn = new JButton("Login");
        loginBtn.setBounds(530, 440, 100, 40);
        loginBtn.setBackground(Color.BLUE);
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFont(myFontSmall);
        loginBtn.addActionListener(this);
        panel.add(loginBtn);
		

        sgnUpBtn = new JButton();
        sgnUpBtn.setText("Sign Up");
        sgnUpBtn.setBounds(620, 490, 100, 25);
		sgnUpBtn.setBackground(Color.BLUE);
        sgnUpBtn.setForeground(Color.WHITE);
		sgnUpBtn.addActionListener(this);
        panel.add(sgnUpBtn);
        panel.add(Iconlabel);
 
 
        this.add(panel);
       
    }

	public void actionPerformed(ActionEvent e)
	{

		 if (e.getSource()==sgnUpBtn)
		{
            this.setVisible(false);
			panel.setVisible(false);
			SignUP s1 =new SignUP();
			s1.setVisible(true);

		}
        if (e.getSource()==loginBtn){
            Passverify();
            
        }

	}
    public void Passverify() {
        entUser = userTF.getText(); 
        entPass = new String(passPF.getPassword());
        File nf1 = new File("Data.txt");
        boolean found1 = false;
        boolean found2 = false;
    
        try (Scanner s1 = new Scanner(nf1)) {
            while (s1.hasNext()) {
                String name=s1.nextLine();
                int colonIndex = name.indexOf(":"); 
                String onlyName = name.substring(colonIndex + 1);
                String Accountno=s1.nextLine();
                int a=Accountno.indexOf(":");
                String onlyAccno=Accountno.substring(a+1);
            
                String balance=s1.nextLine();
                int c=balance.indexOf(":");
                String onlyBalance=balance.substring(c+1);
                String passcode=s1.nextLine();
                int start=passcode.indexOf(":");
                String onlyPass=passcode.substring(start+1);
                if(name.isEmpty()||passcode.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Fill all fields",null,JOptionPane.WARNING_MESSAGE);
                }
                if (onlyName.equals(entUser)) {
                    found1 = true;
                }
                if (onlyPass.equals(entPass)) {
                    found2 = true;
                }
                if (found1==true && found2==true ) {
                    break;
                }
            }
            if (found1==true && found2==true) {
               JOptionPane.showMessageDialog(null,"Successfull");
               this.setVisible(false);
               new MainMenu();

            } else {
                JOptionPane.showMessageDialog(null,"Unuccessfull");
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
    public static void main(String[] args) {
    Login l1 = new Login();
   l1.setVisible(true);
    
}
}

