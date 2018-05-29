import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryProduct {
	
	public static WebDriver gotoCategoryProduct() {

		
		WebDriver driver=helper.createDriverChrome(helper.addressUrlAdmin());
		try {
			driver=helper.logIn(driver);
			
			helper.mobileClickIconMenu(driver);
			
			driver.findElement(By.className("icon-price-tag2")).click();
			
			driver.findElement(By.xpath("//a[@href=\"http://staging.webitop.com/admin/product/category\"]")).click();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return driver;
	}
	
	public static int countCategory(){
		
		WebDriver driver=gotoCategoryProduct();
		
		helper.waiting(driver, 10);
		
		int count= driver.findElements(By.xpath("//table[@id=\"DataTables_Table_0\"]/tbody/tr")).size();
		
		driver.quit();
		
		return count;
	}
	
	public static boolean createCategoryNormal() {
		WebDriver driver=gotoCategoryProduct();
		
		String textTitle="Thể loại automation";
		String textDescription="Mô tả thể loại automation";
		
		try {
			helper.mobileClickIconFunction(driver);
			
			driver.findElement(By.xpath("//button[@class=\"btn bg-info heading-btn\"]")).click();			
			driver.findElement(By.xpath("//div[@class=\"selectize-input items required invalid not-full\"]/input")).sendKeys(textTitle+"\t\t");
			driver.findElement(By.name("description")).sendKeys(textDescription+"\t\t");
			helper.waiting(driver, 10);
			//Thread.sleep(30000);
			
			if(!(textTitle.equalsIgnoreCase(driver.findElement(By.name("title")).getAttribute("value"))
					&& textTitle.equalsIgnoreCase(driver.findElement(By.name("h1")).getAttribute("value"))
					&& textTitle.equalsIgnoreCase(driver.findElement(By.name("meta_title")).getAttribute("value"))
					&& textTitle.equalsIgnoreCase(driver.findElement(By.xpath("//h3[@class=\"seo_title_google\"]")).getAttribute("innerHTML"))
					&& helper.convertToLink(textTitle).equals(driver.findElement(By.name("slug")).getAttribute("value"))
					&& helper.convertToLink(textTitle).equals(driver.findElement(By.xpath("//span[@class=\"slug_google\"]")).getAttribute("innerHTML")))) 
				return false;
			
			
			if (!(textDescription.equalsIgnoreCase(driver.findElement(By.name("meta_description")).getAttribute("value"))
					&& textDescription.equalsIgnoreCase(driver.findElement(By.xpath("//div[@class=\"seo_description_google\"]")).getAttribute("innerHTML")))) return false;
			
			helper.mobileClickIconFunction(driver);
			driver.findElement(By.xpath("//button[@class=\"heading-btn btn btn-info btn-ladda btn-ladda-spinner\"]")).click();
			
			helper.waiting(driver, 10);
					
			if(driver.findElements(By.xpath("//div[@class=\"alert alert-success alert-styled-left alert-arrow-left alert-bordered\"]")).size()==0) return false;
			
			helper.mobileClickIconFunction(driver);
			
			driver.findElement(By.xpath("//h5[@class=\"hiden_1024_1350 hiden_768_1023\"]/a")).click();
			
			if(!(driver.findElement(By.xpath("//table[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[3]/a")).getAttribute("innerHTML").equalsIgnoreCase(textTitle))
					&& driver.findElement(By.xpath("//table[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[4]")).getAttribute("innerHTML").equalsIgnoreCase(helper.convertToLink(textTitle))) return false;
			
			driver.findElement(By.xpath("//table[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[3]/a")).click();
			
			if(!(textTitle.equalsIgnoreCase(driver.findElement(By.name("title")).getAttribute("value"))
					&& textTitle.equalsIgnoreCase(driver.findElement(By.name("h1")).getAttribute("value"))
					&& textTitle.equalsIgnoreCase(driver.findElement(By.name("meta_title")).getAttribute("value"))
					&& textTitle.equalsIgnoreCase(driver.findElement(By.xpath("//h3[@class=\"seo_title_google\"]")).getAttribute("innerHTML"))
					&& helper.convertToLink(textTitle).equals(driver.findElement(By.name("slug")).getAttribute("value"))
					&& helper.convertToLink(textTitle).equals(driver.findElement(By.xpath("//span[@class=\"slug_google\"]")).getAttribute("innerHTML")))) 
				return false;
			
			
			if (!(textDescription.equalsIgnoreCase(driver.findElement(By.name("meta_description")).getAttribute("value"))
					&& textDescription.equalsIgnoreCase(driver.findElement(By.xpath("//div[@class=\"seo_description_google\"]")).getAttribute("innerHTML")))) return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();
			return false;
		}
		driver.quit();
		return true;
	}
	
	public static boolean replaceCategoryProduct() {
		String textTitleReplace="Thể loại automation chỉnh sửa";
		String textDescriptionReplace="Mô tả thể loại automation chỉnh sửa";
		
		WebDriver driver=gotoCategoryProduct();
		
		try {
			helper.waiting(driver, 10);

			driver.findElement(By.xpath("//table[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[3]/a")).click();
			
			//driver.findElement(By.xpath("//div[@selectize-input items required not-full has-options has-items]/input")).click();
			//driver.findElement(By.name("meta_keyword")).clear();
			//driver.findElement(By.name("meta_keyword")).sendKeys(textTitleReplace);
			
			driver.findElement(By.name("title")).clear();
			driver.findElement(By.name("title")).sendKeys(textTitleReplace);
			driver.findElement(By.name("h1")).clear();
			driver.findElement(By.name("h1")).sendKeys(textTitleReplace);
			driver.findElement(By.name("meta_title")).clear();
			driver.findElement(By.name("meta_title")).sendKeys(textTitleReplace);
			driver.findElement(By.name("slug")).clear();
			driver.findElement(By.name("slug")).sendKeys(helper.convertToLink(textTitleReplace));
			
			driver.findElement(By.name("meta_description")).clear();
			driver.findElement(By.name("meta_description")).sendKeys(textDescriptionReplace);
			driver.findElement(By.name("description")).clear();
			driver.findElement(By.name("description")).sendKeys(textDescriptionReplace+"\t");
			
			helper.mobileClickIconFunction(driver);
			
			driver.findElement(By.xpath("//button[@class=\"heading-btn btn btn-info btn-ladda btn-ladda-spinner\"]")).click();
			
			if(driver.findElements(By.xpath("//div[@class=\"alert alert-success alert-styled-left alert-arrow-left alert-bordered\"]")).size()==0) return false;
			
			helper.mobileClickIconFunction(driver);
			
			driver.findElement(By.xpath("//h5[@class=\"hiden_1024_1350 hiden_768_1023\"]/a")).click();
			

			if(!(driver.findElement(By.xpath("//table[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[3]/a")).getAttribute("innerHTML").equalsIgnoreCase(textTitleReplace))
					&& driver.findElement(By.xpath("//table[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[4]")).getAttribute("innerHTML").equalsIgnoreCase(helper.convertToLink(textTitleReplace))) return false;
			
			driver.findElement(By.xpath("//table[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[3]/a")).click();
			
			if(!(textTitleReplace.equalsIgnoreCase(driver.findElement(By.name("title")).getAttribute("value"))
					&& textTitleReplace.equalsIgnoreCase(driver.findElement(By.name("h1")).getAttribute("value"))
					&& textTitleReplace.equalsIgnoreCase(driver.findElement(By.name("meta_title")).getAttribute("value"))
					&& textTitleReplace.equalsIgnoreCase(driver.findElement(By.xpath("//h3[@class=\"seo_title_google\"]")).getAttribute("innerHTML"))
					&& helper.convertToLink(textTitleReplace).equals(driver.findElement(By.name("slug")).getAttribute("value"))
					&& helper.convertToLink(textTitleReplace).equals(driver.findElement(By.xpath("//span[@class=\"slug_google\"]")).getAttribute("innerHTML")))) 
				return false;
			
			
			if (!(textDescriptionReplace.equalsIgnoreCase(driver.findElement(By.name("meta_description")).getAttribute("value"))
					&& textDescriptionReplace.equalsIgnoreCase(driver.findElement(By.xpath("//div[@class=\"seo_description_google\"]")).getAttribute("innerHTML")))) return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();;
			return false;
		}
		
		driver.quit();;
		return true;
	}
	
	public static boolean deleteCategoryProduct() {
		WebDriver driver=gotoCategoryProduct();
		int count_category_before,count_category_after;
		try {
			helper.waiting(driver, 10);
			
			count_category_before=countCategory();
			
			driver.findElement(By.xpath("//table[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td/a/i")).click();
			
			driver.findElement(By.xpath("//div[@class=\"sweet-alert showSweetAlert visible\"]/div[@class=\"sa-button-container\"]/div[@class=\"sa-confirm-button-container\"]/button")).click();
			
			helper.waiting(driver, 10);
			count_category_after=countCategory();
			
			if(count_category_before!=count_category_after+1) return false;
		} catch (Exception e) {
			e.printStackTrace();
			
			driver.quit();
			return false;
		}
		
		driver.quit();
		return true;
	}
	
	public static void main(String[] args) {
		//System.out.println("Number product category current: "+countCategory());
		
		System.out.println("Create category product normal: "+createCategoryNormal());
		
		//System.out.println("Replace category product normal: "+replaceCategoryProduct());
		
		System.out.println("Delete category product: "+deleteCategoryProduct());
	}

}
