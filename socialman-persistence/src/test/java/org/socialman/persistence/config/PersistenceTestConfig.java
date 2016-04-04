package org.socialman.persistence.config;

import org.h2.jdbcx.JdbcDataSource;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.H2Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "org.socialman.persistence")
@PropertySource("classpath:persistence.properties")
public class PersistenceTestConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DataSource dataSource(@Value("${testdb.url}") String dbUrl,
                                 @Value("${testdb.user}") String dbUser,
                                 @Value("${testdb.password}") String dbPass
                                 ) {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setUser(dbUser);
        dataSource.setPassword(dbPass);
        return dataSource;
    }

    @Bean
    @Autowired
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        Properties properties = new Properties();
        properties.setProperty(Environment.DIALECT, H2Dialect.class.getName());
        properties.setProperty(Environment.HBM2DDL_AUTO, "create-drop");
        properties.setProperty(Environment.SHOW_SQL, "true");
        properties.setProperty(Environment.FORMAT_SQL, "true");
        sessionFactory.setHibernateProperties(properties);

        return sessionFactory;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.H2);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setShowSql(true);
        return jpaVendorAdapter;
    }

    @Bean
    @Autowired
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
                                                                       JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactory.setPackagesToScan("org.socialman.domain");
        return entityManagerFactory;
    }

    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(LocalSessionFactoryBean sessionFactory) {
        return new HibernateTransactionManager(sessionFactory.getObject());
    }
}
