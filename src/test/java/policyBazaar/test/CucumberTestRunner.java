package policyBazaar.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\Features",
        glue = "stepDefination",
        plugin = {
                "pretty", "html:reportsCucumber/myreport.html",
                "json:reportsCucumber/myreport.json"
        },
        //tags = "@Sanity"
        dryRun=false,
                monochrome=true
)
public class CucumberTestRunner {

}
