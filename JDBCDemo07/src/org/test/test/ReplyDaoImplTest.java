package org.test.test;

import org.junit.Test;
import org.test.bean.Reply;
import org.test.dao.ReplyDao;
import org.test.dao.impl.ReplyDaoImpl;

import java.sql.Date;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class ReplyDaoImplTest {

    public ReplyDao replyDao = new ReplyDaoImpl();

    @Test
    public void findAll() throws SQLException {
        replyDao.findAll().forEach(System.out::println);
    }

    @Test
    public void findById() throws SQLException{
        System.out.println(replyDao.findById(1));
    }

    @Test
    public void save() throws SQLException{
        Reply reply = new Reply(2, 432, 1, 1, 1, "234",
                "aaaa", "裂开", Date.valueOf("2002-9-8"));
        replyDao.save(reply);
    }

    @Test
    public void updateById() throws SQLException{
        Reply reply = new Reply(2, 432, 1, 1, 1, "11111",
                "啊啊啊啊", "裂开开裂裂开开裂", Date.valueOf("2002-9-8"));
        replyDao.updateById(reply);
    }

    @Test
    public void deleteById() throws SQLException{
        replyDao.deleteById(2);
    }

    @Test
    public void page() throws SQLException{
        replyDao.page(1).forEach(System.out::println);
    }

    @Test
    public void pageRcord() throws SQLException{
        System.out.println(replyDao.pageRcord());
    }
}