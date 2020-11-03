package com.github.lyrric.store.util;

import com.github.lyrric.store.entity.CompanyInfo;
import com.github.lyrric.store.mapper.CompanyInfoMapper;
import com.github.lyrric.store.mapper.ErrorLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.session.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created on 2020-11-03.
 *
 * @author wangxiaodong
 */
@Slf4j
public class JdbcUtil {

    private SqlSessionFactory sqlSessionFactory;

    public JdbcUtil(Properties properties) {
        Properties prop = new Properties();
        prop.setProperty("driver", properties.getProperty("jdbc.driver"));
        prop.setProperty("url", properties.getProperty("jdbc.url"));
        prop.setProperty("username", properties.getProperty("jdbc.username"));
        prop.setProperty("password", properties.getProperty("jdbc.password"));
        PooledDataSourceFactory pooledDataSourceFactory = new PooledDataSourceFactory();
        pooledDataSourceFactory.setProperties(prop);
        DataSource dataSource = pooledDataSourceFactory.getDataSource();

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);

        Configuration configuration = new Configuration();
        configuration.setEnvironment(environment);
        configuration.setMapperHelper(new MapperHelper());
        configuration.addMappers("com.github.lyrric.store.mapper");

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    public SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(true);
    }

}
