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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;





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
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
					if(!con.isClosed()){ System.out.println("Connection Successful");

					String sql ="select * from voterinfo where vid="+id;
    				PreparedStatement preStatement = con.prepareStatement(sql);
				
					ResultSet rs = preStatement.executeQuery();
					 System.out.println("res Successful");
						while(rs.next())
						{
										System.out.println("in res");
										auid=rs.getLong("vid");
										String x=rs.getString("vpassword");
										aname=AESencrp.decrypt(x);
										
										System.out.println("Current Data from Oracle : " +auid +" "+aname );
									
				
						
						}
					
			st=pass.equals(aname);



					}
					else{ System.out.println("Connection is Closed"); }
					
							
			}
			catch(Exception e)
			{
				 System.out.println("exception");
			}
			
			return st;
			
}
}