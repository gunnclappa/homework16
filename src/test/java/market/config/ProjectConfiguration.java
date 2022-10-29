package market.config;

import com.codeborne.selenide.Configuration;
import market.config.web.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProjectConfiguration {
    private final WebConfig webConfig;

    public static final WebConfig CONFIG = ConfigFactory.create(WebConfig.class, System.getProperties());

    public ProjectConfiguration(final WebConfig webConfig) {
        this.webConfig = webConfig;
    }

    public final void webConfig() {
        Configuration.baseUrl = webConfig.baseUrl();
        Configuration.browser = webConfig.browserName();
        Configuration.browserSize = webConfig.browserSize();
        if (webConfig.isRemote()) {
            Configuration.remote = webConfig.remoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }
}
