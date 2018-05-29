import java.io.UnsupportedEncodingException;
import java.text.Normalizer;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class helper {
	static String targetBrower="C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"; 
	
	public static String addressUrl() {
		return "http://staging.webitop.com/";
	}
	
	public static String addressUrlAdmin() {
		return addressUrl()+"admin/";
	}
	
	public static WebDriver createDriverChrome(String address) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		
		options.setBinary(targetBrower);
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(address);
		return driver;		
	}
	
	public static WebDriver createDriverChrome() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setBinary(targetBrower);
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		
		return driver;		
	}
	
	public static WebDriver logIn(WebDriver driver) {
		try {

			driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("admin@imgroup.vn");

			driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("img123");
			
			driver.findElement(By.xpath("//button[@class=\"btn btn-primary btn-block\"]")).click();
		} catch (Exception e) { }
		
		return driver;
	}
	public static WebDriver createDriverChromeGoFruitshop1Admin() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setBinary(targetBrower);
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("http://fruitshop1.webitop.com/admin");
		return driver;		
	}
	
	public static boolean closeDriver(WebDriver driver,String xpathStr) {
		try {
			boolean bool=false;
			
			bool=(!driver.findElements(By.xpath(xpathStr)).isEmpty())?true:false;

			driver.quit();

			System.out.println("DONE!!");
			
			return bool;
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return false;
	}
	
	public static boolean closeDriverBeforeSearch(WebDriver driver,String xpathStr) {
		try {
			boolean bool=false;
			
			bool=(!driver.findElements(By.xpath(xpathStr)).isEmpty())?true:false;

			driver.quit();

			System.out.println("DONE!!");
			
			return bool;
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return false;
	}
	

 	public static boolean mobileClickIconMenu(WebDriver driver) {
		try {
			driver.findElement(By.xpath("//i[@class=\"icon-paragraph-justify3\"]")).click();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
 	
 	public static boolean mobileClickIconFunction(WebDriver driver) {
 		try {
			driver.findElement(By.xpath("//i[@class=\"icon-tree5\"]")).click();
		} catch (Exception e) {
			return false;
		}
 		return true;
 	}
 	
 	public static void waiting(WebDriver driver, int number_second) {

		driver.manage().timeouts().implicitlyWait(number_second, TimeUnit.SECONDS);
 	}
	
 	public static String convertToLink(String value) {
		String s1 = Normalizer.normalize(value, Normalizer.Form.NFKD);
		String regex = Pattern.quote("[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]+");

		String s2 = null;
		try {
			s2 = new String(s1.replaceAll(regex, "").getBytes("ascii"), "ascii");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		s2=s2.replace("?","");
		s2=s2.toLowerCase().replace(" ", "-");

	
		return s2;
	}
 	
}
