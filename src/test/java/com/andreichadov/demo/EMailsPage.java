package com.andreichadov.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EMailsPage {

    public WebDriver driver;
    public EMailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[@id='gs_lc50']/input[1]")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id='aso_search_form_anchor']/button[4]")
    private WebElement searchBtn;

    @FindBy(xpath = "/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[2]/div[2]/div/span/div[1]/span/span[2]")
    private WebElement numberOfEMails;

    @FindBy(xpath = "//*[contains(@class, 'T-I T-I-KE L3')]")
    private WebElement writeEMailBtn;

    @FindBy(xpath = "//*[contains(@class, 'Am Al editable LW-avf tS-tW')]")
    private WebElement mailBody;

    @FindBy(xpath = "//*[contains(@name, 'to')]")
    private WebElement sendingAddress;

    @FindBy(xpath = "//*[contains(@name, 'subjectbox')]")
    private WebElement subjectField;

    @FindBy(xpath = "//*[contains(@class, 'T-I J-J5-Ji aoO v7 T-I-atl L3')]")
    private WebElement sendBtn;


    public void search(String request){
        /* Ждем прогрузки элемента и отправляем нужный запрос*/
        WebDriverWait waitField = new WebDriverWait(driver, 20);
        waitField.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='gs_lc50']/input[1]")));
        searchField.sendKeys(request);
        WebDriverWait waitBtn = new WebDriverWait(driver, 20);
        waitBtn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='aso_search_form_anchor']/button[4]")));
        searchBtn.click();
    }

    public String getNumberOfEMails(){

        if (!numberOfEMails.isEnabled()) return "0";
        return numberOfEMails.getText();
    }

    public void clickWriteEMailBtn(){
        writeEMailBtn.click();
    }

    public void typeMessage(String message){
        mailBody.sendKeys(message);
    }

    public void typeSendingAddress(String address){
        sendingAddress.sendKeys(address);
    }

    public void typeEmailSubject(String subject){
        subjectField.sendKeys(subject);
    }

    /*Нажимаем кнопку и ожидаем появления уведомления "Письмо отправлено"*/
    public void clickSendBtn(){
        sendBtn.click();
        WebDriverWait waitBtn = new WebDriverWait(driver, 20);
        waitBtn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'bAq')]")));
    }

}
