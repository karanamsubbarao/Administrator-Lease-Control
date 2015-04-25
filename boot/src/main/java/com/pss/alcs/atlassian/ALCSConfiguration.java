package com.pss.alcs.atlassian;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by skaranam on 3/16/2015.
 */
@Configuration
@ComponentScan
public class ALCSConfiguration extends WebMvcConfigurerAdapter {
}
