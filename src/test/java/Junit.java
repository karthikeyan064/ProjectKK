import java.io.IOException;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class Junit extends BaseClass {

	public static PageObjectModel p;

	@Test
	public void Browser() {
		driver("chrome");
		launch("https://adactinhotelapp.com/");
		p = new PageObjectModel();
		WebElement username = p.getUsername();
		sendtext(username, "karthi@123");
	}
	//@Test
	//public void pass() {	
		//WebElement password = p.getPassword();
		//sendtext(password, "12345@k");
	//}

	//@Test
	//public void login() {
		//WebElement login = p.getLogin();
		//button(login);
	}
//}
