package jira.run;
import io.cucumber.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(features = "src/test/java/jira/features/JiraIssue.feature",
        glue= "jira/steps")
public class CucumberRunnerSequentialExecution extends AbstractTestNGCucumberTests{
}

