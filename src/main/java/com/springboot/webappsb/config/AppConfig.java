/**
 * 
 */
package com.springboot.webappsb.config;

import java.util.Locale;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * @author Hareesha
 * Jul 10, 2017 2017
 */
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter	{
	
	/**
	 * this sets the default locale
	 * @return
	 */
	@Bean
	public LocaleResolver localeResolver() {
	    SessionLocaleResolver slr = new SessionLocaleResolver();
	    slr.setDefaultLocale(Locale.US);
	    return slr;
	}
	
	/**
	 * This is the bean that is used to intercept and overrride the 
	 * accepts-header of the HttpRequest with the value of the lang request parameter
	 * @return
	 */
	@Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
	
	/**
	 * this method is used to add the interceptor to interceptor registery
	 */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
    
    /**
     * In order for the SpringBoot to know about the custome 404 page we
     * have to configure the EmbeddedServletContainerCustomizer which will be called from
     * EmbeddedServletContainerCustomizerBeanPostProcessor.
     * @return
     */
    @Bean
    public EmbeddedServletContainerCustomizer contanerCustomizer(){
    		return(container->{
    			ErrorPage custom204 = new ErrorPage(HttpStatus.NOT_FOUND, "/404Error");
    			container.addErrorPages(custom204);
    		});
    }
}
