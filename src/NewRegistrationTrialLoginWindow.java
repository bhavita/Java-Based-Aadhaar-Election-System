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

 
public class NewRegistrationTrialLoginWindow.java extends JDialog {
 
    private JTextField tfUsername;
    private JTextField tfOTP;
    private JLabel lbUsername;
    private JLabel lbOTP;
	private JLabel OTPSendInfo;
    private JButton btnNewRegistration;
    private JButton btnCancel;
    private boolean succeeded;
 
    public NewRegistrationTrialLoginWindow() {
		setVisible(true);
		setAlwaysOnTop(true);
        setBounds(100, 100, 600, 600);
		
        JPanel panel = new JPanel();
        
        lbUsername = new JLabel("Username: ");
        panel.add(lbUsername);
		
        tfUsername = new JTextField(20);
        panel.add(tfUsername);
 
        lbOTP = new JLabel("OTP: ");
        panel.add(lbOTP);
		lbOTP.setVisible(false);
        tfOTP = new JTextField(20);
        panel.add(tfOTP);
		
		tfOTP.setVisible(false);
        
        btnNewRegistration = new JButton("NewRegistrationTrialLoginWindow");
 
        btnNewRegistration.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
			lbOTP.setVisible(false);
			tfOTP.setVisible(true);
			InsertOTP o=new InsertOTP(getUsername());
			o.insert();
			String email=sendEmail(getUsername());
			OTPSendInfo=new JLabel("The email has been send to "+email);
			add(OTPSendInfo);
			
			//receive OTP from db from server
			int dbOtp=receiveOtp(getUsername());
			
				
                if (dbOtp==Integer.parseInt(getOtp())) {
                    JOptionPane.showMessageDialog(NewRegistrationTrialLoginWindow.java.this,
                            "Hi " + getUsername() + "! You have successfully registered in.",
                            "NewRegistrationTrialLoginWindow.java",
                            JOptionPane.INFORMATION_MESSAGE);
                    succeeded = true;
                    dispose();
					VoterScreen vs=new VoterScreen(getUsername());
                } else {
                    JOptionPane.showMessageDialog(NewRegistrationTrialLoginWindow.java.this,
                            "Invalid username or OTP",
                            "NewRegistrationTrialLoginWindow.java",
                            JOptionPane.ERROR_MESSAGE);
                    // reset username and password
                    tfUsername.setText("");
                    pfPassword.setText("");
                    succeeded = false;
 
                }
            }
        });
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel bp = new JPanel();
        bp.add(btnNewRegistrationTrialLoginWindow.java);
        bp.add(btnCancel);
 
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
 
        pack();
        setResizable(false);
       // setLocationRelativeTo(parent);
    }
 
    public long getUsername() {
        return Long.parseLong(tfUsername.getText());
    }
	 public long getOtp() {
        return Integer.parseInt(tfOTP.getText());
    }
 
    public boolean isSucceeded() {
        return succeeded;
    }
	
		public static void main(String[] args) {
		try {
			NewRegistrationTrialLoginWindow.java dialog = new NewRegistrationTrialLoginWindow.java();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}