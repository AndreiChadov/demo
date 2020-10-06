package com.andreichadov.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MainTest {

    public static LoginPage loginPage;
    public static EMailsPage eMailsPage;
    public static WebDriver driver;

    @BeforeAll
    public static void setup() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        loginPage = new LoginPage(driver);
        eMailsPage = new EMailsPage(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://gmail.com/");
    }

    @Test
    public void test() {
        /* Логинимся в аккаунт */
        loginPage.inputLogin("chadic007@gmail.com");
        loginPage.clickLoginBtn();
        loginPage.inputPassword("TestPassword!1");
        loginPage.clickPasswordBtn();

        /* Ищем определенные письма и их количество */
        eMailsPage.search("from:(farit.valiahmetov)");
        String numberOfEmails = eMailsPage.getNumberOfEMails();
        eMailsPage.clickWriteEMailBtn();
        eMailsPage.typeSendingAddress("farit.valiahmetov@simbirsoft.com");

        /* Переводим русские символы в нужную кодировку, пишем и отправляем сообщение */
        String subject = null;
        try {
            subject = new String("Тестовое задание. Чадов".getBytes("windows-1251"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        eMailsPage.typeEmailSubject(subject);
        System.out.println(numberOfEmails);
        eMailsPage.typeMessage(numberOfEmails);
        eMailsPage.clickSendBtn();
    }

    @AfterAll
    public static void close(){
       driver.quit();
    }
}