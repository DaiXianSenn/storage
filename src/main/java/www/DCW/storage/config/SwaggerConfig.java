package www.DCW.storage.config;




import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


/**
 * Author: JhonDai
 * Date: 2022/11/25/11:45
 * Version: 1.0
 * Description: <a href="http://localhost:8080/swagger-ui/index.html#/">...</a>
 */

@EnableKnife4j
@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("www.DCW.storage.controller"))	// 为当前包路径
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("FH Admin Swagger3 RESTful API") 	// 页面标题
                .version("3.0")								// 版本号
                .description("fhadmin.org")				    // 描述
                .build();
    }


}
