package baseFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	public WebDriver driver;
	public WebDriver InitilizeDriver() throws IOException {
	Properties Prop = new Properties();
	FileInputStream fs = new FileInputStream("C:\\Users\\kratika.malik\\eclipse-workspace\\automationPrac1\\src\\main\\java\\Data\\data.properties");
	Prop.load(fs);
	String browserName = Prop.getProperty("browser");
	//-- Kratika\\Malik\\eclipse\\Chrome
	if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Kratika\\Malik\\eclipse\\Chrome Driver\\CD\\chromedriver.exe");

		 driver = new ChromeDriver();
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	}
}
	