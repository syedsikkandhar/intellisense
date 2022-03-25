package Runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
  glue={"steps","Hooks"},
  //tags="@smoke",
  plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
  features= {"src/test/java/features/Login.feature"}
		 
		 
)

public class TestRunner extends AbstractTestNGCucumberTests 
{
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}

	
}
