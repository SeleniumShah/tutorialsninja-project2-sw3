package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {

    @Before
    public void setUp() {

    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));

        //1.2 Click on “Show All Laptops & Notebooks”
        selectMenuAndClick1("Show AllLaptops & Notebooks");

        //1.3 Select Sort By "Price (High > Low)"
        selectFromVisibleTextFromDropdown(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");
        //1.4 Verify the Product price will arrange in High to Low order.
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully(){
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));

        //2.2 Click on “Show All Laptops & Notebooks”
        selectMenuAndClick1("Show AllLaptops & Notebooks");

        //2.3 Select Sort By "Price (High > Low)"
        selectFromVisibleTextFromDropdown(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");

        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));

        //2.5 Verify the text “MacBook”
        verifyTextElement("MacBook",By.xpath("//h1[normalize-space()='MacBook']"));

        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        verifyTextElement("Success: You have added MacBook to your shopping cart!\n" +
                "×",By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        // 2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //2.9 Verify the text "Shopping Cart"
        verifyTextElement("Shopping Cart  (0.00kg)",By.xpath("//h1[contains(text(),'Shopping Cart')]"));

        //2.10 Verify the Product name "MacBook"
        verifyTextElement("MacBook",By.cssSelector("body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > a:nth-child(1)"));

        //2.11 Change Quantity "2"
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]")).clear();
        sendTextFromElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"),"2");

        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//button[@type='submit']"));

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        verifyTextElement("Success: You have modified your shopping cart!\n" +
                "×",By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        //2.14 Verify the Total $1,204.00
        verifyTextElement("$1,204.00",By.xpath("//tbody/tr[1]/td[6]"));


        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));

        //2.16 Verify the text “Checkout”
        verifyTextElement("Checkout",By.xpath("//h1[contains(text(),'Checkout')]"));

        //2.17 Verify the Text “New Customer”
        verifyTextElement("New Customer",By.xpath("//h2[contains(text(),'New Customer')]"));

        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));

        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));

        //2.20 Fill the mandatory fields
        sendTextFromElement(By.xpath("//input[@id='input-payment-firstname']"),"prime");
        sendTextFromElement(By.xpath("//input[@id='input-payment-lastname']"),"testing");
        sendTextFromElement(By.xpath("//input[@id='input-payment-email']"),"prime1232@gmail.com");
        sendTextFromElement(By.xpath("//input[@id='input-payment-telephone']"),"01234567899");
        sendTextFromElement(By.xpath("//input[@id='input-payment-address-1']"),"12 kings road");
        sendTextFromElement(By.xpath("//input[@id='input-payment-city']"),"Harrow");
        sendTextFromElement(By.xpath("//input[@id='input-payment-postcode']"),"HA2 9SG");
        selectFromVisibleTextFromDropdown(By.xpath("//select[@id='input-payment-country']"),"United Kingdom");
        selectFromVisibleTextFromDropdown(By.xpath("//select[@id='input-payment-zone']"),"Kent");

        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));

        //2.22 Add Comments About your order into text area
        sendTextFromElement(By.xpath("//textarea[@name='comment']"),"Thanks You");

        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name='agree']"));

        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

        //2.25 Verify the message “Warning: Payment method required!”
        verifyTextElement("Warning: Payment method required!\n" +
                "×",By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
    }

    @After
    public void tearDown() {
     closeBrowser();
    }
}