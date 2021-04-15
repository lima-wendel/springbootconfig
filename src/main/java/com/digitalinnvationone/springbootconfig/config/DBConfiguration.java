package com.digitalinnvationone.springbootconfig.config;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfiguration {

    //mapeamento das propriedades do acesso ao banco de dados
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    //declarando métodos que fazem o mapeamento das propriedades

    @Profile("dev") //aponta para o profile de desenvolvimento; vai chamar application-dev.yml
    @Bean //vai mapear o conteúdo na inicialização do sistema
    public String testDatabaseConnection(){
        System.out.println("DB connection for DEV - H2");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection to H2_TEST - Test instance";
    }
    @Profile("prod") //application-prod.properties
    @Bean
    public String productionDatabaseConnection () {
        System.out.println("DB connection for Production - MySQL");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection to MYSQL_PROD - Production instance";
    }

}
