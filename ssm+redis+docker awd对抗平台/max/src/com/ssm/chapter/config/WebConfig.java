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
//定义Spring MVC扫描的包

@ComponentScan(value = "com.*", includeFilters = { @Filter(type = FilterType.ANNOTATION, value = Controller.class) })
//启动Spring MVC配置
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	/***
	 * 通过注解 @Bean 初始化视图解析器
	 * 
	 * @return ViewResolver 视图解析器
	 */
	@Bean(name = "internalResourceViewResolver")
	public ViewResolver initViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	/**
	 * 初始化RequestMappingHandlerAdapter，并加载Http的Json转换器
	 * 
	 * @return RequestMappingHandlerAdapter 对象
	 */
	@Bean(name = "requestMappingHandlerAdapter")
	public HandlerAdapter initRequestMappingHandlerAdapter() {
		// 创建RequestMappingHandlerAdapter适配器
		RequestMappingHandlerAdapter rmhd = new RequestMappingHandlerAdapter();
		// HTTP JSON转换器
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		// MappingJackson2HttpMessageConverter接收JSON类型消息的转换
		MediaType mediaType = MediaType.APPLICATION_JSON_UTF8;
		List<MediaType> mediaTypes = new ArrayList<MediaType>();
		mediaTypes.add(mediaType);
		// 加入转换器的支持类型
		jsonConverter.setSupportedMediaTypes(mediaTypes);
		// 往适配器加入json转换器
		rmhd.getMessageConverters().add(jsonConverter);
		return rmhd;
	}

	// 配置静态资源处理,
	// 我们要求DispatcherServlet将对静态资源的请求转发到Servlet容器中默认的Servlet上，
	// 而不是使用DispatcherServlet本身来处理此类请求。
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