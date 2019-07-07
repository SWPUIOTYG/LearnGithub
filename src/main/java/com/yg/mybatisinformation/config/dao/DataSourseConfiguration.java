package com.yg.mybatisinformation.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

@Configuration  //来到该类下检索这个类 Configuration标注
@MapperScan("com.yg.mybatisinformation.dao")  //配置mybatis mapper的扫描路径
public class DataSourseConfiguration {
    //application.properties路径下
@Value("$jdbc.driver")
    private String jdbcDriver;
@Value("$jdbc.url")
    private String jdbcUrl;
@Value("$jdbc.password")
    private String jdbcPassWord;
@Value("$jdbc.username")
    private String jdbcUsername;

    @Bean(name="dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setPassword(jdbcPassWord);
        dataSource.setUser(jdbcUsername);
        //关闭连接后不自动commit
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }

}
