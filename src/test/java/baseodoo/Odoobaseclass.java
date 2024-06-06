package baseodoo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Odoobaseclass {
	public static WebDriver driver;
	String url="https://www.odoo.com";
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

}
