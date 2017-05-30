package config.application

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource

@Configuration
@ComponentScan(value="database")
open class ConfigurationDataBase
{
    @Bean
    open fun dataSource(): DriverManagerDataSource
    {
        val dataSource = DriverManagerDataSource("jdbc:postgresql://localhost:5432/postgres?currentSchema=footballstat")
        dataSource.setDriverClassName("org.postgresql.Driver")
        dataSource.username = "postgres"
        dataSource.password = "postgres"
        return dataSource
    }
}
