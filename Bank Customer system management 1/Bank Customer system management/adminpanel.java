import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class adminpanel implements ActionListener
{
    private JFrame adminFrame;
    private JButton updateButton;
    private JButton deleteButton;
    public adminpanel ()
    {
       adminFrame=new JFrame();
       adminFrame.setSize(600,400);
       adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       adminFrame.setLocationRelativeTo(null);
       adminFrame.setVisible(true);
       adminFrame.getContentPane().setBackground(Color.WHITE);
       adminFrame.setLayout(null);

       JLabel label=new JLabel("Admin Panel");
       label.setFont(new Font("Arial", Font.BOLD, 15));
       label.setBounds(200,30,100,50);
       adminFrame.add(label);



       updateButton=new JButton("Search customer");
       updateButton.setBounds(100, 200, 150, 50);
       updateButton.setFocusable(false);
       updateButton.addActionListener(this);
       adminFrame.add(updateButton);

       deleteButton=new JButton("Delete");
       deleteButton.setBounds(340, 200, 150, 50);
       deleteButton.setFocusable(false);
       deleteButton.addActionListener(this);
       adminFrame.add(deleteButton);

       ImageIcon searchIcon=new ImageIcon("10213675.png");
       Image i=searchIcon.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
       ImageIcon i2=new ImageIcon(i);

       ImageIcon deleteIcon=new ImageIcon("885754.png");
       Image d=deleteIcon.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
       ImageIcon d2=new ImageIcon(d);


       JLabel searchLabel=new JLabel(i2);
       searchLabel.setBounds(120,100,100,100);
       adminFrame.add(searchLabel);

       JLabel deleteLabel=new JLabel(d2);
       deleteLabel.setBounds(370,100,100,100);
       adminFrame.add(deleteLabel);

       adminFrame.repaint();
       adminFrame.revalidate();


    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==updateButton)
        {
            adminFrame.dispose();
           new ReadCustomer();
        }
        if(e.getSource()==deleteButton)
        {
            new DeletePage();
            adminFrame.setVisible(false);
        }
    }
}
