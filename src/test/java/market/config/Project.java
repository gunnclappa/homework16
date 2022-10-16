package market.config;

import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static final ProjectConfig CONFIG = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    public static boolean isRemoteWebDriver() {
        return !CONFIG.remoteUrl().equals("");
    }

    public static boolean isVideoOn() {
        return !CONFIG.videoStorage().equals("");
    }
}
