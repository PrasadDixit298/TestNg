import java.awt.AWTException;
import java.net.SocketTimeoutException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Automationpractice {
	static WebDriver driver;
	@BeforeMethod
	public void urlLaunch(){
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://practice.automationtesting.in/my-account/");
	}
	@Test(priority=1)
	public void CreateUser() throws InterruptedException {
		driver.findElement(By.id("reg_email")).sendKeys("pasdf@asd.com");
		driver.findElement(By.id("reg_password")).sendKeys("Qwerty@124!??12e");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")).click();
		String actualTitle = driver.getTitle();
		System.out.println("print actual titile "+actualTitle);     
	    String expected="My Account – Automation Practice Site";
		Assert.assertEquals(actualTitle, expected);	
	}
	@Test(priority=2)
	public void Login() {
		driver.findElement(By.id("username")).sendKeys("qwerty@asd.com");
		driver.findElement(By.id("password")).sendKeys("Qwerty@124!??12e");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();	
		String actualTitle = driver.getTitle();
		System.out.println("print actual titile "+actualTitle);     
	    String expected="My Account – Automation Practice Site";
		Assert.assertEquals(actualTitle, expected);
	}
	@Test(priority=3)
	public void Logout() {
		driver.findElement(By.id("username")).sendKeys("qwerty@asd.com");
		driver.findElement(By.id("password")).sendKeys("Qwerty@124!??12e");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();	
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[6]/a")).click();
		String actualTitle = driver.getTitle();
		System.out.println("print actual titile "+actualTitle);     
	    String expected="My Account – Automation Practice Site";
		Assert.assertEquals(actualTitle, expected);
	}
	
	@Test(priority = 4)
	public void VerifyLogo() {
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"site-logo\"]/a/img"));
		Assert.assertTrue(logo.isDisplayed());
	}
	
	@Test(priority=5)
	public void AddToCart()throws WebDriverException,SocketTimeoutException, AWTException{
		driver.findElement(By.xpath("//*[@id=\"menu-item-40\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[3]/a[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"wpmenucartli\"]/a")).click();
		driver.get("http://practice.automationtesting.in/basket/");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/div/div/a")).click();
		driver.getCurrentUrl();
		driver.findElement(By.id("billing_first_name")).sendKeys("xyz");
		driver.findElement(By.id("billing_last_name")).sendKeys("sfg");
		driver.findElement(By.id("billing_phone")).sendKeys("0123456789");
		driver.findElement(By.xpath("//*[@id=\"billing_address_1\"]")).sendKeys("abcdefg");
		driver.findElement(By.xpath("//*[@id=\"billing_city\"]")).sendKeys("Nagpur");
		 String actualTitle = driver.getTitle();
		 System.out.println("print actual titile "+actualTitle);     
	    String expected="Checkout – Automation Practice Site";
		 Assert.assertEquals(actualTitle, expected);
	}
	@Test(priority=6)
	public void Registrationerror() throws InterruptedException {
		driver.findElement(By.id("reg_email")).sendKeys("qwerty@asd.com");
		driver.findElement(By.id("reg_password")).sendKeys("Qwerty@124!??12e");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")).click();
	     WebElement emailerror = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul"));
	     String Error = emailerror.getText();
	     String ActualError="Error: An account is already registered with your email address. Please login.";
	     Assert.assertEquals(ActualError, Error);
	    
	}
	@Test(priority=7)
	public void LoginError()throws WebDriverException,SocketTimeoutException {
		driver.findElement(By.id("username")).sendKeys("qwert@asd.com");
		driver.findElement(By.id("password")).sendKeys("Qwerty@124!??12e");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
		 WebElement emailerror = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul"));
	     String Error = emailerror.getText();
	     String ActualError="Error: A user could not be found with this email address.";
	     Assert.assertEquals(ActualError, Error);
	}
	@Test(priority=8)
	public void ForgetPassword()
	{
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]//a")).click();
		 driver.findElement(By.id("user_login")).sendKeys("qwerty@asd.com");
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]//input[2]")).click();
		WebElement msg= driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div"));
		 String LinkSendMsg=msg.getText();
		 String Actualmsg="Password reset email has been sent.";
		 Assert.assertEquals(Actualmsg, LinkSendMsg);	
		 
	}
	@Test
	public void user_click_On_Select_Cateogry_to_select_book() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"menu-item-40\"]/a")).click();
		WebElement productCATEGORIES= driver.findElement(By.id("woocommerce_product_categories-2"));
		List<WebElement> Booklist=productCATEGORIES.findElements(By.tagName("li"));
		for (WebElement li : Booklist) {
		if (li.getText().equals("selenium")) {
		     li.click();
		   }
		}
}
}
