package market.config;

import market.config.web.WebConfig;
import org.aeonbits.owner.ConfigFactory;

public enum ConfigReader {
    Instance;

    private static final WebConfig WEB_CONFIG =
            ConfigFactory.create(
                    WebConfig.class,
                    System.getProperties()
            );

    public WebConfig read() {
        return WEB_CONFIG;
    }
}