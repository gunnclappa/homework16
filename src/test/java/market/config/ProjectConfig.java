package market.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:${environment}.properties"
})
public interface ProjectConfig extends Config {

    @Key("browserName")
    String browserName();

    @Key("browserSize")
    String browserSize();

    @Key("remoteUrl")
    String remoteUrl();

    @Key("videoStorage")
    String videoStorage();

    @Key("baseUrl")
    String baseUrl();

    @Key("browserVersion")
    String browserVersion();
}