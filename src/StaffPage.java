import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class StaffPage extends JFrame
{
	JPanel jp,jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8;
	JTabbedPane pn;
	int i=0;
	void panel(StaffPage obj)
	{
		i=0;
		Toolkit t=getToolkit();
		setSize(t.getScreenSize());
		getContentPane().setLayout(new BorderLayout());
		setTitle("Welcome Admin");
		pn=new JTabbedPane();
		pn.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		pn.setTabPlacement(JTabbedPane.LEFT);
		jp=new Panel_home();
		pn.addTab("HOME",new ImageIcon("home-icon.png"),jp );
		jp1=new Panel1();
		pn.addTab("BOOK NOW",new ImageIcon("booking.jpg"),jp1 );
		jp1.setLayout(null);
		jp4=new Panel2(obj);
		pn.addTab("STATUS",new ImageIcon("current.png"),jp4 );
		jp3=new Panel3();
		pn.addTab("<html>ADVANCE<br/>BOOKING</html>",new ImageIcon("earlybooking.jpg"),jp3 );
		jp3.setLayout(null);
		jp5=new Panel4();
		pn.addTab("<html>Check<br/>IN/OUT</html>",new ImageIcon("Checkin.png"),jp5);
		jp2=new Panel5();
		pn.addTab("BILLS",new ImageIcon("icon128-2x.png"),jp2 );
		jp8=new Panel6();
		pn.addTab("SEARCH",new ImageIcon("search-icon.png"),jp8 );
		jp7=new Panel7();
		pn.addTab("CANCEL",new ImageIcon("cancelbook.png"),jp7);
		jp6=new JPanel();
		pn.addTab("LOGOUT",new ImageIcon("logout.png"),jp6);
		pn.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
				if(pn.getSelectedIndex()==8 && e.getButton()==MouseEvent.BUTTON1)
				{
					Exit1 obj=new Exit1();
					obj.setLocationRelativeTo(obj);
					obj.setVisible(true);
				}
			}
		});
		getContentPane().add(pn,BorderLayout.CENTER);
		
	}
	public static void main(String args[])
	{
		StaffPage tb=new StaffPage();
		tb.panel(tb);
		tb.setVisible(true);
		tb.setResizable(false);
		
	}
}