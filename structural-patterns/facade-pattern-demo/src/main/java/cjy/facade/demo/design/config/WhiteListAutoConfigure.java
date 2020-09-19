package cjy.facade.demo.design.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(AuthService.class)
@EnableConfigurationProperties(WhiteListProperties.class)
public class WhiteListAutoConfigure {

    @Autowired
    private WhiteListProperties whiteListProperties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "cjy.door",value = "enabled",havingValue = "true")
    public AuthService authService() {
        return new AuthService(whiteListProperties.getWhiteList());
    }

}
