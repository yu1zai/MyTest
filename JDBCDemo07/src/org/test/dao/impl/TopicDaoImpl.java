package org.test.dao.impl;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.test.bean.Section;
import org.test.bean.Topic;
import org.test.dao.TopicDao;
import org.test.util.BaseDao;
import org.test.util.BaseDaoInterface;

import java.sql.SQLException;
import java.util.List;

public class TopicDaoImpl extends BaseDao implements TopicDao {
    @Override
    public List<Topic> findAll() throws SQLException {
        return queryRunner.query("select * from bbstopic", new BeanListHandler<>(Topic.class));
    }
    @Override
    public Topic findById(Integer id) throws SQLException {
        return queryRunner.query("select * from bbstopic where TID = ?", new BeanHandler<>(Topic.class), id);
    }
    @Override
    public void save(Topic topic) throws SQLException {
        queryRunner.update("insert into bbstopic values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                topic.getTID(), topic.getTNumber(), topic.getTSID(), topic.getTUID(), topic.getTReplyCount(), topic.getTEmotiom(),
                topic.getTTopic(), topic.getTContents(), topic.getTTime(), topic.getTClickCount(), topic.getTFlag(), topic.getTLastClickT());
    }
    @Override
    public void updateById(Topic topic) throws SQLException {
        queryRunner.update("update bbstopic set TEmotiom = ?, TContents = ? where TID = ?", topic.getTEmotiom(), topic.getTContents(), topic.getTID());
    }
    @Override
    public void deleteById(Integer id) throws SQLException {
        queryRunner.update("delete from bbstopic where TID = ?", id);
    }
    @Override
    public List<Topic> page(Integer pageNumber) throws SQLException {
        return queryRunner.query("select * from bbstopic limit  ?, ?", new BeanListHandler<>(Topic.class), (pageNumber - 1) * pageSize, pageSize);
    }
    @Override
    public Integer pageRcord() throws SQLException {
        return queryRunner.query("select count(*) from bbstopic", new ScalarHandler<Long>()).intValue();
    }
}
