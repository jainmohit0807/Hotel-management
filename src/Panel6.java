import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JSeparator;

public class Panel6 extends JPanel 
{
	private JTextField textField_1;
	JComboBox comboBox;
	JButton btnGetIt;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public Panel6() 
	{
		
		btnGetIt = new JButton("Get It");
		btnGetIt.setBounds(460, 326, 105, 41);
		btnGetIt.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		btnGetIt.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				String t1=textField_1.getText();
				String c1=(String)comboBox.getSelectedItem();
				if(t1.length()==0 || c1.equalsIgnoreCase("Select"))
				{
					JOptionPane.showMessageDialog(Panel6.this, "Please fill/select all the fields", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String query="select * from booking where "+c1+"=?";
					int flag=0;
					Connection con;
					Vector<String> header=new Vector<>();
					Vector<Vector<String>> outer=new Vector<>();
					try
					{
						 con=Info2.con();
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1, t1);
						ResultSet res=ps.executeQuery();
						ResultSetMetaData rsmd=res.getMetaData();
						int colcount=rsmd.getColumnCount();
						for(int i=1;i<=colcount-4;i++)
						{
							String colName=rsmd.getColumnName(i);
						   header.add(colName);
						}
						
						//getting table records
						while(res.next())
						{
							Vector<String> records=new Vector<>();
							for(int i=1;i<=colcount-4;i++)
							{
								String v=res.getString(i);
								records.add(v);
							}
							outer.add(records);
						}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					
					table_1 = new JTable(outer,header);
					table_1.setBounds(50, 456, 1150, 179);
					table_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
					table_1.setRowHeight(32);
					table_1.setEnabled(false);
					add(table_1);
					JScrollPane pane=new JScrollPane(table_1);
					pane.setBounds(50, 456, 1100, 179);
					add(pane);
				}
				
			}
		});
		
		JLabel lblSearchBy = new JLabel("Search By");
		lblSearchBy.setBounds(381, 200, 120, 30);
		lblSearchBy.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		setLayout(null);
		
		String str[]={"Select","Name","CustomerId"};
		comboBox = new JComboBox(str);
		comboBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		comboBox.setBounds(589, 198, 195, 32);
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
		
		JLabel lblFindBill = new JLabel("<html><u>Search</u></html>");
		lblFindBill.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		lblFindBill.setBounds(483, 35, 139, 91);
		add(lblFindBill);
		
		JButton btnNewButton = new JButton("RESET");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		btnNewButton.setBounds(604, 326, 105, 41);
		add(btnNewButton);
		
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
		table_1.setVisible(false);
	}
}
