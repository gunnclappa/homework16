package market.base;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import market.config.ConfigReader;
import market.config.ProjectConfiguration;
import market.config.web.WebConfig;
import market.helpers.AllureAttachments;
import market.helpers.DriverUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Objects;

import static com.codeborne.selenide.Configuration.browser;


@ExtendWith({AllureJunit5.class})
public class TestBase {

    private static final WebConfig WEB_CONFIG = ConfigReader.Instance.read();

    @BeforeAll
    static void beforeAll() {
        ProjectConfiguration projectConfiguration = new ProjectConfiguration(WEB_CONFIG);
        projectConfiguration.webConfig();
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

        AllureAttachments.addVideo(sessionId);
    }
}