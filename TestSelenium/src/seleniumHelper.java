import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class seleniumHelper {
	static public WebDriver createChrome() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
  		ChromeOptions options=new ChromeOptions();
  		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
  		WebDriver driver=new ChromeDriver(options);
  		
  		return driver;
	}
}
