package com.dccsh.net.group.one.workplan.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.dccsh.net.group.one.workplan.filter.DataFilter;
import com.dccsh.net.group.one.workplan.filter.SsoFilter;

@Configuration
public class MyConfig {

    private CorsConfiguration bulidConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", bulidConfig());
        return new CorsFilter(source);
    }

    @Bean
    public DataFilter dataFilter() {
        return new DataFilter();
    }
    
    @Bean
    public SsoFilter ssoFilter() {
        return new SsoFilter();
    }
    @Bean
    public FilterRegistrationBean loginFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean(ssoFilter());
        registration.addUrlPatterns("*.html");
        return registration;
    }
    @Bean
    public FilterRegistrationBean dataFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(dataFilter());
        registration.addUrlPatterns("/api/*");
        return registration;
    }
  /*  @Bean
    public EncodingFilter encodingFilter(){
    	return new EncodingFilter();
    }*/
}
