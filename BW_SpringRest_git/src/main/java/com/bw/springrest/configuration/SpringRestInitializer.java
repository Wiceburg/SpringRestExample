package com.bw.springrest.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringRestInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SpringRestConfiguration.class, HibernateConfiguration.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
    	return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
