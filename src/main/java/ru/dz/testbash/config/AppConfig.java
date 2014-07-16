package ru.dz.testbash.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Properties;

/**
 * Created by Эмиль on 14.07.2014.
 */

@EnableWebMvc
@Configuration
//Определяем папку, в которой будем искать веб компоненты (контроллеры)
//Определяем папки, в которых будем автоматически искать бины-компоненты (@Component, @Service)
@ComponentScan({"ru.dz.testbash.*"})
//@PropertySource({ "classpath:testbash.properties"})
@EnableTransactionManagement
public class AppConfig extends WebMvcConfigurerAdapter {


    @Value("${hibernate.show_sql}")  private String showSql;
    @Value("${hibernate.dialect}")  private String dialect;
    @Value("${hibernate.connection.charSet}")  private String charSet;
    @Value("${hibernate.connection.username}")  private String dbUser;
    @Value("${hibernate.connection.password}")  private String dbPass;
    @Value("${hibernate.connection.url}")  private String dbUrl;
    @Value("${hibernate.connection.driver_class}")  private String dbDriverClass;

    //Подгрузка свойств
    @Bean
    public static PropertyPlaceholderConfigurer properties(){
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ClassPathResource[] resources = new ClassPathResource[ ] { new ClassPathResource( "testbash.properties" ) };
        ppc.setLocations( resources );
        ppc.setIgnoreUnresolvablePlaceholders( true );
        return ppc;
    }

    //Менеджер транзакций
    @Bean
    public HibernateTransactionManager txManager() {
        return new HibernateTransactionManager(sessionFactory());
    }

    //Настройки фабрики сессий Хибернейта
    @Bean
    public SessionFactory sessionFactory() {

        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
        builder.scanPackages("ru.dz.testbash.domain").addProperties(getHibernateProperties());

        return builder.buildSessionFactory();
    }

    private Properties getHibernateProperties() {
        Properties prop = new Properties();

        prop.put("hibernate.show_sql", showSql);
        prop.put("hibernate.dialect", dialect);
        prop.put("hibernate.connection.charSet",charSet);
        return prop;
    }

    @Bean
    public BasicDataSource dataSource() {

        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(dbDriverClass);
        ds.setUrl(dbUrl);
        ds.setUsername(dbUser);
        ds.setPassword(dbPass);
        return ds;
    }

    //Отображение видов на jsp-файлы, лежащие в папке /WEB-INF/views
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver
                = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }


    @Bean(name = "messageSource")
    public MessageSource messageSource()
    {
        ReloadableResourceBundleMessageSource bean = new ReloadableResourceBundleMessageSource();
        bean.setBasename("classpath:messages");
        bean.setDefaultEncoding(charSet);
        return bean;
    }
}
