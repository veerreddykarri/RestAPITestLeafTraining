package servicenow.run;
import io.cucumber.testng.*;

@CucumberOptions(features = "src/test/java/servicenow.run.features/ChangeManagement.feature",
        glue= "servicenow/steps")
public class CucumberRunnerSequentialExecution extends AbstractTestNGCucumberTests{
}
