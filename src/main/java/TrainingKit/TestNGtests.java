package TrainingKit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class TestNGtests {
    private WebDriver driver = new ChromeDriver();




    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        driver.get("https://www.register.com");
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }

    @Test
    public void LoginToWebpage() throws Exception {

        //Find the login tab on the page and click the login tab

        WebElement clickLoginTab = driver.findElement(By.id("log-in"));
        Thread.sleep(2000);
        clickLoginTab.click();
    }

    @Test
    public void SearchforDomain() throws InterruptedException {
        // Search for a domain the search bar on the Home page

        WebElement SearchField = driver.findElement(By.id("hp-searchInput"));
        SearchField.clear();
        SearchField.sendKeys("biochemical.com");
        Thread.sleep(2000);

        WebElement searchButton = driver.findElement(By.id("domainSearch"));
        searchButton.click();

        WebDriverWait toWait = new WebDriverWait(driver,30);

        WebElement secondSearchField = toWait.until(presenceOfElementLocated(By.id("SearchedDomain")));
        WebElement secondDomainButton = toWait.until(presenceOfElementLocated(By.xpath("//input[@value='Search Domains']")));

        WebElement notFoundDomain = toWait.until(presenceOfElementLocated(By.xpath("//span[@class='not-avail']")));
        WebElement isAvailableDomain = toWait.until(presenceOfElementLocated(By.xpath("//h1[@class='congrats']")));
        WebElement addToCartButton = toWait.until(presenceOfElementLocated(By.xpath("//input[@class='button btn-standard addDomainToCart']")));

        if (notFoundDomain.isDisplayed()) {
            secondSearchField.sendKeys("biochemistry.solutions");
            secondDomainButton.click();
        } else if(isAvailableDomain.isDisplayed()) {
            addToCartButton.click();
        }
    /*
        Assert.assertEquals(driver.findElement(By.id("biochemical.online-action")).isDisplayed());
            domainAvailableButton.click();
            SearchedDomain
            Search Domains
*/


    }



    @Test
    public void signIntoHostingAccount() throws Exception {

        LoginToWebpage();

        //Find the dropdown button on the page
        WebElement dropDownButton = driver.findElement(By.className("selectButton"));

        //Click the dropdown button on the page
        dropDownButton.click();
        Thread.sleep(2000);

        //Select Web Hosting Account from the Drop down list
        WebElement AccountMangerDropDown = driver.findElement(By.xpath("//a[text()=\"Web Hosting Account\"]"));

        // Click the Web hosting account from the drop down list
        AccountMangerDropDown.click();
        Thread.sleep(2000);
    }
    @Test
    public void clickButtonToAcceptCookies() throws Exception {
        //Scroll down to the bottom of the page and locate the "GOT IT" button to consent to the use of site cookies

        signIntoHostingAccount();

        WebElement gotItButton = driver.findElement(By.xpath("//button[@class=\"optanon-allow-all accept-cookies-button\"]"));
        Thread.sleep(2000);

        // click the "GOT IT" button to consent to use site cookies
        gotItButton.click();

    }
    @Test
    public void AccessAffiliatePage() throws Exception {

        clickButtonToAcceptCookies();

        //locate the "Partner with Register.com" paragraph
        WebElement paragraph = driver.findElement(By.xpath("//p[text()=\"Partner with Register.com\"]"));

        //Scroll action the page to bring the "Partner with Register.com" paragraph to view
        Actions action = new Actions(driver);
        action.moveToElement(paragraph);
        Thread.sleep(2000);

        //locate affiliate link with paragraph and click on the Affiliate link
        WebElement affiliate_link = driver.findElement(By.linkText("Become an Affiliate"));
        affiliate_link.click();
        Thread.sleep(1000);
    }


}
