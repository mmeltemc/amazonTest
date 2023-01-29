import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class driver {
    public static void main (String[] args) throws IOException, InterruptedException {

        //driver tanımla,oluştur
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
        driver.manage().window().maximize();
        //web tarayıcısı kontrol etme - get,navigate,close,manage,switchTo,quit
        //web elementi seçme findElement,findElements,click
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        //giris
        String mail = "mujganmeltemcaglacullu@gmail.com";
        String password = "123456.";
        WebElement mailElement = driver.findElement(By.id("ap_email"));
        mailElement.click();
        mailElement.sendKeys(mail);


        WebElement continueElement = driver.findElement(By.id("continue"));
        continueElement.click();

        WebElement passwordElement = driver.findElement(By.id("ap_password"));
        passwordElement.click();
        passwordElement.sendKeys(password);

        WebElement signInElement = driver.findElement(By.id("signInSubmit"));
        signInElement.click();

        System.out.println("Amazon hesabına giriş yapıldı.\n");
        WebDriver.Timeouts timeouts1 = timeouts;


        WebElement searchElement = driver.findElement(By.id("twotabsearchtextbox"));
        searchElement.click();
        searchElement.sendKeys("headphones");


        // searchElement.submit();
        WebElement searchButtonElement = driver.findElement(By.id("nav-search-submit-button"));
        searchButtonElement.click();


        WebElement propertyElement = driver.findElement(By.id("p_n_feature_two_browse-bin/23746030011"));
        propertyElement.click();
        WebDriver.Timeouts timeouts3 = timeouts;

        //filter
        WebElement filterElement = driver.findElement(By.className("a-dropdown-prompt"));
        filterElement.click();

        WebElement highPriceElement = driver.findElement(By.id("s-result-sort-select_2"));
        highPriceElement.click();

        //String xPathName;

        /*for (int i=1;i <=10 ; i++){
            xPathName = "//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']";
            WebElement xPathElement = driver.findElement(By.xpath(xPathName));
            System.out.println(xPathElement.getText());
           } */



        List<WebElement> elements = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
        File file1 = new File("highPriceProduct.txt");
        FileWriter fw = new FileWriter(file1);
        PrintWriter pw = new PrintWriter(fw);
        pw.println("Fiyatı en yüksek - Active Noise Cancelation - İlk 10 Tanesi");
        for(int i=0; i<=9 ; i++){
            System.out.println(elements.get(i).getText());

            pw.println(elements.get(i).getText()+ "\n");

        }
        pw.close();

        //ikinci kısım

        WebDriver.Timeouts timeouts4 = timeouts;

        WebElement filterElement2 = driver.findElement(By.className("a-dropdown-label"));
        filterElement2.click();

        WebElement lowPriceElement = driver.findElement(By.id("s-result-sort-select_1"));
        lowPriceElement.click();

        driver.get("https://www.amazon.com/s?k=headphones&i=electronics&rh=n%3A172541%2Cp_n_feature_two_browse-bin%3A23746030011%2Cp_72%3A1248879011&s=price-asc-rank&dc&ds=v1%3AflaCxUos2t7%2FGwbP9W5VMiIRYoxGugOxL6IgWmX6hQQ&crid=2455OPMPR3QA&qid=1674984397&rnid=1248877011&sprefix=he%2Caps%2C742&ref=sr_nr_p_72_1");

        WebElement selectBuy = driver.findElement(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
        selectBuy.click();

        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
        addToCart.click();
        WebElement clickAddToCart = driver.findElement(By.id("nav-cart-count-container"));
        clickAddToCart.click();

        /*WebElement user = driver.findElement(By.xpath("//a[@class='nav-a nav-a-2 nav-truncate   nav-progressive-attribute']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(user);
        actions.clickAndHold();

        WebElement signOut = driver.findElement(By.className("nav-text"));
        signOut.click(); */

        String signOutURL="https://www.amazon.com/gp/flex/sign-out.html?path=%2Fgp%2Fyourstore%2Fhome&signIn=1&useRedirectOnSuccess=1&action=sign-out&ref_=nav_signout";
        driver.get(signOutURL);

        WebDriver.Timeouts timeouts5 = timeouts;
        driver.quit();
    }
}

