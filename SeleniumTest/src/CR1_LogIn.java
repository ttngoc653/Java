import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CR1_LogIn {

	public static boolean CR1_TC1() {
		WebDriver driver=helper.createDriverChrome();
		
  		try {
			driver.get("http://fruitshop2.webitop.com/admin/login");
			
			driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("admin");

			driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("pass");
			
			driver.findElement(By.xpath("//button[@class=\"btn btn-primary btn-block\"]")).click();
			
			System.out.println("DONE!!!");

			return helper.closeDriver(driver, "//h5[@class=\"content-group\"]");	
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
  		return false;
	}
	
	public static boolean CR1_TC2() {
		WebDriver driver=helper.createDriverChrome();
		
		try {
			driver.get("http://fruitshop2.webitop.com/admin/login");
			
			driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("admin@admin.com");

			driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
			
			driver.findElement(By.xpath("//button[@class=\"btn btn-primary btn-block\"]")).click();
			
			System.out.println("DONE!!!");


			return !helper.closeDriver(driver, "//h5[@class=\"content-group\"]");	
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
  		return false;
	}
	
	public static boolean CR1_TC3() {
		WebDriver driver=helper.createDriverChrome();
		
  		try {
			driver.get("http://fruitshop2.webitop.com/admin/login");
			
			driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("");

			driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
			
			driver.findElement(By.xpath("//button[@class=\"btn btn-primary btn-block\"]")).click();
			
			System.out.println("DONE!!!");


			return helper.closeDriver(driver, "//h5[@class=\"content-group\"]");	
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
  		return false;
	}
	
	public static boolean CR1_TC4() {
		WebDriver driver=helper.createDriverChrome();
		
  		try {
			driver.get("http://fruitshop2.webitop.com/admin/login");
			
			driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("admin@admin.com");

			driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("");
			
			driver.findElement(By.xpath("//button[@class=\"btn btn-primary btn-block\"]")).click();
			
			System.out.println("DONE!!!");


			return helper.closeDriver(driver, "//h5[@class=\"content-group\"]");	
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
  		return false;
	}
	public static boolean CR1_TC5() {
		WebDriver driver=helper.createDriverChrome();
		
  		try {
			driver.get("http://fruitshop2.webitop.com/admin/login");
			
			driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("admin@admin.com");

			driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
			
			driver.findElement(By.xpath("//input[@name=\"remember\"]")).click();;
			
			driver.findElement(By.xpath("//button[@class=\"btn btn-primary btn-block\"]")).click();
			
			return !helper.closeDriver(driver, "//h5[@class=\"content-group\"]");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
  		return false;
	}

	public static void main(String[] args) {
		System.out.println("CR1_TC1: "+CR1_TC1());
		System.out.println("CR1_TC2: "+CR1_TC2());
		System.out.println("CR1_TC3: "+CR1_TC3());
		System.out.println("CR1_TC4: "+CR1_TC4());
		System.out.println("CR1_TC5: "+CR1_TC5());
	}

}