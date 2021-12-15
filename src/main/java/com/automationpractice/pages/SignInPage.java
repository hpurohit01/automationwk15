package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends Utility {

    private static final Logger log= LogManager.getLogger(SignInPage.class.getName());

    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailadressField;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement passwordField;

    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    WebElement signInButton;

    @FindBy(xpath = "//span[normalize-space()='Create an account']")
    WebElement createAccountButton;

    @FindBy(xpath = "//h1[@class='page-heading']")
    WebElement authenticationText;

    @FindBy(xpath = "//h3[normalize-space()='Create an account']")
    WebElement createAccountText;

    @CacheLookup
    @FindBy(xpath = "//a[@title='Log me out']")
    WebElement singout;

    @FindBy(xpath = "//input[@id='email_create']")
    WebElement emailfornewaccount;

    @FindBy(css = "button[id='SubmitCreate'] span")
    WebElement createAccounTAB;


    public void clickOnCreateAnAccountButton() {
        clickOnElement(createAccounTAB);
        log.info("clicking on create an account button: " + createAccounTAB.toString());
    }


    public void enterEmailfornewacountcreation(String email) {
        sendTextToElement(emailfornewaccount,email);
        log.info("Entering email for new account user: " + emailfornewaccount.toString());
    }


    public void enterYouremail(String emailId) {                   //parameterized method
        sendTextToElement(emailadressField, emailId);
        log.info("Entering email id: " + emailadressField.toString());

    }

    public void enterYourPassword(String password) {
        sendTextToElement(passwordField, password);
        log.info("Entering password: " + passwordField.toString());
    }

    public void clickOnSignInButton() {
        clickOnElement(signInButton);
        log.info("click on sign in button: " + signInButton.toString());
    }

    public void loginToAutomationPractice(String emailId, String password) {
        enterYouremail(emailId);
        enterYourPassword(password);
        clickOnSignInButton();

    }

    public String verifyTextSuccessfully() {
        WebElement result = driver.findElement(By.cssSelector("div[class='alert alert-danger'] ol li"));
        //li[normalize-space()='Password is required.']
        log.info("clicking on register button: " + result.toString());
        return getTextFromElement(result);
    }

    public void verifySignOutButtonIsDisplayed() {
        singout.isDisplayed();
        log.info("verifying sign out button is displayed: " + singout.toString());
    }

    public void clickOnSignOutButton() {
        clickOnElement(singout);
        log.info("clicking on sign out button: " + singout.toString());
    }

    public String getAuthenticationText() {

        String authentication= getTextFromElement(authenticationText);
        log.info("verifying authentication txt : " + authentication.toString());
        return authentication;

    }

    public String createAccountText() {
        String textVerify1 = getTextFromElement(createAccountText);
        log.info("verifying text: " + createAccountText.toString());
        return textVerify1;

    }



}
