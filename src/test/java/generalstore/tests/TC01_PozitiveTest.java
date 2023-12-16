package generalstore.tests;

import generalstore.pages.CartPage;
import generalstore.pages.CatalogPage;
import generalstore.pages.CreatOrderPage;
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
    public void test01PositiveTest() throws InterruptedException {

        FormPage page=new FormPage();
        page.ulkeSec("Lithuania");
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

        CreatOrderPage creatOrderPage=new CreatOrderPage();
        creatOrderPage.aramaMotorundaAra("Temel Reis");
        creatOrderPage.uygulamayaGeriDon();

        page.sayfaBasliginiDogrula("General Store");

    }


}
