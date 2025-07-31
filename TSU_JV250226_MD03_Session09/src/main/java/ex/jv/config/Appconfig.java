package ex.jv.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages ={ "ex.jv.controller", "ex.jv.service", "ex.jv.repository"} )
@EnableTransactionManagement
public class Appconfig {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); //driver
        dataSource.setUrl("jdbc:mysql://localhost:3306/categorymanagement_db");
        dataSource.setUsername("root");
        dataSource.setPassword("Weak");
        return dataSource;
    }

    @Bean
    public Properties props() {
        Properties prop = new Properties();
        //Cơ chế (mode) làm việc với CSDL: create, create-drop, update, validate
        /*
         * create: Khi ứng dụng chạy, xóa tất cả các bảng trong db và tạo lại các bảng mới theo entity --> dữ liệu sẽ mất hết khi ứng dụng chạy
         * create-drop: khi ứng dụng chạy, xóa hết các bảng và tạo mới, ứng dụng tắt xóa tất cả các bảng
         * update: ứng dụng chạy kiểm tra các bảng trong db so với các entity, nếu thiếu entity hoặc thuộc tính entity thì sẽ tạo thêm, thừa không làm gì cả
         * validate: kiểm tra cấu trúc các bảng trong db có giống với các entity không
         * */
        prop.setProperty("hibernate.hbm2ddl.auto", "update");
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect"); // nếu gây lỗi thì dùng MySQL8InnoDBDialect
        prop.setProperty("hibernate.show_sql", "true");
        return prop;
    }


    //Hibernate: quản lý các entity --> entityManager --> entitymanagerFactory
    //entityManger --> session --> hql
    //entity : table

    // Cấu hình EntityManagerFactory
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emtityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        emtityManagerFactory.setDataSource(dataSource());
        emtityManagerFactory.setPackagesToScan("ex.jv.model"); //quét các @Entity
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter(); //Chỉ định nhà cung cấp JPA (JPA Provider)
        emtityManagerFactory.setJpaVendorAdapter(vendorAdapter);
        emtityManagerFactory.setJpaProperties(props());
        return emtityManagerFactory;
    }

    //cấu hình EntityManager
    @Bean
    @Qualifier(value = "entityManager")
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    // Cấu hình transaction
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
