package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchField;

    @FindBy(id = "nav-search-submit-text")
    public WebElement searchButton;

    @FindBy(css = "#search span > h1  div > span.a-color-state")
    public  WebElement searchResultText;

    public void enterSearchField(String product) {
        searchField.sendKeys(product);
    }
    public void clickSearchButton() {
        searchButton.click();
    }
}
