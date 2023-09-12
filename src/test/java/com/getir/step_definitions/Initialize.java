package com.getir.step_definitions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class Initialize {
 public static AndroidDriver<MobileElement> driver;


 @Before
 public void setup() {

  initializeDriver();
  driver.resetApp();

 }

 @After

 public void tearDown(Scenario scenario) throws InterruptedException {
  if(scenario.isFailed()){
   final byte[] screenshot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
   scenario.attach(screenshot,"image/png",scenario.getName());
  }

  Thread.sleep(3000);

  driver.closeApp();
 }

 public void initializeDriver(){
  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
  desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
  desiredCapabilities.setVersion("11.0");
  desiredCapabilities.setCapability("appium:deviceName","Pixel_2");

  desiredCapabilities.setCapability("appPackage","com.getir.casestudy.dev");
  desiredCapabilities.setCapability("appActivity","com.getir.casestudy.modules.splash.ui.SplashActivity");

  try{
   driver= new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
  }catch (MalformedURLException e){
   e.printStackTrace();
  }

 }
    /*
    C:\Users\tosun>adb shell
generic_x86_arm:/ $ dumpsys window | grep -E mCurrentFocus
  mCurrentFocus=Window{f8c7cb u0 com.getir.casestudy.dev/com.getir.casestudy.modules.main.ui.MainActivity}
     */
}
