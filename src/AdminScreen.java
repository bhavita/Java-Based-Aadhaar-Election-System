import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;


public class AdminScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminScreen frame = new AdminScreen();
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
	public AdminScreen() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Toolkit tk=Toolkit.getDefaultToolkit();
		int xsize=(int)tk.getScreenSize().getWidth();
		int ysize=(int)tk.getScreenSize().getHeight();
	System.out.println(xsize+"and"+ysize);
		setSize(xsize,ysize);
		setAlwaysOnTop(true);
		setResizable(false);
		
		setVisible(true);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton add_candidate = new JButton(new ImageIcon("icons//Add-Candidate-icon.png"));
		add_candidate.setBounds(350,150,256,256);
		contentPane.add(add_candidate);
		
		add_candidate.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("add candidate Clicked");
				AddCandidate cd=new AddCandidate();
				
			}
		});
		
		
		JButton election_result = new JButton(new ImageIcon("icons//Election-icon.png"));
		election_result.setBounds(350,450,256,256);
		contentPane.add(election_result);
		
		
		election_result.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("election detail Clicked");
				NewRegistration cd=new NewRegistration();
				
			}
		});
		
		
		JButton voting_details = new JButton("Voting-Details");
		voting_details.setBounds(750,450,256,256);
		contentPane.add(voting_details);
		voting_details.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("voting detail Clicked");
				NewRegistration cd=new NewRegistration();
				
			}
		});
		
		
		JButton modify_candidetails = new JButton(new ImageIcon("icons//Modify-Candidate-icon.png"));
		modify_candidetails.setBounds(750, 150,256,256);
		contentPane.add(modify_candidetails);
		
		modify_candidetails.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("candidate Clicked");
				NewRegistration cd=new NewRegistration();
				
			}
		});
		
	}
}
