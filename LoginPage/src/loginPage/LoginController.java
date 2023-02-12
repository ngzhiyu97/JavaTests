package loginPage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * An SQL server database is used for the storage of the user's login details. 
 * 
 * The SQL table is in the following format:
 * varchar username (Primary key)
 * varchar password 
 * varchar name
 * varchar role
 */
public class LoginController implements ActionListener{
	// Views
	private LoginView loginView;
	private WelcomePageView welcomePage;
	// Database related variables
	private String database = "loginDetails";
	private String databaseConnectionURL = "jdbc:sqlserver://DESKTOP-S5HB06K\\MSSQLSERVER01;Database="
	+ database +";"
	+ "IntegratedSecurity=true;"
	+ "Encrypt=true;"
	+ "TrustServerCertificate=true;"
    + "loginTimeout=20;";
	// Replace this with the database url. The variables IntegratedSecurity, Encrypt, and TrustServerCertificate are set to true only for test environments on localhost.
	
	private String sqlLoginTable = "LoginData";
	private ResultSet queryResult = null;
	
	public LoginController() {
		this.loginView = new LoginView(this);
		this.welcomePage = new WelcomePageView(this);
		// Establish connection with SQL servers
	}

	public boolean login() {
		try {
			// Update user input
			String inputUsername = loginView.getUsername();
			String loginQuery = "SELECT username, password, name, role" + " FROM " + sqlLoginTable + " WHERE username ='" + inputUsername + "'";
			// Establish connection with the sql server
			// For the connection to work, the "mssql-jdbc_auth-12.2.0.x64.dll" file must be added to the classpath of this project
			// The dll file can be downloaded from the official microsoft website
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager.getConnection(databaseConnectionURL);
			Statement statement = connection.createStatement();
			// query results
			queryResult = statement.executeQuery(loginQuery);
			
			// Query will only return at most 1 result as username is a primary key in the database.
			if(queryResult.next() == true) {
				// queryResult index 1 = username, index 2 = password, index 3 = name, index 4 = role
				if(loginView.getPassword().equals(queryResult.getString(2))) {
					welcomePage.updateViewData(queryResult.getString(1), queryResult.getString(3), queryResult.getString(4));
					loginView.hideView();
					welcomePage.showView();
					loginView.messageDialog("Login successful!");
					return true;
				}
				loginView.messageDialog("Password is incorrect! Please check again.");
				return false;
			}
			loginView.messageDialog("Username is incorrect! Please check again.");
			return false;
		}
		catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
			return false;
		}
	}


	public void logout() {
		welcomePage.hideView();
		loginView.showView();
		welcomePage.messageDialog("Logout successful!");
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equalsIgnoreCase("Login")) {
			login();
		}
		else if(event.getActionCommand().equalsIgnoreCase("Logout")){
			logout();
		}

	}
	
	
	
}
