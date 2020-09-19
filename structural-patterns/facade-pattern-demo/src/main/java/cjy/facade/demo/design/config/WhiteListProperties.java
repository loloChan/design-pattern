package cjy.facade.demo.design.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("cjy.door")
@Data
public class WhiteListProperties {

    private String whiteList;

}
