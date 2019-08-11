package com.one4all.datacenter.connector.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket initDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.genericModelSubstitutes(DeferredResult.class)
                .apiInfo(initApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.one4all.datacenter.connector.service.controller"))//要扫描的API(Controller)基础包
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo initApiInfo() {
        return new ApiInfoBuilder()
                .title("新架构样例API")
                .description("RESTful API")
                .contact(new Contact("杭州信雅达数码科技","http://www.sunyard.com/","xiaoqing.liu@sunyard.com"))
                .version("0.1")
                .build();
    }
    
}
