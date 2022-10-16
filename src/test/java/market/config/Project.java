package market.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static final ProjectConfig CONFIG = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    public final Project setConfiguration(final String environment) {
        System.setProperty("environment", environment);
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
        Configuration.remote = config.remoteUrl();
        Configuration.browser = config.browserName();
        Configuration.browserSize = config.browserSize();
        Configuration.baseUrl = config.baseUrl();
        Configuration.browserVersion = config.browserVersion();
        return this;
    }
}
