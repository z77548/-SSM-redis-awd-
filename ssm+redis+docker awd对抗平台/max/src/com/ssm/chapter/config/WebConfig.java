package com.ssm.chapter.config;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.ssm.chapter.interceptor.AdminInterceptor;
import com.ssm.chapter.interceptor.CaptainInterceptor;
import com.ssm.chapter.interceptor.HomeInterceptor;
import com.ssm.chapter.interceptor.OrdinaryInterceptor;

@Configuration
//����Spring MVCɨ��İ�

@ComponentScan(value = "com.*", includeFilters = { @Filter(type = FilterType.ANNOTATION, value = Controller.class) })
//����Spring MVC����
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	/***
	 * ͨ��ע�� @Bean ��ʼ����ͼ������
	 * 
	 * @return ViewResolver ��ͼ������
	 */
	@Bean(name = "internalResourceViewResolver")
	public ViewResolver initViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	/**
	 * ��ʼ��RequestMappingHandlerAdapter��������Http��Jsonת����
	 * 
	 * @return RequestMappingHandlerAdapter ����
	 */
	@Bean(name = "requestMappingHandlerAdapter")
	public HandlerAdapter initRequestMappingHandlerAdapter() {
		// ����RequestMappingHandlerAdapter������
		RequestMappingHandlerAdapter rmhd = new RequestMappingHandlerAdapter();
		// HTTP JSONת����
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		// MappingJackson2HttpMessageConverter����JSON������Ϣ��ת��
		MediaType mediaType = MediaType.APPLICATION_JSON_UTF8;
		List<MediaType> mediaTypes = new ArrayList<MediaType>();
		mediaTypes.add(mediaType);
		// ����ת������֧������
		jsonConverter.setSupportedMediaTypes(mediaTypes);
		// ������������jsonת����
		rmhd.getMessageConverters().add(jsonConverter);
		return rmhd;
	}

	// ���þ�̬��Դ����,
	// ����Ҫ��DispatcherServlet���Ծ�̬��Դ������ת����Servlet������Ĭ�ϵ�Servlet�ϣ�
	// ������ʹ��DispatcherServlet�����������������
	/*
	 * @Override public void
	 * configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	 * configurer.enable(); }
	 */

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new OrdinaryInterceptor()).addPathPatterns("/user/**");
		registry.addInterceptor(new CaptainInterceptor()).addPathPatterns("/captain/**");
		registry.addInterceptor(new HomeInterceptor()).addPathPatterns("/home.do");
		registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin/**");
		super.addInterceptors(registry);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/link-logoin/images/**").addResourceLocations("/WEB-INF/jsp/link-logoin/images/");
		registry.addResourceHandler("/link-logoin/assets/**").addResourceLocations("/WEB-INF/jsp/link-logoin/assets/");
		registry.addResourceHandler("/user/assets/**").addResourceLocations("/WEB-INF/jsp/user/assets/");
		registry.addResourceHandler("/user/images/**").addResourceLocations("/WEB-INF/jsp/user/images/");
		registry.addResourceHandler("/user/js/**").addResourceLocations("/WEB-INF/jsp/user/js/");
		registry.addResourceHandler("/admin/assets/**").addResourceLocations("/WEB-INF/jsp/admin/assets/");
		registry.addResourceHandler("/admin/images/**").addResourceLocations("/WEB-INF/jsp/admin/images/");
		registry.addResourceHandler("/admin/js/**").addResourceLocations("/WEB-INF/jsp/admin/js/");
		registry.addResourceHandler("/captain/assets/**").addResourceLocations("/WEB-INF/jsp/captain/assets/");
		registry.addResourceHandler("/captain/images/**").addResourceLocations("/WEB-INF/jsp/captain/images/");
		registry.addResourceHandler("/captain/js/**").addResourceLocations("/WEB-INF/jsp/captain/js/");
		registry.addResourceHandler("/update/**").addResourceLocations("/WEB-INF/update/");
		super.addResourceHandlers(registry);
	}

}