import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Test_cases {
	static WebDriver Driver;
	 Sheet s;
	
	@BeforeMethod
	public void Open_Browser() {
		 System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe" );
		 Driver  = new ChromeDriver();
		 Driver.manage().window().maximize();
		 Driver.get("http://automationpractice.com/index.php");	
	}
	
	public void Login_Test() {
		Driver.findElement(By.className("login")).click();
		Driver.findElement(By.id("email")).sendKeys("xyz123@abc.com");
		Driver.findElement(By.id("passwd")).sendKeys("123456789");
		Driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
		String Actual_Title=Driver.getTitle();
		System.out.println(Actual_Title);
		String Expected_Title="My account - My Store";
		Assert.assertEquals(Actual_Title, Expected_Title);
	}
	@Test
	public void Logout() {
        Login_Test();
        Driver.findElement(By.className("logout")).click();
		String Actual_Title=Driver.getTitle();
		System.out.println(Actual_Title);
		String Expected_Title="Login - My Store";
		Assert.assertEquals(Actual_Title, Expected_Title);
	}
	}
	

