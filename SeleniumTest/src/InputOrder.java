import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputOrder {
	public static WebDriver gotoInputOrder() {
		WebDriver driver=helper.createDriverChrome(helper.addressUrlAdmin());
		
		try {
			helper.logIn(driver);
			
			driver.findElement(By.xpath("//i[@class=\"icon-cart5\"]")).click();
			
			driver.findElement(By.xpath("//a[@href=\"http://staging.webitop.com/admin/order/setting/general\"]")).click();
			
			driver.findElement(By.xpath("//i[@class=\"fa fa-edit\"]")).click();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return driver;
	}
	
	public static boolean gotoDefault() {
		WebDriver driver=gotoInputOrder();
		
		try {
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return false;
	}
	
	public static boolean changeAllName() {
		WebDriver driver =gotoInputOrder();
		
		try {
						
			driver.findElement(By.xpath("//span[@class=\"ladda-label\"]")).click();
			
			// test in sell checkout
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(changeAllName());
		
	}
}
