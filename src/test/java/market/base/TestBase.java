package market.base;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import market.helpers.AllureAttachments;
import market.helpers.DriverSettings;
import market.helpers.DriverUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Objects;

import static com.codeborne.selenide.Configuration.browser;

@ExtendWith({AllureJunit5.class})
public class TestBase {

    @BeforeAll
    static void beforeAll() {
        DriverSettings.configure();
    }

    @BeforeEach
    public final void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public final void afterEach() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
        if (Objects.equals(browser, "chrome")) {
            AllureAttachments.addBrowserConsoleLogs();
        }

        Selenide.closeWebDriver();

        if (System.getProperty("environment").equals("remote")) {
            AllureAttachments.addVideo(sessionId);
        }
    }
}