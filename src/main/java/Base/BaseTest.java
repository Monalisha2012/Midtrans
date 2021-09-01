package Base;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    public BasePage basepage;
    public Properties prop;
    public WebDriver driver;
    public HomePage homepage;


    @BeforeMethod
    public void setUp() {

        basepage = new BasePage();
        prop = basepage.init_prop();
        String browser = prop.getProperty("browser");
        driver = basepage.init_driver(browser);
        homepage = new HomePage(driver);
        driver.get(prop.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



}