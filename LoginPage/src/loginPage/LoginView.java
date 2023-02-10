package loginPage;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.BorderFactory;


public class LoginView {
	// Dimensions for the components
	private int buttonWidth = 80;
	private int buttonHeight = 50;
	private int labelHeight = 50;
	private int labelWidth = 200;
	private int textFieldLength = 20;
	private int borderGap = 5;
	
	// Components
	private JFrame loginFrame = new JFrame();
	private JButton loginButton = new JButton("Login");
	private JLabel titleLabel = new JLabel("Login Page");
	private JLabel userNameLabel = new JLabel("Username:");
	private JLabel passwordLabel= new JLabel("Password:");
	private JTextField userNameField = new JTextField(textFieldLength);
	private JPasswordField passwordField = new JPasswordField(textFieldLength);
	private JPanel listPanel = new JPanel(); 
	
	public LoginView() {
		// Initializes the login view
		loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		userNameLabel.setSize(labelWidth, labelHeight);
		passwordLabel.setSize(labelWidth, labelHeight);
		loginButton.setSize(buttonWidth, buttonHeight);
		
		// Add borders
		// Top set to 0 on the text fields to make it closer to the label describing what should be written in the field.
		titleLabel.setBorder(BorderFactory.createEmptyBorder(borderGap, borderGap, borderGap, borderGap));
		userNameLabel.setBorder(BorderFactory.createEmptyBorder(borderGap, borderGap, borderGap, borderGap));
		userNameField.setBorder(BorderFactory.createEmptyBorder(0, borderGap, borderGap, borderGap));
		passwordLabel.setBorder(BorderFactory.createEmptyBorder(borderGap, borderGap, borderGap, borderGap));
		passwordField.setBorder(BorderFactory.createEmptyBorder(0, borderGap, borderGap, borderGap));
		listPanel.setBorder(BorderFactory.createEmptyBorder(borderGap, borderGap, borderGap, borderGap));
		
		// Align left
		titleLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		userNameLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		passwordLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		userNameField.setAlignmentX(JTextField.LEFT_ALIGNMENT);
		passwordField.setAlignmentX(JTextField.LEFT_ALIGNMENT);
		
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
		listPanel.add(titleLabel);
		listPanel.add(Box.createGlue());
		listPanel.add(userNameLabel);
		listPanel.add(userNameField);
		listPanel.add(passwordLabel);
		listPanel.add(passwordField);
		listPanel.add(loginButton);
		loginFrame.add(listPanel);
		loginFrame.pack();
		loginFrame.setVisible(true);		
	}
	
	public void hideView() {
		// Hides the view once login is successful and resets all the text fields.
		userNameField.setText("");
		passwordField.setText("");
		loginFrame.setVisible(false);
	}
	
	public void showView() {
		// Show the view upon logging out.
		loginFrame.setVisible(true);
	}
		
}
