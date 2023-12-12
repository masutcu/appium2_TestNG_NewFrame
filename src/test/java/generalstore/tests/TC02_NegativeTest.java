package generalstore.tests;

import generalstore.pages.FormPage;
import io.appium.java_client.AppiumBy;

import org.testng.annotations.Test;

public class TC02_NegativeTest {

    /*
    Uygulama: GeneralStore
        GeneralStore uygulamasına gir
        Menüden Angola seçeneğini seç
        Your Name kutusunu boş bırak
        Let’s Shop butonuna tıkla
        Hata mesajını doğrula (Toast Message)
     */
    @Test
    public void test02_NegativeTest() {

        FormPage page=new FormPage();
        page.letsShopButtonClick();
        page.hataMesajiGorundugunuDogrula("Please enter your nam");


    }

}
