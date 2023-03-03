package org.test.test;

import org.gs.dao.EmpDao;
import org.junit.Test;
import org.test.bean.Topic;
import org.test.dao.TopicDao;
import org.test.dao.impl.TopicDaoImpl;

import java.sql.Date;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class TopicDaoImplTest {

    public TopicDao topicDao = new TopicDaoImpl();
    @Test
    public void findAll() throws SQLException {
        topicDao.findAll().forEach(System.out::println);
    }

    @Test
    public void findById() throws SQLException{
        System.out.println(topicDao.findById(1));
    }

    @Test
    public void save() throws SQLException{
        Topic topic = new Topic(3, 111, 1, 2, 22222,
                "(*^▽^*)", "乌拉乌拉", "123", Date.valueOf("2022-7-5"), 1111,
                "2123", Date.valueOf("2022-7-5"));
        topicDao.save(topic);
    }

    @Test
    public void updateById() throws SQLException {
        Topic topic = new Topic(3, 111, 1, 2, 22222,
                "0000", "乌拉乌拉", "0019023",
                Date.valueOf("2022-7-5"), 1111,
                "2123", Date.valueOf("2022-7-5"));
        topicDao.updateById(topic);
    }

    @Test
    public void deleteById() throws SQLException{
        topicDao.deleteById(3);
    }

    @Test
    public void page() throws SQLException{
        topicDao.page(1).forEach(System.out::println);
    }

    @Test
    public void pageRcord() throws SQLException{
        System.out.println(topicDao.pageRcord());
    }
}