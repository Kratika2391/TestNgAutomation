package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseFile.base;

//import base.base;


public class ProductsPage extends base {
	
	
	//@SuppressWarnings("unlikely-arg-type")
	/*public boolean addProducts() throws IOException {
		
		Properties Prop = new Properties();
		FileInputStream fs = new FileInputStream("C:\\Users\\kratika.malik\\eclipse-workspace\\automationPrac1\\src\\main\\java\\Data\\ProductsPage.properties");
		Prop.load(fs);
		//Fetching prop values from loginPage property file
		String URL = Prop.getProperty("URL");
		String productName = Prop.getProperty("productName");
		int productQuantity = Integer.parseInt(Prop.getProperty("productQuantity"));
		driver = InitilizeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		String productNamePage = driver.findElement(By.xpath("//h4[@class='product-name']")).getText();//apply loop
		if(productNamePage.equalsIgnoreCase(productName)) {//doubt with name
			for(int i=1;i<=productQuantity-1;i++) {
			driver.findElement(By.className("increment")).click();
			}
			
			driver.findElement(By.xpath("//button[contains(text(),'ADD TO CART')]")).click();
			driver.findElement(By.className("cart-icon")).click();
			if(!(driver.findElement(By.className("product-name")).getText().equalsIgnoreCase(productName))) {
				return false;	
			}
				driver.findElement(By.xpath("//*[contains(text(),'PROCEED TO CHECKOUT')]")).click();
				driver.findElement(By.xpath("//*[contains(text(),'Place Order')]")).click();
				
				WebElement country = driver.findElement(By.xpath("//div[@class='products-wrapper']/div/div/div/select"));
				Select dropDown = new Select(country);
				String countryName = Prop.getProperty("countryName");
				dropDown.selectByVisibleText(countryName);
				driver.findElement(By.xpath("//input[@class='chkAgree']")).click();
				
			if(driver.findElement(By.xpath("//input[@class='chkAgree']")).isSelected()) {
				driver.findElement(By.xpath("//*[contains(text(),'Proceed')]")).click();
			}
			
			}
		
		
		return false;
		
	}*/
	
	public boolean addProducts2() throws IOException {
		Properties Prop = new Properties();
		FileInputStream fs = new FileInputStream("C:\\Users\\kratika.malik\\eclipse-workspace\\automationPrac1\\src\\main\\java\\Data\\ProductsPage.properties");
		Prop.load(fs);
		//Fetching prop values from loginPage property file
		String URL = Prop.getProperty("URL");
		
		driver = InitilizeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		String productName1 = Prop.getProperty("productName1");
		String quantity1 =Prop.getProperty("productQuantity1");
		String pruductName2 = Prop.getProperty("productName2");
		String quanitity2 = Prop.getProperty("productQuantity2");
		
		addProductToCart(productName1,quantity1);
		addProductToCart(pruductName2,quanitity2);
		
		WebElement cartButton = driver.findElement(By.xpath("//a[@class='cart-icon']"));
		cartButton.click();
		
		WebElement proceedtoCheckoutElement = driver.findElement(By.xpath("//div[@class='action-block']"));
		proceedtoCheckoutElement.click();
		
		
		
		WebElement proceedButton = driver.findElement(By.xpath("//button[@id='proceed']"));
		proceedButton.click();
		
		WebElement logoOfWebsiteElement = driver.findElement(By.xpath("//button[@id='logo ki xpath']"));
		String logoText = logoOfWebsiteElement.getText();
		if(logoText.equals(Prop.getProperty("logotext"))) {
		return true;
		}
		
		return false;
		
	}

	void addProductToCart(String productName, String quantity) {
		List<WebElement> productList = driver.findElements(By.xpath("//h4[@class='product-name']"));
	
		for(WebElement myProduct : productList) {
			if(myProduct.getText().contains(productName)) {
				List<WebElement> quanityTextboxes = myProduct.findElements(By.xpath(".//following::input[@class='quantity']"));
				quanityTextboxes.get(0).clear();
				quanityTextboxes.get(0).sendKeys(quantity);
				
				List<WebElement> addToCartButtons = myProduct.findElements(By.xpath(".//following::button[@type='button']"));
				addToCartButtons.get(0).click();
		                        
			}
		}
	}
}
