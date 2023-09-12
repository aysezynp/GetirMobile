package com.getir.pages;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    @FindBy(id = "com.getir.casestudy.dev:id/usernameEditText")
    public AndroidElement usernameInput;
    @FindBy(id = "com.getir.casestudy.dev:id/passwordEditText")
    public AndroidElement passwordInput;
    @FindBy(xpath = "//*[@text='Submit']")
    public AndroidElement submitBtn;
    @FindBy(xpath = "//*[@text='Dondurma']")
    public AndroidElement ldondurma;


    public void login(String username,String password){
        waitUntil(usernameInput).sendKeys(username);
        passwordInput.sendKeys(password);
        submitBtn.click();
    }

    public AndroidElement waitUntil(AndroidElement element) {
        return (AndroidElement) wait.until(ExpectedConditions.visibilityOf(element));
    }
}
