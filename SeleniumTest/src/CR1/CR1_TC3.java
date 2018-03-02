package CR1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CR1_TC3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
  		ChromeOptions options=new ChromeOptions();
  		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
  		WebDriver driver=new ChromeDriver(options);
  		
		driver.get("http://fruitshop2.webitop.com/admin/login");
		
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("");

		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[@class=\"btn btn-primary btn-block\"]")).click();
		
		if (driver.findElements(By.xpath("//ul[@class=\"navigation navigation-main navigation-accordion\"]/li")).size()>0) {
			System.out.println("TRUE");	
		} else {
			System.out.println("FALSE");
		}
		
		
		System.out.println("done!!!");
	}

}
