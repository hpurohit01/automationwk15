package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {                                      //created a constructor for PageFactorySetUp
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Women']")
    WebElement womenbutton;

    @FindBy(linkText = "Dresses")
    WebElement dressesbutton;

    @FindBy(linkText = "T-shirts")
    WebElement tshirtbutton;

    @FindBy(css = "a[title='Log in to your customer account']")
    WebElement signIn;

    @FindBy(xpath = "//img[@alt='My Store']")
    WebElement logoimg;

    public void clickonWomenButtonOnHomePage() {
        clickOnElement(womenbutton);
        log.info("clicking on women button: " + womenbutton.toString());

    }

    public void clickonDressesButtonOnHomePage() {
        clickOnElement(dressesbutton);
        log.info("clicking on dress button: " + dressesbutton.toString());
    }

    public void clickontshirtButtonOnHomePage() {
        clickOnElement(tshirtbutton);
        log.info("clicking on t shirt button: " + tshirtbutton.toString());
    }

    public void clickOnSignInLinkOnHomePage() {
        clickOnElement(signIn);
        log.info("clicking on sign In: " + signIn.toString());
    }

    public String getLogoVerifyOnHomePage() {
        String logoVerify = getTextFromElement(logoimg);
        log.info("verifying logo img : " + logoimg.toString());
        return logoVerify;

    }

    public void verifySignInLinkIsDisplayed() {
        signIn.isDisplayed();
        log.info("Sign in link is displayed : " + signIn.toString());
    }



}
