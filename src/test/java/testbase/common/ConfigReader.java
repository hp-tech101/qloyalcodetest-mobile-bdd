package testbase.common;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import static testbase.common.Settings.logger;

public class ConfigReader {

	public static void PopulateSettings() throws IOException {
		ConfigReader reader = new ConfigReader();
		reader.ReadProperty();
	}
	
	private void ReadProperty() throws IOException {
		Properties p = new Properties();
//		p.load(getClass().getResourceAsStream("./src/main/resources/config/env_config.properties"));
        String env_config_fs="./src/resources/config/env_config.properties";
		File f = new File(env_config_fs);

		if(f.exists()) {
			System.out.println("config file found");
			p.load(new FileInputStream(f));
		} else {
			System.out.println("config file not found");
		}


		
		Settings.env = p.getProperty("currentEnv");
		//Settings.host = p.getProperty(Settings.env+"_host");
		//Settings.port = p.getProperty(Settings.env+"_port");
		Settings.url = p.getProperty(Settings.env+"_host")+":"+p.getProperty(Settings.env+"_port");
		//System.out.println("Env : "+Settings.env);
		//System.out.println("Config File : "+p.getProperty("desiredCapabilityConfigFile"));
		Settings.serverLogFile = p.getProperty("pathServerLogFile")+"/appium_server_"+Settings.env+".log";
		Settings.htmlReportFile = p.getProperty("pathHtmlLogFile")+"/index.html";
		Settings.testExecutionLogFile = p.getProperty("pathTxtLogFile")+"/TestExecution.log";

        Settings.logger = Logger.getLogger("[qloyalcodetest "+Settings.env+"]");
        PropertyConfigurator.configure("./src/resources/config/log4j.properties");



        logger.info("Test Environment details read from : "+env_config_fs);
        logger.info("Current Environment : "+Settings.env);
        logger.info("Desired Capability Config file : "+p.getProperty("desiredCapabilityConfigFile"));
        logger.info("Driver instance created using URL : "+Settings.url);

		Settings.capabilities = (new Capability(Settings.env,p.getProperty("desiredCapabilityConfigFile"))).getDesiredCapabilities(Settings.env);
		Settings.nodeExecutable = p.getProperty("nodeExecutable");
		Settings.appiumMainJS = p.getProperty("appiumMainJS");

	}
}

/*

	currentEnv=local
	desiredCapability=./src/main/resources/config/desiredcapabilities/capability.xml

#--credentials
	sauce.username=himanshu-tech101
	sauce.accesskey=bdd8e6ef-c1bc-495a-abe6-59e9f853a4f4

#--local
			local_host=http://127.0.0.1
	local_port=4723/wd/hub

#--sauce
			sauce_host=https://himanshu-tech101:bdd8e6ef-c1bc-495a-abe6-59e9f853a4f4@ondemand.saucelabs.com
	sauce_port=443/wd/hub
*/
