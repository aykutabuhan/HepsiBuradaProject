package runner;

import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        features = {"src/test/java/features"},

        plugin ={"com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport/ExtendReportRegression.html"},

        glue = {"stepDefinition"},

        dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @AfterClass
    public static void afterClass(){
        Reporter.loadXMLConfig("src/main/java/XMLFiles/extendReportSet.xml");
        //xml dosyasının yolu özel rapolarma için

        Reporter.setSystemInfo("QA Tester: ", "Aykut ABUHAN");
        Reporter.setSystemInfo("Application name: ", "DemoQA Text Box Test");
        Reporter.setSystemInfo("Operating System Info", System.getProperty("os.name")); //Çalıştığım sistem, windows yada osX
        Reporter.setSystemInfo("Department", "QA");
        Reporter.setTestRunnerOutput("Test execution Cucumber Report");
    }
}
