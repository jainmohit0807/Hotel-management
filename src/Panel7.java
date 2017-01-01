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


public class Panel7 extends JPanel 
{
	private JTextField textField_1;
	JComboBox comboBox;
	JButton btnGetIt;
	/**
	 * Create the panel.
	 */
	public Panel7() 
	{
		
		btnGetIt = new JButton("Delete");
		btnGetIt.setBounds(455, 366, 105, 41);
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
					JOptionPane.showMessageDialog(Panel7.this, "Please fill/select all the fields", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
						cancel_booking obj=new cancel_booking(sc1,t1);
						obj.setVisible(true);
						obj.setLocationRelativeTo(Panel7.this);
						reset();
				}
				
			}
		});
		
		JLabel lblSearchBy = new JLabel("Search By");
		lblSearchBy.setBounds(381, 201, 120, 30);
		lblSearchBy.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		setLayout(null);
		
		String str[]={"Select","Name","CustomerId","Roomno"};
		comboBox = new JComboBox(str);
		comboBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		comboBox.setBounds(589, 200, 195, 32);
		add(comboBox);
		add(btnGetIt);
		add(lblSearchBy);
		
		JLabel lblTypeHere = new JLabel("Type Here");
		lblTypeHere.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblTypeHere.setBounds(381, 269, 120, 30);
		add(lblTypeHere);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		textField_1.setBounds(589, 269, 195, 32);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFindBill = new JLabel("<html><u>Cancel Booking</u></html>");
		lblFindBill.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		lblFindBill.setBounds(467, 35, 228, 91);
		add(lblFindBill);
		
		JButton btnNewButton = new JButton("RESET");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		btnNewButton.setBounds(600, 366, 105, 41);
		add(btnNewButton);
		
		String book[]={"Select","Current","Advance"};
		
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
		textField_1.setText(null);
		comboBox.setSelectedIndex(0);
	}
}
