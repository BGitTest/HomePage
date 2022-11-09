package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
//import java.time.Duration;

public class HomePage
{
    protected static WebDriver driver;

  @ BeforeMethod
    public void openBrowser()
    {
        // It allows system property to have the value
        System.setProperty("webDriver.chrome.driver", "src/test/java/chromedriver.exe");

        //calling particular browser and it should execute without any issue
        driver = new ChromeDriver();

        // manage() - returns instance of options,
        // window() - returns instance of window and
        // maximize() - this method is used to maximize
        driver.manage().window().maximize();

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //opening homepage with .get
        driver.get("https://demo.nopcommerce.com/");
    }

       public String timeStampMethod()
    {
        // To get the Unique ID
       return new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());

    }

    public void clickMethod(By by)
    {
        driver.findElement(by).click();
    }

    public String gettingTextFromElement(By by)
    {
     return driver.findElement(by).getText();
    }

    public void enterTextWithSendKeys(By by, String text)
    {
         driver.findElement(by).sendKeys(text);
    }

 @ Test
    public void basePage()
    {

        // Clicking the Register button
        clickMethod(By.className("ico-register"));
        // driver.findElement(By.className("ico-register")).click();

        // Using click method to choose radio button of female
        clickMethod(By.xpath("//label[@for=\"gender-female\"]"));

        // Filling out the First name by sending the keys
        enterTextWithSendKeys(By.id("FirstName"),"Bhavi");

        // Filling out the Last name by sending the keys
       enterTextWithSendKeys(By.id("LastName"),"Vora");

       Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
       selectDay.selectByValue("27");

       Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
       selectMonth.selectByValue("11");

       //choosing "Date of birth" and click on Year
       Select selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
       selectYear.selectByVisibleText("1988");

        // Sending the email address by finding the xpath
        enterTextWithSendKeys(By.id("Email"),"bhavi"+timeStampMethod()+"@gmail.com");

        enterTextWithSendKeys(By.id("Company"),"Info LTD.");

        // Find Newsletter locator to unTick the checkbox
        clickMethod(By.xpath("//input[@type=\"checkbox\"]"));

        // Sending the keys of Password
       enterTextWithSendKeys(By.id("Password"),"123456");

        // Sending the keys of confirming the Password
       enterTextWithSendKeys(By.id("ConfirmPassword"),"123456");

        // Finding the xpath and clicking the Register button
        clickMethod(By.id("register-button"));

        // Storing in string variable
        String registrationMsg = gettingTextFromElement(By.className("result"));

        // Printing out the result by storing in string variable
        System.out.println("Result = " + registrationMsg);

        // closes all browser windows and ends the WebDriver session
        closeBrowser();
    }

    @ Test
  public void products()
    {
        // Click on Computers of homepage - demonopcommerce
        clickMethod(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a\n"));

        // Click on Desktop on Computers page
        clickMethod(By.xpath("//h2/a[@href=\"/desktops\"]"));

        //Finding the product 1 of Desktops in Computers , storing the variable in string and printing it out

        String productItem1 = gettingTextFromElement(By.xpath("//h2/a[@href=\"/build-your-own-computer\"]"));
        System.out.println(productItem1);

        //Finding the Product 2 of Desktops in Computers , storing the variable in string and printing it out
        String productItem2 = gettingTextFromElement(By.xpath("//h2/a[@href=\"/digital-storm-vanquish-3-custom-performance-pc\"]"));
        System.out.println(productItem2);

        //Finding the Product 3 of Desktops in Computers , storing the variable in string and printing it out
      String productItem3 = gettingTextFromElement(By.xpath("\"//h2/a[@href=\"/lenovo-ideacentre-600-all-in-one-pc\""));
        System.out.println(productItem3);

        closeBrowser();
    }

  @ Test
  public void newsComments()
  {

      // Click on homepage, in News section 2 - nopCommerce New Release, 'Details'
      clickMethod(By.xpath("//div[@class=\"news-list-homepage\"]/div[2]/div[2]/div[3]/a"));

      //Finding the xpath of text box and sending the key
      enterTextWithSendKeys(By.id("AddNewComment_CommentTitle"),"Products");

      //Sending the key whatever message want to send
      enterTextWithSendKeys(By.id("AddNewComment_CommentText"),"All the products are in good condition");

      // Clicking the New Comment button
      clickMethod(By.name("add-comment"));

      // Printing out the message after submitting the comments whether it's successful or not
      String printNewsComment = gettingTextFromElement(By.className("result"));
      System.out.println(printNewsComment);

      closeBrowser();
  }

@ Test
  public void homeCategories()
  {

      // With finding the xpath, printing out the Computers of homepage categories
      String computers = gettingTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[1]"));
      System.out.println(computers);

      // With finding the xpath, printing out the Electronics of homepage categories
      String electronics =  gettingTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]"));
      System.out.println(electronics);

      // With finding the xpath, printing out the Apparel of homepage categories
      String apparel =  gettingTextFromElement(By.xpath("//ul[@class='top-menu notmobile']/li[3]/a"));
      System.out.println(apparel);

      // With finding the xpath, printing out the DigitalDownloads of homepage categories
      String digitalDownloads =  gettingTextFromElement(By.xpath("//ul[@class='top-menu notmobile']/li[4]/a"));
      System.out.println(digitalDownloads);

      // With finding the xpath, printing out the Books of homepage categories
      String books = gettingTextFromElement(By.xpath("//ul[@class='top-menu notmobile']/li[5]/a"));
      System.out.println(books);

      // With finding the xpath, printing out the Jewelry of homepage categories
      String jewelry = gettingTextFromElement(By.xpath("//ul[@class='top-menu notmobile']/li[6]/a"));
      System.out.println(jewelry);

      // With finding the xpath, printing out the GiftCards of homepage categories
      String giftCards= gettingTextFromElement(By.xpath("//ul[@class='top-menu notmobile']/li[7]/a"));
      System.out.println(giftCards);

      closeBrowser();
  }

@ Test
  public void emailAFriend()
  {

      // To click the particular product - Apple MacBook Pro 13-inch on HomePage
      clickMethod(By.xpath("//div[@class='product-grid home-page-product-grid']//h2//a[@href=\"/apple-macbook-pro-13-inch\"]"));

      // Click on email a friend
     clickMethod(By.className("email-a-friend"));

      // Enter a friend's email on 'email-a-friend'
      enterTextWithSendKeys(By.className("friend-email"),"sonavora"+timeStampMethod()+"@gmail.com");

      // Enter sender email
      enterTextWithSendKeys(By.className("your-email"),"bhavivora@gmail.com");

      // Writing down the message with the send keys
     enterTextWithSendKeys(By.id("PersonalMessage"),"Please check that, is this the right product or not ?");

      // Clicking on send email button to find out whether it's working or not
     clickMethod(By.name("send-email"));

      // storing variable to get the message
      String msgSuccessfulOrNot = gettingTextFromElement(By.xpath("//form[@method='post']//li"));
      System.out.println(msgSuccessfulOrNot);

      closeBrowser();
  }

  @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }


}
