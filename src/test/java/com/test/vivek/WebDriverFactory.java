package com.test.vivek;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Map;

public class WebDriverFactory {

    private static String browser;
    public WebDriver getDriver(Map<String, String> seleniumconfig) {
        browser = seleniumconfig.get("browser");

            if (browser.equalsIgnoreCase("firefox")) {
                return getFirefoxDriver();
            } else if (browser.equalsIgnoreCase("chrome")) {
                return getChromeDriver();
            } else if (browser.equalsIgnoreCase("Safari")) {
                return getSafariDriver();
            }

        return new FirefoxDriver();
    }

    private static WebDriver getChromeDriver() {
    	ChromeDriverService service;
    	ChromeDriver driver;
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		System.setProperty("webdriver.chrome.silentOutput", "true");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--dns-prefetch-disable");
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        service = new ChromeDriverService.Builder().usingAnyFreePort().build();
		driver = new ChromeDriver(service, options);
        return new ChromeDriver(options);
    }

    private static WebDriver getSafariDriver() {
        SafariOptions safariOptions = new SafariOptions();
        return new SafariDriver(safariOptions);
    }

    private static WebDriver getFirefoxDriver() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.cache.disk.enable", false);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("marionette", true);
        firefoxOptions.setCapability(FirefoxDriver.PROFILE, profile);
        return new FirefoxDriver(firefoxOptions);
    }
}
