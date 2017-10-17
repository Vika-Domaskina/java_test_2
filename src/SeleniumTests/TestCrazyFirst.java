package SeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Viktoriya.D on 10/10/2017.
 */
public class TestCrazyFirst {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Viktoriya.D\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.crazydomains.com.au/");
        driver.close();

    }
}
