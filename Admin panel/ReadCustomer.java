import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.*;
 class ReadCustomer implements ActionListener {
    private JFrame readFrame=new JFrame();
    public String[] columns={"Name","password","Balance"};
    private  String[]row;
    public  DefaultTableModel model;
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
        readFrame.setLocation(400,200);
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
        model.setColumnIdentifiers(columns);
        table.setModel(model);
       // table.setBackground(Color.CYAN);
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
            String name=scanner.nextLine();
            int colonIndex = name.indexOf(":"); 
            String onlyName = name.substring(colonIndex + 1);
            String passcode=scanner.nextLine();
            int start=passcode.indexOf(":");
            String onlyPass=passcode.substring(start+1);
            String balance=scanner.nextLine();
            int c=balance.indexOf(":");
            String onlyBalance=balance.substring(c+1);  
            row=new String[3];
            row[0]=onlyName;
            row[1]=onlyPass;
            row[2]=onlyBalance;
            model.addRow(row);
        }
    } catch (IOException ioe) {
        System.out.println("Error");
       
    }
}

private void searchUser()
    {
      String name =searchField.getText().toLowerCase();
      DefaultTableModel tempModel = new DefaultTableModel();
      tempModel.setColumnIdentifiers(columns);
        File read=new File("store.txt");
        if(name.isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Name cannot be empty",null, JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            for(int row=0;row<model.getRowCount();row++)
            {
                String data=model.getValueAt(row, 0).toString().toLowerCase();
                if(data.contains( name))
                {
                    String[] tempRow = {model.getValueAt(row, 0).toString(), model.getValueAt(row, 1).toString(),model.getValueAt(row,2).toString()};
                    tempModel.addRow(tempRow);
                }
            }
            table.setModel(tempModel);
            if (tempModel.getRowCount() == 0) {
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





