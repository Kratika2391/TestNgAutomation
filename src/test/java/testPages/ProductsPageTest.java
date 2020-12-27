package testPages;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseFile.base;
import pages.ProductsPage;

public class ProductsPageTest extends base {	
	ProductsPage lp = new ProductsPage();
	@Test
	public void isLoginSuccess() throws IOException {
	
		Assert.assertTrue(lp.addProducts2(), "Login Scenario failed");
	}
}
