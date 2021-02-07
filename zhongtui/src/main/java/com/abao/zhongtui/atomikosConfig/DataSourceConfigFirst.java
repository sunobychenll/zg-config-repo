package com.abao.zhongtui.atomikosConfig;
 
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.boot.jta.atomikos.AtomikosXADataSourceWrapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
 
import javax.sql.DataSource;
import java.sql.SQLException;
 
@Configuration
@MapperScan(basePackages = "com.abao.zhongtui.dao",sqlSessionFactoryRef = "sqlSessionFactory1",sqlSessionTemplateRef = "sqlSessionTemplate1")
public class DataSourceConfigFirst {
 
    @Bean("dataSource1")
    public DataSource dataSource1(DataSourceI dataSource) throws Exception {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl(dataSource.getJdbcUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setUser(dataSource.getUsername());
        mysqlXADataSource.setPassword(dataSource.getPassword());

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("dataSource1");
        atomikosDataSourceBean.setMinPoolSize(dataSource.getMinPoolSize());
        atomikosDataSourceBean.setMaxPoolSize(dataSource.getMaxPoolSize());
        atomikosDataSourceBean.setMaxLifetime(dataSource.getMaxLifetime());
        atomikosDataSourceBean.setBorrowConnectionTimeout(dataSource.getBorrowConnectionTimeout());
        atomikosDataSourceBean.setLoginTimeout(dataSource.getLoginTimeout());
        atomikosDataSourceBean.setMaintenanceInterval(dataSource.getMaintenanceInterval());
        atomikosDataSourceBean.setMaxIdleTime(dataSource.getMaxIdleTime());
        atomikosDataSourceBean.setTestQuery(dataSource.getTestQuery());

        return atomikosDataSourceBean;
    }

    @Autowired
    private ApplicationContext applicationContext;
 
    @Bean("sqlSessionFactory1")
    public SqlSessionFactory sqlSessionFactory1(@Qualifier("dataSource1") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
 
    @Bean("sqlSessionTemplate1")
    public SqlSessionTemplate sqlSessionTemplate1(@Qualifier("sqlSessionFactory1") SqlSessionFactory sqlSessionFactory){
       SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
       return sqlSessionTemplate;
    }
}