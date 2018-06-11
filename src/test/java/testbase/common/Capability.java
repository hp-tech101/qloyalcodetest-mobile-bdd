package testbase.common;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.List;

public class Capability {

    private String nodePathLocal=null;
    private Document document = null;
    private String capability="./src/main/resources/config/desiredcapabilities/capability.xml";

    public Capability(String environment) {

        File capFile = new File(capability);
        if(capFile.exists()) {
            System.out.println("File exists :"+capability);
            SAXReader reader = new SAXReader();
            try {
                document = reader.read( capFile );
            } catch (DocumentException e) {
                e.printStackTrace();
            }
            System.out.println("Root element :" + document.getRootElement().getName());
            Element classElement = document.getRootElement();
            nodePathLocal="/capability/"+environment;
            try {
                document = reader.read( capFile );
            } catch (DocumentException e) {
                e.printStackTrace();
            }

        }
    }

    public Capability(String environment, String capabilityXML) {
        capability=capabilityXML;
        File capFile = new File(capability);
        if(capFile.exists()) {
            System.out.println("File exists :"+capability);
            SAXReader reader = new SAXReader();
            try {
                document = reader.read( capFile );
            } catch (DocumentException e) {
                e.printStackTrace();
            }
            System.out.println("Root element :" + document.getRootElement().getName());
            Element classElement = document.getRootElement();
            nodePathLocal="/capability/"+environment;
            try {
                document = reader.read( capFile );
            } catch (DocumentException e) {
                e.printStackTrace();
            }

        }
    }

    Node getParentRoot() {
        return document.selectSingleNode(nodePathLocal);
    }

    public List<Node> getChildNodes() {
        List<Node> childLocalNodes = getParentRoot().selectNodes("*");
        System.out.println("size of childLocalNodes : "+childLocalNodes.size());
        return childLocalNodes;
    }

    public DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String val=null;
        for ( Node childNode : getChildNodes()  ) {
            String key=childNode.getName();
            String value=((val=childNode.getText()).contentEquals(""))?"":val;
            System.out.println("|"+key +":  :"+value+"|");
            capabilities.setCapability(key,value);
        }
        return capabilities;
    }

    String getAppfsAbsolutePath(String value) {
        File fss=new File(value);
        System.out.println("Absolute Path = "+fss.getAbsolutePath());
        return fss.getAbsolutePath();
    }
    public DesiredCapabilities getDesiredCapabilities(String env) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String val=null;
        for ( Node childNode : getChildNodes()  ) {
            String key=childNode.getName();
            String value=((val=childNode.getText()).contentEquals(""))?"":val;
            System.out.println("|"+key +":  :"+value+"|");
            if(env.contentEquals("local") && key.contentEquals("app"))
                capabilities.setCapability(key,getAppfsAbsolutePath(value));
            else
                capabilities.setCapability(key,value);
        }
        return capabilities;
    }
}
