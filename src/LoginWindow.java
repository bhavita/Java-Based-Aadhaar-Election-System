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

 
public class LoginWindow extends JDialog {
 
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JButton btnLoginWindow;
    private JButton btnCancel;
    private boolean succeeded;
 
    public LoginWindow() {
		setVisible(true);
		setAlwaysOnTop(true);
        setBounds(100, 100, 600, 600);
		
        JPanel panel = new JPanel();
        
        lbUsername = new JLabel("Username: ");
        panel.add(lbUsername);
 
        tfUsername = new JTextField(20);
        panel.add(tfUsername);
 
        lbPassword = new JLabel("Password: ");
        panel.add(lbPassword);
 
        pfPassword = new JPasswordField(20);
        panel.add(pfPassword);
        
        btnLoginWindow = new JButton("LoginWindow");
 
        btnLoginWindow.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
			LoginD ld=new LoginD();
			
                if (ld.validate(getUsername(), getPassword())) {
                    JOptionPane.showMessageDialog(LoginWindow.this,
                            "Hi " + getUsername() + "! You have successfully logged in.",
                            "LoginWindow",
                            JOptionPane.INFORMATION_MESSAGE);
                    succeeded = true;
                    dispose();
					VoterScreen vs=new VoterScreen(getUsername());
                } else {
                    JOptionPane.showMessageDialog(LoginWindow.this,
                            "Invalid username or password",
                            "LoginWindow",
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
        bp.add(btnLoginWindow);
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
 
    public String getPassword() {
        return new String(pfPassword.getText());
    }
 
    public boolean isSucceeded() {
        return succeeded;
    }
	
		public static void main(String[] args) {
		try {
			LoginWindow dialog = new LoginWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}