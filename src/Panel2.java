import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;

public class Panel2 extends JPanel {
	private JTable table_1;
	private JTable table_2;
	/**
	 * Create the panel.
	 */
	
	public Panel2(StaffPage obj) 
	{
		// TODO Auto-generated constructor stub
		setLayout(null);
		
		Vector<String> header=new Vector<>();
		Vector<Vector<String>> outer=new Vector<>();
		String query="select * from status_current"; 
		Connection con;
		try
		{
			con=Info2.con();
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			ResultSetMetaData rsmd=res.getMetaData();
			int colcount=rsmd.getColumnCount();
			for(int i=1;i<=colcount;i++)
			{
				String colName=rsmd.getColumnName(i);
			   header.add(colName);
			}
			
			//getting table records
			while(res.next())
			{
				Vector<String> records=new Vector<>();
				for(int i=1;i<=colcount;i++)
				{
					String v=res.getString(i);
					records.add(v);
				}
				outer.add(records);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		table_1 = new JTable(outer,header);
		table_1.setBounds(50, 101, 1100, 248);
		table_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		table_1.setRowHeight(32);
		table_1.setEnabled(false);
		add(table_1);
		JScrollPane pane=new JScrollPane(table_1);
		pane.setBounds(50, 101, 1100, 248);
		add(pane);
		
		Vector<String> header1=new Vector<>();
		Vector<Vector<String>> outer1=new Vector<>();
		String query1="select * from status_advance"; 
		Connection con1;
		try
		{
			con1=Info2.con();
			PreparedStatement ps1=con1.prepareStatement(query1);
			ResultSet res1=ps1.executeQuery();
			ResultSetMetaData rsmd1=res1.getMetaData();
			int colcount1=rsmd1.getColumnCount();
			for(int i1=1;i1<=colcount1;i1++)
			{
				String colName1=rsmd1.getColumnName(i1);
			   header1.add(colName1);
			}
			
			//getting table records
			while(res1.next())
			{
				Vector<String> records1=new Vector<>();
				for(int i1=1;i1<=colcount1;i1++)
				{
					String v1=res1.getString(i1);
					records1.add(v1);
				}
				outer1.add(records1);
			}
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}

		
		table_2 = new JTable(outer1,header1);
		table_2.setBounds(50, 456, 1100, 248);
		table_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		table_2.setRowHeight(32);
		table_2.setEnabled(false);
		add(table_2);
		JScrollPane pane1=new JScrollPane(table_2);
		pane1.setBounds(50, 456, 1100, 248);
		add(pane1);
		
		JLabel lblNewLabel = new JLabel("<html><u>Current Status</u></html>");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		lblNewLabel.setBounds(451, 36, 191, 31);
		add(lblNewLabel);
		
		JLabel lbladvanceStatus = new JLabel("<html><u>Advance Status</u></html>");
		lbladvanceStatus.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		lbladvanceStatus.setBounds(451, 377, 191, 31);
		add(lbladvanceStatus);
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		btnNewButton.setBounds(1022, 38, 115, 31);
		btnNewButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				obj.setVisible(false);
				StaffPage x=new StaffPage();
				x.panel(x);
				x.pn.setSelectedIndex(2);
				x.setVisible(true);
				x.setResizable(false);
			}
		});
		add(btnNewButton);
	}
	
}
