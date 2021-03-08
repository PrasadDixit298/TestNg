import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Speed {
	WebDriver Driver;
	@BeforeMethod
	public void openurl()
	{
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe" );
		 Driver  = new ChromeDriver();
		 Driver.manage().window().maximize();
		 Driver.get("https://www.google.com/");
	}
	@Test
	public void Speedtest() {
	WebElement elment=	Driver.findElement(By.name("q"));
	elment.sendKeys("fast.com");
	elment.submit();
	Driver.findElement(By.className("yuRUbf")).click();
	Driver.switchTo();
		
	}

}
