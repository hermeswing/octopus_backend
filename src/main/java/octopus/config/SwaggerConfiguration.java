package octopus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;

import octopus.backend.comm.dto.UserSessionDto;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .ignoredParameterTypes(Errors.class, UserSessionDto.class) // 제외할 파라미터
                .apiInfo(swaggerInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("octopus.backend"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false); // 기본으로 세팅되는 200,401,403,404 메시지를 표시 하지 않음
    }
    
    private ApiInfo swaggerInfo() {
        return new ApiInfoBuilder()
                .title("Octopus API Documentation")
                .description("앱 개발시 사용되는 서버 API에 대한 연동 문서입니다")
                .license("MIT License")
                .licenseUrl("https://hermeslog.tistory.com/")
                .version("1.0")
                .build();
    }
    
    // @Bean
    // public LinkDiscoverers discoverers() {
    // List<LinkDiscoverer> plugins = new ArrayList<>();
    // plugins.add(new CollectionJsonLinkDiscoverer());
    //
    // return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
    // }
}