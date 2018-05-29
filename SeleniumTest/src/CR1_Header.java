import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CR1_Header {
	public static boolean CR1_TC1() {
		WebDriver driver = helper.createDriverChrome();
		
		try {
			driver.get("http://fruitshop2.webitop.com");
			//driver.findElement(By.xpath("//i[@class=\"pe-7s-search\"]")).click();
			driver.findElement(By.xpath("//input[@class=\"search-box ui-autocomplete-input\"]")).sendKeys("ghe go");
			driver.findElement(By.xpath("//form[@class=\"search-form pull-left\"]/input[@type=\"submit\"]")).click();
			
			System.out.println(driver.findElements(By.xpath("//a[@class=\"custom_title_product\"]")).size());
			
			return helper.closeDriver(driver, "//div[@class=\"wb-shop\"]");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println("CR1_TC1: "+CR1_TC1());
	}
}
