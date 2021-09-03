package IntegrationTest;

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

public class Topic_01_Annotation { 
//  @Test(dataProvider = "dp")
	@Test(groups = {"integration", "regresstion"})
	  public void TC_01_Get_Student_By_Name() {
		  System.out.println("Run Testcase 01");
	  }
	@Test(groups = {"integration", "regresstion"})
	public void TC_02_Update_Student_By_Id() {
		System.out.println("Run Testcase 02");
	}
	
	@Test(groups = {"integration", "regresstion"})
	public void TC_03_Delete_Student_By_Id() {
		System.out.println("Run Testcase 03");
	}

}
