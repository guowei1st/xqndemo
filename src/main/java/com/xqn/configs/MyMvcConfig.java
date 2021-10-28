package com.xqn.configs;


import com.xqn.component.LoginHandlerInterceptor;
import com.xqn.component.MyLocaleResolver;
import com.xqn.component.MystuInterceptor;
import com.xqn.component.MyteaInterceptor;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                //factory.setPort(8083);
            }
        };
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        registry.addViewController("/abc").setViewName("success");
    }
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter=new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/stu/index.html").setViewName("dashboard");
                registry.addViewController("/tea/1").setViewName("/tea/teaindex");
                registry.addViewController("/stu/1").setViewName("/stu/stuindex");
            }


            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
               registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/emp","/emps").excludePathPatterns("/asserts/*","/static","/index.html","/","/user/login");
               registry.addInterceptor(new MystuInterceptor()).addPathPatterns("/stu/**").excludePathPatterns("/asserts/*","/static","/index.html","/","/user/login");
                registry.addInterceptor(new MyteaInterceptor()).addPathPatterns("/tea/**").excludePathPatterns("/asserts/*","/static","/index.html","/","/user/login");

            }







        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
