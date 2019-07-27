package com.dccsh.net.group.one.workplan.config;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.MultipartConfigElement;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MyBeans {
	
	@Bean
	public MultipartConfigElement multipartConfigElement(){
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize("51200KB");
		factory.setMaxRequestSize("102400KB");
		return factory.createMultipartConfig();
	}

	// @Bean(name = "scheduler")
	// public Scheduler scheduler() throws SchedulerException {
	// return StdSchedulerFactory.getDefaultScheduler();
	// };

	// @Bean
	// public ServletListenerRegistrationBean<VisitCountListener>
	// testListenerRegistration() {
	// ServletListenerRegistrationBean<VisitCountListener> registration = new
	// ServletListenerRegistrationBean<VisitCountListener>(
	// new VisitCountListener());
	// return registration;
	// }
	// @Bean
	// public FilterRegistrationBean testFilterRegistration() {
	// FilterRegistrationBean registration = new FilterRegistrationBean(new
	// VisitCountFilter());
	// registration.addUrlPatterns("/*");
	// // registration.addUrlPatterns("/lineInfo/*");
	// // registration.addUrlPatterns("*.html");
	//
	// return registration;
	// }

	@Bean(name = "httpsRestTemplate")
	public RestTemplate httpsRestTemplate() throws NoSuchAlgorithmException, KeyManagementException {
		HttpClientBuilder builder = HttpClients.custom();
		SSLContext sslContext = SSLContext.getInstance("TLS");
		sslContext.init(null, trustAllCerts, new SecureRandom());
		builder.setSSLHostnameVerifier(new HostnameVerifier() {
			@Override
			public boolean verify(String arg0, SSLSession arg1) {
				return true;
			}
		});
		builder.setSSLContext(sslContext);
		HttpClient httpClient = builder.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
		requestFactory.setConnectionRequestTimeout(30000);
		requestFactory.setConnectTimeout(30000);
		requestFactory.setReadTimeout(30000);
		
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		return restTemplate;
	}

	private static TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
		@Override
		public X509Certificate[] getAcceptedIssuers() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
			// TODO Auto-generated method stub
		}

		@Override
		public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
			// TODO Auto-generated method stub
		}
	} };

}
