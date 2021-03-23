package units;



import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import testcase.SearchTest;

import java.io.*;
import java.util.Properties;

/**
 * @author zhouwenzhen@xinli001.com
 * @date 2021/3/16 11:19
 */
 public class   WebUIBase {
     public static WebDriver driver;
    private static Logger logger = Logger.getLogger(WebUIBase.class);


    @BeforeAll
    public static void init(){

        String chrome= System.getenv("currentBrowser");
        logger.info("浏览器是"+chrome);
        driver=getDriver(chrome);
        System.out.println(System.getProperty("user.home") );



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
        if(curBrowser!=null&&curBrowser.equalsIgnoreCase("chrome")){
            String chrome_path=getProperties("CHROME_PATH");
            System.setProperty("webdriver.chrome.driver", chrome_path);
            //ChromeOptions chromeOptions = new ChromeOptions();

           // chromeOptions.setBinary(chrome_path);
            driver = new ChromeDriver();
        }else if(curBrowser!=null&&curBrowser.equalsIgnoreCase("nogui")){
             String chrome_path=getProperties("CHROME_PATH");
             System.setProperty("webdriver.chrome.driver", chrome_path);
             ChromeOptions chromeOptions = new ChromeOptions();
             chromeOptions.addArguments("--headless"); //静默模式
             //chromeOptions.setBinary("D:\\chromedriver_win32_1\\chromedriver.exe");
             driver = new ChromeDriver(chromeOptions);

        }else {
            String chrome_path=getProperties("CHROME_PATH");
            System.setProperty("webdriver.chrome.driver", chrome_path);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless"); //静默模式
            //chromeOptions.setBinary("D:\\chromedriver_win32_1\\chromedriver.exe");
            driver = new ChromeDriver(chromeOptions);
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
