package com.example.webtag.config;

import com.example.webtag.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * create by Lee
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("");
        String lee = ",\"desc\":\"\",\"defineType\":0}],\n" +
                "                            \"expenseList\":null,\n" +
                "                            \"reviewIndexes\":[1,2],\n" +
                "                            \"scoreList\":[{\"score\":taste_score,\"title\":\"口味\",\"desc\":\"\"},{\"score\":ser_score,\"title\":\"服务\",\"desc\":\"\"},{\"score\":env_score,\"title\":\"环境\",\"desc\":\"\"}]\n" +
                "                        }";
    }
}
