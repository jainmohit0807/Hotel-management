import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class cancel_booking extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */


	public cancel_booking(String sc1, String t1)
	{
		// TODO Auto-generated constructor stub
		setTitle("Cancel Booking");
		setBounds(100, 100, 302, 146);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAreYouSure = new JLabel("Cancel the booking?");
			lblAreYouSure.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblAreYouSure.setBounds(63, 11, 165, 39);
			contentPanel.add(lblAreYouSure);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Yes");
				okButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						// TODO Auto-generated method stub
						
						String query="delete from status_advance where "+sc1+"=?";
						int flag=0;
						Connection con;
						try
						{
							 con=Info2.con();
							PreparedStatement ps=con.prepareStatement(query);
							ps.setString(1, t1);
							flag=ps.executeUpdate();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						if(flag!=0)
						{
					JOptionPane.showMessageDialog(getParent(), "Booking is cancelled!!");		
						}
						if(flag==0)
						{
							JOptionPane.showMessageDialog(getParent(), "No Booking is found!!");
						}
						dispose();
					}
				});
			}
			{
				JButton cancelButton = new JButton("No");
				cancelButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						dispose();
					}
				});
				dispose();
			}
		}
	}

}
