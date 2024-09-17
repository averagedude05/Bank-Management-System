import javax.swing.*;
import java.awt.Image;
import java.awt.*;
import java.lang.*;

class welcomepage {
   JFrame frame=new JFrame();
   welcomepage()
   {
    frame.setSize(600,400);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(null);

    ImageIcon icon= new ImageIcon("bank.gif");
    Image i2=icon.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);

    
    JLabel label =new JLabel("");
    label.setIcon(i3);
    label.setBounds(0, 0, 600, 400);
    frame.add(label);
    //methods used to properly show the gif
    frame.repaint();
    frame.revalidate();


    try {
      Thread.sleep(2000);
      frame.setVisible(false);
      new login();

    } catch (Exception e) {
     e.printStackTrace();   
    }
    


   }
}
