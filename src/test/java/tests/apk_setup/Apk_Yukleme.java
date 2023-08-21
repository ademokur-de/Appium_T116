package tests.apk_setup;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Apk_Yukleme {

    AndroidDriver<AndroidElement> driver; //android cihazlarin driveri
    final String cihazName="Pixel 2";
    final String platfomVersion="8.1";

    @Test
    public void ApkYukle() throws MalformedURLException {

        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,cihazName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,platfomVersion);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        //capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\ademo\\IdeaProjects\\APPIUM_T-116\\Apps\\Apk Bilgisi_2.3.4_apkcombo.com.apk");
        //capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\ademo\\IdeaProjects\\APPIUM_T-116\\Apps\\arabam.com_4.8.0_Apkpure.apk");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\ademo\\IdeaProjects\\APPIUM_T-116\\Apps\\all-currency-converter-3-9-0.apk");


        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
