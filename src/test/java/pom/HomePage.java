package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By searchInput = By.name("search");
    private final By searchButton = By.xpath("//*[@id=\"search\"]/span/button");

    public void searchProduct(String product){
        driver.findElement(searchInput).sendKeys(product);
        driver.findElement(searchButton).click();
    }

}
