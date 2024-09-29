import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.*;
 class ReadCustomer implements ActionListener {
    private JFrame readFrame=new JFrame();
    public String[] headers={"Account","Name","PIN","Balance"};
    private  String[]column;
    private  DefaultTableModel model;
    private JTextField searchField;
    private JButton searchButton;
    private JButton cancelButton;
    JTable table;
  public  ReadCustomer()
    {
        readCustomer();
        
    }
    public void readCustomer()
    {
        readFrame.setSize(600,400);
        readFrame.setVisible(true);
        readFrame.setLocationRelativeTo(null);
        readFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        readFrame.getContentPane().setBackground(Color.WHITE);
        readFrame.setLayout(null);
        addTable();
        readData();
        searchField=new JTextField();
        searchField.setBounds(190, 250, 170, 50);
        readFrame.add(searchField);
    
        searchButton=new JButton("Search");
        searchButton.setBounds(80, 250, 80, 50);
        searchButton.addActionListener(this);
        searchButton.setFocusable(false);
        readFrame.add(searchButton);

        cancelButton=new JButton("Cancel");
        cancelButton.setBounds(450,250, 100, 50);
        cancelButton.addActionListener(this);
        cancelButton.setFocusable(false);
        readFrame.add(cancelButton);


        readFrame.repaint();
        readFrame.revalidate();
    }
  private void addTable()
    {
       
        table = new JTable();
        model =new DefaultTableModel();
        model.setColumnIdentifiers(headers);
        table.setModel(model);
        table.setRowHeight(30);
        table.setBackground(Color.CYAN);
        table.setFont(new Font("Arial", Font.BOLD, 15));

        JScrollPane scrollPane=new JScrollPane(table);
        scrollPane.setBounds(20, 70, 550, 165);
        readFrame.add(scrollPane);
    }
    private void readData()
    {  try {
        File read=new File("C:\\Users\\Adib Afsar Khan\\Documents\\Aiub\\language\\Java\\Project\\Bank-Management-System-main\\Admin panel\\store.txt");
        Scanner scanner=new Scanner(read);
        while(scanner.hasNext())
        {
            String Accountno=scanner.nextLine();
            int a=Accountno.indexOf(":");
            String onlyAccno=Accountno.substring(a+1);
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
            column[0]=onlyAccno;
            column[1]=onlyName;
            column[2]=onlyPass;
            column[3]=onlyBalance;
            model.addRow(column);
        }
    } catch (IOException ioe) {
        System.out.println("Error");
       
    }
}

private void searchUser()
    {
        String srch=searchField.getText().toString().toLowerCase();
      DefaultTableModel tempModel = new DefaultTableModel();
      tempModel.setColumnIdentifiers(headers);
        if(srch.isEmpty())
        { 
            JOptionPane.showMessageDialog(null,"Search cannot be empty",null, JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            for(int row=0;row<model.getRowCount();row++)
            {
                String dataA=model.getValueAt(row, 0).toString();
                String dataN=model.getValueAt(row, 1).toString().toLowerCase();
                if(dataA.contains(srch)||dataN.contains(srch))
                {
                    String[] tempRow = {model.getValueAt(row, 0).toString(), model.getValueAt(row, 1).toString(),model.getValueAt(row,2).toString(),model.getValueAt(row,3).toString()};
                    tempModel.addRow(tempRow);
                }
            }
            table.setModel(tempModel);
            if (tempModel.getRowCount() == 0) {
                table.setModel(model);
                JOptionPane.showMessageDialog(null, "No results found", null, JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==searchButton)
        {
          searchUser();
        }
        if(e.getSource()==cancelButton)
        {
            new adminpanel();
            readFrame.setVisible(false);
        }
    }
}





