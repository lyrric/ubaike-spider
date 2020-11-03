package com.github.lyrric.store;

import com.github.lyrric.store.entity.CompanyInfo;
import com.github.lyrric.store.mapper.CompanyInfoMapper;
import com.github.lyrric.store.util.JdbcUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created on 2020-11-03.
 *
 * @author wangxiaodong
 */
@Slf4j
public class StoreTest {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        try (InputStream inputStream = JdbcUtil.class.getResourceAsStream("/application.properties");){
            properties.load(inputStream);
        } catch (IOException e) {
            log.error("读取application.properties文件时发生错误", e);
            throw e;
        }
        JdbcUtil jdbcUtil = new JdbcUtil(properties);
        try (SqlSession sqlSession = jdbcUtil.getSqlSession()){
            final CompanyInfoMapper mapper = sqlSession.getMapper(CompanyInfoMapper.class);
            final CompanyInfo companyInfo = mapper.selectByPrimaryKey(1);
            System.out.println();
        }
    }
}
