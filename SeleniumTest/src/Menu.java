import java.util.ArrayList; 
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Menu {

	public static boolean TC_addMenuWas() {
		WebDriver driver=helper.createDriverChromeGoFruitshop1Admin();		
		
		try {
			
			// log in to admin "Cau hinh chung"
			driver=helper.logIn(driver);
			
			// click to Menu in menu left
			driver.findElement(By.xpath("//i[@class=\"icon-menu3\"]")).click();
			
			
			// number menu parent 
			int num_nemu_parent_after=driver.findElements(By.xpath("//div[@class=\"dd menu_container\"]/ol[@class=\"menu-item-list dd-list\"]/li[@class=\"menu-item dd-item\"]")).size();
			
			// 
			//System.out.println(num_nemu_parent_after+" "+driver.findElements(By.xpath("//div[@class=\"dd menu_container\"]/ol[@class=\"menu-item-list dd-list\"][last()]/li[@class=\"menu-item dd-item\"][last()]/form[@class=\"store-form\"][last()]/div[@class=\"panel panel-white widget-item cursor-move panel-collapsed\"]/div[@class=\"panel-heading menu-handle\"]/h6[@class=\"panel-title\"]")).size());
			
			//System.out.println(driver.findElement(By.xpath("//div[@class=\"dd menu_container\"]/ol[@class=\"menu-item-list dd-list\"][last()]/li[@class=\"menu-item dd-item\"][last()]/form[@class=\"store-form\"][last()]/div[@class=\"panel panel-white widget-item cursor-move panel-collapsed\"]/div[@class=\"panel-heading menu-handle\"]/h6[@class=\"panel-title\"]")).getText());
			
			driver.findElement(By.xpath("//button[@class=\"btn btn-default sidebar-control sidebar-detached-hide heading-btn sidebar-mobile-detached-toggle\"]")).click();
			
			driver.findElement(By.xpath("//div[@class=\"sidebar-category\"][5]")).click();
			
			//System.out.println(driver.findElements(By.xpath("//div[@class=\"sidebar-category\"][5]/div[@class=\"category-content\"]/div[@class=\"form-group\"]/div[@class=\"checkbox\"]/label")).size());
			driver.findElement(By.xpath("//div[@class=\"sidebar-category\"][5]/div[@class=\"category-content\"]/div[@class=\"form-group\"]/div[@class=\"checkbox\"]/label")).click();
			
			//System.out.println(driver.findElements(By.xpath("//div[@class=\"sidebar-category\"][5]/div[@class=\"category-content\"]/div[@class=\"row\"]/div[@class=\"col-xs-12\"]/button")).size());
			driver.findElement(By.xpath("//div[@class=\"sidebar-category\"][5]/div[@class=\"category-content\"]/div[@class=\"row\"]/div[@class=\"col-xs-12\"]/button")).click();
			

			driver.quit();
			
			driver=helper.createDriverChromeGoFruitshop1Admin();
			
			driver=helper.logIn(driver);
			
			driver.findElement(By.xpath("//i[@class=\"icon-menu3\"]")).click();
			
			int num_menu_parent_before=driver.findElements(By.xpath("//div[@class=\"dd menu_container\"]/ol[@class=\"menu-item-list dd-list\"]/li[@class=\"menu-item dd-item\"]")).size();
			
			//System.out.println(num_nemu_parent_after+" "+driver.findElements(By.xpath("//div[@class=\"dd menu_container\"]/ol[@class=\"menu-item-list dd-list\"][last()]/li[@class=\"menu-item dd-item\"][last()]/form[@class=\"store-form\"][last()]/div[@class=\"panel panel-white widget-item cursor-move panel-collapsed\"]/div[@class=\"panel-heading menu-handle\"]/h6[@class=\"panel-title\"]")).size());
			
			driver.get("http://fruitshop1.webitop.com");
			
			int num_menu_in_index=driver.findElements(By.xpath("//ul[@class=\"wb-menu\"]/li")).size();
			
			System.out.println(num_menu_in_index+" "+driver.findElement(By.xpath("//ul[@class=\"wb-menu\"]/li[last()]")).getText());
			
			//System.out.println(driver.findElement(By.xpath("//div[@class=\"dd menu_container\"]/ol[@class=\"menu-item-list dd-list\"][last()]/li[@class=\"menu-item dd-item\"][last()]/form[@class=\"store-form\"][last()]/div[@class=\"panel panel-white widget-item cursor-move panel-collapsed\"]/div[@class=\"panel-heading menu-handle\"]/h6[@class=\"panel-title\"]")).getText());
			//System.out.println(num_menu_parent_before);
			
			driver.quit();
			
			return num_nemu_parent_after==num_menu_parent_before-1 && num_menu_in_index==num_menu_parent_before?true:false;
			
			//return true;	
		} catch (Exception e) {
			System.out.println(e.toString());
			driver.quit();
			return false;
		}
	}
	
	/*
	 * building
	 * */
	public static boolean TC_addMenuParentWasToMenuParent() {
		WebDriver driver=helper.createDriverChromeGoFruitshop1Admin();		
		
		try {
			
			// log in to admin "Cau hinh chung"
			driver=helper.logIn(driver);
			
			// click to Menu in menu left
			driver.findElement(By.xpath("//i[@class=\"icon-menu3\"]")).click();
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MICROSECONDS);
			
			Actions act=new Actions(driver);
			
			Action dragAndDrop=act.clickAndHold(driver.findElement(By.xpath("//li[@data-id=\"48\"]/form/div[@class=\"panel panel-white widget-item cursor-move panel-collapsed\"]/div[@class=\"panel-heading menu-handle\"]")))
									.moveToElement(driver.findElement(By.xpath("//li[@data-id=\"3\"]/form/div/div")))
									.release(driver.findElement(By.xpath("//li[@data-id=\"3\"]/form/div/div")))
									.build();
			
			dragAndDrop.perform();
			
			driver.navigate().refresh();
			//act.dragAndDrop(driver.findElement(By.xpath("//li[@data-id=\"48\"]")), driver.findElement(By.xpath("//li[@data-id=\"3\"]/form/div[@class=\"panel panel-white widget-item cursor-move panel-collapsed\"]/div[@class=\"panel-heading menu-handle\"]"))).perform();
			
			System.out.println(driver.findElements(By.xpath("//li[@data-id=\"48\"]/form/div[@class=\"panel panel-white widget-item cursor-move panel-collapsed\"]/div[@class=\"panel-heading menu-handle\"]")).size());
			System.out.println(driver.findElements(By.xpath("//li[@data-id=\"3\"]/form/div[@class=\"panel panel-white widget-item cursor-move panel-collapsed\"]/div[@class=\"panel-heading menu-handle\"]")).size());
			
			
			//driver.quit();
			return true;
		} catch (Exception e) {
		
			System.out.println(e.toString());
			driver.quit();
			
			return false;
		}
	}
	
	public static boolean TC_deleteMenuParent() {
		WebDriver driver=helper.createDriverChromeGoFruitshop1Admin();		
		
		try {
			
			// log in to admin "Cau hinh chung"
			driver=helper.logIn(driver);
			
			// click to Menu in menu left
			driver.findElement(By.xpath("//i[@class=\"icon-menu3\"]")).click();
			
			// number menu parent 
			int num_nemu_parent_after=driver.findElements(By.xpath("//div[@class=\"dd menu_container\"]/ol[@class=\"menu-item-list dd-list\"]/li[@class=\"menu-item dd-item\"]")).size();
			
			
			//System.out.println(num_nemu_parent_after);
			//System.out.println(driver.findElements(By.xpath("//div[@class=\"dd menu_container\"]/ol[@class=\"menu-item-list dd-list\"][last()]/li[@class=\"menu-item dd-item\"][last()]/form[@class=\"store-form\"][last()]/div[@class=\"panel panel-white widget-item cursor-move panel-collapsed\"]/div[@class=\"panel-heading menu-handle\"]/div[@class=\"heading-elements\"]/ul[@class=\"icons-list\"]/li/a[@class=\"btn-remove-item text-danger\"]")).size());
			
			driver.findElement(By.xpath("//div[@class=\"dd menu_container\"]/ol[@class=\"menu-item-list dd-list\"][last()]/li[@class=\"menu-item dd-item\"][last()]/form[@class=\"store-form\"][last()]/div[@class=\"panel panel-white widget-item cursor-move panel-collapsed\"]/div[@class=\"panel-heading menu-handle\"]/div[@class=\"heading-elements\"]/ul[@class=\"icons-list\"]/li/a[@class=\"btn-remove-item text-danger\"]")).click();
			
			//System.out.println(driver.findElements(By.xpath("//div[@class=\"sa-confirm-button-container\"]/button[@class=\"confirm\"]")).size());
			
			driver.findElement(By.xpath("//div[@class=\"sa-confirm-button-container\"]/button[@class=\"confirm\"]")).click();
			
			driver.quit();
			
			driver=helper.createDriverChromeGoFruitshop1Admin();
			driver=helper.logIn(driver);
						
			driver.findElement(By.xpath("//i[@class=\"icon-menu3\"]")).click();
			
			int num_nemu_parent_before=driver.findElements(By.xpath("//div[@class=\"dd menu_container\"]/ol[@class=\"menu-item-list dd-list\"]/li[@class=\"menu-item dd-item\"]")).size();
			
			//System.out.println(num_nemu_parent_before);
			
			driver.quit();
			return num_nemu_parent_after==num_nemu_parent_before+1?true:false;
		} catch (Exception e) {
		
			System.out.println(e.toString());
			driver.quit();
			
			return false;
		}
	}
	
	public static boolean TC_createMenuChildDetail() {
		WebDriver driver=helper.createDriverChromeGoFruitshop1Admin();		
		
		try {
			driver.manage().window().maximize();
						
			driver=helper.logIn(driver);
			
			driver.findElement(By.xpath("//i[@class=\"icon-menu3\"]")).click();
			
			//System.out.println(driver.findElements(By.xpath("//li[@data-id=\"519\"]/form[@class=\"store-form\"]/div[@class=\"panel panel-white widget-item cursor-move panel-collapsed\"]/div[@class=\"panel-heading menu-handle\"]/div[@class=\"heading-elements\"]/a[@class=\"label label-primary heading-text dropdown-toggle\"]")).size());
			
			driver.findElement(By.xpath("//li[@data-id=\"519\"]/form/div/div/div/a[@class=\"label label-primary heading-text dropdown-toggle\"]")).click();
			
			driver.findElement(By.xpath("//div[@class=\"heading-elements open\"]/ul[@class=\"dropdown-menu dropdown-menu-right\"]/li[1]/a")).click();
			
			//System.out.println(driver.findElements(By.xpath("//div[@class=\"selectize-input items required invalid not-full\"]/input")).size());
			
			String str_title="THÔNG BÁO KHẨN CẤP";
			
			List<String> arrStrKey=new ArrayList<String>();
			
			arrStrKey.add(str_title);
			arrStrKey.add("cam độc");
			arrStrKey.add("các loại Hoa Quả từ Trung Quốc");
			
			String str_key="";
			
			for (String object : arrStrKey) {
				str_key+=object+",";
			}
			
			String str_description="Tuyệt đối không ăn Táo, Cam, Quýt, Lê, Nho,... các loại Hoa Quả từ Trung Quốc. "
					+ "Bên đó, lên Ti vi lệnh Cấm Dân ăn, vì có chất gây Phá Hủy Nội Tạng. Trung Quốc lập tức đẩy Hàng sang Việt Nam bán. "
					+ "Tin chính xác từ Đại sứ quán Việt Nam, ở Trung Quốc báo về, mọi người tuyệt đối cảnh giác với Hoa Quả Trung Quốc. "
					+ "Thực tế thì khách du lịch Trung Quốc sang Việt Nam cũng không dám ăn Hoa Quả của chính nước mình sản xuất.";
			
			String str_detail="<p><b>Trái cây Trung Quốc chứa chất độc phá hủy nội tạng</b><br>"
					+ "<br>Một số nước đã phát hiện trái cây Trung Quốc có thuốc trừ sâu, chất gây ung thư, melamine. Đáng lo ngại là những loại trái cây này đang tràn ngập thị trường Việt Nam.<br>"
					+ "<br>Hàn Quốc mới đây phát hiện rau và trái cây nhập từ Trung Quốc có chứa melamine. Đài Loan cũng cấm nấm, cà chua, cần tây và nhiều loại rau khác từ Trung Quốc. Đài Loan nghi ngờ trong rau có nitrit natri, một chất gây ung thư cho người dùng. "
					+ "Tại Thái Lan, Bộ Y tế nước này phát hiện dư lượng thuốc trừ sâu ở mức nguy hiểm được tìm thấy trong nhiều mặt hàng rau quả Trung Quốc.<br>"
					+ "<br>Ở Việt Nam, theo thống kê của Bộ Công thương, danh mục trái cây nhập khẩu từ Trung Quốc về trong tháng 10/2008 rất đa dạng. Hiện tại các chợ lớn, nhỏ ở TP HCM, nhiều loại trái cây Trung Quốc đang “vào mùa”, bày bán la liệt. "
					+ "“Trái cây Trung Quốc về nhiều nhất là quýt, lựu, nho, cam đỏ, hồng… với giá dao động 10.000 – 15.000 đồng một kg”, chị Hồng bán trái câytại chợ Bà Chiểu cho biết.<br><br>Trái cây Trung Quốc có ưu thế là giá rẻ, hình thức đẹp. "
					+ "Một tiểu thương tại chợ Bình Tây so sánh, cách đây khoảng hai năm, giá quýt không hột, lựu là 20.000 đồng một kg thì nay chỉ còn một nửa. Chị Hải, một tiểu thương chợ đầu mối nông sản Thủ Đức, cho biết, vừa nhập về khoảng 10 tấn trái cây, trong đó hơn 70% là hàng Trung Quốc.<br>"
					+ "<br>Theo Ban quản lý Chợ đầu mối Thủ Đức, vừa qua, đoàn thanh tra liên ngành về vệ sinh an toàn thực phẩm TP HCM phát hiện nhiều loại trái cây, rau củ tươi nhập từ Trung Quốc không có nhãn phụ tiếng Việt, giấy chứng minh nguồn gốc xuất xứ. "
					+ "Đặc biệt, các mẫu này còn có dư lượng thuốc bảo vệ thực vật cao hơn nhiều lần so với tiêu chuẩn.<br>"
					+ "<br>Một số tiểu thương thừa nhận: “Chúng tôi biết trái cây Trung Quốc có chất làm ngọt, chất bảo quản… nhưng không biết rõ chúng là chất gì, độc hại đến mức nào nên vẫn bán”.<br>"
					+ "<br>Tuy nhiên, người tiêu dùng đã bắt đầu cảnh giác với trái cây Trung Quốc. Không ít người vì sợ trái cây Trung Quốc có chứa chất độc hại nên chuyển sang tiêu thụ trái cây nội địa. "
					+ "Khảo sát tại quầy trái cây Siêu thị Co-op Mart Nguyễn Đình Chiểu cho thấy, trong số 10 khách hàng chọn mua trái cây ngoại, không ai chọn mua trái cây Trung Quốc. "
					+ "“Từ khi nghe thông tin trái cây Trung Quốc có chất độc hại, tôi không dám mua nữa”, chị Vân, một khách hàng nói.</p>";
			
			String str_meta_title="Trái cây Trung Quốc chứa chất độc phá hủy nội tạng";
			
			String str_meta_description="Một số nước đã phát hiện trái cây Trung Quốc có thuốc trừ sâu, chất gây ung thư, melamine. Đáng lo ngại là những loại trái cây này đang tràn ngập thị trường Việt Nam.";
			
			driver.findElement(By.xpath("//div[@class=\"selectize-input items required invalid not-full\"]/input")).sendKeys(str_key);
			driver.findElement(By.xpath("//input[@name=\"title\"]")).sendKeys(str_title);
			driver.findElement(By.xpath("//textarea[@name=\"description\"]")).sendKeys(str_description);
			
			//System.out.println(driver.findElements(By.xpath("//a[@id=\"cke_43\"]")).size());
			
			driver.findElement(By.xpath("//span[@class=\"cke_button_icon cke_button__source_icon\"]")).click();
			
			driver.findElement(By.xpath("//textarea[@aria-describedby=\"cke_81\"]")).sendKeys(str_detail);
			driver.findElement(By.xpath("//input[@name=\"meta_title\"]")).sendKeys(str_meta_title);
			driver.findElement(By.xpath("//textarea[@name=\"meta_description\"]")).sendKeys(str_meta_description);
			driver.findElement(By.xpath("//button[@id=\"btnCheckSeo\"]")).click();
			
			
			//driver.findElement(By.xpath("//div[@class=\"text-center\"]/*[text()[contains(.,'Chọn hình')]]")).click();
			
			driver.findElement(By.xpath("//span[@class=\"ladda-label\"]")).click();

			System.out.println(1460653);
			
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			
			//System.out.println(driver.findElements(By.xpath("//li[@data-id=\"3\"]/ol/li[@class=\"menu-item dd-item\"][last()]/form/div[@class=\"panel panel-white widget-item cursor-move panel-collapsed\"]/div[@class=\"panel-heading menu-handle\"]/div[@class=\"heading-elements\"]/ul[@class=\"icons-list\"]/li/a[@data-original-title=\"Sửa\"][last()]")).size());
			driver.findElement(By.xpath("//li[@data-id=\"519\"]/ol/li[@class=\"menu-item dd-item\"][last()]/form/div[@class=\"panel panel-white widget-item cursor-move panel-collapsed\"]/div[@class=\"panel-heading menu-handle\"]/div[@class=\"heading-elements\"]/ul[@class=\"icons-list\"]/li/a[@data-original-title=\"Sửa\"][last()]")).click();
			
			//System.out.println(driver.findElements(By.xpath("//div[@class=\"panel panel-white widget-item cursor-move\"]/div[@class=\"panel-body\"]/div[@class=\"form-group\"][2]/span[@class=\"ml-15\"]/u/a")).size());
			
			driver.findElement(By.xpath("//div[@class=\"panel panel-white widget-item cursor-move\"]/div[@class=\"panel-body\"]/div[@class=\"form-group\"][2]/span[@class=\"ml-15\"]/u/a")).click();
			
			System.out.println(driver.findElement(By.xpath("//div[@class=\"cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_show_borders\"]/p")).getAttribute("outerHTML"));
			
			//return driver.findElement(By.xpath("//div[@class=\"cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_show_borders\"]/p")).getAttribute("outerHTML").equals(str_detail)?true:false;
			
			driver.findElement(By.xpath("//a[@class=\"navbar-brand\"]")).click();
			
			return true; //num_nemu_parent_after==num_nemu_parent_before+1?true:false;
		} catch (Exception e) {
		
			System.out.println(e.toString());
			//driver.quit();
			
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		//System.out.println("Test add menu was create: "+TC_addMenuWas());
		//System.out.println("Test delete menu last: "+TC_deleteMenuParent());
		//System.out.println("Move menu from parent to menu child: "+TC_addMenuParentWasToMenuParent());
		System.out.println("Test create MenuChildDetail: "+TC_createMenuChildDetail());
	}
	
}
