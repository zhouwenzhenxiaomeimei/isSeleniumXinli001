package units;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.util.Properties;

/**
 * @author zhouwenzhen@xinli001.com
 * @date 2021/3/16 11:19
 */
 public class   WebUIBase {
     public static WebDriver driver;

    @BeforeAll
    public static void init(){

        driver=getDriver("chrome");



    }

    @AfterAll
    public static void end(){
        if (driver==null){
            return;
        }
        driver.quit();
    }


    private static WebDriver  getDriver(String curBrowser){
        WebDriver driver = null;
        if(curBrowser.equalsIgnoreCase("chrome")){
            String chrome_path=getProperties("CHROME_PATH");
            System.setProperty("webdriver.chrome.driver", chrome_path);
            driver = new ChromeDriver();
        }else if(curBrowser.equalsIgnoreCase("nogui")){
             String chrome_path=getProperties("CHROME_PATH");
             System.setProperty("webdriver.chrome.driver", chrome_path);
             driver = new ChromeDriver();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless"); //静默模式

        }

        return driver ;

    }

    private static String getProperties(String key)  {
        Properties prop=new Properties();
        try {
        InputStream inputStream=new BufferedInputStream(new FileInputStream(new File("src/test/resources/config.properties")));

            prop.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
         return prop.getProperty(key);
    }



}
