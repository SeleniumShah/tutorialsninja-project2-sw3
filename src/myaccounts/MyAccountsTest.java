package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MyAccountsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String option) {
        driver.findElement(By.xpath("//span[contains(text(),'" + option + "')]")).click();
    }
 @Test
 public void verifyUserShouldNavigateToRegisterPageSuccessfully() {

     // 1.1 Click on My Account Link.
     clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

     //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
     //selectMyAccountOptions("Register");
     mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Register']"));

     //1.3 Verify the text “Register Account”.
     verifyTextElement("Register Account",By.xpath("//h1[normalize-space()='Register Account']"));


 }@Test
   public void verifyUserShouldNavigateToLoginPageSuccessfully() {

        //2.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

       // 2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        //selectMyAccountOptions("Login");
        mouseHoverAndClickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']"));

      //  2.3 Verify the text “Returning Customer”.
        verifyTextElement("Returning Customer", By.xpath("//h2[normalize-space()='Returning Customer']"));
    }
    @Test

    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

       // 3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        //selectMyAccountOptions("Register");
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Register']"));

       // 3.3 Enter First Name
        sendTextFromElement(By.xpath("//input[@id='input-firstname']"), "John");

       // 3.4 Enter Last Name
        sendTextFromElement(By.xpath("//input[@id='input-lastname']"), "Park");

       // 3.5 Enter Email
        sendTextFromElement(By.xpath("//input[@id='input-email']"), "Parkjohn12@gmail.com");

       // 3.6 Enter Telephone
        sendTextFromElement(By.xpath("//input[@id='input-telephone']"), "07845898941");

       // 3.7 Enter Password
        sendTextFromElement(By.xpath("//input[@id='input-password']"), "LLondon12@");

       // 3.8 Enter Password Confirm
        sendTextFromElement(By.xpath("//input[@id='input-confirm']"), "LLondon12@");

       // 3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));

       //  3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));

       // 3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));

       //  3.12 Verify the message “Your Account Has Been Created !”
       verifyTextElement("Your Account Has Been Created!", By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));

        // 3.13 Click on Continue button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));

        // 3.14 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        // 3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        //selectMyAccountOptions("Logout");
        mouseHoverAndClickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']"));

       // 3.16 Verify the text “Account Logout”
        verifyTextElement("", By.xpath("//h1[normalize-space()='Account Logout']"));

       // 3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

       // 4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        //selectMyAccountOptions("Login");
        mouseHoverAndClickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']"));

       // 4.3 Enter Email address
        sendTextFromElement(By.xpath("//input[@id='input-email']"), "Prime102@gmail.com");

       // 4.4 Enter Last Name

       //4.5 Enter Password
        sendTextFromElement(By.xpath("//input[@id='input-password']"), "Prime1234");

       // 4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));

       // 4.7 Verify text “My Account”
        verifyTextElement("My Account",By.xpath("//h2[normalize-space()='My Account']"));

       // 4.8 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

       // 4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        //selectMyAccountOptions("Logout");
        mouseHoverAndClickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']"));

        // 4.10 Verify the text “Account Logout”
        verifyTextElement("Account Logout", By.xpath("//h1[normalize-space()='Account Logout']"));

       // 4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

    }

    @After
    public void tearDown(){
       closeBrowser();
    }

}
