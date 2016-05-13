import java.sql.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.*;

public class LoginWindow extends JDialog implements ActionListener{
String pass;
long id;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginWindow dialog = new LoginWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginWindow() {
		setBounds(100, 100, 600, 600);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 228);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("User-Id\r\n");
		lblNewLabel.setBounds(70, 88, 60, 14);
		contentPanel.add(lblNewLabel);
	
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(70, 135, 60, 14);
		contentPanel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(184, 85, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(184, 132, 86, 20);
		contentPanel.add(passwordField);
		
		 btnLogin = new JButton("Login");
		btnLogin.setBounds(194, 194, 89, 23);
		contentPanel.add(btnLogin);
		
		
		
	btnLogin.addActionListener(this);
		 
		 
    }
	

	public void actionPerformed(ActionEvent e12)  
	{
		if(e12.getSource()==btnLogin)
		{
		
		
		LoginD ld=new LoginD();
		id=Long.parseLong(textField.getText());
		pass=passwordField.getText();
		if(ld.validate(id,pass))
		{
		VoterScreen vs=new VoterScreen();
		}
		else{
		System.out.println("enter valid info");
		
		}
		
		
		}
		
		
		}
	
	
	
}



class LoginD
{
String aname;
long auid;
boolean st=false;
public boolean validate(long id,String pass)
{


		try
					{
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","riddhi123soni");  
					if(!con.isClosed()){ System.out.println("Connection Successful"); }
					else{ System.out.println("Connection is Closed"); }
					
					PreparedStatement ps = con.prepareStatement("select * from voterinfo where vid=?");
					ps.setLong(1,id);
					//ps.setString(2,pass);
					ResultSet rs=ps.executeQuery();
					//st=rs.next();
					while(rs.next())
					{
						
									auid=rs.getLong("vid");
									aname=rs.getString("vpassword");
									
									System.out.println("Current Data from Oracle : " +auid +" "+aname );
								
			
					
					}
					
			st=pass.equals(aname);		
			}
			catch(Exception e)
			{}
			
			return st;
			
}
/*
public static void main(String []args)
{
LoginD l=new LoginD();
String giv=new String("Riddhi");
Boolean b2=l.validate(1234L,giv);
System.out.println("sds"+b2);
}*/
}