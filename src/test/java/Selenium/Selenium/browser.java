package Selenium.Selenium;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browser {
	WebDriver driver;
	@BeforeTest
	@Parameters("Browser")
	public void crossbrowser(String Browser) {
		if(Browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.get("https://kitchen.applitools.com/ingredients/file-picker");
		}
		else if(Browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
	        driver.get("https://kitchen.applitools.com/ingredients/file-picker");
		}
		else if(Browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
	        driver.get("https://kitchen.applitools.com/ingredients/file-picker");
		}
	}
@Test
public void uploadFile() {
	WebElement upload =driver.findElement(By.id("photo-upload"));
    String file="A:\\All documents\\Gopinath_photo.jpg";
    upload.sendKeys(file);
	
}
	@AfterTest
public void close_browser() throws InterruptedException {
		Thread.sleep(2000);
        driver.quit();

}
	public static void main(String[] args) throws InterruptedException {
        
	}

}
