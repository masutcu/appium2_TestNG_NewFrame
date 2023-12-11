package generalstore.tests;

import generalstore.pages.CartPage;
import generalstore.pages.CatalogPage;
import generalstore.pages.FormPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_PozitiveTest {
    @Test
    public void testGeneralStore() throws InterruptedException {

        FormPage page=new FormPage();
        page.ulkeSec("Austria");
        page.isimGir("Safinaz");
        page.cinsiyetSec("female");
        page.letsShopButtonClick();

        CatalogPage catalogPage=new CatalogPage();
        catalogPage.sepeteUrunEkle("Converse All Star",1);
        catalogPage.sepeteUrunEkle("LeBron Soldier 12 ",0);
        catalogPage.sepeteGit();

        CartPage cartPage=new CartPage();
        cartPage.secilenUrunAdediniDogrula(2);
        cartPage.secilenUrunlerinToplamFiyatiniDogrula();
        cartPage.kontrolKutusunaTikla();
        cartPage.satinAlmaButonunaTikla();



        /*




        bekle(5);

        //Hibrit Uygulama
        // Sadece Web context'inin değerini alabilmek için bu kodu yazmaya ihtiyacım var.
//        Set<String> contextHandles = driver.getContextHandles();
//        for (String contextName:contextHandles){
//            System.out.println(contextName);
//        }

        driver.context("WEBVIEW_com.androidsample.generalstore");

        //Arama motoru
        driver.findElement(By.name("q")).sendKeys("Temel Reis", Keys.ENTER);

        //Native Uygulama
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");

        // Başlık Doğrulaması
        String baslik = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")).getText();
        Assert.assertEquals(baslik, "General Store");

        bekle(5);
 */
    }


}
