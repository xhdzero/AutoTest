package listenreport;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import listeners.TestFailListener;
import util.AttachmentUtil;
import util.DriverUtil;

@Listeners(TestFailListener.class)
public class PersionIssues {

	@Test(description="听取汇报添加个人问题")
	public void add(ITestContext tc) throws InterruptedException {
		WebDriver driver = (WebDriver)tc.getAttribute("driver");
		Thread.sleep(100);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='进驻动员'])[1]/following::div[1]")).click();
	    driver.findElement(By.id("cname")).click();
	    driver.findElement(By.id("cname")).clear();
	    driver.findElement(By.id("cname")).sendKeys("test1");
	    driver.findElement(By.id("time")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='六'])[2]/following::td[9]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='面上问题'])[1]/following::div[2]")).click();
	    driver.findElement(By.name("place")).click();
	    driver.findElement(By.name("place")).clear();
	    driver.findElement(By.name("place")).sendKeys("中软大厦");
	    driver.findElement(By.linkText("添加")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("itemname")).click();
	    driver.findElement(By.id("itemname")).clear();
	    driver.findElement(By.id("itemname")).sendKeys("张三");
	    driver.findElement(By.id("itemcompany")).click();
	    driver.findElement(By.id("itemcompany")).sendKeys("中软");
	    driver.findElement(By.id("itempost")).click();
	    driver.findElement(By.id("itempost")).clear();
	    driver.findElement(By.id("itempost")).sendKeys("职员");
	    driver.findElement(By.id("postType1")).click();
	    Thread.sleep(200);
	    driver.findElement(By.xpath("//*[text()='原班子成员']")).click();
	    driver.findElement(By.xpath("(//input[@value=''])[10]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='违反政治纪律行为'])[2]/following::dd[1]")).click();
	    driver.findElement(By.id("itemcontent")).click();
	    driver.findElement(By.id("itemcontent")).clear();
	    driver.findElement(By.id("itemcontent")).sendKeys("");
	    System.out.println(0001);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='支撑材料'])[1]/following::button[2]")).click();
	    Thread.sleep(2000);
	    System.out.println(111);
	    if(DriverUtil.isElementPresent(driver, By.xpath("//div[contains(text(),'不能为空') and @class='layui-layer-content']"))) {
	    	System.out.println(222);
	    	System.out.println(driver.findElement(By.xpath("//div[contains(text(),'不能为空') and @class='layui-layer-content']")).getText());
	    	AttachmentUtil.printFail(driver.findElement(By.xpath("//div[contains(text(),'不能为空') and @class='layui-layer-content']")).getText());
	    	assertEquals(false,"添加个人问题失败!");
	    }
	    
	    System.out.println(333);
	    driver.findElement(By.linkText("关闭")).click();
	    Thread.sleep(300);
	    driver.findElement(By.id("sss")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='确定进行保存操作？'])[1]/following::button[1]")).click();
	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("//*[@id=\"5e9d4cac-1e2a-4914-8188-bcca974b2c58\"]/div[1]/div/div[3]/button[1]")).click();
//	    Thread.sleep(1000);
	    
	    
	    /*driver.findElement(By.linkText("首页")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='统计分析'])[1]/following::div[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='用于问题线索'])[1]/following::div[3]")).click();
	    driver.findElement(By.id("name")).click();
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys("张三");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='>'])[1]/following::button[1]")).click();
*/	    
	}

}
