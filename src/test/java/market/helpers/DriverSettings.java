package market.helpers;

import com.codeborne.selenide.Configuration;
import market.config.Project;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSettings {

    public static void configure() {
        Configuration.browser = Project.CONFIG.browserName();
        Configuration.browserSize = Project.CONFIG.browserSize();
        Configuration.baseUrl = Project.CONFIG.baseUrl();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (Project.isRemoteWebDriver()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = Project.CONFIG.remoteUrl();
        }

        Configuration.browserCapabilities = capabilities;
    }
}