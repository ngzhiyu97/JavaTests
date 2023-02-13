package loginPage;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JDialog;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;


public class LoginView implements PageView{
	// Components
	private final JFrame loginFrame = new JFrame();
	private final JButton loginButton = new JButton("Login");
	private final JLabel titleLabel = new JLabel("Login Page");
	private final JLabel usernameLabel = new JLabel("Username:");
	private final JLabel passwordLabel= new JLabel("Password:");
	private final JTextField usernameField = new JTextField(textFieldLength);
	private final JPasswordField passwordField = new JPasswordField(textFieldLength);
	private final JPanel listPanel = new JPanel(); 
	
	public LoginView(LoginController loginController) {
		// Initializes the login view
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		usernameLabel.setSize(labelWidth, labelHeight);
		passwordLabel.setSize(labelWidth, labelHeight);
		loginButton.setSize(buttonWidth, buttonHeight);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		// Add borders
		// Top set to 0 on the text fields to make it closer to the label describing what should be written in the field.
		titleLabel.setBorder(BorderFactory.createEmptyBorder(borderGap, borderGap, borderGap, borderGap));
		usernameLabel.setBorder(BorderFactory.createEmptyBorder(borderGap, borderGap, borderGap, borderGap));
		usernameField.setBorder(BorderFactory.createEmptyBorder(0, borderGap, borderGap, borderGap));
		passwordLabel.setBorder(BorderFactory.createEmptyBorder(borderGap, borderGap, borderGap, borderGap));
		passwordField.setBorder(BorderFactory.createEmptyBorder(0, borderGap, borderGap, borderGap));
		listPanel.setBorder(BorderFactory.createEmptyBorder(borderGap, borderGap, borderGap, borderGap));
		
		// Align left
		titleLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		usernameLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		passwordLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		usernameField.setAlignmentX(JTextField.LEFT_ALIGNMENT);
		passwordField.setAlignmentX(JTextField.LEFT_ALIGNMENT);
		
		// Additional ui
		loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		// Add an ActionListener to the button
		loginButton.addActionListener(loginController);
		// Make the "Enter" key activate the login button
		loginFrame.getRootPane().setDefaultButton(loginButton);
		
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
		listPanel.add(titleLabel);
		listPanel.add(usernameLabel);
		listPanel.add(usernameField);
		listPanel.add(passwordLabel);
		listPanel.add(passwordField);
		listPanel.add(Box.createRigidArea(new Dimension(0, borderGap)));
		listPanel.add(loginButton);
		loginFrame.add(listPanel);
		loginFrame.pack();
		loginFrame.setLocationRelativeTo(null);
		loginFrame.setVisible(true);		
	}
	
	public void showView() {
		// Show the view upon logging out.
		loginFrame.setLocationRelativeTo(null);
		loginFrame.setVisible(true);
	}
	
	public void hideView() {
		// Hides the view once login is successful and resets all the text fields.
		usernameField.setText("");
		passwordField.setText("");
		loginFrame.setVisible(false);
	}
	
	public void messageDialog(String message) {
		JDialog loginDialog = new JDialog();
		loginDialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		loginDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JLabel loginMessage = new JLabel(message);	
		loginMessage.setFont(new Font("Arial", Font.BOLD, 20));
		loginMessage.setBorder(BorderFactory.createEmptyBorder(borderGap, borderGap, borderGap, borderGap));
		loginDialog.add(loginMessage);
		loginDialog.pack();
		loginDialog.setLocationRelativeTo(null);
		loginDialog.setVisible(true);
	}
		
	public String getUsername() {
		return usernameField.getText();
	}
	
	public String getPassword() {
		char[] password = passwordField.getPassword();
		StringBuilder convertedPassword = new StringBuilder(password.length);
		for(Character c : password) {
			convertedPassword.append(c.charValue());
		}
		return convertedPassword.toString();
	}
}
