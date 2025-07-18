package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By productPrice = By.xpath("//*[@id=\"content\"]/div[2]/div/table/tbody/tr[4]/td[2]");
    private final By removeItemButton = By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[2]");
    private final By itemRemovedText = By.xpath("//*[@id=\"content\"]/p");

    public boolean priceDisplayed(){
        return driver.findElement(productPrice).isDisplayed();
    }
    public void removeItem(){
        driver.findElement(removeItemButton).click();
    }
    public String setItemRemovedText(){
        return driver.findElement(itemRemovedText).getText();
    }
}
