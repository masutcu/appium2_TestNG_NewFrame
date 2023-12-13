package generalstore.pages;

import generalstore.utils.Driver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static generalstore.utils.Driver.driver;
import static generalstore.utils.ExtentReport.bilgiNotu;

public class CreatOrderPage {
    public CreatOrderPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }
    //Burada web alanına geçeceğiz o yüzden @FindBy kullanmalıyız
    @FindBy (name="q")
    public WebElement aramaMotoru;

    public void aramaMotorundaAra(String metin){
        aramaMotoru.sendKeys(metin, Keys.ENTER);
        bilgiNotu("Arama motorunda "+ metin +" arandı");
    }
    public void uygulamayaGeriDon(){
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");
        bilgiNotu("Native uygulamaya geri dönüldü");
    }
}
