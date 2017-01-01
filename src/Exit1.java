import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exit1 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Exit1 dialog = new Exit1();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Exit1() {
		setBounds(100, 100, 339, 311);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("");
			label.setBounds(217, 10, 0, 0);
			contentPanel.add(label);
		}
		
		JLabel lblDoYouReally = new JLabel("EXIT ACCOUNT?");
		lblDoYouReally.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblDoYouReally.setBounds(79, 14, 181, 43);
		contentPanel.add(lblDoYouReally);
		
		JButton btnNewButton = new JButton("Yes");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		btnNewButton.setBounds(43, 205, 98, 27);
		btnNewButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				System.exit(StaffPage.EXIT_ON_CLOSE);
			}
		});
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("No");
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		btnNewButton_1.setBounds(181, 205, 98, 27);
		btnNewButton_1.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				dispose();
			}
		});
		contentPanel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("exit.png"));
		lblNewLabel.setBounds(110, 54, 126, 127);
		contentPanel.add(lblNewLabel);
		
		Icon ic=new ImageIcon("cry.jpg");
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
