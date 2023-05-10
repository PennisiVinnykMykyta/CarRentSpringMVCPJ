package com.project.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                //indica la classe di configurazione generale
          WebApplicationContextConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        // si assicura che qualsiasi chiamata che viene inserita verrà gestita dal dispatche rservlet

        return new String[] {"/"};
    }
}
