package com.imooc.test;

import com.imooc.entity.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class AccountTest {

    public static void main(String[] args) throws IOException {

        String resource = "config.xml";
        // 使用类加载器加载mybatis配置文件
        InputStream stream = AccountTest.class.getClassLoader().getResourceAsStream(resource);
        // 构件sqlSession工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
        // 使用Mybatis提供的Resources类加载mybatis的配置文件(它也加载关联的映射文件)
        Reader reader = Resources.getResourceAsReader(resource);
        // 构件sqlSession工厂
        SqlSessionFactory sessionFactory1 = new SqlSessionFactoryBuilder().build(reader);
        // 创建能执行映射文件的sqlSession
        SqlSession sqlSession = sessionFactory.openSession();
        // 映射sql标识的字符串
        String statement = "com.imooc.mapping.AccountMapper.getId";
        // 执行查询返回唯一Account对象的sql
        Account one = sqlSession.selectOne(statement, 2);
        System.out.println(one);
    }
}
