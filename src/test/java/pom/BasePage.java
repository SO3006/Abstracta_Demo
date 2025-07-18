package pom;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void click(WebElement element){
        try{
            element.click();
        } catch (Exception e) {
            throw new RuntimeException("Could not perform click into the element " + e);
        }
    }

    public boolean waitForElement(WebElement element, WebDriverWait wait){
        boolean unfound = false;
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            unfound = true;
        }
        return unfound;
    }
}
