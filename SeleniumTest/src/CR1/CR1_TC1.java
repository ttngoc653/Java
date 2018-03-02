package CR1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CR1_TC1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
  		ChromeOptions options=new ChromeOptions();
  		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
  		WebDriver driver=new ChromeDriver(options);
  		
		driver.get("http://fruitshop2.webitop.com/admin/login");
		
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("admin");

		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("pass");
		
		driver.findElement(By.xpath("//button[@class=\"btn btn-primary btn-block\"]")).click();
		
		
		System.out.println("done!!!");
	}

}
