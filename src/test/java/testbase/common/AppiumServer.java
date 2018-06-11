package testbase.common;

import java.io.File;

import common.Utils;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import static testbase.common.Settings.appiumMainJS;
import static testbase.common.Settings.nodeExecutable;

public class AppiumServer {
   /* private String node="/node.exe";
    private String appium=
            "/AppData/Roaming/npm/node_modules/appium/build/lib/main.js";*/
    private AppiumServiceBuilder appiumServerInstance=null;
    public AppiumServer() {
        appiumServerInstance = new AppiumServiceBuilder();
        File nodeJS=new File(Utils.getPathFromEnvVariable("NODE_HOME")+nodeExecutable);
        appiumServerInstance.usingDriverExecutable(nodeJS);
        File appiumMain=new File (Utils.getPathFromEnvVariable("userprofile")+appiumMainJS);
        appiumServerInstance.withAppiumJS(appiumMain);
    }

    public void _start() {
        appiumServerInstance.build().start();
    }

    public void start(String logFile) {
        appiumServerInstance.withLogFile(new File(logFile));
        appiumServerInstance.build().start();
    }

    public void start() {
       // String logFile="appium_server_"+System.currentTimeMillis()+"_.log";
        appiumServerInstance.withLogFile(new File(Settings.serverLogFile));
        appiumServerInstance.build().start();
    }
    public void stop() {
        appiumServerInstance.build().stop();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(isServerRunning()) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            appiumServerInstance.build().stop();
        }
    }

    public boolean isServerRunning() {
        return appiumServerInstance.build().isRunning();
    }

}
