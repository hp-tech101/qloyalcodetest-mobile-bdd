package stepDefinitions;


import common.Utils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import testbase.common.Settings;

import static testbase.common.Settings.logger;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario)
    {
        logger.info(" -------- Starting execution of scenario : "+scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        logger.info("***********************");
        if(scenario.isFailed()) {
            logger.info(" ---------> "+scenario.getName()+" : Failed :-(");
        } else {
            logger.info(" ---------> "+scenario.getName()+" : Successful :-)");
        }



    }


}
