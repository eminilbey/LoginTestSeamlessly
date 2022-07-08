package com.cydeo.step_definitions;

import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get("https://qa.seamlessly.net/");
    }

    @When("user enters {string} as username")
    public void userEntersAsUsername(String userName) {
        loginPage.userName.sendKeys(userName);
    }

    @When("user enters {string} as no username")
    public void userEntersAsNoUsername(String noUserName) {
        loginPage.userName.sendKeys(noUserName);

    }

    @When("user enters faker username")
    public void userEntersFakerUsername() {
        Faker faker = new Faker();
        String fakeUsername = faker.name().username();
        loginPage.userName.sendKeys(fakeUsername);
    }

    @And("user enters {string} as password")
    public void userEntersAsPassword(String password) {
        loginPage.password.sendKeys(password);
    }

    @And("user clicks eye icon")
    public void userClicksEyeIcon() {
        loginPage.eyeIcon.click();
    }

    @And("user enters {string} as no password")
    public void userEntersAsNoPassword(String noPassword) {
        loginPage.password.sendKeys(noPassword);
    }

    @And("user enters {string} as invalidPassword")
    public void userEntersAsInvalidPassword(String invalidPassword) {
        loginPage.password.sendKeys(invalidPassword);
    }

    @And("user hits Enter Key")
    public void userHitsEnterKey() {
        loginPage.password.sendKeys(Keys.ENTER);
    }

    @And("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginButton.click();
    }

    @When("user Clicks Forgot Password Button")
    public void userClicksForgotPasswordButton() {
        loginPage.forgotPasswordButton.click();
    }

    @Then("user should login successfully")
    public void user_should_login_successfully() {
        BrowserUtils.verifyURLContains("files");

    }

    @Then("Please Fill Out UserName Field Displayed")
    public void pleaseFillOutThisFieldDisplayed() {
        String expectedMessage = "Please fill out this field.";
        String actualMessage = Driver.getDriver().findElement(By.name("user")).getAttribute("validationMessage");
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Then("Please Fill Out Password Field Displayed")
    public void pleaseFillOutPasswordFieldDisplayed() {
        String expectedMessage = "Please fill out this field.";
        String actualMessage = Driver.getDriver().findElement(By.name("password")).getAttribute("validationMessage");
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Then("Wrong username or password Message Displayed")
    public void wrongUsernameOrPasswordMessageDisplayed() {
        String expectedWarningMessage = "Wrong username or password.";
        String actualWarningMessage = loginPage.invalidCredentialsWarning.getText();
        Assert.assertEquals(actualWarningMessage,expectedWarningMessage);
    }

    @Then("password type is dotForm By Default")
    public void passwordTypeIsDotFormByDefault() {
        Assert.assertTrue(loginPage.passwordType.isDisplayed());
    }

    @Then("password is visible")
    public void passwordIsVisible() {
        Assert.assertTrue(loginPage.passwordtext.isDisplayed());
    }

    @Then("reset Password Button Is Displayed")
    public void resetPasswordButtonIsDisplayed() {
        Assert.assertTrue(loginPage.resetPasswordButton.isDisplayed());
    }

    @Then("user Can See userName Placeholder")
    public void userCanSeeUserNamePlaceholder() {
        Assert.assertTrue(loginPage.userNamePlaceHolder.isDisplayed());
    }

    @Then("user can see password placeholder")
    public void userCanSeePasswordPlaceholder() {
        Assert.assertTrue(loginPage.passwordPlaceHolder.isDisplayed());
    }
}
