import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 public class transactionpg implements ActionListener{
    private static double balance=50000.0;
	public void updateBalance(double a)
	{
		balance-=a;
	}
	public static double getUpdateBalance()
	{
		return balance;
	}

	double amount;
	JButton ok;
	JButton cancel;
	JTextField eamount;
	JFrame f;
	private String password= new String("1234");
	public String getPassword()
	{
		return password;
	}
	public JPasswordField entpass=new JPasswordField();
	
	//private Object entpass;
	transactionpg()
	{
    f=new JFrame();
    f.setSize(600,400);
	f.setVisible(true);
	f.setLocation(400,200);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLayout(null);
	
	
	JLabel amountlabel=new JLabel("Enter the amount:");
	amountlabel.setBounds(100,130,100,50);
	
	eamount=new JTextField();
	eamount.setBounds(210,135,200,50);
	
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
			try {
				amount=Double.parseDouble(eamount.getText());
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null,"Please enter a valid amount",null,JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(amount<balance)
			{
				f.dispose();
				new verify(amount);
			}
			else
			{
				System.out.println("Unsuccessful");
			}
		}
		if(e.getSource()==cancel)
		{
			new Transfer();
			
		}
	}
				
	




	

		
	}
 
	
	