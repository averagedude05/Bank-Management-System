import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
class adminlog implements ActionListener{
    JFrame adminFrame;
    JTextField textField;
    JPasswordField passwordField;
    String adminUserName=new String("admin");
    private String adminPassword=new String("1234");
    JButton ok;
    public String getadminPassword()
    {
        return adminPassword;
    }
        adminlog()
    {
        adminFrame=new JFrame();
        adminFrame.setVisible(true);
        adminFrame.setSize(600,400);
        adminFrame.setLocationRelativeTo(null);
        adminFrame.setLayout(null);

        JLabel username=new JLabel("Enter username");
        username.setBounds(300,100,150,60);
       // username.setFont(new Font("Arial", Font.BOLD, 15));
       username.setForeground(Color.BLACK);
        adminFrame.add(username);

        textField=new JTextField();
        textField.setBounds(420,110,150,50);
        adminFrame.add(textField);

        // ImageIcon backgound=new ImageIcon("adminlog.jpeg");
        // Image i2=backgound.getImage().getScaledInstance(600, 400,Image.SCALE_DEFAULT);
        // ImageIcon i3=new ImageIcon(i2);
        
        // JLabel bakgroundl=new JLabel(i3);
        // bakgroundl.setBounds(0,0,600,400);
        // adminFrame.add(bakgroundl);

        // JPanel backPanel=new JPanel();
        // backPanel.setBounds(0,0,600,400);
        // backPanel.add(bakgroundl);
        // adminFrame.add(backPanel);

        passwordField=new JPasswordField();
        passwordField.setBounds(420,180,150,50);
        adminFrame.add(passwordField);

        JLabel passJLabel=new JLabel("Enter password");
        passJLabel.setBounds(300,180,150,50);
        adminFrame.add(passJLabel);

        ok=new JButton("Confirm");
        ok.setBounds(250,250,80,50);
        ok.addActionListener(this);
        ok.setFocusable(false);
        adminFrame.add(ok);

        adminFrame.repaint();;
        adminFrame.revalidate();




        

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==ok)
        {
            try {
                usernamePasswordVerify();
                //adminFrame.setVisible(false);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }
    public void usernamePasswordVerify() throws IOException
    {
        String enteredName=textField.getText();
        String enteredPass=String.valueOf(passwordField.getPassword());
        File admin=new File("adminstore.txt");
        Scanner scanadmin=new Scanner(admin);
        if(enteredName.isEmpty()|| enteredPass.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Fill all fields",null,JOptionPane.WARNING_MESSAGE);
                
            }
            else
            {
                while (scanadmin.hasNext()) {
                    String name=new String(scanadmin.nextLine());
                    String pass=new String(scanadmin.nextLine());
                    
                    if(name.equals(enteredName) && pass.equals(enteredPass))
                    {
                        new adminpanel();
                        adminFrame.setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Invalid Credentials",null,JOptionPane.ERROR_MESSAGE);
                    }
                  }
            }

           
        } 
    public static void main(String[] args) {
      new adminlog();
        
    }
}
        

