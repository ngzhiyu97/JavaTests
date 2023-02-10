package loginPage;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;


public class LoginView {
	// Dimensions for the components
	int windowSizeX = 500;
	int windowSizeY = 500;
	int buttonWidth = 80;
	int buttonHeight = 40;
	int textFieldHeight = 50;
	
	// Components
	JFrame loginFrame = new JFrame();
	JButton loginButton = new JButton("Login");
	JLabel usernameLabel = new JLabel("Username:");
	JLabel passwordLabel= new JLabel("Password:");
	JTextField usernameField = new JTextField(textFieldHeight);
	JPasswordField passwordField = new JPasswordField(textFieldHeight);
	
	
	
	public LoginView() {
		// Initializes the login view
		
		loginFrame.setSize(windowSizeX, windowSizeY);
		loginButton.setBounds(380, 400, buttonWidth, buttonHeight);
		loginButton.setVisible(true);
		
		loginFrame.add(loginButton);
		loginFrame.setLayout(null);
		loginFrame.setVisible(true);
		
		// Connect to the SQL Database
	}
	
	private void loginFunction() {
		System.out.println("abc");
	}
	
	public void hideView() {
		// Hides the view once login is successful.
		loginFrame.setVisible(false);
	}
	
	public void showView() {
		// Show the view upon logging out.
		loginFrame.setVisible(true);
	}
		
}
