/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.config;


import com.google.common.base.Predicate;
import static com.google.common.base.Predicates.or;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author JeisonI
 */
@Profile(value = {"dev"})
@EnableSwagger2
@Configuration
public class SwaggerConfig{
    
    
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(infoApp())
                .select()
                .paths(Paths())
                .apis(RequestHandlerSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }
    
    private ApiInfo infoApp(){
        return new ApiInfoBuilder()
                .title("Gestion de riesgo")
                .description("Swagger del proyecto gestion de riesgo, donde se exponen los api disponibles para su adaptacion en App ")
                .version("1.0")
                .build();
    }
    
     private Predicate<String> Paths() {
        return or(
                regex("/laboratory.*"),
                regex("/auth.*"),
                regex("/exams.*"),
                regex("/gestante.*"),
                regex("/vacunacion.*")
                );
    }   
}
