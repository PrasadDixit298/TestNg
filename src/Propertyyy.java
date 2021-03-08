import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Propertyyy {

public static void main(String[] args) throws JXLException, IOException {
FileInputStream fis = new  FileInputStream("config.properties");
Properties property = new Properties();
property.load(fis);
String Value = property.getProperty("URL");
System.out.println(Value);
 String uname = property.getProperty("Username");
 String pass =property.getProperty("Password");
System.out.println("Login Details : " + uname + " "+pass);		
}
}
