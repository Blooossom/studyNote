package blooossom.api.global.config;

import com.zaxxer.hikari.HikariConfig;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
        basePackages = {"blooossom.api.user.repository", "blooossom.api.post.repository"},
        entityManagerFactoryRef = "studyEm", transactionManagerRef = "studyTm"
)
@ConfigurationProperties(prefix = "db.datasource")
@Slf4j
public class DataSourceConfig extends HikariConfig {
    @Value("${dialect.postgresql}")
    private String postgresqlDialect;

    @Bean("studyDs")
    public DataSource dataSource() {
        log.info(postgresqlDialect);
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        String driverClassName = this.getDriverClassName();
        dataSource.setDriverClassName(driverClassName);
        String jdbcUrl = this.getJdbcUrl();
        dataSource.setUrl(jdbcUrl);
        String username = this.getUsername();
        dataSource.setUsername(username);
        String password = this.getPassword();
        dataSource.setPassword(password);
        String schema = this.getSchema();
        dataSource.setSchema(schema);
        return dataSource;
    }



    @Primary
    @Bean("studyEm")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan(
                "blooossom.api.user.entity", "blooossom.api.post.entity"
        );
        entityManagerFactoryBean.setJpaProperties(getProperties());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return entityManagerFactoryBean;
    }

    @Bean("studyTm")
    public JpaTransactionManager jpaTransactionManager(@Qualifier("studyEm") LocalContainerEntityManagerFactoryBean emf) {
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(emf.getObject());
        return tm;
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        properties.put(Environment.FORMAT_SQL, "true");
        properties.put(Environment.SHOW_SQL, "false");
        properties.put(Environment.DIALECT, postgresqlDialect);
        properties.put(Environment.HBM2DDL_AUTO, "update");
        return properties;
    }

}
