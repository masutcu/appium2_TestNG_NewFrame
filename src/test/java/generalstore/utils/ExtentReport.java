package generalstore.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ExtentReport {

    //listener kullanmasaydık buradaki metodları test içinde kullanmamız gerekecekti.

    public  static ExtentReports extent;
    public  static ExtentTest test;

    //xml de listener ı çağıracaz, listener da extend reportu çağıracağız. extend report raporumuzu oluşturacak

    public static void raporOlustur(){
        String path=System.getProperty("user.dir") + File.separator+"raporlar"+File.separator+"rapor.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);//raporun kaydedileceği yolu yazıyoruz
        reporter.config().setReportName("GeneralStoreAPK_TestRaporu");//raporun sağ üst tarafında çıkan isim
        reporter.config().setDocumentTitle("Masutcu_Test_Rapor");//üste yazan başlık

        extent=new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("QA/Tester","Mehmet Ali Sütçü");//test environment information yazılabilir
        extent.setSystemInfo("test device resolution","1080 x 2340");
        extent.setSystemInfo("TestFrameRunsWith","Java 17v, Appium 2.1v, TestNG 7.8v");

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

    public static void raporuAc(){
        // Rapor dosyasının tam yolu
        String raporYolu = "C:\\Users\\Lenovo\\IdeaProjects\\Appium_ProjectTestNG\\raporlar\\rapor.html";

        try {
            // Google Chrome'un çalıştırılması
            String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
            String command = chromePath + " " + raporYolu;
            Process process = Runtime.getRuntime().exec(command);

            // İşlemi bekleyin
            process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void muzikAc(){
        // müzik dosyasının tam yolu
        String muzikYolu = "C:\\Users\\Lenovo\\IdeaProjects\\Appium_ProjectTestNG\\hababam-sinifi-okul-zil-sesi.mp3";

        try {
            // mediaplayer çalıştırılması
            String mediaplayerPath = "C:\\Program Files\\VideoLAN\\VLC\\vlc.exe";
            String command = mediaplayerPath + " " + muzikYolu;
            Process process = Runtime.getRuntime().exec(command);

            // İşlemi bekleyin
            process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    }

