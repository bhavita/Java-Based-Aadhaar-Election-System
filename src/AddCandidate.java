import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;



public class AddCandidate extends JDialog implements ActionListener {
	String cname,cqal,cdes;
	int conid,cid,pid;
	private final JPanel contentPanel = new JPanel();
	private JTextField tcanName,tconId,tcanAge,tcanQua,tpartyId, tcanPic;
	JButton addCan;
	JLabel label;
	JTextArea textArea;
	JButton browse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddCandidate dialog = new AddCandidate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddCandidate() {
		setAlwaysOnTop(true);
		setBounds(100, 100, 800, 800);
		setVisible(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel canid = new JLabel("Candidate ID");
		 label = new JLabel("New label");
		JLabel canName = new JLabel("Candidate Name ");
		JLabel conId = new JLabel("Constituency ID");
		JLabel canAge = new JLabel("Candidate Age");
		JLabel canQua = new JLabel("Candidate Qualification");
		JLabel partyId = new JLabel("Party ID");
		JLabel canPic = new JLabel("Candidate Picture");
		JLabel canDes = new JLabel("Candidate Description\r\n");
		addCan = new JButton("Add Candidate");

		 textArea = new JTextArea(); 	
		
		tcanName = new JTextField(); 
		tconId = new JTextField();
		tcanAge = new JTextField();
		tcanQua = new JTextField();
		tpartyId = new JTextField();
		tcanPic = new JTextField();
		browse =new JButton("Browse");
		
		canid.setBounds(42, 36, 95, 14);
		label.setBounds(252, 36, 46, 14);
		canName.setBounds(42, 70, 124, 14);
		conId.setBounds(42, 108, 95, 14);
		canAge.setBounds(42, 145, 95, 14);
		canQua.setBounds(42, 180, 165, 14);
		partyId.setBounds(42, 214, 46, 14);
		canPic.setBounds(42, 361, 150, 14);
		browse.setBounds(325,361,85,14);
		canDes.setBounds(42, 256, 175, 14);
		
		tcanName.setBounds(212, 67, 86, 20);
		tconId.setBounds(212, 105, 86, 20);
		tcanAge.setBounds(212, 142, 86, 20);
		tcanQua.setBounds(212, 177, 86, 20);
		tpartyId.setBounds(212, 211, 86, 20);
		tcanPic.setBounds(212, 358, 86, 20);
		addCan.setBounds(165, 429, 133, 23);

	
		textArea.setBounds(212, 256, 86, 63);
		
		tcanName.setColumns(10);
		tconId.setColumns(10);
		tcanAge.setColumns(10);
		tcanQua.setColumns(10);
		tpartyId.setColumns(10);
		tcanPic.setColumns(10);
		
		
		contentPanel.add(canid); contentPanel.add(label); contentPanel.add(canName); contentPanel.add(conId);
		contentPanel.add(canAge); contentPanel.add(canQua); contentPanel.add(partyId); contentPanel.add(canPic);
		contentPanel.add(canDes);
		
		
		contentPanel.add(tcanName); contentPanel.add(tconId); contentPanel.add(tcanAge); contentPanel.add(tcanQua);
		contentPanel.add(tpartyId); contentPanel.add(tcanPic); contentPanel.add(addCan);
		
		contentPanel.add(textArea);
		contentPanel.add(browse);
		
		addCan.addActionListener(this);
			
		}
	public void actionPerformed(ActionEvent e)  
	{
		if(e.getSource()==addCan)
		{
		
				genrateCid hg=new genrateCid();	
				
				 hg.getCid();
				label.setText(String.valueOf(hg.getCid()));
				genrateCid g1=new genrateCid();	
				cid=g1.getCid();
				cname=tcanName.getText();
				conid=Integer.parseInt(tconId.getText());
				cqal=tcanQua.getText();
				pid=Integer.parseInt(tpartyId.getText());
				CanGetSet cg=new CanGetSet();
				cdes=textArea.getText();
				cg.setname1(cname); cg.setcons1(conid); cg.setcqal(cqal); cg.setCanDes(cdes);
				System.out.println("can name is"+cg.getname1()+"id is"+cg.getcons1()+"pid is"+cg.getPartyId()+"cdes id"+cg.getCanDes());
					try
					{
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
					if(!con.isClosed()){ System.out.println("Connection Successful"); }
					else{ System.out.println("Connection is Closed"); }
					
					PreparedStatement ps = con.prepareStatement("insert into candidate (c_id,c_name, cons_id,c_qualification,pid) values (?, ?,?,?,?)");
					ps.setInt(1,cid);ps.setString(2,cname);ps.setInt(3,conid);ps.setString(4,cqal);
					ps.setInt(5,pid);
					int i=ps.executeUpdate();  
					System.out.println(i+" records affected");  
			
					}
					catch(Exception e2) { e2.printStackTrace(); }

			
		}
	}
	

	
	}
	
	

class genrateCid
{  int cid;
genrateCid()
{
cid=30;
}
public int getCid()
{
return ++cid;
}
}