package pl.bikes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import javax.persistence.EntityManagerFactory;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan("pl.bikes")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl.bikes.repository")
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        StringHttpMessageConverter converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        converter.setSupportedMediaTypes(Arrays.asList(
                new MediaType("text", "plain", StandardCharsets.UTF_8),
                new MediaType("text", "html", StandardCharsets.UTF_8)
        ));
        converters.add(converter);
    }

    @Bean("entityManagerFactory")
    public LocalEntityManagerFactoryBean entityManager() {
        LocalEntityManagerFactoryBean entityManager = new LocalEntityManagerFactoryBean();
        entityManager.setPersistenceUnitName("bikesPersistence");
        return entityManager;
    }

    @Bean("transactionManager")
    public JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManager) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(entityManager);
        return jpaTransactionManager;
    }


}
