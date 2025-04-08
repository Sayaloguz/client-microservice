package com.sarawipay.client_microservice.Client.infrastructure.interceptor.config;

import com.sarawipay.client_microservice.Client.infrastructure.interceptor.Interceptor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
*/

@Setter
@Getter
@RequiredArgsConstructor
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
/*
    private final Interceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/**")
                .excludePathPatterns("/api/generateToken*");
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Nunca hacer esto en producción
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("Authorization", "Content-Type");
    }
    */

}
