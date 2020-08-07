package cn.wf.starter.config;


import cn.wf.starter.properties.DemoServiceProperties;
import cn.wf.starter.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(DemoService.class)
@EnableConfigurationProperties(DemoServiceProperties.class)
public class DemoConfig {

    @Autowired
    private DemoServiceProperties demoServiceProperties;

    @Bean
    @ConditionalOnMissingBean(DemoService.class)
    @ConditionalOnProperty(prefix = "demo.service",value = "enabled",havingValue = "true")
    public DemoService demoService(){
        return new DemoService(demoServiceProperties.getPrefix(),demoServiceProperties.getSuffix());
    }

}
