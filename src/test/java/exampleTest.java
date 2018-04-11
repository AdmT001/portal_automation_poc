import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.RectangleSize;


public class exampleTest {

    private WebDriver driver;

    //Test case
    @Test
    public void portalTest() throws InterruptedException {
        //Navigat to given url on localhost
        driver.get("https://sitebuilder.panasonic.aero/previews/bbe843c4-7018-4b49-81f9-1416d85467ff/index.html");
        //Wait page to load
        Thread.sleep(4000);
        //Getting the title of the page
        String title = driver.getTitle();
        //Check if we are on the right page
        Assert.assertTrue(title.contains("China Southern Airlines"));
        //Open language switch drop down menu
        driver.findElement(By.xpath("//*[@id=\"itk-wrapper\"]/header/div/div/div/div[2]/div/div[1]/div")).click();
        Thread.sleep(2000);
        //Select English
        driver.findElement(By.xpath("//*[@id=\"itk-wrapper\"]/header/div/div/div/div[2]/div/div[2]/ul/li[1]")).click();
        Thread.sleep(4000);
        //Go to "Information News" page
        driver.findElement(By.xpath("//*[@id=\"itk-wrapper\"]/nav/ul/li[2]/a")).click();
        Thread.sleep(4000);
        //Click on "Food" article in news
        driver.findElement(By.xpath("//*[@id=\"itk-wrapper\"]/main/div/div/div/div/div[2]/div/div/div[1]/a/img")).click();
        //Wait a while before test is over
        Thread.sleep(10000);
    }

    @Test
    public void visualCorrectnes() throws InterruptedException {

        //Using applitools to do this visual correctenes check
        Eyes eyes = new Eyes();
        eyes.setApiKey("M24HNo5mBn2rKfWDO3hYxnjHwetwC7rliAkifZ105Ib34110");

        //Navigate to the url what we want to check
        eyes.open(driver, "Visual Correctnes", "Visual test");
        driver.get("https://sitebuilder.panasonic.aero/previews/bbe843c4-7018-4b49-81f9-1416d85467ff/index.html");

        //This line bellow only used for the first time when we want to mak a reference image
        //eyes.checkWindow();

        //Change site language
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"itk-wrapper\"]/header/div/div/div/div[2]/div/div[1]/div")).click();
        Thread.sleep(1000);
        //Select English
        driver.findElement(By.xpath("//*[@id=\"itk-wrapper\"]/header/div/div/div/div[2]/div/div[2]/ul/li[1]")).click();
        Thread.sleep(3000);
        //Take screen shoot from the state of the site and compare it with the reference image
        eyes.checkWindow();
        eyes.close();
    }

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
    }


    @AfterTest(alwaysRun = true)
    public void afterTest() {
        driver.quit();
    }
}