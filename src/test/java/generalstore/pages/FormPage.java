package generalstore.pages;

import generalstore.utils.Driver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static generalstore.utils.Driver.driver;

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

    public void ulkeSec(String ulke){
        ulkeMenusu.click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+ulke+"\"))"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\""+ulke+"\"]")).click();
    }

    public  void isimGir(String isim){
        isimAlani.sendKeys(isim);
    }

    public void cinsiyetSec(String cinsiyet){
        if(cinsiyet.equalsIgnoreCase("male")){
            cinsiyetMale.click();
        } else if (cinsiyet.equalsIgnoreCase("female")) {
            cinsiyetFemale.click();
        }else System.out.println("cinsiyet tanımlamanız yanlış");

    }

    public void letsShopButtonClick(){
        letsShopButton.click();
    }




}
