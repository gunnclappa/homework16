package market.helpers;

import com.codeborne.selenide.Configuration;
import market.config.Project;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSettings {

    public static void configure() {

        String typeOfLaunch = "remote"; // Можно поменять на local -> тесты запустятся локально

        Project config = new Project();
        config.setConfiguration(typeOfLaunch);

        if (typeOfLaunch.equals("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }
}