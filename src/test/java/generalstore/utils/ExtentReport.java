package generalstore.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReport {

    //listener kullanmasaydık buradaki metodları test içinde kullanmamız gerekecekti.

    public  static ExtentReports extent;
    public  static ExtentTest test;

    //xml de listener ı çağıracaz, listener da extend reportu çağıracağız. extend report raporumuzu oluşturacak

    public static void raporOlustur(){
        String path=System.getProperty("user.dir") + File.separator+"raporlar"+File.separator+"rapor.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);//raporun kaydedileceği yolu yazıyoruz
        reporter.config().setReportName("GeneralStoreAPPRaporu");//raporun sağ üst tarafında çıkan isim
        reporter.config().setDocumentTitle("Masutcu_App_Rapor");//üste yazan başlık

        extent=new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("QA/Tester","Mehmet Ali Sütçü");//test environment information yazılabilir
    }
     public static void testOlustur(String testAdi){
        test=extent.createTest(testAdi);

     }

     public static void bilgiNotu(String bilgiNotu){
        test.info(bilgiNotu);
     }

    public static void raporuKaydet(){
        extent.flush();
    }
}
