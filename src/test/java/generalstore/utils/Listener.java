package generalstore.utils;

import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static generalstore.utils.Driver.driver;
import static generalstore.utils.Driver.driverClose;
import static generalstore.utils.ExtentReport.*;

public class Listener implements ITestListener {
    //burada implement çok önemlidir. ITestLissenerdaki methodları kullanmamız lazım. on -dersen intelij metodları getirir.
    //@Before @after yerine listener kullanarak
    //onTesFailure veya onTestSucsess gibi methodları kullanabildik.
    @Override
    public void onStart(ITestContext context) {
        raporOlustur();

    }

    @Override
    public void onTestStart(ITestResult result) {
        //String testName = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).testName();//test adında annotation varsa, anotationa ait test değerini ekler
        testOlustur(result.getMethod().getMethodName()); //testin adını panele başlık olarak ekleyecek
        test.info("Test Başladı");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"Test Başarıyla Tamamlandı");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail("Test Fail oldu çünkü : "+result.getThrowable().getMessage());//hata mesajını eklemiş oluyoruz

        //Ekran görüntüsünü alma
        File dosya= driver.getScreenshotAs(OutputType.FILE);
        String dosyaYolu=System.getProperty("user.dir") + File.separator+"ScreenShots"+File.separator+result.getMethod().getMethodName()+".png";
        try {
            FileUtils.copyFile(dosya, new File(dosyaYolu));//FileUtils için <artifactId>commons-io</artifactId> dependency eklenmelidir.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //ekran görüntüsünü rapora ekleme
        try {
            test.addScreenCaptureFromPath(dosyaYolu);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        //DİKKAT:resmi raporda görmek için browserla değil explorer ile açmalısın.
        //xml üzerinde Sağclick -openin Explorer, açılan package da raporlar packege içinde html dosyası

        driverClose();//Bu olmaz ise fail olan dosyada raporlama tıkanıyor.
    }

    @Override
    public void onFinish(ITestContext context) {
        driverClose();
        raporuKaydet();
    }
}
