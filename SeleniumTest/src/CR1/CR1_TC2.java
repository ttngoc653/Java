package CR1;

import java.nio.charset.*;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CR1_TC2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
  		ChromeOptions options=new ChromeOptions();
  		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
  		WebDriver driver=new ChromeDriver(options);
  		try {
  			driver.get("http://fruitshop2.webitop.com/admin/login");
  			
  			driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("admin@admin.com");

  			driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
  			
  			driver.findElement(By.xpath("//button[@class=\"btn btn-primary btn-block\"]")).click();
  			
  			System.out.println();
  			
  			if ((new String(driver.findElement(By.xpath("//div[@class=\"navbar-collapse collapse\"]/ul[@class=\"nav navbar-nav\"][2]/li/h5")).getText().getBytes(Charset.forName("utf-8")))=="Quản lý chung")) {
				System.out.println("true");
			} else {
				System.out.println("false");
			}  				
		} catch (Exception e) {
			System.out.println(e.toString());
		}finally {
			driver.close();
						
		}

		System.out.println("done!!!");
	}

}
