package MobileAPP;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Topic_01_Mobile { 

	@Test(groups = {"mobile", "regresstion"})
	  public void TC_01_New_Certificate() {
		  System.out.println("Run Testcase 01");
	  }
	@Test(groups = {"mobile", "regresstion"})
	public void TC_02_View_Certificate() {
		System.out.println("Run Testcase 02");
	}
	
	@Test(groups = {"mobile", "regresstion"})
	public void TC_03_Delete_Certificate() {
		System.out.println("Run Testcase 03");
	}

}
