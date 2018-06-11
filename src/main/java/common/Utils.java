package common;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Utils {
    public static String getPathFromEnvVariable(String env_var) {
        String absPath=null;
        absPath=System.getenv(env_var);
        absPath.replace("\\","/");
        return absPath;
    }

    public static void archive(String srcFile, String targetFile) {
        File sFile = new File(srcFile);
        File dFile = new File(targetFile);
        if(sFile.exists()) {
            try {
                FileUtils.copyFile(sFile,dFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File not found : "+srcFile);
        }
    }


}
