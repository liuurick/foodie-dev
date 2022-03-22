package com.liubin.foodie.gateway.conf;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {

    /**
     * 创建SwaggerApi
     *
     * @return springfox.documentation.spring.web.plugins.Docket
     * @author YangYudi
     * @date 2020/12/14 14:02
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.liubin.foodie"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Lists.newArrayList(apiKey()));
    }

    /**
     * Swagger API基本信息
     *
     * @return springfox.documentation.service.ApiInfo
     * @author YangYudi
     * @date 2020/12/14 14:02
     */
    private ApiInfo apiInfo() {
        Contact contact = new Contact("yudi", "http://localhost:9000/doc.html", "529699377@qq.com");
        return new ApiInfoBuilder()
                .title("course-online-swagger-ui RESTFul APIs")
                .description("course-online-swagger-ui")
                .termsOfServiceUrl("http://localhost:9000/")
                .contact(contact)
                .version("1.0")
                .build();
    }

    /**
     * 配置token类型为Bearer
     *
     * @return springfox.documentation.service.ApiKey
     * @author YangYudi
     * @date 2020/12/14 14:02
     */
    private ApiKey apiKey() {
        return new ApiKey("BearerToken", "Authorization", "header");
    }


    @Bean
    public ServerCodecConfigurer serverCodecConfigurer() {
        return ServerCodecConfigurer.create();
    }
}
