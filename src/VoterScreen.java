import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.*;


public class VoterScreen extends JFrame implements ActionListener {
	private long vid;
	private JPanel contentPane;
	private JButton bModifyVoterD;
	private JButton bCandidateD;
	private JButton bCastVote;
	private JButton bhelp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VoterScreen frame = new VoterScreen(100L);
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
	public VoterScreen(long id) {
		vid=id;
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 55);
		contentPane.add(panel);
		
		JTextArea txtrWelcomeToVoting = new JTextArea();
		txtrWelcomeToVoting.setEnabled(false);
		txtrWelcomeToVoting.setEditable(false);
		txtrWelcomeToVoting.setText("          Welcome to Voting System");
		txtrWelcomeToVoting.setBounds(10, 77, 414, 22);
		contentPane.add(txtrWelcomeToVoting);
		
		bModifyVoterD = new JButton(new ImageIcon("icons//Modify-Voter-icon.png"));
		bModifyVoterD.setBounds(350,150,256,256);
		contentPane.add(bModifyVoterD);
		
		bCandidateD = new JButton(new ImageIcon("icons//Candidate-icon.png"));
		bCandidateD.setBounds(750,150,256,256);
		contentPane.add(bCandidateD);
		
		bCastVote = new JButton(new ImageIcon("icons//Cast-Vote-icon.png"));
		bCastVote.setBounds(350,450,256,256);
		contentPane.add(bCastVote);
		
		bhelp = new JButton(new ImageIcon("icons//help-icon.png"));
		bhelp.setBounds(750,450,256,256);
		contentPane.add(bhelp);
		
		bModifyVoterD.addActionListener(this);
		 
		 
    }
	

	public void actionPerformed(ActionEvent e)  
	{
		if(e.getSource()==bModifyVoterD)
		{
		ModifiyVoterDetails mvd=new ModifiyVoterDetails(vid);
	}
}

}
