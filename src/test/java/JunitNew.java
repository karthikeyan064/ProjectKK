import org.junit.Test;
import org.openqa.selenium.WebElement;

public class JunitNew extends BassClassNew {
	
	public static ProjectObjectModelNew p;
	
	@Test
	public void junit() {
		getDriver("chrome");
		launch("https://adactinhotelapp.com/");
		
		ProjectObjectModelNew p = new ProjectObjectModelNew();
		
	}
	

}
