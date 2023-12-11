package generalstore.pages;

import generalstore.utils.Driver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static generalstore.utils.Driver.driver;

public class CartPage {
    public CartPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }
    @AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
    private List<WebElement> urunler;

    @AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement toplamFiyat;

    @AndroidFindBy(className="android.widget.CheckBox")
    private WebElement checkBox;

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
    private WebElement satinAlmaButonu;

    public void secilenUrunAdediniDogrula(int urunAdet){
        Assert.assertEquals(urunler.size(), urunAdet);
    }

    public void secilenUrunlerinToplamFiyatiniDogrula(){
        double total = 0;
        for (int i = 0; i < urunler.size(); i++) {
            String priceText = urunler.get(i).getText(); // $160.97 --> $120.0
            System.out.println("ürün fiyatı : "+urunler.get(i).getText());
            double price = Double.parseDouble(priceText.substring(1)); // 160.97  --> 120.0
            total += price;
        }

        double totalAmount = Double.parseDouble(toplamFiyat.getText().substring(1));
        System.out.println("toplam fiyat : "+totalAmount);
        Assert.assertEquals(total, totalAmount);
    }

    public void kontrolKutusunaTikla(){
        checkBox.click();
    }

    public void satinAlmaButonunaTikla(){
        satinAlmaButonu.click();
    }











}
