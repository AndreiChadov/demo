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

    @FindBy(xpath = "/html/body/div[7]/div[3]/div/div[1]/div[3]/header/div[2]/div[2]/div[2]/form/div/table/tbody/tr/td/table/tbody/tr/td/div/input[1]")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id=\"aso_search_form_anchor\"]/button[4]")
    private WebElement searchBtn;

    @FindBy(xpath = "/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[2]/div[2]/div/span/div[1]/span/span[2]")
    private WebElement numberOfEMails;

    @FindBy(xpath = "/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div[1]/div/div")
    private WebElement writeEMailBtn;

    @FindBy(xpath = "/html/body/div[20]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/div/div[1]/div[2]/div[1]/div/table/tbody/tr/td[2]/div[2]/div")
    private WebElement mailBody;

    @FindBy(xpath = "/html/body/div[20]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/form/div[1]/table/tbody/tr[1]/td[2]/div/div/textarea")
    private WebElement sendingAddress;

    @FindBy(xpath = "/html/body/div[20]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/form/div[3]/div/input")
    private WebElement subjectField;

    @FindBy(xpath = "/html/body/div[20]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/div/div/div[4]/table/tbody/tr/td[1]/div/div[2]/div[1]")
    private WebElement sendBtn;


    public void search(String request){
        /* Ждем прогрузки элемента и отправляем нужный запрос*/
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div[3]/div/div[1]/div[3]/header/div[2]/div[2]/div[2]/form/div/table/tbody/tr/td/table/tbody/tr/td/div/input[1]")));
        searchField.sendKeys(request);
        searchBtn.click();
    }

    public String getNumberOfEMails(){
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

    public void clickSendBtn(){
        sendBtn.click();
    }

}
