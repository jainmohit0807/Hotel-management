import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1221, 750);
		setLocationRelativeTo(this);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMohitJain = new JLabel("Welcome To Hotel Management");
		lblMohitJain.setBounds(461, 22, 472, 48);
		lblMohitJain.setForeground(Color.BLACK);
		lblMohitJain.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblMohitJain.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(lblMohitJain);
		
		JLabel lblEnterName = new JLabel("Enter Username");
		lblEnterName.setBackground(new Color(128, 128, 128));
		lblEnterName.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblEnterName.setBounds(147, 531, 157, 35);
		contentPane.add(lblEnterName);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		textField.setBounds(328, 531, 263, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterPassword = new JLabel("Enter password");
		lblEnterPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblEnterPassword.setBounds(147, 593, 173, 35);
		contentPane.add(lblEnterPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		btnLogin.setBounds(662, 529, 173, 39);
		contentPane.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		passwordField.setBounds(328, 593, 263, 39);
		contentPane.add(passwordField);
		
		btnLogin.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				String str1=textField.getText();
				String str3=passwordField.getText();
				if(str1.length()==0)
				{
					JOptionPane.showMessageDialog(LoginPage.this, "Enter the name","Error",JOptionPane.ERROR_MESSAGE);
				}
				else if(str3.length()==0)
				{
					JOptionPane.showMessageDialog(LoginPage.this, "Enter the password","Error",JOptionPane.ERROR_MESSAGE);
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
					if((str1.equals(name))&&(str3.equals(pass)))
					{
						StaffPage tb=new StaffPage();
						tb.panel(tb);
						tb.setVisible(true);
						tb.setResizable(false);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(LoginPage.this, "Invalid Username/Password","Error",JOptionPane.ERROR_MESSAGE);
					}
					
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Hotels.jpg"));
		lblNewLabel.setBounds(287, 77, 664, 429);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		btnNewButton.setBounds(862, 529, 173, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Change password");
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		btnNewButton_1.setBounds(753, 592, 199, 40);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				change obj1=new change();
				obj1.setVisible(true);
			}
		});
		
		
		btnNewButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				textField.setText(null);
				passwordField.setText(null);
			}
		});
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblMohitJain, lblEnterName, textField, lblEnterPassword, passwordField, btnLogin, lblNewLabel}));
		
	}
}
