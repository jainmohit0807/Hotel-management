import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.JComboBox;


public class Panel5 extends JPanel 
{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JComboBox comboBox;
	JButton btnGetIt;
	private JTextField textField_3;
	/**
	 * Create the panel.
	 */
	public Panel5() 
	{
		
		JLabel lblRemainingBill = new JLabel("Remaining Bill");
		lblRemainingBill.setBounds(381, 381, 149, 30);
		lblRemainingBill.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		textField.setBounds(589, 380, 195, 32);
		textField.setColumns(10);
		textField.setEditable(false);
		
		btnGetIt = new JButton("Get It");
		btnGetIt.setBounds(460, 251, 105, 41);
		btnGetIt.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		btnGetIt.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				String sc1=(String) comboBox.getSelectedItem();
				String t1=textField_1.getText();
				if(sc1.equalsIgnoreCase("Select")||t1.length()==0)
				{
					JOptionPane.showMessageDialog(Panel5.this, "Please fill/select all the fields", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
						String query="select Total,Due from booking where "+sc1+"=?";
						int flag=0;
						Connection con;
						try
						{
							 con=Info2.con();
							PreparedStatement ps=con.prepareStatement(query);
							ps.setString(1, t1);
							ResultSet res=ps.executeQuery();
							while(res.next())
							{
								flag=1;
								textField.setText(res.getString(2));
								textField_2.setText(res.getString(1));
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						if(flag==0)
						{
							JOptionPane.showMessageDialog(getParent(), "No Bill Found!", "Error", JOptionPane.ERROR_MESSAGE);
						}
				}
				
			}
		});
		
		JLabel lblSearchBy = new JLabel("Search By");
		lblSearchBy.setBounds(381, 135, 120, 30);
		lblSearchBy.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		setLayout(null);
		
		String str[]={"Select","Name","CustomerId","Roomno"};
		comboBox = new JComboBox(str);
		comboBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		comboBox.setBounds(589, 134, 195, 32);
		add(comboBox);
		add(btnGetIt);
		add(lblSearchBy);
		add(lblRemainingBill);
		add(textField);
		
		JLabel lblTypeHere = new JLabel("Type Here");
		lblTypeHere.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblTypeHere.setBounds(381, 195, 120, 30);
		add(lblTypeHere);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		textField_1.setBounds(589, 194, 195, 32);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFindBill = new JLabel("<html><u>Find Bill</u></html>");
		lblFindBill.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		lblFindBill.setBounds(483, 35, 139, 91);
		add(lblFindBill);
		
		JLabel lblTotalBill = new JLabel("Total Bill");
		lblTotalBill.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblTotalBill.setBounds(381, 325, 120, 30);
		add(lblTotalBill);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		textField_2.setBounds(589, 325, 195, 30);
		add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEditable(false);
		
		JButton btnNewButton = new JButton("RESET");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		btnNewButton.setBounds(589, 251, 105, 41);
		add(btnNewButton);
		
		JLabel lblPayrs = new JLabel("Pay Money(Rs)");
		lblPayrs.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblPayrs.setBounds(381, 440, 139, 30);
		lblPayrs.setVisible(true);
		add(lblPayrs);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		textField_3.setBounds(589, 438, 195, 32);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Ok");
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		btnNewButton_1.setBounds(506, 502, 105, 41);
		btnNewButton_1.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				String t1=textField_1.getText();
				String sc1=(String) comboBox.getSelectedItem();
				String query="update booking set Due=? where "+sc1+"=?";
				String t2=textField_3.getText();
				String t3=textField.getText();
				int flag=0;
				Connection con;
				if(t1.length()==0||t2.length()==0||t3.length()==0)
				{
					JOptionPane.showMessageDialog(Panel5.this, "Please fill/select all the field", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
				try
				{
					con=Info2.con();
					PreparedStatement ps=con.prepareStatement(query);	
					int a,b,c;
					b=Integer.parseInt(textField_3.getText());
					a=Integer.parseInt(textField.getText());
					c=a-b;
					ps.setString(1, Integer.toString(c));
					ps.setString(2, t1);
					flag=ps.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				if(flag==1)
				{
					JOptionPane.showMessageDialog(Panel5.this, "Booking updated!!", "Success", JOptionPane.INFORMATION_MESSAGE);
					reset();
					textField_3.setText(null);
				}
				else
				{
					JOptionPane.showMessageDialog(Panel5.this, "Booking Not Updated", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				}
			}
		});
		add(btnNewButton_1);
		
		btnNewButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				reset();
			}
		});

		
	}
	
	void reset()
	{
		textField.setText(null);
		textField_1.setText(null);
		textField_2.setText(null);
		comboBox.setSelectedIndex(0);
	}
}
