package BrowserAccess;

import Util.GlobalFunction;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang.SystemUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BrowserControl {

    public static BrowserControl INSTANCE = new BrowserControl();
    static Properties prop = new Properties();
    public static String environment;
    public static String ChromeBrowser;
    public static String Firebox;
    public static String Edge;
    public static String IE;




    public static void loadPropertiesFile() {

        try {
            //String filename = "src//test//resources//Browser.properties";
            String filename = "src/test/resources/Browser.properties";
            BrowserControl.class.getClassLoader().getResourceAsStream(filename);
            prop.load(new FileInputStream(filename));
            ChromeBrowser=prop.getProperty("ChromeBrowser");
            Firebox=prop.getProperty("FirefoxBrowser");
            IE=prop.getProperty("InternetExplorer");

            Edge=prop.getProperty("EdgeBrowser");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openBrowser() {


        //Load the properties file
        loadPropertiesFile();

        if (prop.getProperty("ChromeBrowser").compareToIgnoreCase("Yes") == 0) {
            ChromeOptions chromeoptions = new ChromeOptions();
            chromeoptions.setAcceptInsecureCerts(true);
            //chromeoptions.addArguments("-headless");
            chromeoptions.addArguments("-incognito");
          // System.setProperty("webdriver.chrome.driver", getDriverPath());
            WebDriverManager.chromedriver().setup();
            GlobalFunction.driver = new ChromeDriver(chromeoptions);
            GlobalFunction.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            GlobalFunction.driver.manage().window().maximize();
            environment=prop.getProperty("URl");
            GlobalFunction.driver.get(environment);


        }

       /* if (prop.getProperty("FirefoxBrowser").compareToIgnoreCase("Yes") == 0) {
            System.setProperty("webdriver.gecko.driver", getDriverPath());

            ReusableFunction.driver = new FirefoxDriver();
            ReusableFunction.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            ReusableFunction.driver.manage().window().maximize();
            ReusableFunction.driver.get(prop.getProperty("DEV"));


        }

        if (prop.getProperty("InternetExplorer").compareToIgnoreCase("Yes") == 0) {
            System.setProperty("webdriver.ie.driver", getDriverPath());
            ReusableFunction.driver = new InternetExplorerDriver();
            ReusableFunction.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            ReusableFunction.driver.manage().window().maximize();
            ReusableFunction.driver.get(prop.getProperty("DEV"));
        }

        if (prop.getProperty("EdgeBrowser").compareToIgnoreCase("Yes") == 0) {
            System.setProperty("webdriver.edge.driver", getDriverPath());
            ReusableFunction.driver = new EdgeDriver();
            ReusableFunction.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            ReusableFunction.driver.manage().window().maximize();
            ReusableFunction.driver.get(prop.getProperty("DEV"));
        }*/
    }

    private String getDriverPath() {
        String driverPath = "drivers/%s";
        if (SystemUtils.IS_OS_MAC) {
            return String.format(driverPath, "chromedriver");
        } else {
            return String.format(driverPath, "chromedriver.exe");
        }
    }

    public static BrowserControl getInstance() {
        return INSTANCE;
    }

}
