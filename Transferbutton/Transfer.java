import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.BorderFactory;




public class Transfer  implements ActionListener {
    JFrame f;
	JPanel p;
    JButton transfer;
    Transfer()
    {

		f=new JFrame("Bank Management");
        f.setSize(600,400);
        f.setVisible(true);
        f.setLocation(400,200);

       // setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        
        ImageIcon i=new ImageIcon("logo.png");
        Image i2=i.getImage().getScaledInstance(100,90,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);

        transfer =new JButton(i3);
        transfer.setBackground(new Color(146, 176, 159));
        transfer.setBounds(300,130,100,90);
        transfer.setFocusable(false);
		transfer.setBorder(BorderFactory.createLineBorder(new Color(51, 51, 51),1));
		//transfer.setForeground(Color.CYAN);
		transfer.addActionListener(this);
		f.repaint();
		f.revalidate();
		
		
 
        f.add(transfer);	
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==transfer)
		{
            f.setVisible(false);
			new transactionpg();
           // t.actionPerformed(e);
		}
	}
	
			 
		
	
		
    
    
    public static void main(String[] args) {
        new Transfer();
        
    }
}
