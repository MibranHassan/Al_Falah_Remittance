package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class baseclassdriver {
    private static WebDriver driver;

    private baseclassdriver(){};

    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            FileInputStream input = null;
        try {
            input = new FileInputStream("target\\config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Properties obj = new Properties();
        try {
            obj.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        }
        return driver;
    }
}
