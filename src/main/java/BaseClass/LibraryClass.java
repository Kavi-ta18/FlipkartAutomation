package BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibraryClass {
	
	protected static WebDriver driver;
    protected static Properties config = new Properties();
    public static final Logger logger = LogManager.getLogger(LibraryClass.class);
    // Load config.properties
    public static void loadConfig() {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/Configuration.Properties/Config.property");
            config.load(fis);
            logger.info("Read property file");
        } catch (IOException e) {
            System.out.println("Failed to load configuration: " + e.getMessage());
        }
    }
 
    // Initialize browser based on config
    public static void initializeBrowser() {
        loadConfig();
        String browser = config.getProperty("browser");
        int implicitWait = Integer.parseInt(config.getProperty("implicitWait", "10"));
 
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            logger.info("Launching Chrome browser..");
        }
        else if(browser.equalsIgnoreCase("firefox")){
        	 WebDriverManager.firefoxdriver().setup();
             driver = new FirefoxDriver();
        }

        // You can add other browsers like Firefox, Edge etc.
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        logger.info("Maximize the screen..");
    }
 
    // Open application using config URL
    public static void openApplication() {
        String url = config.getProperty("url");
        driver.get(url);
        logger.info("Navigated to the url");
    }
 
    // Close the browser
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            logger.info("Closed Browser");
        }

}
}
