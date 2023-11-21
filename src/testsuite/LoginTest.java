package testsuite;
/**
 * Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValid Credentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed on page
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSucessfullyWithValidCredentials() {
        driver.findElement(By.xpath("//input[@id = 'user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@value = 'Login']")).click();
        String expectedText = "Products";
        // Find the actual text element and get the text from element
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class = 'title']"));
        String actualText = actualTextElement.getText();
        //Verify expected and actual Text
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        driver.findElement(By.xpath("//input[@id = 'user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@value = 'Login']")).click();
        String expectedMessage = "six products are displayed on page";
        // Find the actual text element and get the text from element
        String expectedText = "six products are displayed on page";
        WebElement actualText = driver.findElement(By.xpath("//div[@class='inventory_list']"));
        String actualTest = actualText.getText();
        Assert.assertEquals(expectedText, actualTest);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
