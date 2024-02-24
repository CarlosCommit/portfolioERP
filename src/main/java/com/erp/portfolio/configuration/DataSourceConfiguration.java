package com.erp.portfolio.configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    private final String classNameDriver;
    private final String password;
    private final String username;
    private final String url;

    public DataSourceConfiguration(@Value("${datasource.class}") String classNameDriver,@Value("${datasource.password}") String password,
                                   @Value("${datasource.username}")String username, @Value("${datasource.url}")String url) {
        this.classNameDriver = classNameDriver;
        this.password = password;
        this.username = username;
        this.url = url;
    }

    @Bean("mysqlProjectsDataSource")
    public DataSource getDataSource()
    {
        return DataSourceBuilder.create().
                driverClassName(classNameDriver)
                .password(password)
                .url(url)
                .username(username)
                .build();
    }


}
