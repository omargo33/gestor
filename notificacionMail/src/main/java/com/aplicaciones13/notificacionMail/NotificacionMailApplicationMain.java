package com.aplicaciones13.notificacionMail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(
        {
            "com.aplicaciones13.notificacionMail.servicio",
            "com.aplicaciones13.notificacionMail.scheduler"
        }
)
@EnableJpaRepositories("com.aplicaciones13.notificacionMail.jpa.queries")
@EnableScheduling
@EntityScan("com.aplicaciones13.notificacionMail.jpa.model")
@SpringBootApplication
public class NotificacionMailApplicationMain extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(NotificacionMailApplicationMain.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(NotificacionMailApplicationMain.class, args);
    }
}