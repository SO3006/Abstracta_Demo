package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import runner.browser_manager.DriverManager;
import runner.browser_manager.DriverManagerFactory;
import runner.browser_manager.DriverType;

public class Hooks {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private DriverManager driverManager;

    @Before
    public void setUp(){
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver.set(driverManager.getDriver());
        driver.get().get("http://opencart.abstracta.us/");
        driver.get().manage().window().maximize();
    }

    @After
    public void close(){
        driverManager.quitDriver();}

    public static WebDriver getDriver(){return driver.get();}
}
