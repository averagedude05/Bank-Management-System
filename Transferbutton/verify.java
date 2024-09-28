import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class verify extends transactionpg implements ActionListener {
    JFrame framep;
    JButton b;
    JButton c;
    JButton r;
    String checkpass=new String();
    private static int counter=0;
    private String matchBalance=new String();
    public int getCounter()
    {
        return counter;
    }
    public  void Error()
    {
        if(getCounter()==3)
        {
            JOptionPane.showMessageDialog(null,"Too many Incorrect Attempts",null,JOptionPane.PLAIN_MESSAGE);
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
            checkpass=String.valueOf(entpass.getPassword());//entered password
            try {

                checkPassword();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
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
   
    public void checkPassword()throws FileNotFoundException
    {
        try  
        {
            String onlyPin=new String();
            File read=new File("C:\\Users\\Adib Afsar Khan\\Documents\\Aiub\\language\\Java\\Project\\Bank-Management-System-main\\Admin panel\\store.txt");
            Scanner scanner =new Scanner(read);
            boolean found=false;
           while(scanner.hasNextLine())
           {
            String line=scanner.nextLine();
            if(line.contains("PIN"))
            {
                int index=line.indexOf(":");
                onlyPin=line.substring(index+1);
                if(checkpass.equals(onlyPin))
                {
                    JOptionPane.showMessageDialog(null,"Successful",null,JOptionPane.PLAIN_MESSAGE);
                    found=true;
                    matchBalance=scanner.nextLine();
                    checkBalance();
                    updateBalance(amount);
                    updateBalancetxt();
                    break;
                }
                else
                {
                    line=scanner.nextLine();
                }  
            }
           }
           if(found==false)
                {
                    JOptionPane.showMessageDialog(null,"Credentials donot match",null,JOptionPane.ERROR_MESSAGE);
                    counter++;
                    Error();
                }
        } catch (IOException ioe) {
            System.out.println("Error");
           }
      } 
      private void updateBalancetxt() throws FileNotFoundException {
        File balance = new File("C:\\Users\\Adib Afsar Khan\\Documents\\Aiub\\language\\Java\\Project\\Bank-Management-System-main\\Admin panel\\store.txt");
        String line;
        StringBuilder fileContent = new StringBuilder();
        try (Scanner balanceScanner = new Scanner(balance)) {
            while (balanceScanner.hasNext()) {
               line = balanceScanner.nextLine();
                if (line.contains("Balance:")) 
                {
                    if(line.equals(matchBalance))
                    {
                        
                        line = "Balance:" + getUpdateBalance();
                    }
                    
                }
                fileContent.append(line +"\n");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        try (FileWriter writeBalance = new FileWriter(balance)) {
            writeBalance.write(fileContent.toString());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public void checkBalance() throws FileNotFoundException
    {
        File read=new File("C:\\Users\\Adib Afsar Khan\\Documents\\Aiub\\language\\Java\\Project\\Bank-Management-System-main\\Admin panel\\store.txt");
        Scanner scanner=new Scanner(read);
        String line=new String();
        while(scanner.hasNext())
        {
           line=scanner.nextLine();
           if(line.contains("Balance")&& line.equals(matchBalance))
           {
            int index=line.indexOf(":");
            String onlyBalance=line.substring(index+1);
            balance=Double.parseDouble(onlyBalance);
            if(balance>amount)
            {
                
                new Transfer();
                return;
            }
            else{
                JOptionPane.showMessageDialog(null,"Insufficient balance",null,JOptionPane.ERROR_MESSAGE);
                new transactionpg();
            }
           }
        }


    }
    }
   

