package com.example.demo.config

import com.google.common.base.Predicates
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.service.StringVendorExtension
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(Predicates.not(RequestHandlerSelectors
                        .basePackage("org.springframework.boot")
                ))
                .paths(PathSelectors.any()).build()
                .apiInfo(apiInfo())
    }

    private fun apiInfo(): ApiInfo {

        return ApiInfo(
                "REST API",
                "",
                "0.1",
                "",
                Contact("", "", ""),
                "",
                "",
                listOf(StringVendorExtension("leetaehun", ""))
        )
    }
}