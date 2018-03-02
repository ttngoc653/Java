package CR1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CR1_TC4 {

	public static void main(String[] args) {
		System.out.println("TC4: ");
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
  		ChromeOptions options=new ChromeOptions();
  		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
  		WebDriver driver=new ChromeDriver(options);
  		try {

  			driver.get("http://fruitshop2.webitop.com/admin/login");
  			
  			driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("admin@admin.com");

  			driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("");
  			
  			driver.findElement(By.xpath("//button[@class=\"btn btn-primary btn-block\"]")).click();
  			
  			if (!(driver.findElements(By.xpath("//ul[@class=\"navigation navigation-main navigation-accordion\"]/li")).size()>0)) {
  				System.out.println("TRUE");	
  			} else {
  				System.out.println("FALSE");
  			}	
		} catch (Exception e) {
			e.toString();

			System.out.println("FALSE");
		}finally {
			driver.close();
		}
		
		System.out.println("\tdone CR1_TC4!!!");
	}
}
