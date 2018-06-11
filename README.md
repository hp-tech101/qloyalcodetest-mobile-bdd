# qloyalcodetest-mobile-bdd : You have following options to execute this project <br/>
### Option 1 : Run it on SauceLabs Cloud <br/>
### Option 2 : Run it locally on your machine <br/>
#### Note: By default the configuration are to run on the SauceLabs Cloud
### ------------------------------------------------------
## ===================================================== <br/>
### OPTION 1: How to execute the test on SauceLabs Cloud <br/>
## ===================================================== <br/>

#### 1. On command prompt: git clone git@github.com:hp-tech101/qloyalcodetest-mobile-bdd.git <br/>
#### 2. Enter Passphrase: Success17$$18 <br/>
#### 3. cd qloyalcodetest-mobile-bdd <br/>
#### 4. Execute following command in that order: <br/>
       a. command 1> mvn clean 
       b. command 2> mvn compile 
       c. command 3> mvn test 
#### 5. Reports <br/>
       a. HTML Report is generated in the project folder under src/artefacts/htmlreports/index.html 
       b. Test Execution log file is generated in the project folder under src/artefacts/logs/TestExecution.logs 
       c. appium server log (appium-server.log) file is generated on Saucelab account (see 1.1 under Important Point 1 for details)
       
### Important Point 1: To view the execution live on the Android Emulator or Server Logs of execution 
#### 1.1 login to saucelab account (details below) >> Go to dashboard (left panel) >> Click on Tab "Automated Test" and click on the latest job (on the top)
#### 1.2 Under each job , use the following tabs
           a. 'Watch' Tab contains the recording of the execution. Also this tab can be used to watch the test execution live (i.e. right after you have entered 'mvn test' from your terminal [Step 4.c above]) 
           b. 'Logs' Tab contains a drop down , choose 'appium-server.log' to view the server logs
#### 1.3 SauceLab Credentials
           a. SauceLab Url  : https://saucelabs.com/beta/login
           b. SauceLab User : himanshu-tech101
           c. SauceLab Pass : Eminence17$$18

### Important Point 2: To change the remote device on which to execute the test 
        a. Change the desiredcapability configuration in src\resources\config\desiredcapabilities\capability.xml under <sauce> ... </sauce>
        b. You may refer to https://wiki.saucelabs.com/display/DOCS/Platform+Configurator#/
       
## ================================================= <br/> 
### OPTION 2: How to execute the test on Local setup <br/>
## ================================================= <br/>

#### 1. On command prompt: git clone git@github.com:hp-tech101/qloyalcodetest-mobile-bdd.git <br/>
#### 2. Enter Passphrase: Success17$$18 <br/>
#### 3. cd qloyalcodetest-mobile-bdd <br/>
#### 4. Execute following command in that order: <br/>
       a. command 1> mvn clean 
       b. command 2> mvn compile 
       
#### 5. Make the following changes in the project:
##### a. Update src/resources/config/env_config.properties to set the current execution environment to localhost as follows:
                currentEnv=local
##### b. Update src/resources/config/desiredcapabilities/capability.xml to point to Android Virtual Device on which to run the test:
                <deviceName>Nexus5X</deviceName> 
                Note: deviceName tag to be updated under <local> .... </local>
                
                
           
