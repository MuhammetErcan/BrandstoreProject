package Hook;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.Homepage;
import utils.Driver;
import utils.ExcelUtility;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static utils.ExcelUtility.getCurrentTime;


public class Hook  {
    public static String path = "src/test/java/logsAndReports/";
    public static String fileName="excelLogs.xlsx";
    public static String sheet = "sayfa";
    public static String tarihSaat = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));


    @BeforeAll
    public static void beforeAll(){
        ExcelUtility.writeToExcel( new LinkedList<>(Arrays.asList("Senaryo Adı", "Açıklama","Zaman")));
    }

    @Before
    public void beforeHook(Scenario scenario){

        ExcelUtility.writeToExcel(scenario.getName(), "senaryo başladı",getCurrentTime());
        ExcelUtility.writeToExcel("ali");
    }

    @After
    public void afterHook(Scenario scenario){
        if (scenario.isFailed()){
            System.out.println("başarısız");
            ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList(scenario.getName(), "başarısız",getCurrentTime())));
        }
        else {
            ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList(scenario.getName(), "başarılı",getCurrentTime())));
        }

        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList(scenario.getName(), "bitti",getCurrentTime())));
    }







}
