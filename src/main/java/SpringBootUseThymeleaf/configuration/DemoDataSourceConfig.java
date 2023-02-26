package SpringBootUseThymeleaf.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration


@PropertySource("classpath:application.properties")
public class DemoDataSourceConfig {

    @Primary
    @Bean
    @ConfigurationProperties(prefix="app.datasource")
    public DataSource appDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix="spring.data.jpa.entity")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, DataSource appDataSource) {
        return builder
                .dataSource(appDataSource)
                .build();
    }

    @Bean
    @ConfigurationProperties(prefix="security.datasource")
    public DataSource securityDataSource() {
        return DataSourceBuilder.create().build();
    }

}
