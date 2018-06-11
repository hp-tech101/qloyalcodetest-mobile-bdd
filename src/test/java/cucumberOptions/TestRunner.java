package cucumberOptions;

import common.Utils;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.junit.runner.RunWith;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import testbase.common.AppiumServer;
import testbase.common.ConfigReader;
import testbase.common.Settings;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static testbase.common.Settings.driver;
import static testbase.common.Settings.logger;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/",
        glue = "stepDefinitions",
        tags = {"@regression"},
        plugin = { "pretty",
                   "json:target/cucumber-reports/cucumber-report1.json",
                   "junit:target/cucumber-reports/Cucumber.xml",
                    "html:target/cucumber-htmlreport"
                   }
)
public class TestRunner {

    private static AppiumServer server = null;



    @BeforeClass
    public static void setUp() {

        try {
            ConfigReader.PopulateSettings();
        } catch (IOException e) {
            System.out.println("Problem reading env_config.properties");
        }
        logger.info("++++++++ Executing setup @BeforeClass");

        archiveLogFiles();


        if (Settings.env.contentEquals("local")) {
            logger.info("Starting Appium server with logfile location : "+Settings.serverLogFile);
            server = new AppiumServer();
            server.start(Settings.serverLogFile);
        } else {
            logger.info("No need to start appium server current environment is not local");
        }
        DesiredCapabilities capabilities = Settings.capabilities;
        try {
            driver =
                    new AndroidDriver(new URL(Settings.url), capabilities);
        } catch (MalformedURLException e) {
            logger.error("Problem with init android driver");
        }
    }

    @AfterClass
    public static void tearDown() {

        logger.info("+++++++ calling tearDown @AfterClass");
        if (driver != null && Settings.env.contentEquals("local")) {
            driver.quit();
        }
        if (Settings.env.contentEquals("local")) {
            logger.info("Stopping the appium server");
            server.stop();
        } else {
            logger.info("No need to Stop the appium server because current Environment is not local");
        }

        if (Settings.env.contentEquals("local") && server.isServerRunning()) {
            logger.info("Server stopped Succesfully");
        } else {
            logger.warn("Server is still running");
        }

        try {
            FileUtils.copyFile(new File("./target/cucumber-htmlreport/index.html"), new File(Settings.htmlReportFile));
            logger.info("Html report generated");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void archiveLogFiles() {
        String timeStamp=Long.toString(System.currentTimeMillis());
        if((new File(Settings.serverLogFile)).exists()) {
            String[] tmpName=(Settings.serverLogFile).split("/");
            String name=timeStamp+"_"+tmpName[tmpName.length-1];
            Utils.archive(Settings.serverLogFile, "./src/artefacts/archieve/serverlogs/"+name);
        }

        if((new File(Settings.testExecutionLogFile)).exists()) {
            //String name=timeStamp+"_"+Settings.testExecutionLogFile;
            String[] tmpName=(Settings.testExecutionLogFile).split("/");
            String name=timeStamp+"_"+tmpName[tmpName.length-1];
            Utils.archive(Settings.testExecutionLogFile, "./src/artefacts/archieve/logs/"+name);
        }

        if((new File(Settings.htmlReportFile)).exists()) {
            //String name=timeStamp+"_"+Settings.htmlReportFile;
            String[] tmpName=(Settings.htmlReportFile).split("/");
            String name=timeStamp+"_"+tmpName[tmpName.length-1];
            Utils.archive(Settings.htmlReportFile, "./src/artefacts/archieve/htmlreports/"+name);
        }


    }
}
