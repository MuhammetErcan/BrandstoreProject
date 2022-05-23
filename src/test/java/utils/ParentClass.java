package utils;

import Hook.Hook;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.Rectangle;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ParentClass {

   public     WebDriver driver;
   public     WebDriverWait wait;

   public ParentClass(){
       driver= Driver.getDriver();
       driver.manage().window().maximize();
       wait=new WebDriverWait(driver, Duration.ofSeconds(10));
   }

    /**
     * aldigi url"e driver.get eden method
     * @param url string
     */
   public void goToUrl(String url){
       driver.get(url);
   }

    /**
     * aldigi By class"indan locatora click eden method
     * @param locater By
     */
   public void clickTo(By locater){
       wait.until(ExpectedConditions.elementToBeClickable(locater)).click();
   }

    public void clickTo(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

   public void sendKeysTo(By locater, String text){
       wait.until(ExpectedConditions.visibilityOfElementLocated(locater)).clear();
       wait.until(ExpectedConditions.visibilityOfElementLocated(locater)).sendKeys(text);
   }

    public void sendKeysTo(By locator, String text, boolean clear){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if (clear)
            element.clear();
        element.sendKeys(text);
    }

    public void waitFor(By locater, WaitConditions waitConditions){
        switch (waitConditions){
            case exist:
                wait.until(ExpectedConditions.presenceOfElementLocated(locater));
                break;
            case clickable:
                wait.until(ExpectedConditions.elementToBeClickable(locater));
                break;
            case visible:
                wait.until(ExpectedConditions.visibilityOfElementLocated(locater));
                break;
        }
    }

   public void hoverWithLocator(By locater){
       List<WebElement>list=driver.findElements(locater);
       Actions builder=new Actions(driver);
       for (WebElement element:list) {
           builder.moveToElement(element).build().perform();
       }
   }

    public void hoverWithElement(WebElement element){
        hoverWithElement(element, 10);
    }

    public void hoverWithElement(WebElement element, long milis){
        new Actions(driver).moveToElement(element).pause(milis).build().perform();
    }

    public boolean isExist(By locator){
        return driver.findElements(locator).size()>0;
    }

    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Bu lokasyondaki elementte bu string ifade var mı
     */
    public void verifyTextIn(By locator, String str){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Assert.assertTrue(notification.getText().toLowerCase().contains(str.toLowerCase()));
    }

   public void scrollElement(WebElement element){
       JavascriptExecutor js=(JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView();",element);
   }
    public void scrollElement(By locator){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",driver.findElement(locator));
    }
    public void scrollElement(WebElement element, boolean bool){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView("+bool+")",element);
    }
    public void scrollElement(By locator, boolean bool){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView("+bool+")",driver.findElement(locator));
    }

    public void screenShotBySelenium() throws IOException {

        String scrName="ScreenShot_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));
        TakesScreenshot scr= (TakesScreenshot) driver ;
        File scrShot=scr.getScreenshotAs(OutputType.FILE);
        File destScr=new File("ScreenShots\\" + scrName+ ".png");
        FileUtils.copyFile(scrShot,destScr);

    }

    public void screenShotByRobot( ) throws AWTException, IOException {
        Robot robot=new Robot();
        //Kaydedilecek ekran alanını belirliyoruz.
        Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        //ekranda belirlenen dikdörtgeni resim olarak buffer a atar
        BufferedImage image= robot.createScreenCapture(rect);
        String fileName="ScreenShotRobot_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));
        File destFile=new File("ScreenShots\\" + fileName + ".png");
        ImageIO.write(image,"png", destFile);
    }

    public void screenShotByRobotWithLoca(int x, int y, int width, int height) throws AWTException, IOException {
        Robot robot=new Robot();
        Rectangle rect = new Rectangle(x,y,width,height);
        BufferedImage image= robot.createScreenCapture(rect);
        String fileName="ScreenShotRobot_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));
        File destFile=new File("ScreenShots\\" + fileName + ".png");
        ImageIO.write(image,"png", destFile);
    }

    public void clickTextInList(By locator, String text){
        List<WebElement>list=driver.findElements(locator);
        for (WebElement element:list) {
            if (element.getText().contains(text)){
                element.click();
                break;
            }
        }
    }

    public void clickTextInSelect(By locator, String text){
        WebElement selectButton=driver.findElement(locator);
        Select select =new Select(selectButton);
        List<WebElement>list=select.getOptions();
        for (WebElement element:list) {
            if (element.getText().contains(text)){
                element.click();
                break;
            }
        }
    }

    public void selectChoiceValues(By locator, String...value){
        List<WebElement>choicelist=driver.findElements(locator);
        if (!value[0].equalsIgnoreCase("all")){
            for (WebElement element:choicelist) {
                String text=element.getText();
                for (String val:value) {
                    if (text.equals(val)){
                        element.click();
                        break;
                    }
                }
            }
        }
        else {
            for (WebElement element:choicelist) {
                element.click();
            }
        }
    }


    public void quitDriver(){
        Driver.quitDriver();
    }
}
