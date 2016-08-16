package org.redlead.quiz.configuration;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2ConsoleConfig {

    @Bean
    ServletRegistrationBean h2ServletRegistrationBean() {
        return new ServletRegistrationBean(new WebServlet(), "/console/*");
    }
}
