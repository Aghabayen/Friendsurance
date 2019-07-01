package intermidiate.classes;

import org.testng.annotations.BeforeClass;

import main.test.MainDriver;
import main.test.TestConstants.TestData;

public class LaunchLoginPage extends MainDriver {

	@BeforeClass
	public void launchLogin() {
		driver.get(TestData.ENVIRONMENT);
	}
}
