package edu.cibertec.capitulo4;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Capitulo4Application implements CommandLineRunner {

    @Autowired
    HolaMundoService holaMundoService;

    public static void main(String[] args) {
        SpringApplication.run(Capitulo4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        holaMundoService.saludar();
    }
    
    @Bean
    public CommandLineRunner commandLineRunner (ApplicationContext ctx){
        return arg->{
            System.out.println("Inspeccionando los beans creados automaticamente por Spring Boot");
            String [] beansNames=ctx.getBeanDefinitionNames();
            Arrays.sort(beansNames);
            for(String beansName:beansNames){
                System.out.println(beansName);
            }
        };
    }

}
