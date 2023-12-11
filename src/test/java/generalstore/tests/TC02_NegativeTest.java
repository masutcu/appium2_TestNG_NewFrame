package generalstore.tests;

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
    public void testGenaralStoreNegativeTest() {

        //driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        //String toastMessage = driver.findElement(AppiumBy.xpath("//android.widget.Toast")).getAttribute("name");
        //Assert.assertEquals(toastMessage, "Please enter your name");
    }

}
