package util;

import io.qameta.allure.Attachment;

public class AttachmentUtil {

	@Attachment(value="错误信息")
	public static String printFail(String str) {
		return str;
	}

}
