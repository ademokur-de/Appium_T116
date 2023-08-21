package tests.day1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Calculator_Test {


    AndroidDriver<AndroidElement> driver; //android cihazlarin driveri

    //  AppiumDriver<MobileElement> appiumDriver; //hem android de hem de ios da calisir

    @Test
    public void deneme1() throws MalformedURLException {

        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        //capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\ademo\\IdeaProjects\\APPIUM_T-116\\Apps\\Calculator_8.4 (503542421)_Apkpure.apk");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\ademo\\IdeaProjects\\APPIUM_T-116\\Apps\\Apk Bilgisi_2.3.4_apkcombo.com.apk");

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

}