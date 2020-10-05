package HBTestingProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EnterToMyList {

    public final String DRIVER_PATH = "driver/chromedriver";
    public final String DRIVER_TYPE = "webdriver.chrome.driver";
    public final String EMAIl_OWN_PATH = "yourmailadress";
    public final String PASSWORD_PATH = "//*[@id=\"txtPassword\"]";
    public final String PASSWORD = "yourpassword";
    public final String ENTER_ID = "btnLogin";
    public final String MY_LIST_PATH = "//*[@id=\"myAccount\"]/div/div[2]/ul/li[5]";
    public final String MY_ACCOUNT_ID = "myAccount";
    public final String ACCOUNT_NAME_PATH = "//*[@id=\"AccountMenu\"]/div/div/div[1]/div/div[1]/div[2]/strong";

    public final String EMAIL_PATH = "//*[@id=\"txtUserName\"]";
    public final String BASE_URL = "https://giris.hepsiburada.com/?ReturnUrl=https%3A%2F%2Foauth.hepsiburada.com%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3DSPA%26redirect_uri%3Dhttps%253A%252F%252Fwww.hepsiburada.com%252Fuyelik%252Fcallback%26response_type%3Dcode%26scope%3Dopenid%2520profile%26state%3Db51887314e0e40d3bebe8c4206bbfc57%26code_challenge%3D_IFWvWI8lD-u_4wpNpLw6FRwBof_78Tu0w4_GWc_umE%26code_challenge_method%3DS256%26response_mode%3Dquery\n";
    public static WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty(DRIVER_TYPE, DRIVER_PATH);
        driver = new ChromeDriver(options);
        driver.get(BASE_URL);
    }

    @Test
    public void ToMyList(){
        driver.findElement(By.xpath(EMAIL_PATH)).sendKeys(EMAIl_OWN_PATH);
        driver.findElement(By.xpath(PASSWORD_PATH)).sendKeys(PASSWORD);
        driver.findElement(By.id(ENTER_ID)).click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

        driver.findElement(By.id(MY_ACCOUNT_ID)).click();
        driver.findElement(By.xpath(MY_LIST_PATH)).click();
        driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
        System.out.println(driver.findElement(By.xpath(ACCOUNT_NAME_PATH)).getText());

    }

    @AfterClass
    public void afterClass() throws Exception {
        driver.quit();
    }
}
