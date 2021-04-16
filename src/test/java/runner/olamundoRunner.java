package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "src/test/resources/feature/olamundo.feature",
        glue = {"steps.olamundoStep"})
    public class olamundoRunner extends AbstractTestNGCucumberTests {
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
            return super.scenarios();
        }
    }
