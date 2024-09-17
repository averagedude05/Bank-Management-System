import java.awt.Image;

import javax.swing.*;
class login extends JFrame{
    login()
    {
        setSize(800, 700);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon i =new ImageIcon("");
        //Image i2 = i.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
       // ImageIcon i3 =new ImageIcon(i2);

        JLabel l= new JLabel();
        l.setBounds(0,0,800,700);
        l.setIcon(i);

       
        add(l);



        
    }
    public static void main(String[] args) {
        new login();
    }

}