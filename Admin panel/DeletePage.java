import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
class DeletePage implements ActionListener
{
   public JFrame deleteFrame;
   public String[] headers={"Account no","Name","PIN","Balance"};
   private  String[]column;
   public DefaultTableModel dmodel;
   private JButton deButton;
  private JTable table;
  private JTextField searchField=new JTextField();
   private JButton searchButton;
   private JButton cancelButton;
  public  DeletePage()
   {
    
    deleteFrame =new JFrame();
    deleteFrame.setSize(600,400);
    deleteFrame.setVisible(true);
    deleteFrame.setLocationRelativeTo(null);
    deleteFrame.setLayout(null);
    d();

    deButton =new JButton("Delete");
    deButton.setBounds(360,250,100, 60);
    deleteFrame.add(deButton);
    deButton.addActionListener(this);

    searchField.setBounds(150, 250,200, 60);
    deleteFrame.add(searchField);

    searchButton=new JButton("Search");
    searchButton.setBounds(20, 250, 100, 60);
    searchButton.addActionListener(this);
    searchButton.setFocusable(false);
    deleteFrame.add(searchButton);

    cancelButton=new JButton("Cancel");
    cancelButton.setBounds(490,260,80,50);
    cancelButton.addActionListener(this);
    deleteFrame.add(cancelButton);

    deleteFrame.repaint();
    deleteFrame.revalidate();
   }
   public void d()
   {
      addTable();
      readData();
   }
   
   public void addTable()
    {
        table = new JTable();
        dmodel =new DefaultTableModel();
        dmodel.setColumnIdentifiers(headers);
        table.setModel(dmodel);
        table.setRowHeight(30);
        table.setBackground(Color.CYAN);
        table.setFont(new Font("Arial", Font.BOLD, 15));

        JScrollPane scrollPane=new JScrollPane(table);
        scrollPane.setBounds(20, 70, 550, 165);
        deleteFrame.add(scrollPane);
    }

    private void readData()
    {
      try {
         File read=new File("C:\\Users\\Adib Afsar Khan\\Documents\\Aiub\\language\\Java\\Project\\Bank-Management-System-main\\Admin panel\\store.txt");
         Scanner scanner=new Scanner(read);
         while(scanner.hasNext())
         {
             String Accountno=scanner.nextLine();
             int a=Accountno.indexOf(":");
             String onlyAccountno=Accountno.substring(a+1);
             String name=scanner.nextLine();
             int colonIndex = name.indexOf(":"); 
             String onlyName = name.substring(colonIndex + 1);
             String passcode=scanner.nextLine();
             int start=passcode.indexOf(":");
             String onlyPass=passcode.substring(start+1);
             String balance=scanner.nextLine();
             int c=balance.indexOf(":");
             String onlyBalance=balance.substring(c+1); 
             column=new String[4];
             column[0]=onlyAccountno;
             column[1]=onlyName ;
             column[2]=onlyPass;
             column[3]=onlyBalance;
             dmodel.addRow(column);
         }
     } catch (IOException ioe) {
         System.out.println("Error");
        
     }
    }
private void saveUpdatedDataToFile() {
       try(FileWriter writer=new FileWriter("C:\\Users\\Adib Afsar Khan\\Documents\\Aiub\\language\\Java\\Project\\Bank-Management-System-main\\Admin panel\\store.txt"))
       {
        for(int row=0;row<dmodel.getRowCount();row++)
        {
            writer.write("Account no:"+dmodel.getValueAt(row,0)+"\n");
            writer.write("Name:" + dmodel.getValueAt(row,1)+"\n");
            writer.write("PIN:"+ dmodel.getValueAt(row,2)+"\n");
            writer.write("Balance:" + dmodel.getValueAt(row,3)+"\n");
            
        }
    }
       catch(IOException ioe)
       {
        ioe.printStackTrace();
       }
        }
    public void searchUser() {
        String searchText = searchField.getText().toLowerCase();
        boolean found=false;
        if(searchText.isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Search cannot be empty",null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        for (int row = 0; row < dmodel.getRowCount(); row++) {
            String acc=dmodel.getValueAt(row,0).toString();
            String name=dmodel.getValueAt(row,1).toString().toLowerCase();
            if (name.contains(searchText)||acc.equals(searchText)) {
                dmodel.removeRow(row);
                saveUpdatedDataToFile(); 
                JOptionPane.showMessageDialog(null,"User removed Successfully");
                found=true;
                break;  
            }
        }
            if(found==false)
            {
                JOptionPane.showMessageDialog(null,"Not found", null,JOptionPane.INFORMATION_MESSAGE);
            }
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==deButton)
       {
          int rownum=table.getSelectedRow();
          if(rownum==-1)
          {
            JOptionPane.showMessageDialog(null,"Invalid row", null,JOptionPane.ERROR_MESSAGE);
          }
          else
          {
            dmodel.removeRow(rownum); 
            saveUpdatedDataToFile();
          }
       }
       if(e.getSource()==searchButton)
       {
        searchUser();
       }
       if(e.getSource()==cancelButton)
       {
        new adminpanel();
        deleteFrame.setVisible(false);
       }
    }
}