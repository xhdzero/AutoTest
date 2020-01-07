package gzwalone;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Step;
import listeners.TestFailListener;
import util.DriverUtil;

@Listeners(TestFailListener.class)
public class TestSuspected1 {
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "D://software//Firefox//geckodriver.exe");
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  @Step("测试登陆")
  @Test
  public void testUntitledTestCase(ITestContext tc) throws Exception {
    try {
    	
    	tc.setAttribute("driver", driver);
    	driver.get("http://localhost:8080/patrolStandAlone/login.jsp");
        //登陆 
        driver.findElement(By.name("sUser.loginName")).clear();
        driver.findElement(By.name("sUser.loginName")).sendKeys("");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"mod_r\"]/div[4]/a")).click();
       

//        WebElement userEmpty = driver.findElement(By.xpath("//*[@id=\"name-error\"]"));
//        WebElement passEmpty = driver.findElement(By.xpath("//*[@id=\"password-error\"]"));
        /*System.out.println(isElementPresent(By.xpath("//*[@id=\"name-error\"]"))==true);*/
        if(isElementPresent(By.xpath("//*[@id=\"name-error\"]"))) {
        	System.out.println(driver.findElement(By.xpath("//*[@id=\"name-error\"]")).getText());
        	
        	Assert.assertEquals("user", driver.findElement(By.xpath("//*[@id=\"name-error\"]")).getText());
        }
        if(isElementPresent(By.xpath("//*[@id=\"password-error\"]"))) {
        	System.out.println(driver.findElement(By.xpath("//*[@id=\"password-error\"]")).getText());
        	Assert.assertEquals("password", driver.findElement(By.xpath("//*[@id=\"password-error\"]")).getText());
        }
        if(DriverUtil.isAlertPresent(driver)) {
        	 Alert alert = driver.switchTo().alert();
             String text = alert.getText();
             System.out.println(text);
        }
       
    }catch(Exception e) {
    	System.out.println(e.getMessage());
    }
    //
    /*driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='进驻动员'])[1]/following::div[1]")).click();
    driver.findElement(By.id("cname")).click();
    driver.findElement(By.id("cname")).clear();
    driver.findElement(By.id("cname")).sendKeys("test1");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='六'])[2]/following::td[5]")).click();
    driver.findElement(By.name("place")).click();
    driver.findElement(By.name("place")).clear();
    driver.findElement(By.name("place")).sendKeys("*");
    driver.findElement(By.linkText("添加")).click();
    driver.findElement(By.id("itemname")).click();
    driver.findElement(By.id("itemname")).clear();
    driver.findElement(By.id("itemname")).sendKeys("qsc");
    driver.findElement(By.id("itemcompany")).click();
    driver.findElement(By.id("itemcompany")).clear();
    driver.findElement(By.id("itemcompany")).sendKeys("qsc");
    driver.findElement(By.id("itempost")).click();
    driver.findElement(By.id("itempost")).clear();
    driver.findElement(By.id("itempost")).sendKeys("qsc");
    driver.findElement(By.id("postType1")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='委管干部'])[1]/following::span[2]")).click();
    driver.findElement(By.xpath("(//input[@value=''])[10]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='请选择'])[2]/following::dd[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='支撑材料'])[1]/following::td[1]")).click();
    driver.findElement(By.id("itemcontent")).click();
    driver.findElement(By.id("itemcontent")).clear();
    driver.findElement(By.id("itemcontent")).sendKeys("qsc");
    driver.findElement(By.xpath("//div[@id='grwtProblem']/div[2]/div[2]/button/i")).click();
    driver.findElement(By.id("sss")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='确定进行保存操作？'])[1]/following::button[1]")).click();
    driver.findElement(By.linkText("首页")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='统计分析'])[1]/following::div[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='用于问题线索'])[1]/following::div[3]")).click();
    driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("qsc");
    driver.findElement(By.id("company")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=company | ]].
    driver.findElement(By.id("company")).clear();
    driver.findElement(By.id("company")).sendKeys("qsc");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='>'])[1]/following::button[1]")).click();*/
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
  
  /*@Attachment(value="screen shot",type="image/png")
	public byte[] saveScreenShot(WebDriver driver,String filename) throws IOException {
		String currentPath = System.getProperty("user.dir");
		System.out.println(currentPath);
		byte[] screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(currentPath+File.separator+"screenshot"+File.separator+filename));
		return screenShot;
	}*/
  
  
}
