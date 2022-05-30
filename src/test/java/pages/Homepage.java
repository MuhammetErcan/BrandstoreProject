package pages;

import Hook.Hook;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.ExcelUtility;
import utils.ParentClass;
import utils.WaitConditions;

import java.util.*;

public class Homepage extends ParentClass implements Locators {

    public void isThereImageAllProducts() {
        for (int i = 0; i < 2; i++) {
            List<WebElement> listOfProducts = driver.findElements(lProducts);
            for (int j = 0; j < listOfProducts.size(); j++) {
                wait.until(ExpectedConditions.visibilityOf(listOfProducts.get(i).findElement(lProductsImage)));
            }
            clickTo(lNext);
        }

        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList("", "Alle produkte tüm resimler tanımlı", ExcelUtility.getCurrentTime())));
    }

    public void isTherePriceAllProducts() {
        sleep(3000);
        for (int i = 0; i < 2; i++) {
            List<WebElement> listOfProducts = driver.findElements(lProducts2);
            for (int j = 0; j < listOfProducts.size(); j++) {
                wait.until(ExpectedConditions.visibilityOf(listOfProducts.get(i).findElement(lPrices)));
                Assert.assertTrue(listOfProducts.get(i).findElement(lPrices).getText().contains("CHF"));
            }
            clickTo(lNext);
        }

        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList("", "Alle produkte ÜRÜNLERDE FİYAT VAR", ExcelUtility.getCurrentTime())));
    }

    public void controlKategorienDropdownMethod() {
        clickTo(lKategorien);
        List<WebElement> listDropdown = driver.findElements(lDropdownList);
        int randomChoose = (int) (Math.random() * 10);

        String choosenProduktName = listDropdown.get(randomChoose).getText();
        clickTo(listDropdown.get(randomChoose));

        int numberInName = Integer.parseInt(choosenProduktName.replaceAll("[^0-9]", ""));
        int selectedKategorienProductsSize = driver.findElements(lselectedKategorienProducts).size();


        if (numberInName > 12) {
            scrollElement(driver.findElement(lNext));
            clickTo(lNext);
            int selectedKategorienProductsSize2 = driver.findElements(lselectedKategorienProducts).size();
            int totalProductSize = selectedKategorienProductsSize + selectedKategorienProductsSize2;
            Assert.assertEquals(numberInName, totalProductSize);
        } else {
            Assert.assertEquals(numberInName, selectedKategorienProductsSize);
        }

        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList("", "kategoriler dropdown calisiyor", ExcelUtility.getCurrentTime())));
    }

    public void sortByPriceAscendingMethod() {
        clickTo(lSelectSort);
        clickTo(lAscendingSort);
        for (int i = 0; i < 2; i++) {
            List<WebElement> pricesOfProducts = driver.findElements(lRowProductsPrices);
            List<Double> doublePricesList = new LinkedList<>();

            for (int j = 0; j < pricesOfProducts.size(); j++) {
                String pricesString = pricesOfProducts.get(j).getText();
                String priceOnly = pricesString.substring(pricesString.lastIndexOf("F") + 2, pricesString.indexOf("i") - 1);
                double priceOnlyDouble = Double.parseDouble(priceOnly);
                doublePricesList.add(priceOnlyDouble);
            }

            for (int k = 0; k < doublePricesList.size() - 1; k++) {
                if (!(doublePricesList.get(k) <= doublePricesList.get(k + 1))) {
                    Assert.fail();
                } else {
                    Assert.assertTrue(true);
                }
            }
            scrollElement(driver.findElement(lNext));
            clickTo(lNext);
        }

        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList("", "fiyat artan sıralama calisiyor", ExcelUtility.getCurrentTime())));
    }

    public void sortByPriceDescMethod() {
        clickTo(lSelectSort);
        clickTo(lDecrasingSort);
        for (int i = 0; i < 2; i++) {
            List<WebElement> pricesOfProducts = driver.findElements(lRowProductsPrices);
            List<Double> doublePricesList = new LinkedList<>();

            for (int j = 0; j < pricesOfProducts.size(); j++) {
                String pricesString = pricesOfProducts.get(j).getText();
                String priceOnly = pricesString.substring(pricesString.lastIndexOf("F") + 2, pricesString.indexOf("i") - 1);
                double priceOnlyDouble = Double.parseDouble(priceOnly);
                doublePricesList.add(priceOnlyDouble);
            }

            for (int k = 0; k < doublePricesList.size() - 1; k++) {
                if (!(doublePricesList.get(k) >= doublePricesList.get(k + 1))) {
                    Assert.fail();
                } else {
                    Assert.assertTrue(true);
                }
            }
            scrollElement(driver.findElement(lNext));
            clickTo(lNext);
        }

        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList("", "fiyat azalan sıralama calisiyor", ExcelUtility.getCurrentTime())));
    }

    public void sortByRatingMethod() {
        clickTo(lSelectSort);
        clickTo(lRatingSort);

        List<WebElement> ratingOfProducts = driver.findElements(lProductsRating);
        for (int i = 0; i < ratingOfProducts.size(); i++) {
            System.out.println(ratingOfProducts.get(i).getText());

        }
    }

    public void filterNachPreisMethod() {
        /*
        clickTo(lProdukteFilter);
        Actions builder = new Actions(driver);
        Action build = builder.dragAndDropBy(driver.findElement(lLeftSlider),12,0).build();
        build.perform();

         */


    }

    public void filterMethod(By inputLocator,By lClickButton,  String text) {
        clickTo(lProdukteFilter);
        clickTo(inputLocator);
        List<WebElement> listOfColours = driver.findElements(lColours);
        int randomSayi = (int) (Math.random() * listOfColours.size());
        String choosenColourName = listOfColours.get(randomSayi).getText();
        clickTo(listOfColours.get(randomSayi));
        clickTo(lClickButton);
        sleep(5000);
        List<WebElement> produkts = driver.findElements(lProducts);
        int randomSayi2 = (int) (Math.random() * produkts.size());

        sleep(5000);

        clickTo(produkts.get(randomSayi2));
        sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        //js.executeScript("arguments[0].scrollIntoView(false);",driver.findElement(lInformation));
        sleep(500);
        clickTo(lInformation);
        String tableString = driver.findElement(lTable).getText();
        Assert.assertTrue(tableString.contains(choosenColourName));


        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList("", text + " filtreleme calisiyor", ExcelUtility.getCurrentTime())));
    }

    public void addToFavoriteRandomMethod() {
        sleep(3000);
        List<WebElement>listOfFavoriteButtons=driver.findElements(lAddFavoriteButtons);
        int randomsayi= (int) (Math.random()*listOfFavoriteButtons.size());

        String addedFavoriteProductsName=driver.findElements(lProduktsnames).get(randomsayi).getText();

        clickTo(listOfFavoriteButtons.get(randomsayi));
        sleep(4000);
        scrollElement(driver.findElement(lWunschlist));
        clickTo(lWunschlist);

        String favoriteProductName=driver.findElement(lFavoriteProductNameInWunschlist).getText();
        Assert.assertEquals(addedFavoriteProductsName,favoriteProductName);

    }

    public void deleteFavoriteMethod(){
        clickTo(lRemoveFavoriteButton);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(lFavoriteProductNameInWunschlist));
        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList("",  " Favorilere ürün ekleyip, kaldirma", ExcelUtility.getCurrentTime())));
    }

    public void searchProductOnMenuMethod(String text) {
        clickTo(lSearchButtonOnMenu);
        sendKeysTo(lInputSearch,text+ Keys.ENTER);

        List<WebElement>list=driver.findElements(lSearchedProducts);
        for (WebElement product : list) {
            Assert.assertTrue(product.getText().contains(text));

        }
        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList("","menü kısmında arama fonsiyonu düzgün çalışıyor",ExcelUtility.getCurrentTime())));
    }

    public void searchProductLeft(String text){
        //scrollElement(driver.findElement(lInputSearchLeft));
        sendKeysTo(lInputSearchLeft,text+Keys.ENTER);
        //sleep(2000);
        List<WebElement>list=driver.findElements(lSearchedProducts);
        for (WebElement product : list) {
            Assert.assertTrue(product.getText().contains(text));

        }
        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList("","sol alt kısımda arama fonsiyonu düzgün çalışıyor",ExcelUtility.getCurrentTime())));

    }

    public void productComparisonMethod() {
        List<WebElement>list=driver.findElements(lProduktsnames);
        int randomSayi = (int)(Math.random()*list.size());
        String firstProductName=list.get(randomSayi).getText();
        clickTo(list.get(randomSayi));
        clickTo(lAddComparison);
        clickTo(lCloseButton);
        clickTo(lAusblenden);
        clickTo(lAlleProdukte);
        List<WebElement>list2=driver.findElements(lProduktsnames);
        int randomSayi2 = (int)(Math.random()*list2.size());
        String secondProductName=list2.get(randomSayi2).getText();
        clickTo(list2.get(randomSayi2));
        clickTo(lAddComparison);
        sleep(2000);
        clickTo(lCloseButton);
        sleep(6000);
        clickTo(lVergleischlisteFalse);
        //sleep(3000);
        String anasayfaId = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(anasayfaId)){
                driver.switchTo().window(windowHandle);
            }
        }
        Assert.assertTrue(driver.findElement(lComparisonFistProductName).getText().contains(firstProductName));
       Assert.assertTrue(driver.findElement(lComparisonSecondProductName).getText().contains(secondProductName));
        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList("","ürün karşılaştırma çalışıyor",ExcelUtility.getCurrentTime())));
    }

    public void addProductToCartMethod() {
        List<WebElement>list=driver.findElements(lProductAddToCartButtons);
        int randomSayi=(int)(Math.random()*list.size());
        String buttonName= list.get(randomSayi).getText();
        List<WebElement>products=driver.findElements(lProduktsnames);
        String productName=products.get(randomSayi).getText();
        clickTo(list.get(randomSayi));

        if (buttonName.equalsIgnoreCase("In den Warenkorb")){
            sleep(2000);
            clickTo(lWarenkorb);
            Assert.assertTrue(driver.findElement(lProductinWarenkorb).getText().contains(productName));
        }
        else {
            clickTo(lGrosseButton);
            clickTo(driver.findElements(lOptionsInGross).get(1));
            clickTo(lSubmitButtonForProduct);
            sleep(3000);
            clickTo(lWarenkorb);
            sleep(2000);
            Assert.assertTrue(driver.findElement(lProductinWarenkorb).getText().contains(productName));
        }
        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList("","Ürünler sepete dogru bilgiler ile eklenebiliyor mu",ExcelUtility.getCurrentTime())));

    }

    public void updateCartMethod(){
        String priceString=driver.findElement(lproductPriceInCart).getText();
        String justPrice=priceString.substring(priceString.indexOf("F")+1);
        double justPriceDouble=Double.parseDouble(justPrice);
        clickTo(lProductPlus);
        clickTo(lButtonUpdateCart);
        sleep(6000);
        String priceString2=driver.findElement(lTotalPrice).getText();
        String justPrice2=priceString2.substring((priceString2.indexOf("F"))+1);
        double justPriceDouble2=Double.parseDouble(justPrice2);
        double expected= justPriceDouble * 2.0;
        Assert.assertEquals(justPriceDouble2,expected);
        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList("","Sepette gücelleme islemi yapilabiliyor",ExcelUtility.getCurrentTime())));
    }

    public void buyProductMethod() {
        scrollElement(lGoExitButton,false);
        clickTo(lGoExitButton);
        sendKeysTo(lInputName,"ali");
        sendKeysTo(lInputSurName,"ali");
        sendKeysTo(lInputRegion,"ist");
        sendKeysTo(lPostCode, "4310");
        sendKeysTo(lCity,"ist");
        clickTo(lSelectKantonButton);
        clickTo(lSelectAargau);
        sendKeysTo(lPhone,"12332424");
        sendKeysTo(lEmail,"weefsf@gmail.com");
        clickTo(lContinue);
        sleep(3000);
        scrollElement(lCreeditCartButton,false);
        clickTo(lCreeditCartButton);
        wait.until(ExpectedConditions.elementToBeSelected(lCreeditCartButton));
        sleep(7000);
        clickTo(lcheckBox);
        clickTo(lSendButton);
        sleep(3000);
        waitFor(lTextForBuy,WaitConditions.visible);
        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList("","ürün satın alma başarılı",ExcelUtility.getCurrentTime())));
        String bestSellerNumString=driver.findElement(lBestSellerNum).getText();
        clickTo(lMeinKonto);
        waitFor(lGoToBestellungenButton,WaitConditions.clickable);
        clickTo(lGoToBestellungenButton);
        String bestellungNumStringLast=driver.findElement(lBestellungNum).getText();
        Assert.assertTrue(bestellungNumStringLast.contains(bestSellerNumString));
        System.out.println("işlem başarılı");
        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList("","satın alınan ürün siparişler bölümünde mevcut",ExcelUtility.getCurrentTime())));



    }



}
