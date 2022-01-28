package com.mortality.config;

import com.mortality.converter.CountryConverter;
import com.mortality.converter.CountryDtoConverter;
import com.mortality.converter.MortalityConverter;
import com.mortality.converter.MortalityDtoConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new MortalityConverter());
        registry.addConverter(new MortalityDtoConverter());
        registry.addConverter(new CountryConverter());
        registry.addConverter(new CountryDtoConverter());
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        configurer
                .favorParameter(true)
                .parameterName("media")
                .ignoreAcceptHeader(true)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("csv", MediaType.valueOf("text/csv"));
    }
}
