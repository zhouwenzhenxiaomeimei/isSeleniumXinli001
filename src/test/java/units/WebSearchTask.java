package units;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * @author zhouwenzhen@xinli001.com
 * @date 2021/3/18 15:05
 */
public class WebSearchTask {
    private static int waitShot=30;
    private static Logger logger = Logger.getLogger(WebSearchTask.class);



    public static void getUrl(WebDriver driver, String url){
        driver.get(url);
        logger.info("输入浏览器地址");
    }

    public static void clearInput(WebDriver driver){
        WebElement e =findElementByName(driver,"keyword");
        e.clear();
        logger.info("清空搜索内容");
    }

    public static void inputText(WebDriver driver,String keyword){
        WebElement e =findElementByName(driver,"keyword");
        e.sendKeys(keyword);
        logger.info("输入搜索内容");
    }

    public static void clickSearchButton(WebDriver driver){
        WebElement e =findElementByClassName(driver,"search_a");
        e.click();
        logger.info("点击搜索按钮");
    }


     public static void clickCepingButton(WebDriver driver){
         WebElement webElement = driver.findElement(By.xpath("//*[@data-name='test']"));

         webElement.click();
         webElement.click();
         logger.info("点击测评Tab");
     }

    public static void assertSearchResult(WebDriver driver,String keyword){
        String actualString =driver.findElement(By.xpath("(//h2[@class='info-title'])[1]")).getText();
        Assert.assertEquals(true, actualString.contains(keyword));
        logger.info("验证搜索结果");
    }






    public static WebElement findElementByName(WebDriver driver,String name){
        return  driver.findElement(By.name(name));

    }

    public static WebElement findElementByClassName(WebDriver driver,String className){
        return  driver.findElement(By.className(className));

    }

    public static WebElement findElementByXpath(WebDriver driver,String xPath){
        return  driver.findElement(By.xpath(xPath));

    }

    public static  void switchToHandle(WebDriver driver) {
        String handle = driver.getWindowHandle();
        //获取所有句柄，循环判断是否等于当前句柄
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle))
                continue;
            driver.switchTo().window(handles);
        }
    }


    public static void wait(int sec){

        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
