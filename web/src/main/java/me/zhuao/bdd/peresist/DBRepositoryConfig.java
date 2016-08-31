package me.zhuao.bdd.peresist;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(value = "me.zhuao.bdd.peresist", entityManagerFactoryRef ="customerEntityManagerFactory", transactionManagerRef = "customerTransactionManager")
public class DBRepositoryConfig {
    @Bean
    PlatformTransactionManager customerTransactionManager() {
        return new JpaTransactionManager(customerEntityManagerFactory().getObject());
    }

    @Bean
    LocalContainerEntityManagerFactoryBean customerEntityManagerFactory() {

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter() {
            {
                setDatabase(Database.H2);
            }

        };

        jpaVendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(customerDataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan(History.class.getPackage().getName());

        return factoryBean;
    }

    @Bean
    DataSource customerDataSource() {

        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("db-config.sql")
                .build();
    }
}
