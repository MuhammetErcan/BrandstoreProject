package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Driver {

    private static ThreadLocal<WebDriver>driver=new ThreadLocal<>();
    public static ThreadLocal<Browser>browserNames=new ThreadLocal<>();

    public static WebDriver getDriver(){
        return getDriver(Browser.CHROME);
    }

    public static WebDriver getDriver(Browser browser){

        if (driver.get()==null){
            if (browserNames.get()==null){
                browserNames.set(browser);
            }
            switch (browserNames.get()){
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                case OPERA:
                    WebDriverManager.operadriver().setup();
                    driver.set(new OperaDriver());
                    break;
                case EDGE:
                    WebDriverManager.edgedriver();
                    driver.set(new EdgeDriver());
                    break;
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
            }
        }
        return driver.get();
    }

    public static void quitDriver(){
        if (driver.get()!=null){
            driver.get().quit();
            driver.set(null);
        }
    }
}
