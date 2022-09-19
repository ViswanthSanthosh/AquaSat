package baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() throws IOException {

		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"src/main/java/config/config.properties");
		prop.load(ip);

	}

	public static void initialization() {
		String browsername = prop.getProperty("browser");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName",browsername);
		capabilities.setCapability("enableVNC", true);
		capabilities.setCapability("enableVideo",true);
		capabilities.setCapability("enableLog",true);
		capabilities.setCapability("videoName","test1_video.mp4");
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}

//		if (browsername.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver",
//					"src/main/java/util/driver/chromedriver.exe");
//
//			driver = new ChromeDriver();
//		} else if (browsername.equals("firefox")) {
//			System.setProperty("webdriver.gecko.driver",
//					"src/main/java/util/driver/geckodriver.exe");
//			driver = new FirefoxDriver();
//			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		

		

		
	}

}
