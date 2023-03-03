package org.test.test;

import org.junit.Test;
import org.test.bean.User;
import org.test.dao.UserDao;
import org.test.dao.impl.UserDaoImpl;

import java.sql.Date;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    public UserDao userDao = new UserDaoImpl();
    @Test
    public void findAll() throws SQLException {
        userDao.findAll().forEach(System.out::println);
    }

    @Test
    public void findById() throws SQLException{
        System.out.println(userDao.findById(1));
    }

    @Test
    public void save() throws SQLException{
        User user = new User(4, "小蓝", "445",
                "123@.com", Date.valueOf("2020-9-8"),
                "男", 1, "wu", Date.valueOf("2020-9-8"),
                "99", 1);
        userDao.save(user);
    }

    @Test
    public void updateById() throws SQLException{
        User user = new User(4, "小蓝", "445",
                "123@.com", Date.valueOf("2020-9-8"),
                "男", 1, "......",
                Date.valueOf("2020-9-8"), "0000", 1);
        userDao.updateById(user);
    }

    @Test
    public void deleteById() throws SQLException{
        userDao.deleteById(4);
    }

    @Test
    public void page() throws SQLException{
        userDao.page(1).forEach(System.out::println);

    }

    @Test
    public void pageRcord() throws SQLException{
        System.out.println(userDao.pageRcord());
    }
}