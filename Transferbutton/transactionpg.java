import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 public class transactionpg implements ActionListener{
	protected static double balance=0;
	public void updateBalance(double a)
	{
		if(balance>amount)
		{
			balance-=a;
		}
		else
		{
			balance-=0;
		}
	}
	public  double getUpdateBalance()
	{
		return balance;
	}

	protected double amount;
	JButton ok;
	JButton cancel;
	JTextField eamount;
	JFrame f;
	protected JPasswordField entpass=new JPasswordField();
	transactionpg()
	{
    f=new JFrame();
    f.setSize(600,400);
	f.setVisible(true);
	f.setLocation(400,200);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLayout(null);
	
	
	JLabel amountlabel=new JLabel("Enter amount");
	amountlabel.setBounds(140,130,100,50);
	
	eamount=new JTextField();
	eamount.setBounds(230,135,200,50);
	
	f.add(amountlabel);
	f.add(eamount);
	
	ok=new JButton("OK");
	ok.setBounds(200,250,80,40);
	ok.setFocusable(false);
	ok.addActionListener(this);

	cancel=new JButton("Cancel");
	cancel.setBounds(290,250,80,40);
	cancel.setFocusable(false);
	cancel.addActionListener(this);


	
	f.add(ok);
	f.add(cancel);
	
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==ok)
		{
			if(eamount.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please fill all fields",null,JOptionPane.WARNING_MESSAGE);
				return;
			}
			try {
				amount=Double.parseDouble(eamount.getText());
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null,"Please enter a valid amount",null,JOptionPane.WARNING_MESSAGE);
				return;
			}
			new verify(amount);
		}
		if(e.getSource()==cancel)
		{
			new Transfer();

		}
	}

	}
 
	
	
