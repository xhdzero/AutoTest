package base;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Step;
import listeners.TestFailListener;
import util.AttachmentUtil;
import util.DriverUtil;

@Listeners(TestFailListener.class)
public class LoginServer {

	private WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp(ITestContext tc) throws Exception {
		String currentPath = System.getProperty("user.dir");
		String driverPath = currentPath + File.separator + "driver" + File.separator + "geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		tc.setAttribute("driver", driver);
	}

	@Test(description = "登陆")
	public void login() {
		List<String> list = new ArrayList<String>();
		driver.get("http://localhost:8080/patrolStandAlone/login.jsp");
		driver.findElement(By.name("sUser.loginName")).clear();
		driver.findElement(By.name("sUser.loginName")).sendKeys("luyao");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin111111");
		driver.findElement(By.xpath("//*[@id=\"mod_r\"]/div[4]/a")).click();
		if (DriverUtil.isElementPresent(driver,By.xpath("//*[@id=\"name-error\"]"))) {
			System.out.println(driver.findElement(By.xpath("//*[@id=\"name-error\"]")).getText());
			list.add("账号必填!");
		}
		if (DriverUtil.isElementPresent(driver,By.xpath("//*[@id=\"password-error\"]"))) {
			System.out.println(driver.findElement(By.xpath("//*[@id=\"password-error\"]")).getText());
			list.add("密码必填!");
		}
		if (DriverUtil.isAlertPresent(driver)) {
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			list.add(text);
		}
		if(list.size()>0) {
			for(int i=0;i<list.size();i++) {
				AttachmentUtil.printFail(i+1+" : " + list.get(i));
			}
			assertEquals(false,"登陆失败!");
		}
	}

}
