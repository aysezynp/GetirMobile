package com.getir.pages;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasketPage extends BasePage{
    @FindBy(id = "com.getir.casestudy.dev:id/ga_toolbar_getir10GABasketButton")
    public AndroidElement lbasket;
    @FindBy(xpath = "//*[@text='There is no result']")
    public AndroidElement lbasketText;
    @FindBy(id = "com.getir.casestudy.dev:id/ga_toolbar_leftIconImageView")
    public AndroidElement lbackBtn;
    @FindBy(className = "android.widget.TextView")
    public List<AndroidElement> lmenuList;
    @FindBy(id = "com.getir.casestudy.dev:id/btnAdd")
    public AndroidElement laddItem;
    @FindBy(id = "com.getir.casestudy.dev:id/tvTotalTitle")
    public AndroidElement totalAmount;
    public  void clickCategory(String category){
        driver.findElement(By.xpath("//*[@text='"+category+"']")).click();

    }
}
