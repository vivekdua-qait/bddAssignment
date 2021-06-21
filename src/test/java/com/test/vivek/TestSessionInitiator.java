package com.test.vivek;

import com.test.vivek.automation.Keywords;
import com.test.vivek.utils.YamlReader;
import com.test.vivek.utils.config_reader;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestSessionInitiator {

    protected WebDriver driver;
    private final WebDriverFactory wdfactory;
    protected static String product, browser;

    //Initiating page objects
    public Keywords pages;

    private void _initPage() {
        pages = new Keywords(driver);
    }

    public TestSessionInitiator(String testname) throws IOException {
        wdfactory = new WebDriverFactory();
        testInitiator();
    }

    public void testInitiator() throws IOException {
        YamlReader.setYamlFilePath();
        _configureBrowser();
        _initPage();
    }

    private void _configureBrowser()  {
        driver = wdfactory.getDriver(_getSessionConfig());
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config_reader.getProperty("timeout")), TimeUnit.SECONDS);
    }

    public static Map<String, String> _getSessionConfig() {
        String[] configKeys = { "tier", "browser","product", "timeout"};
        Map<String, String> config = new HashMap<String, String>();
        for (String string : configKeys) {
            try {
                if (System.getProperty(string).isEmpty())
                    config.put(string, config_reader.getProperty( string));
                else
                    config.put(string, System.getProperty(string));

            } catch (NullPointerException e) {
                config.put(string, config_reader.getProperty( string));

            }
        }
        return config;
    }
    public static String getProduct() {
        if (System.getProperty("product") != null) {
            product = System.getProperty("product");
        } else {
            product = _getSessionConfig().get("product");
        }
        return product;
    }
    public static String getBrowser() {
        if (System.getProperty("browser") != null) {
            browser = System.getProperty("browser");
        } else {
            browser = _getSessionConfig().get("browser");
        }
        return browser;
    }
    public static String getEnv() {
        String tier = System.getProperty("tier");
        if (tier == null) {
            tier = _getSessionConfig().get("tier");
        }
        return tier;
    }
    public void openUrl(String url) {
        driver.get(url);
    }

    public void closeTestSession() {
        driver.quit();
    }

}
