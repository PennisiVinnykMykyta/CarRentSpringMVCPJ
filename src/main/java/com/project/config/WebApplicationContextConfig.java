package com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration //cosi che spring sappia che questa è la classe di configurazione
@EnableWebMvc //abilità funzionalita dello spring MVC
@ComponentScan(basePackages = "com.project") //il path dove andare a cercare i controller
public class WebApplicationContextConfig implements WebMvcConfigurer { //gestisce le configurazioni dell'applicazione

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

        configurer.enable();
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver(){
        //quando otteniamo i dati grezzi e li vogliamo trasformare in formato compatibile col nostro browser

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);

        //qui stiamo dicendo allo springMVC di andare a cercare le pagine jsp nella cartella WEB-INF/view
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");

        return resolver;
    }
}
