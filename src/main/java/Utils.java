import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {
    public static ChromeDriver startBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
