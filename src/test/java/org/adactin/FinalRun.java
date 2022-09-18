package org.adactin;

import java.io.IOException;

import org.testng.annotations.Test;

public class FinalRun extends BaseClassA {
@Test(priority = 0)
	private void tc01() {
		driver("chrome");
		launchUrl("https://adactinhotelapp.com/");

	}
@Test(priority = 1)
	private void tc02() throws IOException {
		SearchHotel s1 = new SearchHotel();
		s1.login(getExcelDatas(1, 0, "keyan"), getExcelDatas(1, 1, "keyan"));
	}

}
