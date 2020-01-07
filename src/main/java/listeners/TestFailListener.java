package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class TestFailListener extends TestListenerAdapter {

	@Override
	public void onTestFailure(ITestResult tr) {
		ITestContext tx = tr.getTestContext();
		screenshot(tx);
	}

	@Attachment(value="screen shot",type="image/png")
	@Step("截图")
	public byte[] screenshot(ITestContext tx) {
		TakesScreenshot driver = (TakesScreenshot)tx.getAttribute("driver");
		byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;
	}

}
