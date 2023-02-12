package loginPage;

import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HyperlinkController extends MouseAdapter {
	String webpageLink = "";
	
	public HyperlinkController(String webpageLink){
		this.webpageLink = webpageLink;
	}
	
	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
		try {
			Desktop.getDesktop().browse(new URI(webpageLink));
		}
		catch (IOException | URISyntaxException exceptionE) {
			exceptionE.printStackTrace();
		}
		
	}

}
