package HBTestingProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SayYesToFirstCommand {
    public final String DRIVER_PATH = "driver/chromedriver";
    public final String DRIVER_TYPE = "webdriver.chrome.driver";

    public final String BASE_URL = "https://www.hepsiburada.com";

    public final String XPATH_SEARCH_BAR = "//*[@id=\"SearchBoxOld\"]/div/div/div[1]/div[2]/input";
    public final String XPATH_SEARCH_BUTTON = "//*[@id=\"SearchBoxOld\"]/div/div/div[2]";
    public final String XPATH_SEARCH_PRODUCT = "huawei";
    public final String XPATH_SELECTED_PRODUCT = "/html/body/div[3]/main/div[2]/div/div/div/div/div[2]/section/div[1]/div[4]/div/div/div/div/ul/li[1]/div/a/div[2]/h3/div/p/span";
    public final String XPATH_REVIEWS_TAB = "//*[@id=\"productReviewsTab\"]";
    public final String XPATH_REVIEWS_TEXT = "Değerlendirmeler (0)";
    public final String XPATH_FIRST_YES_BUTTON = "//*[@id=\"hermes-voltran-comments\"]/div[3]/div[3]/div/div[1]/div[2]/div[5]/div[1]/div/button[1]";
    public final String XPATH_THANKS_TEXT = "//*[@id=\"hermes-voltran-comments\"]/div[3]/div[3]/div/div[1]/div[2]/div[5]/div[2]/span[2]";
    public final String XPATH_CLOSE_COOKIE = "/html/body/div[8]/img";
    public final String XPATH_LOCATION_ELEMENT = "//*[@id=\"hermes-voltran-comments\"]/div[3]/div[3]/div/div[1]";

    public WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty(DRIVER_TYPE, DRIVER_PATH);
        driver = new ChromeDriver(options);
        driver.get(BASE_URL);
    }

    @Test
    public void testYesToCommand() throws Exception {
        driver.findElement(By.xpath(XPATH_SEARCH_BAR)).sendKeys(XPATH_SEARCH_PRODUCT);
        driver.findElement(By.xpath(XPATH_SEARCH_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        driver.findElement(By.xpath(XPATH_SELECTED_PRODUCT)).click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        if (!driver.findElement(By.xpath(XPATH_REVIEWS_TAB)).getText().equals(XPATH_REVIEWS_TEXT)) {
            Thread.sleep(2000);
            driver.findElement(By.xpath(XPATH_REVIEWS_TAB)).click();

            ((Locatable) driver.findElement(By.xpath(XPATH_LOCATION_ELEMENT))).getCoordinates().inViewPort();

            driver.findElement(By.xpath(XPATH_CLOSE_COOKIE)).click();

            System.out.println(driver.findElement(By.xpath(XPATH_FIRST_YES_BUTTON)).getText());

            driver.findElement(By.xpath(XPATH_FIRST_YES_BUTTON)).click();
            System.out.println(driver.findElement(By.xpath(XPATH_THANKS_TEXT)).getText());
        }
    }

    @AfterClass
    public void afterClass() throws Exception {
        driver.quit();
    }
}
