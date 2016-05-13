import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.*;
import sun.misc.*;
import javax.crypto.spec.*;

public class ModifiyVoterDetails extends NewRegistration
{
private long vid;
public ModifiyVoterDetails(long id)
	{
	super();
	vid=id;
	remove(lpass);remove(lpass1);remove(tpass);remove(tpass1);
	try{
	
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
					if(!con.isClosed()){ System.out.println("Connection Successful"); }
					else{ System.out.println("Connection is Closed"); }
					
					String sql ="select * from voterInfo where vid="+vid;
    				PreparedStatement preStatement = con.prepareStatement(sql);
				
					ResultSet result = preStatement.executeQuery();
					RegGetSet args=new RegGetSet(phno,email);
				  
								while(result.next()){
									aname=result.getString("vname");
									aemail=result.getString("vemailid");
									aadd=result.getString("vaddress");
									acons=result.getInt("cons_id");
									auid=result.getLong("vid");
									aphno=result.getLong("vphno");;
									System.out.println("Current Data from Oracle : " +   aname+" "+aemail +" "+aadd +"  "+acons+" "+auid+" "+aphno    );
								}
					System.out.println("\n\nAfter inserted record\n\n");			
					args.setname1(aname);args.setemail1(aemail);args.setphno1(aphno);args.setuid1(auid);args.setadd1(aadd);args.setcons1(acons);

					System.out.println("\n\nfetching value from database using get and set method \n\n"+args.getname1()+" "+args.getemail1()+ " "+args.getphno1()+" "+args.getuid1()+" "+args.getadd1()+" "+args.getcons1() );
			 
					tname.setText(aname);
					temail.setText(aemail);
				 tphno.setText(String.valueOf(aphno)); 
				tuid.setText(String.valueOf(auid));
				 taddress.setText(aadd); 
				 //tpass.setText(apass);
				 //tpass1.getText();
				 tconsid.setText(String.valueOf(acons));
				 
					
					}
					catch(Exception e2) { e2.printStackTrace(); }
					
	}

public void actionPerformed(ActionEvent e)  
	{
	
		if(e.getSource()==bsubmit)
		{
				 name=tname.getText();
				 email=temail.getText();
				 try{  phno=Long.parseLong(tphno.getText()); uid=Long.parseLong(tuid.getText()); }
				 catch(NumberFormatException nf) { lerr1.setText("Enter valid number"); }
				 add=taddress.getText(); 
				 cons=Integer.parseInt(tconsid.getText());
				 RegGetSet rgs=new RegGetSet(phno,email);
				 rgs.setname1(name);
				 System.out.println("name from get set "+rgs.getname1());
				 rgs.setname1(name); rgs.setemail1(email); rgs.setphno1(phno); rgs.setuid1(uid); rgs.setadd1(add); 
					rgs.setcons1(cons);
		 
					 
					 
					 System.out.println("\n\n Information before entering into database throgh get and set "+rgs.getname1()+" "+rgs.getemail1()+ " "+rgs.getphno1()+" "+rgs.getuid1()+" "+rgs.getadd1()+" "+rgs.getcons1() );
					 
						 System.out.println("ph no is="+rgs.getphno1()); long p1=rgs.getphno1(); System.out.println("ph no is long="+p1);
						int i1=rgs.numdigits(p1);System.out.println("Mobile no digit is"+i1);String s1=rgs.getemail1();
						System.out.println("get mail iss"+s1);boolean b1=rgs.authenticateemail1();System.out.println("email l"+b1);
							
			if(rgs.authenticatephno1(i1) && rgs.authenticateemail1())
				{
		 
					try
					{
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
					if(!con.isClosed()){ System.out.println("Connection Successful"); }
					else{ System.out.println("Connection is Closed"); }
					
					PreparedStatement ps = con.prepareStatement("insert into modifyvoterInfo (vname, vemailid, vphno, vid,vaddress,cons_id) values ( ?, ?, ?,?,?,?)");
					
					//--setting all values in database
					ps.setString(1,name);ps.setString(2,email);ps.setLong(3,phno);ps.setLong(4,uid);ps.setString(5,add);ps.setInt(6,cons);

					int i=ps.executeUpdate();  
					System.out.println(i+" records affected");  
					//--getting value from database
					String sql ="select * from modifyvoterInfo where vid="+uid;
    				PreparedStatement preStatement = con.prepareStatement(sql);
				
					ResultSet result = preStatement.executeQuery();
					RegGetSet args=new RegGetSet(phno,email);
				  
								while(result.next()){
									aname=result.getString("vname");
									aemail=result.getString("vemailid");
									aadd=result.getString("vaddress");
									acons=result.getInt("cons_id");
									auid=result.getLong("vid");
									aphno=result.getLong("vphno");;
									System.out.println("Current Data from Oracle : " +   aname+" "+aemail +" "+aadd +"  "+acons+" "+auid+" "+aphno    );
								}
					System.out.println("\n\nAfter inserted record\n\n");			
					args.setname1(aname);args.setemail1(aemail);args.setphno1(aphno);args.setuid1(auid);args.setadd1(aadd);args.setcons1(acons);

					System.out.println("\n\nfetching value from database using get and set method \n\n"+args.getname1()+" "+args.getemail1()+ " "+args.getphno1()+" "+args.getuid1()+" "+args.getadd1()+" "+args.getcons1() );
			 
						
					}
					catch(Exception e2) { e2.printStackTrace(); }
						
	
				}
			else 
			{System.out.println("Please enter valid info");}
			
			}
		
		
	}
	


public static void main(String []args)
{
ModifiyVoterDetails md=new ModifiyVoterDetails(100L);

}

}
