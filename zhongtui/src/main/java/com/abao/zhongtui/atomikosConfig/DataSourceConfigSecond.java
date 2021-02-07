package com.abao.zhongtui.atomikosConfig;
 
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
import javax.sql.DataSource;
 
@Configuration
@MapperScan(basePackages = "com.abao.zhongtui.dao2",sqlSessionFactoryRef = "sqlSessionFactory2",sqlSessionTemplateRef = "sqlSessionTemplate2")
public class DataSourceConfigSecond {

    @Autowired
    ApplicationContext context;

    @Bean("dataSource2")
    public DataSource dataSource2( DataSourceII dataSource) throws Exception {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl(dataSource.getJdbcUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setUser(dataSource.getUsername());
        mysqlXADataSource.setPassword(dataSource.getPassword());
 
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("dataSource2");
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
 
    @Bean("sqlSessionFactory2")
    public SqlSessionFactory sqlSessionFactory2(@Qualifier("dataSource2") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(context.getResources("classpath:mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
 
    @Bean("sqlSessionTemplate2")
    public SqlSessionTemplate sqlSessionTemplate2(@Qualifier("sqlSessionFactory2") SqlSessionFactory sqlSessionFactory){
       SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
       return sqlSessionTemplate;
    }
}