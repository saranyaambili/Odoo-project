package pageodoo;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Odoopage {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"top_menu\"]/ul[1]/li[3]/a")
	WebElement signlink;
	@FindBy(xpath="//*[@id=\"login\"]")
	WebElement email;
	@FindBy(id="password")
	WebElement password;
	@FindBy(xpath="//*[@id=\"wrapwrap\"]/main/div[1]/div/div/form/div[3]/button")
	WebElement login;
	@FindBy(xpath="//*[@id=\"top_menu\"]/a[1]")
	WebElement home;
	@FindBy(xpath="//*[@id=\"wrap\"]/section[1]/div/div/a")
	WebElement demo;
	@FindBy(xpath="//*[@id=\"o_appointment_index_main_col\"]/div/div[1]/div/a/div[1]/div/img")
	WebElement image;
	@FindBy(xpath="/html/body/div[1]/main/div[1]/section[1]/div/a")
	WebElement start;
	@FindBy(xpath="//*[@id=\"wrapwrap\"]/main/div[1]/div[2]/div/div[1]/div[1]/div[1]/label[1]/div")
	WebElement radio;
	@FindBy(xpath="//*[@id=\"top_menu\"]/ul[1]/li[3]/a")
	WebElement icon;
	@FindBy(xpath="//*[@id=\"o_logout\"]")
	WebElement logout;
	public Odoopage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void signin() {
	signlink.click();
}

public void buttonclick() {
	login.click();
}

public void log(String email2, String password2) {
	 email.sendKeys(email2);
	 password.sendKeys(password2);
	
}
public void clear() {
	email.clear();
	password.clear();
}
public void windowhandling() {
	home.click();
	String parent=driver.getWindowHandle();
	demo.click();
	 Set<String> allwindowhandle=driver.getWindowHandles();
	 for(String handle : allwindowhandle) {
 	   if(!handle.equalsIgnoreCase(parent)) {
 	   driver.switchTo().window(handle);
 	   image.click();
 	  driver.close();
 	   }
 	  driver.switchTo().window(parent);
 	   }
	}
public void startfree() {
	start.click();
	String actual=driver.getTitle();
	System.out.println(actual);
	String expected="Odoo Online Trial | Odoo";
	Assert.assertEquals(actual, expected);
	radio.click();

}
public void quit() {
	icon.click();
	logout.click();
	
}
}
