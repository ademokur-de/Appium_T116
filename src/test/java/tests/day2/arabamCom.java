package tests.day2;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class arabamCom {
    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        //capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\ademo\\IdeaProjects\\APPIUM_T-116\\Apps\\arabam.com_4.8.0_Apkpure.apk");
        capabilities.setCapability("appPackage","com.dogan.arabam");//Hangi uygulama uzerinde calismak istiyorsak,
        // Apk infodan uyguluma bilgisine ulasabiliriz
        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");
        // Kullanacak oldugumuz uygulamayi belirledikten sonra, o uygulamada hangi sayfadan baslamak istiyorsak
        // onun degerini activities kisminda bularak appActivity degiskenin karsisina parametre olarak giriyoruz


        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }


    @Test
    public void arabamTest() throws InterruptedException {
        //  driver.activateApp("com.dogan.arabam"); Bir uygulamayi akrif hale getirmek istedigimizde apk info dan onun bundleId degerini bularak buradan aktif hale getirebiliriz

        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));


        AndroidElement headerKontrol=driver.findElementByXPath("//*[@text='Arabam kaç para?']");
                // driver.findElementById("com.dogan.arabam:id/tvShowroomInfo"); // burasri benim tel de olmadi Android 8.1 oldugundan olabilir!!
        Assert.assertTrue(headerKontrol.isDisplayed());

        // Arabam kac para bolumune tiklayalim
        driver.findElementById("com.dogan.arabam:id/tvPricePrediction").click();
        // ya da xpath ile :
        // driver.findElementByXPath("//*[@text='Arabam kaç para?']");
        // Appium da Text attribiute'u ile calisirken "@" isareti kullanilir cift parantezler "()" kullanilmaz!!!

        // Aracimin fiyatini merak ediyorum bolumune tiklayalim
        driver.findElementByXPath("//*[@text='Aracımın fiyatını merak ediyorum']").click();

        // Volkswagen markasini secelim
        Thread.sleep(1500);
        TouchAction action = new TouchAction<>(driver);
        //alt : 535,1726   üst : 535, 240

        action.press(PointOption.point(535,1726))
              .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
              .moveTo(PointOption.point(535,240))
              .release()
              .perform();

        driver.findElementByXPath("//*[@text='Volkswagen']").click();

        // yil secimi yapalim
        driver.findElementByXPath("//*[@text='2018']").click();

        // model secimi yapalim
        driver.findElementByXPath("//*[@text='Passat']").click();

        // govde tipini secelim
        driver.findElementByXPath("//*[@text='Sedan']").click();

        // yakit tipini secelim
        driver.findElementByXPath("//*[@text='Benzin']").click();

        // vites tipini secelim
        driver.findElementByXPath("//*[@text='Yarı Otomatik']").click();

        // Versiyon secimi yapalim
        Thread.sleep(1000);
        action.press(PointOption.point(456,618)).release().perform();

        // aracin km bilgilerini girelim
        AndroidElement kmBox=driver.findElementById("com.dogan.arabam:id/et_km");

        if(driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("150000");
        }else {
            kmBox.sendKeys("200000");
        }
        Thread.sleep(1000);
        driver.findElementByXPath("//*[@text='Devam']").click();

        // aracin rengini secelim
        driver.findElementByXPath("(//*[@class='android.widget.TextView'])[16]").click();

        // opsiyel donanim (varsa) secelim
        driver.findElementByXPath("//*[@text='Devam']").click();
        Thread.sleep(1000);
        // degisen bilgisi ekleyerek tramer kaydi belirtelim
        action.press(PointOption.point(538,795)).release().perform();
        action.press(PointOption.point(230,1619)).release().perform();
        Thread.sleep(1000);
        driver.findElementByXPath("//*[@text='Devam']").click();

        Thread.sleep(1000);
        driver.findElementByXPath("//*[@text='Tramer kaydı yok']").click();
        driver.findElementByXPath("//*[@text='Devam']").click();

        // aracimizin fiyatinin 500.000 tl den fazla oldugunu test edelim
        AndroidElement ortalamaFiyatSonucuLocate=driver.findElementById("com.dogan.arabam:id/tvAveragePrice");
        String ortalamaSonSonuc=ortalamaFiyatSonucuLocate.getText();
        ortalamaSonSonuc=ortalamaSonSonuc.replaceAll("\\D","");

        Assert.assertTrue(Integer.parseInt(ortalamaSonSonuc)>5000);
        // uygulamayi kapatalim
    }

}