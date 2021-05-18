package com.qf.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zxb
 * @date 2021-05-10 23:13
 **/
public class SqlSessionFactoryUtil {
    private SqlSessionFactoryUtil() {
    };

    private static SqlSessionFactory sessionFactory;
    /**
     * 生成一个工厂
     * @return
     */
    public static SqlSessionFactory getSessionFactory() {
        synchronized (SqlSessionFactoryUtil.class) {
            if (sessionFactory == null) {
                SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
                try {
                    InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                    sessionFactory = builder.build(inputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sessionFactory;
    }

    /**
     * 返回一个SqlSession
     * @return
     */
    public static SqlSession getSqlsession() {
        if (sessionFactory == null) {
            getSessionFactory();
        }
        SqlSession sqlSession = sessionFactory.openSession();
        return sqlSession;
    }

}
