import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameWork {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		WebElement btnfind = driver.findElement(By.id("twotabsearchtextbox"));
		btnfind.sendKeys("iphone 13 pro max");
		
		WebElement btnclick = driver.findElement(By.id("nav-search-submit-button"));
		btnclick.click();
		
		WebElement textiphone = driver.findElement(By.xpath("//span[contain(@text='Apple iPhone 13 Pro Max (128GB) - Sierra Blue')]"));
		String text = textiphone.getText();
		System.out.println(text);
		
			
		
	}

}
