import java.io.IOException;

import org.openqa.selenium.WebElement;

public class Test extends BaseClass{
	
	public static void main(String[] args) throws IOException {
		
		driver("chrome");
		launch("https://adactinhotelapp.com/");
		
		PageObjectModel p = new PageObjectModel();
		
		WebElement username = p.getUsername();
		String getfile = getfile(0, 0, "keyan");
		
		
	}
	


}
