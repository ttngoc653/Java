package CR1_Header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CR1_TC1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=seleniumHelper.createChrome();
  		driver.get("http://themini6.webitop.com");
  		
  		driver.findElement(By.id("search-box")).sendKeys("thời trang nam");
  		
  		driver.findElement(By.xpath("//i[@class=\"fa fa-search\"]")).click();
  		driver.wait(1000);
  		driver.close();
  		System.out.println("Done!!!");

	}

}
