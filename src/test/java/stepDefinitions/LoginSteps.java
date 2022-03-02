package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPage;
import stepDefinitions.BaseClass;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class LoginSteps extends BaseClass{
    public WebDriver driver;
    public LoginPage lp;


    @Given("User launches chrome browser")
    public void user_launches_chrome_browser() {
        logger = Logger.getLogger("nopCommerce");
PropertyConfigurator.configure("log4j.properties");


        System.setProperty("webdriver.chrome.driver","C:\\Users\\bsirivella\\chromedriver_win32 (2)\\chromedriver.exe");
       // WebDriverManager.chromedriver().setup();
        logger.info("***  Launching chrome browser   ***");
        driver = new ChromeDriver();
        lp = new LoginPage(driver);
    }
    @When("User opens URL {string}")
    public void user_opens_url(String weburl) {
        logger.info("***  opening website url in chrome browser   ***");
        driver.get(weburl);
    }
    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) throws InterruptedException {
        logger.info("***  Entering email and password   ***");
        lp.setUserName(email);
       lp.setPassword(password);
        Thread.sleep(1000);
    }
    @When("click on Login")
    public void click_on_login() throws InterruptedException {
        logger.info("***  Clicking on log in button   ***");
        lp.clickLogin();
       Thread.sleep(3000);
    }
    @Then("Page title should be {string}")
    public void page_title_should_be(String title) {
        logger.info("***  Verifying page title   ***");
        if (driver.getPageSource().contains("Login was unsuccessful."))
     {
         driver.close();
         Assert.assertTrue(false);}
         else
         {

             Assert.assertEquals(title,driver.getTitle());
             System.out.println("title matches");
         }
    }


    @When("User click on Log out link")
    public void user_click_on_log_out_link() throws InterruptedException {
        logger.info("***  Clicking on Logout button   ***");
        Thread.sleep(1000);
        lp.clickLogout();
        Thread.sleep(3000);
    }

    @Then("close browser")
    public void close_browser() throws InterruptedException {
        logger.info("***  Closing the chrome browser   ***");
        Thread.sleep(3000);
       System.out.println("LOGGING OUT");
        driver.close();
    }
}
