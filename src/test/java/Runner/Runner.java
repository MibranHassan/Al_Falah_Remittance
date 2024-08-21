package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
//                "Features/gotoLogin.feature",
//                "Features/Login.feature",
//                "Features/dashboard.feature",
                "Features/Initiate_Remittance.feature"
        }, glue={"stepDefinition"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class Runner {
}
