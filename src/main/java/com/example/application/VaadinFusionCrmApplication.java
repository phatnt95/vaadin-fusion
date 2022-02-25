package com.example.application;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */
@SpringBootApplication
@EnableJpaRepositories
@Theme(value = "vaadinfusion")
@PWA(name = "Vaadin Fusion", shortName = "Vaadin Fusion", offlineResources = {"images/logo.png"})
public class VaadinFusionCrmApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(VaadinFusionCrmApplication.class, args);
    }

}
