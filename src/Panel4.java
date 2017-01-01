import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Panel4 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	JComboBox comboBox_3,comboBox_4;
	String a,b,c,d,e;
	/**
	 * Create the panel.
	 */
	public Panel4() {
		setLayout(null);
		
		JLabel lblCheckIn = new JLabel("<html><u>Check IN/OUT</u></html>");
		lblCheckIn.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
		lblCheckIn.setBounds(446, 60, 213, 42);
		add(lblCheckIn);
		
		JLabel lblName = new JLabel("Type Here");
		lblName.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblName.setBounds(368, 260, 114, 28);
		add(lblName);
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		textField.setBounds(556, 260, 171, 28);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblDate = new JLabel("Check IN/OUT");
		lblDate.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblDate.setBounds(368, 316, 155, 28);
		add(lblDate);
		
		JLabel lblSearchBy = new JLabel("Search By");
		lblSearchBy.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblSearchBy.setBounds(368, 197, 114, 28);
		add(lblSearchBy);
		
		String str[]={"Select","Name","CustomerId","Roomno"};
		comboBox_3 = new JComboBox(str);
		comboBox_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		comboBox_3.setBounds(556, 197, 171, 28);
		add(comboBox_3);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		btnOk.setBounds(437, 380, 114, 42);
		btnOk.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO Auto-generated method stub
				String sc=(String)comboBox_4.getSelectedItem();
				String sc1=(String)comboBox_3.getSelectedItem();
				String t=textField.getText();
				int flag=0;
				if(sc.equalsIgnoreCase("Select")||sc1.equalsIgnoreCase("Select")||t.length()==0)
				{
					 JOptionPane.showMessageDialog(Panel4.this, "Please fill/select all the fields", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					if(sc.equalsIgnoreCase("IN"))
					{
						
						String query="select * from status_advance where "+sc1+"=?";
						String query1="insert into status_current values(?,?,?,?,?)";
						String query2="delete from status_advance where "+sc1+"=?";
						Connection con,con1,con2;
						try
						{
							con=Info2.con();
							PreparedStatement ps=con.prepareStatement(query);
							String f;
							ps.setString(1, t);
							ResultSet res=ps.executeQuery();
							while(res.next())
							{
								flag=1;
								a=res.getString(1);
								b=res.getString(2);
								c=res.getString(3);
								d=res.getString(4);
								e=res.getString(5);
							}
							
							con1=Info2.con();
							PreparedStatement ps1=con1.prepareStatement(query1);
							ps1.setString(1, a);
							ps1.setString(2, b);
							ps1.setString(3, c);
							ps1.setString(4, d);
							ps1.setString(5, e);
							ps1.executeUpdate();
							
							con2=Info2.con();
							PreparedStatement ps2=con2.prepareStatement(query2);
							ps2.setString(1, t);
							ps2.executeUpdate();
							
						}
						catch(Exception x)
						{
							x.printStackTrace();
						}
					}
					else
					{
					String query3="delete from status_current where "+sc1+"=?";
					Connection con3;
					try
					{
						con3=Info2.con();
						PreparedStatement ps3=con3.prepareStatement(query3);
						ps3.setString(1, t);
						flag=ps3.executeUpdate();
						
					}
					catch(Exception y)
					{
						y.printStackTrace();
					}
					}
					
					if(flag!=0)
					{
						JOptionPane.showMessageDialog(Panel4.this, "Done", "Added", JOptionPane.INFORMATION_MESSAGE);
						reset();
					}
					if(flag==0)
					{
						JOptionPane.showMessageDialog(Panel4.this, "Booking Not Found", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		add(btnOk);
		
		JButton btnNewButton = new JButton("RESET");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		btnNewButton.setBounds(593, 380, 114, 42);
		btnNewButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				reset();
			}
		});
		add(btnNewButton);
		
		JLabel lblCheck = new JLabel("Check ");
		lblCheck.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblCheck.setBounds(368, 141, 114, 28);
		add(lblCheck);
		
		String option[]={"Select","IN","OUT"};
		comboBox_4 = new JComboBox(option);
		comboBox_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		comboBox_4.setBounds(556, 141, 171, 28);
		add(comboBox_4);
		
		Date d=new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy");
		textField_1 = new JTextField(ft.format(d));
		textField_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		textField_1.setBounds(556, 316, 171, 28);
		add(textField_1);
		textField_1.setEditable(false);
		textField_1.setColumns(10);

	}

	void reset()
	{
		textField.setText(null);
		comboBox_3.setSelectedIndex(0);
		comboBox_4.setSelectedIndex(0);
	}
}
