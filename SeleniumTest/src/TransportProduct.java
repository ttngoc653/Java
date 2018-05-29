import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TransportProduct {

	public static WebDriver gotoDetailOrder() {

		WebDriver driver=helper.createDriverChrome(helper.addressUrlAdmin());
		try {
			
			driver=helper.logIn(driver);
			
			driver.findElement(By.xpath("//i[@class=\"icon-cart5\"]")).click();
			
			driver.findElement(By.xpath("//a[@href=\""+helper.addressUrlAdmin()+"order\"]")).click();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return driver;
	}
	
	static String getShippingService(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id=\"giaohangtietkiem\"]")).getCssValue("display").equals("block")?"giaohangtietkiem":
			driver.findElement(By.xpath("//div[@id=\"giaohangnhanh\"]")).getCssValue("display").equals("block")?"giaohangnhanh":
				driver.findElement(By.xpath("//div[@id=\"shipchung\"]")).getCssValue("display").equals("block")?"shipchung":"custom";
		
	}
	
	public static boolean shipTuGiaoHang() {
		WebDriver driver=gotoDetailOrder();
		
		String noteShip="chứng tôi sẽ giao hàng cho bạn vào ngày mai hãy giữ điện thoại bạn cung cấp để cửa hàng liên hẹ bạn nhận hàng nhé. Thân ái";
		
		try {

			new Select(driver.findElement(By.xpath("//select[@name=\"status\"]"))).selectByVisibleText("Mới");
			
			Thread.sleep(500);
			
			//System.out.println(driver.findElements(By.xpath("//table[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[1]/a")).size());
			
			driver.findElement(By.xpath("//table[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[1]/a")).click();
			
			driver.findElement(By.xpath("//button[@data-target=\"#delivery\"]")).click();
						
			driver.findElement(By.xpath("//div[@id=\""+getShippingService(driver)+"\"]/form[@id=\"delivery-form\"]/div[1]/textarea[@name=\"note\"]")).click();			
			driver.findElement(By.xpath("//div[@id=\""+getShippingService(driver)+"\"]/form[@id=\"delivery-form\"]/div[1]/textarea[@name=\"note\"]")).sendKeys(noteShip);
			
			driver.findElement(By.xpath("//div[@id=\""+getShippingService(driver)+"\"]/form[@id=\"delivery-form\"]/div[@class=\"modal-footer\"]/div[@class=\"col-sm-6\"]/button[@class=\"btn btn-info btn-create-shipping-order\"]")).click();
			
			Thread.sleep(10000);
			
			System.out.println(driver.findElement(By.xpath("//div[@class=\"col-md-8\"]/div[@class=\"panel panel-flat\"][2]/div[@class=\"panel-body\"]/div[@class=\"table-responsive\"]/table[@class=\"table table-bordered\"]/tbody/tr/td[1]")).getText());
			System.out.println(driver.findElement(By.xpath("//div[@class=\"col-md-8\"]/div[@class=\"panel panel-flat\"][2]/div[@class=\"panel-body\"]/div[@class=\"table-responsive\"]/table[@class=\"table table-bordered\"]/tbody/tr/td[2]")).getText().contains(noteShip));
			System.out.println(driver.findElement(By.xpath("//div[@class=\"col-md-8\"]/div[@class=\"panel panel-flat\"][2]/div[@class=\"panel-body\"]/div[@class=\"table-responsive\"]/table[@class=\"table table-bordered\"]/tbody/tr/td[3]")).getText()==noteShip);
			
			int id_order=Integer.parseInt(driver.findElement(By.xpath("//div[@id=\"orderDetailPanel\"]")).getAttribute("data-id"));
			
			driver.close();
			
			System.out.println("DELETE SHIPPING: "+quitShip(id_order));
			
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return false;
	}
	
	public static boolean quitShip(int id_order) {
		if(id_order==-1) return false;
		
		WebDriver driver=helper.createDriverChrome(helper.addressUrlAdmin()+"order/"+id_order);
		try {
			driver=helper.logIn(driver);
			
			driver.navigate().to(helper.addressUrlAdmin()+"order/"+id_order);
			
			driver.findElement(By.xpath("//button[@id=\"btnCancelShipping\"]")).click();
			
			Thread.sleep(1000);
			
			new Select(driver.findElement(By.xpath("//select[@class=\"form-control order_status\"]"))).selectByVisibleText("Mới");
			System.out.println("DON'T SHIPPING ORDER "+id_order);
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
		
	}
	
	static String getMoney(String text) {
		
		for (int i = 0; i < text.length(); i++) {
			if(text.charAt(i)>='0' && text.charAt(i)<='9') return text.substring(i,i+5+ (text.charAt(i+5)==' '?0:text.charAt(i+6)==' '?1:text.charAt(i+8)==' '?3:text.charAt(i+9)==' '?4:text.charAt(i+10)==' '?5:6));
		}
		return "";
	}
	
	static void changeWeight(WebDriver driver,String str_weight) {
		try {
			driver.findElement(By.xpath("//div[@id=\""+getShippingService(driver)+"\"]/form[@id=\"delivery-form\"]/div/div/div/div/div/input[@name=\"weight\"]")).clear();			
			driver.findElement(By.xpath("//div[@id=\""+getShippingService(driver)+"\"]/form[@id=\"delivery-form\"]/div/div/div/div/div/input[@name=\"weight\"]")).sendKeys(str_weight);	
		} catch (Exception e) {	System.out.println(e.toString());}
	}
	
	public static boolean shipGiaoHangTietKiemNormal() {
		WebDriver driver=gotoDetailOrder();
		
		try {

			new Select(driver.findElement(By.xpath("//select[@name=\"status\"]"))).selectByVisibleText("Mới");
			
			Thread.sleep(1000);
			
			//System.out.println(driver.findElements(By.xpath("//table[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[1]/a")).size());
			
			driver.findElement(By.xpath("//table[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[1]/a")).click();
			
			driver.findElement(By.xpath("//button[@data-target=\"#delivery\"]")).click();
			
			new Select(driver.findElement(By.xpath("//select[@id=\"service_shipping\"]"))).selectByValue("giaohangtietkiem");
			
			String service_transport=(new Select(driver.findElement(By.xpath("//select[@id=\"service_shipping\"]"))).getFirstSelectedOption().getText());
			
			Thread.sleep(1000);
			
			changeWeight(driver,"2000");
			
			Thread.sleep(5000);
			
			Select slt = new Select(driver.findElement(By.xpath("//div[@id=\""+getShippingService(driver)+"\"]/form[@id=\"delivery-form\"]/div/div/select[@name=\"service_id\"]")));
			if(2>slt.getOptions().size()) System.out.println("OPTION UNDER REQUEST!");
			slt.selectByIndex(2 % slt.getOptions().size());
			
			String fee_transport_install=getMoney(new Select(driver.findElement(By.xpath("//div[@id=\""+getShippingService(driver)+"\"]/form[@id=\"delivery-form\"]/div/div/select[@name=\"service_id\"]"))).getFirstSelectedOption().getText());
						
			driver.findElement(By.xpath("//div[@id=\""+getShippingService(driver)+"\"]/form[@id=\"delivery-form\"]/div[@class=\"modal-footer\"]/div[@class=\"col-sm-6\"]/button[@class=\"btn btn-info btn-create-shipping-order\"]")).click();
			
			Thread.sleep(10000);
			
			boolean result=true;
			
			if(!driver.findElement(By.xpath("//div[@class=\"col-md-8\"]/div[@class=\"panel panel-flat\"][2]/div[@class=\"panel-body\"]/div[@class=\"table-responsive\"]/table[@class=\"table table-bordered\"]/tbody/tr/td[1]")).getText().equals(service_transport)) {
				System.out.println("INFORMATION TRANSPORT GIAOHANGTIETKIEM:  INCORRECT SERVICE");
				result=false;
			}if (!driver.findElement(By.xpath("//div[@class=\"col-md-8\"]/div[@class=\"panel panel-flat\"][2]/div[@class=\"panel-body\"]/div[@class=\"table-responsive\"]/table[@class=\"table table-bordered\"]/tbody/tr/td[3]")).getText().contains(fee_transport_install)) {
				System.out.println("INFORMATION TRANSPORT GIAOHANGTIETKIEM:  INCORRECT FEE");
				result=false;
			}
			
			
			int id_order=Integer.parseInt(driver.findElement(By.xpath("//div[@id=\"orderDetailPanel\"]")).getAttribute("data-id"));
			
			driver.close();
			
			quitShip(id_order);
			
			return result;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return false;
	}

	public static boolean shipShipchunghNormal() {
		WebDriver driver=gotoDetailOrder();
		
		try {

			new Select(driver.findElement(By.xpath("//select[@name=\"status\"]"))).selectByVisibleText("Mới");
			
			Thread.sleep(1000);
			
			//System.out.println(driver.findElements(By.xpath("//table[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[1]/a")).size());
			
			driver.findElement(By.xpath("//table[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[1]/a")).click();
			
			driver.findElement(By.xpath("//button[@data-target=\"#delivery\"]")).click();
			
			new Select(driver.findElement(By.xpath("//select[@id=\"service_shipping\"]"))).selectByValue("giaohangnhanh");
			
			String service_transport=(new Select(driver.findElement(By.xpath("//select[@id=\"service_shipping\"]"))).getFirstSelectedOption().getText());
			
			Thread.sleep(1000);
			
			changeWeight(driver,"2000");
			
			Thread.sleep(5000);
			
			Select slt = new Select(driver.findElement(By.xpath("//div[@id=\""+getShippingService(driver)+"\"]/form[@id=\"delivery-form\"]/div/div/select[@name=\"service_id\"]")));
			
			int option_service_transport=1;
			
			if(option_service_transport>slt.getOptions().size()) System.out.println("OPTION UNDER REQUEST!");
			
			slt.selectByIndex(option_service_transport % slt.getOptions().size());
			
			String fee_transport_install=getMoney(new Select(driver.findElement(By.xpath("//div[@id=\""+getShippingService(driver)+"\"]/form[@id=\"delivery-form\"]/div/div/select[@name=\"service_id\"]"))).getFirstSelectedOption().getText());
						
			driver.findElement(By.xpath("//div[@id=\""+getShippingService(driver)+"\"]/form[@id=\"delivery-form\"]/div[@class=\"modal-footer\"]/div[@class=\"col-sm-6\"]/button[@class=\"btn btn-info btn-create-shipping-order\"]")).click();
			
			Thread.sleep(10000);
			
			boolean result=true;
			
			if(!driver.findElement(By.xpath("//div[@class=\"col-md-8\"]/div[@class=\"panel panel-flat\"][2]/div[@class=\"panel-body\"]/div[@class=\"table-responsive\"]/table[@class=\"table table-bordered\"]/tbody/tr/td[1]")).getText().equals(service_transport)) {
				System.out.println("INFORMATION TRANSPORT GIAOHANGTIETKIEM:  INCORRECT SERVICE");
				result=false;
			}if (!driver.findElement(By.xpath("//div[@class=\"col-md-8\"]/div[@class=\"panel panel-flat\"][2]/div[@class=\"panel-body\"]/div[@class=\"table-responsive\"]/table[@class=\"table table-bordered\"]/tbody/tr/td[3]")).getText().contains(fee_transport_install)) {
				System.out.println("INFORMATION TRANSPORT GIAOHANGTIETKIEM:  INCORRECT FEE");
				result=false;
			}
			
			int id_order=Integer.parseInt(driver.findElement(By.xpath("//div[@id=\"orderDetailPanel\"]")).getAttribute("data-id"));
			
			driver.close();
			
			quitShip(id_order);
			
			return result;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return false;
	}
	
	public static boolean shipGiaoHangNhanhNormal() {
		WebDriver driver=gotoDetailOrder();
		
		try {

			new Select(driver.findElement(By.xpath("//select[@name=\"status\"]"))).selectByVisibleText("Mới");
			
			Thread.sleep(1000);
			
			//System.out.println(driver.findElements(By.xpath("//table[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[1]/a")).size());
			
			driver.findElement(By.xpath("//table[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[1]/a")).click();
			
			driver.findElement(By.xpath("//button[@data-target=\"#delivery\"]")).click();
			
			new Select(driver.findElement(By.xpath("//select[@id=\"service_shipping\"]"))).selectByValue("giaohangnhanh");
			
			String service_transport=(new Select(driver.findElement(By.xpath("//select[@id=\"service_shipping\"]"))).getFirstSelectedOption().getText());
			
			Thread.sleep(1000);
			
			changeWeight(driver,"2000");
			
			Thread.sleep(5000);
			
			Select slt = new Select(driver.findElement(By.xpath("//div[@id=\""+getShippingService(driver)+"\"]/form[@id=\"delivery-form\"]/div/div/div/div/div/select[@name=\"service_id\"]")));
			
			if(2>slt.getOptions().size()) System.out.println("OPTION UNDER REQUEST!");
			
			slt.selectByIndex(2 % slt.getOptions().size());
			
			String fee_transport_install=getMoney(new Select(driver.findElement(By.xpath("//div[@id=\""+getShippingService(driver)+"\"]/form[@id=\"delivery-form\"]/div/div/div/div/div/select[@name=\"service_id\"]"))).getFirstSelectedOption().getText());
						
			driver.findElement(By.xpath("//div[@id=\""+getShippingService(driver)+"\"]/form[@id=\"delivery-form\"]/div[@class=\"modal-footer\"]/div[@class=\"col-sm-6\"]/button[@class=\"btn btn-info btn-create-shipping-order\"]")).click();
			
			Thread.sleep(10000);
			
			boolean result=true;
			
			if(!driver.findElement(By.xpath("//div[@class=\"col-md-8\"]/div[@class=\"panel panel-flat\"][2]/div[@class=\"panel-body\"]/div[@class=\"table-responsive\"]/table[@class=\"table table-bordered\"]/tbody/tr/td[1]")).getText().equals(service_transport)) {
				System.out.println("INFORMATION TRANSPORT GIAOHANGTIETKIEM:  INCORRECT SERVICE");
				result=false;
			}if (!driver.findElement(By.xpath("//div[@class=\"col-md-8\"]/div[@class=\"panel panel-flat\"][2]/div[@class=\"panel-body\"]/div[@class=\"table-responsive\"]/table[@class=\"table table-bordered\"]/tbody/tr/td[3]")).getText().contains(fee_transport_install)) {
				System.out.println("INFORMATION TRANSPORT GIAOHANGTIETKIEM:  INCORRECT FEE");
				result=false;
			}
			
			int id_order=Integer.parseInt(driver.findElement(By.xpath("//div[@id=\"orderDetailPanel\"]")).getAttribute("data-id"));
			
			driver.close();
			
			quitShip(id_order);
			
			return result;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return false;
	}
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(shipTuGiaoHang());
		//System.out.println(shipGiaoHangTietKiemNormal());
		//System.out.println(shipGiaoHangNhanhNormal());
	}

}
