package br.com.mercado_livre.desafio.adapters.http.v1.configurations;

import br.com.mercado_livre.desafio.adapters.http.v1.interceptors.RestControllerLoggingInterceptor;
import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static io.swagger.models.auth.In.HEADER;
import static java.util.Collections.singletonList;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Configuration
@EnableSwagger2
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket api(TypeResolver typeResolver) {
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(singletonList(new ApiKey("BEARER", AUTHORIZATION, HEADER.name())))
                .securityContexts(singletonList(SecurityContext.builder()
                        .securityReferences(singletonList(SecurityReference.builder()
                                .reference("BEARER")
                                .scopes(new AuthorizationScope[0])
                                .build()))
                        .build()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.mercado_livre.desafio.adapters.http.v1.controllers"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("desafio_mercado_livre info")
                .description("desafio_mercado_livre description")
                .version("1.0-SNAPSHOT")
                .build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RestControllerLoggingInterceptor());
    }

}
