package com.pss.alcs.atlassian;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * Created by skaranam on 3/16/2015.
 */
@Configuration
@EnableSwagger
public class SwaggerConfig implements ServletContextAware {

    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    private Environment environment;

    private ServletContext servletContext;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(
                apiInfo()).includePatterns(".*");

    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "ALCS API",
                "API for ALCS",
                "ALCS API terms of service",
                "mail2karanamsubbarao@gmail.com",
                "ALCS API Licence Type",
                "ALCS API License URL"
        );
        return apiInfo;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
