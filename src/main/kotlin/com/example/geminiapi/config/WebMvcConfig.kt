package com.example.geminiapi.config

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcConfig : WebMvcConfigurer {

    @Bean
    fun corsFilter(): FilterRegistrationBean<CorsFilter> {
        return FilterRegistrationBean(
            CorsFilter(
                UrlBasedCorsConfigurationSource().apply {
                    registerCorsConfiguration(
                        "/**",
                        CorsConfiguration().apply {
                            addAllowedOrigin(CorsConfiguration.ALL)
                            addAllowedHeader(CorsConfiguration.ALL)
                            addAllowedMethod(CorsConfiguration.ALL)
                        }
                    )
                }
            )
        ).apply {
            order = Ordered.HIGHEST_PRECEDENCE
        }
    }
}