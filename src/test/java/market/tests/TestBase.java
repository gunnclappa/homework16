package market.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import market.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

    private static final String REMOTE_URL = System.getProperty("selenide.remote");

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.setCapability("enableVNC", true);
        options.setCapability("enableVideo", true);

        Configuration.browserCapabilities = options;
        Configuration.baseUrl = "https://market.kz/";
        Configuration.timeout = 30000;
        Configuration.pageLoadTimeout = 300000;
        Configuration.browser = System.getProperty("browser_name", "chrome");
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");

        if (REMOTE_URL != null) {
            Configuration.remote = "https://user1:1234@" + REMOTE_URL;
        }
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        if (REMOTE_URL != null) {
            Attach.addVideo();
        }
    }
}