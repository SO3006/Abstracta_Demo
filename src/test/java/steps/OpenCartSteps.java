package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.junit.Assertions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.CartPage;
import pom.HomePage;
import pom.SearchedProductPage;
import java.time.Duration;

import static org.junit.Assert.*;

public class OpenCartSteps  {

    private  WebDriver driver = Hooks.getDriver();
    private HomePage homePage;
    private SearchedProductPage searchedProductPage;
    private  CartPage cartPage;



    @Given("The Opencart site is displayed")
    public void userOnPage() {
        homePage = new HomePage(driver);
    }

    @When("^The user search for an \"([^\"]*)\"$")
    public void searchAProduct(String product) {
        homePage.searchProduct(product);
    }

    @And("Press the first Iphone item")
    public void pressTheIphone() {
        searchedProductPage = new SearchedProductPage(driver);
        searchedProductPage.lookForProduct();
    }

    @And("The user adds the Iphone to the cart")
    public void UserAddsTheIphoneToTheCart() throws InterruptedException  {
        searchedProductPage.clickOnButton();
        Thread.sleep(2000);
        searchedProductPage.clickOnCartLink();
    }

    @Then("The user verifies if the Iphone is on the cart")
    public void validateIfTheProductIsOnCart() {
        cartPage = new CartPage(driver);
        assertTrue("Price is not displayed", cartPage.priceDisplayed());
    }
    
    @And("the user removes the Iphone from the cart")
    public void removeItemFromCart() {
        cartPage.removeItem();
    }

    @Then("^The user validates if the page displays: \"([^\"]*)\"$")
    public void removedItemValidation(String expectedText) throws InterruptedException {
        Thread.sleep(2000);
        assertEquals(expectedText, cartPage.setItemRemovedText());
    }
}
