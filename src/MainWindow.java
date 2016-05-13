import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import java.awt.Canvas;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements Runnable {

	private JPanel contentPane;
	private String banner;
	private JLabel ticker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MainWindow frame = new MainWindow();
		
	}
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					/*banner="Vote for a better India. Vote for your better future";
					 
           char ch; 
               while(true) 
                { 
                     
                     Thread.sleep(150); 
                     ch=banner.charAt(0); 
                     banner = banner.substring(1,banner.length()); 
                     banner +=ch; 
					 ticker=new JLabel(banner);
					 frame.add(ticker);
					 ticker.setBounds(0,0,1200,20);
                      
                } */
           } 
					//frame.setVisible(true);
				 catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit tk=Toolkit.getDefaultToolkit();
		int xsize=(int)tk.getScreenSize().getWidth();
		int ysize=(int)tk.getScreenSize().getHeight();
	System.out.println(xsize+"and"+ysize);
		setSize(xsize,ysize);
		setResizable(false);
		
		//setBounds(0,0 , 1300, 780); to remove this
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Panel panel = new Panel();
		//panel.setBounds(10, 20, 764, 74);
		//contentPane.add(panel);
		
	/*	JLabel lblVotingSystem = new JLabel("                                                                   Voting System                                                   ");
		lblVotingSystem.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblVotingSystem);
		
		//Panel panel_1 = new Panel();
		//panel_1.setBounds(10, 112, 764, 24);
	//	contentPane.add(panel_1);*/
		ImageIcon banner=new ImageIcon("icons//banner.gif");
		JLabel im = new JLabel(banner);
		
		im.setBounds(20,20,764,135);
		contentPane.add(im);
		im.setVisible(true);
		
		//--registration..login..election detail...admin login..candidate..help.....
		ImageIcon rg=new ImageIcon("icons//New-Registration-icon.png");
		JButton b_newregistration = new JButton("",rg); //---registration
		b_newregistration.setBounds(150,150,256,256);
		contentPane.add(b_newregistration);
		
			b_newregistration.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("registration Clicked");
				NewRegistration nr=new NewRegistration();
				
			}
		});
	
		
		ImageIcon lg=new ImageIcon("icons//Login-icon.png");
		JButton b_login = new JButton("",lg);  //---login
		b_login.setBounds(550,150,256,256);
		contentPane.add(b_login);
		b_login.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("Login Clicked");
				LoginWindow log=new LoginWindow();
				
			}
		});
		
		
		ImageIcon alg=new ImageIcon("icons//admin-login.png");
		JButton b_admin_login = new JButton("",alg); //---admin login
		b_admin_login.setBounds(150,450,256,256);
		contentPane.add(b_admin_login);
		
		b_admin_login.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("admin login Clicked");
				AdminLogin ad=new AdminLogin();	
			}
		});
		
		ImageIcon eld=new ImageIcon("icons//Election-icon.png");
		JButton b_election = new JButton("",eld);
		b_election.setBounds(950, 150,256,256); //--- election detail
		contentPane.add(b_election);
		
		b_election.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("election detail Clicked");
				NewRegistration ed=new NewRegistration();
				
			}
		});
		
		ImageIcon cad=new ImageIcon("icons//Candidate-icon.png");
		JButton b_candidate = new JButton("",cad);
		b_candidate.setBounds(550,450,256,256); //---candidate 
		contentPane.add(b_candidate); 
		
		b_candidate.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("candidate Clicked");
				NewRegistration cd=new NewRegistration();
				
			}
		});
		
		ImageIcon hp=new ImageIcon("icons//help-icon.png");
		JButton b_help = new JButton("",hp);  //---help
		b_help.setBounds(950,450,256,256);
		contentPane.add(b_help);
		
		
		b_help.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("help Clicked");
					Help frame1 = new Help();
			
			}
		});
	}
}
