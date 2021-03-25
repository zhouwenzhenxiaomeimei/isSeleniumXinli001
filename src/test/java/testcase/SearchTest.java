package testcase;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import units.WebUIBase;
import units.WebSearchTask;


/**
 * @author zhouwenzhen@xinli001.com
 * @date 2021/3/11 15:00
 */
class SearchTest extends WebUIBase {

    private static Logger logger = Logger.getLogger(SearchTest.class);

    @Test

    void cepingOnSearchAiQing() throws InterruptedException {

        search("爱情");
    }

    @Test
    void cepingOnSearchYouQing() throws InterruptedException {

        search("疫情");
    }


     private void search(String keyword){

        // 前往浏览器地址
         WebSearchTask.getUrl(driver,"https://www.xinli001.com/ceshi?source=pc-home");

        //清空搜索内容
         WebSearchTask.clearInput(driver);

        //输入内容
         WebSearchTask.inputText(driver,keyword);

        //点击搜索按钮
         driver.findElement(By.className("search_a")).click();

        //切换当前句柄
         WebSearchTask.switchToHandle(driver);


         WebSearchTask.wait(5);

        //点击测试按钮

         WebSearchTask.clickCepingButton(driver);

         WebSearchTask.wait(5);

         // 验证搜索结果
         WebSearchTask.assertSearchResult(driver,"花朵");



    }




}