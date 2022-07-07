package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "submit-form")
    public WebElement loginButton;

    @FindBy(css = ".warning")
    public WebElement invalidCredentialsWarning;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordType;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement passwordtext;

    @FindBy(xpath = "//a[@href='#']")
    public WebElement eyeIcon;

    @FindBy(id = "lost-password")
    public WebElement forgotPasswordButton;

    @FindBy(xpath = "//input[@id='reset-password-submit']")
    public WebElement resetPasswordButton;

    @FindBy(xpath = "//input[@placeholder='Username or email']")
    public WebElement userNamePlaceHolder;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordPlaceHolder;





}
