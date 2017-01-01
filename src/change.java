import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class change extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					change frame = new change();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public change() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 705, 429);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterUsername = new JLabel("Enter Username");
		lblEnterUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblEnterUsername.setBounds(129, 86, 166, 28);
		contentPane.add(lblEnterUsername);
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		textField.setBounds(329, 86, 210, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblOldPassword = new JLabel("Old Password");
		lblOldPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblOldPassword.setBounds(129, 136, 166, 28);
		contentPane.add(lblOldPassword);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewPassword.setBounds(129, 185, 166, 28);
		contentPane.add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblConfirmPassword.setBounds(129, 235, 181, 28);
		contentPane.add(lblConfirmPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		passwordField.setBounds(329, 136, 210, 28);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		passwordField_1.setBounds(329, 185, 210, 28);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		passwordField_2.setBounds(329, 235, 210, 28);
		contentPane.add(passwordField_2);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		btnSave.setBounds(200, 303, 116, 36);
		btnSave.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO Auto-generated method stub
				String sc=textField.getText();
				String sc1=passwordField.getText();
				String sc2=passwordField_1.getText();
				String sc3=passwordField_2.getText();
				if(sc.length()==0||sc1.length()==0||sc2.length()==0||sc3.length()==0)
				{
					JOptionPane.showMessageDialog(change.this, "Please fill/select all the fields", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String query="select * from login";
					String name="";
					String pass="";
					Connection con;
					try{
					con=Info2.con();
					PreparedStatement ps=con.prepareStatement(query);
					ResultSet res=ps.executeQuery();
					while(res.next())
					{
						name=res.getString(1);
						pass=res.getString(2);
					}
					if((sc.equals(name))&&(sc1.equals(pass))&&sc2.equals(sc3))
					{
						int flag=0;
						String query1="update login set Password=? where Username='Admin'";
						Connection con1;
						try{
							con1=Info2.con();
							PreparedStatement ps1=con1.prepareStatement(query1);
							ps1.setString(1, sc2);
							flag=ps1.executeUpdate();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						if(flag==1)
						{
							JOptionPane.showMessageDialog(change.this, "Password Changed", "Success", JOptionPane.INFORMATION_MESSAGE);
							reset();
						}
						else
						{
							JOptionPane.showMessageDialog(change.this, "Password not changed", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else if(!sc2.equals(sc3))
					{
						JOptionPane.showMessageDialog(change.this, "Different Passwords","Error",JOptionPane.ERROR_MESSAGE);	
					}
					else
					{
						JOptionPane.showMessageDialog(change.this, "Invalid Username/Password","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
					catch(Exception e)
					{
						e.printStackTrace();
					}
			}
			}
		});
		contentPane.add(btnSave);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		btnReset.setBounds(342, 303, 116, 36);
		btnReset.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				reset();
			}
		});
		contentPane.add(btnReset);
		
		JLabel lblChangePassword = new JLabel("<html><u>Change Password</u></html>");
		lblChangePassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		lblChangePassword.setBounds(240, 22, 181, 28);
		contentPane.add(lblChangePassword);
	}
	void reset()
	{
		textField.setText(null);
		passwordField.setText(null);
		passwordField_1.setText(null);
		passwordField_2.setText(null);
	}
}
