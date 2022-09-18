import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageObjectModel extends BaseClass{
	
	@FindBy(id="email")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login")
	private WebElement login;
	
//	@FindBy(id="location")
//	private WebElement location;
//	
//	@FindBy(id="hotel")
//	private WebElement hotel;
//	
//	@FindBy(id="room_type")
//	private WebElement roomType;
//	
//	@FindBy(id="room_nos")
//	private WebElement Room;
//	
//	
//	@FindBy(id="adult_room")
//	private WebElement AdultRoom;
//




//	public WebElement getLocation() {
//		return location;
//	}
//
//
//	public WebElement getHotel() {
//		return hotel;
//	}
//
//
//	public WebElement getRoomType() {
//		return roomType;
//	}
//
//
//	public WebElement getRoom() {
//		return Room;
//	}
//
//
//	public WebElement getAdultRoom() {
//		return AdultRoom;
//	}
	
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}

	public PageObjectModel() {
		PageFactory.initElements(driver, this);
	}



}

	

	
	
		