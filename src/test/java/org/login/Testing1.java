package org.login;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testing1 extends BaseClass {
	
	@Parameters({"name","pass"})
	@Test
	private void tc01(String username, String password) {
		
		driver("chrome");
		launch("https://adactinhotelapp.com/");
		WebElement textuser = locatorId("id", "username");
		sendtext(textuser, username);
		WebElement textpass = locatorId("id", "password");
		sendtext(textpass, password);
		locatorId("id", "login").click();

	}
	
	

}
