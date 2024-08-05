package de.neumaennl.springboot.plugin.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * A simple example application that shows how a plugin system could be built
 * using Spring Boot.
 *
 * @author Martin Neumann - <a href="http://www.brain-child.de">brainchild
 *         GmbH</a>
 */
@SpringBootApplication
public class MainApp {

    /**
     * Starts the application.
     *
     * @param args
     *            The arguments given on the command line.
     */
    public static void main(String[] args) {

        SpringApplication.run(MainApp.class, args);
    }

    /**
     * Defines a {@link CommandLineRunner} which lists all Spring Beans found in
     * the Spring context and adds it to the Spring context.
     *
     * @param ctx
     *            The Spring application context.
     * @return A {@link CommandLineRunner} which lists all Spring Beans found in
     *         the Spring context.
     */
    @SuppressWarnings("static-method")
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {

        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }
}
