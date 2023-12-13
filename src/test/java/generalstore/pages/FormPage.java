package generalstore.pages;

import generalstore.utils.Driver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static generalstore.utils.Driver.driver;
import static generalstore.utils.ExtentReport.bilgiNotu;

public class FormPage {

    public FormPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
    private WebElement ulkeMenusu;

    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    private WebElement isimAlani;

    @AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
    private WebElement cinsiyetFemale;

    @AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
    private WebElement cinsiyetMale;

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    private WebElement letsShopButton;

    @AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
    private WebElement sayfaBasligi;

    @AndroidFindBy(xpath = "//android.widget.Toast")
    private WebElement hataMesaji;



    public void ulkeSec(String ulke){
        ulkeMenusu.click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+ulke+"\"))"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\""+ulke+"\"]")).click();
        bilgiNotu("Ülke menüsünden "+ulke+" seçildi");
    }

    public  void isimGir(String isim){
        isimAlani.sendKeys(isim);
        bilgiNotu("isim bölümüne "+isim+" seçildi");
    }

    public void cinsiyetSec(String cinsiyet){
        if(cinsiyet.equalsIgnoreCase("male")){
            cinsiyetMale.click();
        } else if (cinsiyet.equalsIgnoreCase("female")) {
            cinsiyetFemale.click();
        }else System.out.println("cinsiyet tanımlamanız yanlış");

        bilgiNotu("Cinsiyet checkBox  "+cinsiyet+" seçildi");

    }

    public void letsShopButtonClick(){
        letsShopButton.click();
        bilgiNotu("LetsShop Button Tıklandı");
    }

    public  void  sayfaBasliginiDogrula(String baslik){
        Assert.assertEquals(sayfaBasligi.getText(), baslik);
        bilgiNotu("Sayfa başlığı doğrulaması yapıldı");
    }

    public  void  hataMesajiGorundugunuDogrula(String mesaj){
        Assert.assertEquals(hataMesaji.getAttribute("name"), mesaj);
        bilgiNotu("Hata mesajının içeriği ve görünürlüğü doğrulandı");
    }




}
