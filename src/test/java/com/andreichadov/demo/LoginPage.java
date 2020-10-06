package com.andreichadov.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[contains(@id, 'identifierId')]")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id='identifierNext']")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[contains(@name, 'password')]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='passwordNext']")
    private WebElement passwordNextBtn;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickPasswordBtn(){
        passwordNextBtn.click();    }
}
