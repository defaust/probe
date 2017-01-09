package ua.com.codespace.config;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories("ua.com.codespace.repository")
@Import(TransactionConfig.class)
public class JpaConfig {

    //todo: don't forget to set your database properties in the application.properties file
    @Value("${spring.data.db.url}")
    private String url;
    @Value("${spring.data.db.user}")
    private String user;
    @Value("${spring.data.db.password}")
    private String password;
//    @Value("${spring.data.db.driver}")
//    private String driverClassName;
//    @Value("${spring.data.db.cp.maxSize}")
//    private Integer maxPoolSize;
//    @Value("${hibernate.hbm2ddl.auto}")
//    private String hbm2dll;

// **** DATA SOURCE CONFIG ****************************************************

    @Bean
//    @Profile("dev")
    DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }

// **** JPA CONFIG ****************************************************

    @Bean
//    @Profile({"dev", "stage", "prod"})
    JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);

//        adapter.setGenerateDdl(true);
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");

        return adapter;
    }

// **** EMF CONFIG ****************************************************
    @Bean("entityManagerFactory")
    LocalContainerEntityManagerFactoryBean localContainerEMF(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean lcmfb = new LocalContainerEntityManagerFactoryBean();
        lcmfb.setDataSource(dataSource);
        lcmfb.setJpaVendorAdapter(jpaVendorAdapter);
        lcmfb.setPersistenceUnitName("PersistenceUnit");//todo: you can rename persistent unit
        lcmfb.setPackagesToScan("ua.com.codespace.model");

        //lcmfb.getJpaPropertyMap().put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, hbm2dll);

        return lcmfb;
    }

//     todo: use this EMF if you want to configure it with /META-INF/persistence.xml
//        @Bean("entityManagerFactory")
//        public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
//            LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
//            emfb.setPersistenceUnitName("PersistenceUnit");
//            return emfb;
//        }

}

