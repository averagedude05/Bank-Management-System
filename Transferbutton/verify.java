import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class verify extends transactionpg implements ActionListener {
    JFrame framep;
    JButton b;
    JButton c;
    JButton r;

    String checkpass=new String();
    public static int counter=0;
    public  void Error()
    {
        if(counter==1)
        {
            System.exit(0);

        }
    }

    verify(double amount)
    {
        
        this.amount=amount;
        framep=new JFrame("Bank Management");
        framep.setVisible(true);
        framep.setSize(600,400);
        framep.setLocation(400,200);
        framep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framep.setLayout(null);
    
        JLabel pinlabel=new JLabel("Enter PIN: ");
        pinlabel.setBounds(100,130,100,50);
        //pinlabel.setBounds(200,100,100,50);
        framep.add(pinlabel);
        entpass.setBounds(210,135,200,50);
        //entpass.setBounds(270,100,200,50);
        framep.add(entpass);
        
        
        
        
        
        
        b=new JButton("OK");
        b.setBounds(200,250,80,40);
        b.setFocusable(false);
        b.addActionListener(this);
        
        c=new JButton("Cancel");
        c.setBounds(320,250,80,40);
        c.setFocusable(false);
        c.addActionListener(this);

        r=new JButton("Return to main menu");
        r.setBounds(200,300,200,40);
        r.setFocusable(false);
        r.addActionListener(this);
        
        
        
        framep.add(b);
        framep.add(c);
        framep.add(r);
        
        
        
        
        
        
        
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b)
        {
            checkpass=String.valueOf(entpass.getPassword());
            
            if(checkpass.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Field cannot be empty", "GUI", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                if(getPassword().equals(checkpass))
                {
                    JOptionPane.showMessageDialog(null, "Successfull", "GUI", JOptionPane.PLAIN_MESSAGE);
                    updateBalance(amount);
                    JOptionPane.showMessageDialog(null, "Remaining balance is "+transactionpg.getUpdateBalance(), "GUI", JOptionPane.PLAIN_MESSAGE);
                    //f.dispose();
                    framep.setVisible(false);
                    new Transfer();
                }

                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect password", "GUI", JOptionPane.ERROR_MESSAGE);
                    counter=(counter+1);
                    new transactionpg();
                    Error();
                }
            }
        }
        if(e.getSource()==c)
        {
           new transactionpg();
        }
        if(e.getSource()==r)
        {
            new Transfer();
        }
    }
   
}
