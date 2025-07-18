package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchedProductPage extends BasePage {

    public SearchedProductPage(WebDriver driver) {
        super(driver);
    }


    private final By productSelected = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a");
    private final By addtoCartButton = By.id("button-cart");
    private final By goToCartLink = By.xpath("/html/body/div[2]/div[1]/a[2]");


    public void lookForProduct(){
      driver.findElement(productSelected).click();
    }

    public void clickOnButton(){
        driver.findElement(addtoCartButton).click();
    }

    public void clickOnCartLink(){
        driver.findElement(goToCartLink).click();
    }
}

