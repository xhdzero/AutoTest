package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Attachment;


public class ScreenShot {

	@Attachment(value="screen shot",type="image/png")
	public static byte[] saveScreenShot(WebDriver driver,String filename) throws IOException {
		String currentPath = System.getProperty("user.dir");
		System.out.println(currentPath);
		byte[] screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(currentPath+File.separator+"screenshot"+File.separator+filename));
		return screenShot;
	}

}
