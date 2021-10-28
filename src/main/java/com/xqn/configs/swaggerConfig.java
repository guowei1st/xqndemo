package com.xqn.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.nio.file.Path;
import java.util.ArrayList;

@Configuration
//开启swagger2
@EnableSwagger2
public class swaggerConfig {
    @Bean
    public Docket docket(Environment environment){

        Profiles profiles= Profiles.of("dev");
        boolean flag= environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).select()

                //扫描固定包
                .apis(RequestHandlerSelectors.basePackage("com.xqn.controller"))

                //过滤
               // .paths(PathSelectors.ant("/kuang/**"))
                .build()
                .enable(flag);
    }

    private ApiInfo apiInfo() {
         Contact DEFAULT_CONTACT = new Contact("郭威", "", "1347624395@qq.com");

        return  new ApiInfo("小青牛后台接口文档",
                "小青牛demo",
                "1.0",
                "urn:tos",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }
}
