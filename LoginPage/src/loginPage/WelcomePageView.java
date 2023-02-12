package loginPage;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;


public class WelcomePageView implements PageView{
	enum Roles{
		USER,
		MANAGER
	}
	// Components
	private final String webpage= "https://www.google.com/";
	private final JFrame welcomePage = new JFrame();
	private final JButton logoutButton = new JButton("Logout");
	private final JLabel titleLabel = new JLabel("Welcome Page");
	private final JLabel usernameLabel = new JLabel("Username");
	private final JLabel nameLabel = new JLabel("Name");
	private final JLabel roleLabel = new JLabel("Role");
	private final JLabel username= new JLabel("");
	private final JLabel name = new JLabel("");
	private final JLabel role= new JLabel(Roles.USER.toString());
	private final JLabel webpageLink = new JLabel(webpage); //Using a random link to google's website
	private final JPanel listPanel = new JPanel();
	
	public WelcomePageView(LoginController loginController) {
		welcomePage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		usernameLabel.setSize(labelWidth, labelHeight);
		nameLabel.setSize(labelWidth, labelHeight);
		roleLabel.setSize(labelWidth, labelHeight);
		logoutButton.setSize(buttonWidth, buttonHeight);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		// Add borders
		// Top set to 0 on the text fields to make it closer to the label describing what should be written in the field.
		titleLabel.setBorder(BorderFactory.createEmptyBorder(borderGap, borderGap, borderGap, borderGap));
		usernameLabel.setBorder(BorderFactory.createEmptyBorder(borderGap, borderGap, 0, borderGap));
		username.setBorder(BorderFactory.createEmptyBorder(0, borderGap, borderGap, borderGap));
		nameLabel.setBorder(BorderFactory.createEmptyBorder(borderGap, borderGap, 0, borderGap));
		name.setBorder(BorderFactory.createEmptyBorder(0, borderGap, borderGap, borderGap));
		roleLabel.setBorder(BorderFactory.createEmptyBorder(borderGap, borderGap, 0, borderGap));
		role.setBorder(BorderFactory.createEmptyBorder(0, borderGap, borderGap, borderGap));
		listPanel.setBorder(BorderFactory.createEmptyBorder(borderGap, borderGap, borderGap, borderGap));

		// Align left
		titleLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		usernameLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		username.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		nameLabel.setAlignmentX(JTextField.LEFT_ALIGNMENT);
		name.setAlignmentX(JTextField.LEFT_ALIGNMENT);

		// Set additional UI items
		webpageLink.setForeground(Color.BLUE.darker());
		webpageLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
		// Add a action listener to the button 
		logoutButton.addActionListener(loginController);
		// Add mouse adapter webpageLink label
		webpageLink.addMouseListener(new HyperlinkController(webpage));
		
		
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
		listPanel.add(titleLabel);
		listPanel.add(usernameLabel);
		listPanel.add(username);
		listPanel.add(nameLabel);
		listPanel.add(name);
		listPanel.add(roleLabel);
		listPanel.add(role);
		listPanel.add(webpageLink);
		listPanel.add(Box.createRigidArea(new Dimension(0, borderGap)));
		listPanel.add(logoutButton);
		welcomePage.add(listPanel);
		welcomePage.pack();
		welcomePage.setLocationRelativeTo(null);
		welcomePage.setVisible(false); // By default you cannot see this View until it is called by the controller
	}
	
	public void showView() {
		welcomePage.pack();
		welcomePage.setLocationRelativeTo(null);
		welcomePage.setVisible(true);
	}
	
	public void hideView() {
		// Clear existing data
		username.setText("");
		name.setText("");
		role.setText(Roles.USER.toString());
		webpageLink.setVisible(false);		
		welcomePage.setVisible(false);
	}
	

	public void messageDialog(String message) {
		JDialog logoutDialog = new JDialog();
		logoutDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JLabel logoutMessage = new JLabel(message);	
		logoutMessage.setFont(new Font("Arial", Font.BOLD, 20));
		logoutMessage.setBorder(BorderFactory.createEmptyBorder(borderGap, borderGap, borderGap, borderGap));
		logoutDialog.add(logoutMessage);
		logoutDialog.pack();
		logoutDialog.setLocationRelativeTo(null);
		logoutDialog.setVisible(true);
	}	
	
	public void updateViewData(String username, String name, String role) {
		this.username.setText(username);
		this.name.setText(name);
		this.role.setText(role);
		if(role.equalsIgnoreCase(Roles.MANAGER.toString())) {
			webpageLink.setVisible(true);
		}
		else {
			webpageLink.setVisible(false);
		}
	}
	

}
