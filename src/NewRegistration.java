import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.*;
import sun.misc.*;
import javax.crypto.spec.*;

 
public class NewRegistration extends JFrame implements ActionListener
{	String name,email,add,pass,pass1;
	String getpass;
	int cons; long uid,phno;
	String aname,aemail,aadd,apass,apass1;
	String agetpass;
	int acons; long auid,aphno;
    JLabel lname, laddress, lemail,lphno,luid,lpass,lpass1,lconsid;
	JLabel lerr1,lerr2;
    JTextField tname,temail,tphno,tuid,tpass,tpass1,tconsid;
    JButton bsubmit;
    JTextArea taddress;
    NewRegistration()
    {	setAlwaysOnTop(true);
        setTitle("NewRegistration Form in Windows Form");
        setVisible(true);
        setSize(800,800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
        lname = new JLabel("Name:");    lemail = new JLabel("Email:");   lphno = new JLabel("Phone No:");
		luid=new JLabel("UID:");  	laddress=new JLabel("Address:");	lpass=new JLabel("Password");
		lpass1=new JLabel("Conform Password"); 	lconsid=new JLabel("Const id");
		lerr1=new JLabel("");
		lerr2=new JLabel("");
        bsubmit = new JButton("Submit");
		tname = new JTextField();
		taddress=new JTextArea("   ENTER YOUR ADDRESS HERE      ");
		temail=new JTextField();  tphno = new JTextField(); tuid = new JTextField(); tpass = new JPasswordField();
		tpass1 = new JPasswordField(); 	tconsid=new JTextField();
		
        lname.setBounds(100, 70, 200, 30); 
		laddress.setBounds(100, 110, 200, 30);
        lemail.setBounds(100, 200, 200, 30);
		lphno.setBounds(100, 240, 200, 30);
        luid.setBounds(100, 280, 200, 30);
		lpass.setBounds(100,320,200,30);
		lpass1.setBounds(100,360,200,30);
		lconsid.setBounds(100,400,200,30);
		lerr1.setBounds(200,550,200,100);
		lerr1.setBounds(200,600,200,100);
        
        tname.setBounds(400, 70, 200, 30);
        taddress.setBounds(400, 110, 200, 80);
        temail.setBounds(400, 200, 200, 30);
		tphno.setBounds(400, 240, 200, 30);
        tuid.setBounds(400, 280, 200, 30);
		tpass.setBounds(400,320,200,30);
		tpass1.setBounds(400,360,200,30);

		tconsid.setBounds(400,400,200,30);
		
		bsubmit.setBounds(500,500,100,30);
		taddress.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
        add(lname); add(laddress); add(lemail);  add(lphno); add(luid); add(lpass); add(lpass1); add(lconsid);
		add(lerr1);	add(lerr2); add(bsubmit);
		
		add(tname);  add(taddress);  add(temail); add(tphno); add(tuid); add(tconsid); add(tpass); 	add(tpass1);
        add(bsubmit);
	
        bsubmit.addActionListener(this);
		 
		 
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
				 pass=tpass.getText();
				 pass1=tpass1.getText();
				 cons=Integer.parseInt(tconsid.getText());
				 RegGetSet rgs=new RegGetSet(phno,email);
				
				 rgs.setname1(name);
				 System.out.println("name from get set "+rgs.getname1());
				 rgs.setname1(name); rgs.setemail1(email); rgs.setphno1(phno); rgs.setuid1(uid); rgs.setadd1(add); 
				 rgs.setpass1(pass); rgs.setcons1(cons);
		 
					 try{
					  getpass=rgs.setpass2(pass);
					 System.out.println("encrepted pas"+getpass);
					 }
					 catch(Exception r2)
					 {
					 r2.printStackTrace();
					 }System.out.println("\n\n Information before entering into database throgh get and set "+rgs.getname1()+" "+rgs.getemail1()+ " "+rgs.getphno1()+" "+rgs.getuid1()+" "+rgs.getadd1()+" "+rgs.getpass1()+" "+rgs.getcons1() );
					 
						 System.out.println("ph no is="+rgs.getphno1()); long p1=rgs.getphno1(); System.out.println("ph no is long="+p1);
						int i1=rgs.numdigits(p1);System.out.println("Mobile no digit is"+i1);String s1=rgs.getemail1();
						System.out.println("get mail iss"+s1);boolean b1=rgs.authenticateemail1();System.out.println("email l"+b1);
							
			if(rgs.authenticatephno1(i1) && rgs.authenticateemail1() && rgs.checkPass(pass,pass1))
				{
		 
					try
					{
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
					if(!con.isClosed()){ System.out.println("Connection Successful"); }
					else{ System.out.println("Connection is Closed"); }
					
					PreparedStatement ps = con.prepareStatement("insert into voterInfo (vname, vemailid, vphno, vid,vaddress,vpassword,cons_id) values (?, ?, ?, ?,?,?,?)");
					
					//--setting all values in database
					ps.setString(1,name);ps.setString(2,email);ps.setLong(3,phno);ps.setLong(4,uid);ps.setString(5,add);ps.setString(6,getpass);ps.setInt(7,cons);

					int i=ps.executeUpdate();
					
					System.out.println(i+" records affected");  
					//--getting value from database
					String sql ="select * from voterInfo where vid="+uid;
    				PreparedStatement preStatement = con.prepareStatement(sql);
				
					ResultSet result = preStatement.executeQuery();
					RegGetSet args=new RegGetSet(phno,email);
				  
								while(result.next()){
									aname=result.getString("vname");
									aemail=result.getString("vemailid");
									aadd=result.getString("vaddress");
									apass=result.getString("vpassword");
									acons=result.getInt("cons_id");
									auid=result.getLong("vid");
									aphno=result.getLong("vphno");;
									System.out.println("Current Data from Oracle : " +   aname+" "+aemail +" "+aadd +" "+apass+" "+acons+" "+auid+" "+aphno    );
								}
					System.out.println("\n\nAfter inserted record\n\n");			
					args.setname1(aname);args.setemail1(aemail);args.setphno1(aphno);args.setuid1(auid);args.setadd1(aadd);args.setpass1(apass);args.setcons1(acons);

					System.out.println("\n\nfetching value from database using get and set method \n\n"+args.getname1()+" "+args.getemail1()+ " "+args.getphno1()+" "+args.getuid1()+" "+args.getadd1()+" "+args.getpass2(apass)+" "+args.getcons1() );
			 
						
					}
					catch(Exception e2) { e2.printStackTrace(); }
						
	
				}
			else 
			{System.out.println("Please enter valid info");}
		
		
	}
	}
 
    public static void main(String arr[])
    { NewRegistration na=new NewRegistration();}
}

