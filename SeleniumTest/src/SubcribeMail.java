import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubcribeMail {

	public static boolean inputEmail(String str) {
		WebDriver driver=helper.createDriverChrome(helper.addressUrl());
		
		try {
			System.out.println(driver.findElements(By.xpath("//input[@name=\"subcribe_mail\"]")).size());
			
			for (WebElement element : driver.findElements(By.xpath("//input[@name=\"subcribe_mail\"]"))) {
				element.sendKeys(str+Keys.ENTER);
				
				if(driver.findElements(By.xpath("//h1[@class=\"break-long-words exception-message\"]")).size()>0) {
					driver.quit();
					return false;
				}
				
				driver.quit();
				
				driver=helper.createDriverChrome(helper.addressUrlAdmin());
				
				driver=helper.logIn(driver);
				
				driver.findElement(By.xpath("//i[@class=\"icon-mention\"]")).click();
				
				Thread.sleep(1000);
				
				//System.out.println(driver.findElements(By.xpath("//table[@id=\"subscriberDatatable\"]")).size());
				
				String str_save= driver.findElement(By.xpath("//table[@id=\"subscriberDatatable\"]/tbody/tr[1]/td[2]")).getAttribute("innerHTML");
					
				driver.quit();

				return str_save.equals(str)?true:false;		
			}

			return true;		
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public static boolean inputMailUncorrect(String str) {
		WebDriver driver=helper.createDriverChrome(helper.addressUrl());
		
		try {
			System.out.println(driver.findElements(By.xpath("//input[@name=\"subcribe_mail\"]")).size());
			
			for (WebElement element : driver.findElements(By.xpath("//input[@name=\"subcribe_mail\"]"))) {
				element.sendKeys(str+Keys.ENTER);
				
				if(driver.findElements(By.xpath("//h1[@class=\"break-long-words exception-message\"]")).size()>0) {
					driver.quit();
					return false;
				}
				
				driver.quit();
				
				driver=helper.createDriverChrome(helper.addressUrlAdmin());
				
				driver=helper.logIn(driver);
				
				driver.findElement(By.xpath("//i[@class=\"icon-mention\"]")).click();
				
				Thread.sleep(1000);
				
				//System.out.println(driver.findElements(By.xpath("//table[@id=\"subscriberDatatable\"]")).size());
				
				String str_save= driver.findElement(By.xpath("//table[@id=\"subscriberDatatable\"]/tbody/tr[1]/td[2]")).getAttribute("innerHTML");
					
				driver.quit();

				return !str_save.equals(str)?true:false;		
			}

			return true;		
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}		
	}
	
	public static void main(String[] args) {
		
		System.out.println("TEST SUBCRIBE MAIL NORMAL: "+inputEmail("duynguyen@gmail.com"));
		System.out.println("TEST SUBCRIBE MAIL NO @: "+inputMailUncorrect("abc.com"));
		System.out.println("TEST SUBCRIBE MAIL NO . BEFORE @: "+inputMailUncorrect("abc@gmail"));
		System.out.println("TEST SUBCRIBE MAIL EMPTY: "+inputMailUncorrect(""));
		
	}
	
}
