
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import org.junit.Assert;

public class SearchStep {
    private WebDriver driver;
    @Before
    public void StartUp() {
        //Start Browser
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() {
        //Close driver
        driver.close();
        driver.quit();
    }
    @Given("I navigate to the home page")
    public void ıNavigateToTheHomePage()throws Throwable{
        driver.navigate().to("https://www.amazon.com.tr/");
    }
    @When("I enter keyword {string} to search bar")
    public void ıEnterKeywordToSearchBar(String arg0) {
        HomePage homePage = new HomePage(driver);
        homePage.enterSearchField("laptop");
    }

    @And("I click on search button")
    public void ıClickOnSearchButton() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSearchButton();
    }

    @Then("I should see search results for {string} keyword successfully")
    public void ıShouldSeeSearchResultsForKeywordSuccessfully(String searchResult) {
        HomePage homePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(homePage.searchResultText));
        String result = homePage.searchResultText.getText();
        Assert.assertTrue(result.contains(searchResult));
    }
}
