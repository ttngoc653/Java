package seleniumDemo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class case1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.opera.driver","operadriver.exe");
		OperaOptions options=new OperaOptions();
		options.setBinary("C:\\Program Files\\Opera\\launcher.exe");
		WebDriver driver=new OperaDriver(options);
		driver.get("http://themini6.webitop.com/");
		System.out.println(driver.getTitle());
		driver.close();
		driver.quit();
		System.out.println("End!!!");
	}

}
