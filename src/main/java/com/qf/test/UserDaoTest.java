package com.qf.test;

import com.qf.entity.User;
import com.qf.dao.IUserDao;
import com.qf.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author zxb
 * @date 2021-05-10 23:17
 **/
public class UserDaoTest {

    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlsession();
        System.out.println("aa");
        //获得映射器
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User user = userDao.getUserById(3);
        System.out.println(user);
    }

}
