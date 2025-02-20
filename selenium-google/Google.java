import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Google {

    private static WebDriver edgeDriver() {
        var options = new EdgeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", List.of("enable-automation", "enable-logging"));

        var driver = new EdgeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        return driver;
    }

    private static void exec(WebDriver driver) {
        driver.get("https://www.google.com/");
        driver.findElement(By.id("APjFqb")).sendKeys("selenium");
        driver.findElements(By.name("btnK")).get(1).click();
        System.out.println("--- executed ---");
    }

    public static void main(String[] args) throws Exception {
        var driver = edgeDriver();
        exec(driver);
        Thread.sleep(10_000L);
        driver.quit();
    }
}
