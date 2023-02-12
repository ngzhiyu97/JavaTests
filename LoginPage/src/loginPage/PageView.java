package loginPage;

public interface PageView {
	// Defines the sizes of components in the view
	int buttonWidth = 80;
	int buttonHeight = 40;
	int labelHeight = 50;
	int labelWidth = 200;
	int textFieldHeight = 50;
	int textFieldLength = 20;
	int borderGap = 5;

	public void messageDialog(String message); // Function to show a message dialog to notify the user of success or failure when changing views.
	
}
