package org.test.dao.impl;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.test.bean.Reply;
import org.test.dao.ReplyDao;
import org.test.util.BaseDao;

import java.sql.SQLException;
import java.util.List;

public class ReplyDaoImpl extends BaseDao implements ReplyDao {
    @Override
    public List<Reply> findAll() throws SQLException {
        return queryRunner.query("select * from bbsreply", new BeanListHandler<>(Reply.class));
    }
    @Override
    public Reply findById(Integer id) throws SQLException {
        return queryRunner.query("select * from bbsreply where TID = ?", new BeanHandler<>(Reply.class), id);
    }
    @Override
    public void save(Reply reply) throws SQLException {
        queryRunner.update("insert into bbsreply values (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                reply.getTID(),reply.getRNumber(), reply.getRTID(), reply.getRSID(), reply.getRUID(), reply.getREmotion(), reply.getRTopic(), reply.getRContents(), reply.getRTime());
    }
    @Override
    public void updateById(Reply reply) throws SQLException {
        queryRunner.update("update bbsreply set REmotion = ?, RContents = ? where TID = ?", reply.getREmotion(), reply.getRContents(), reply.getTID());
    }
    @Override
    public void deleteById(Integer id) throws SQLException {
        queryRunner.update("delete from bbsreply where TID = ?", id);
    }
    @Override
    public List<Reply> page(Integer pageNumber) throws SQLException {
        return queryRunner.query("select * from bbsreply limit ?, ?", new BeanListHandler<>(Reply.class), (pageNumber - 1) * pageSize, pageSize);

    }
    @Override
    public Integer pageRcord() throws SQLException {
        return queryRunner.query("select count(*) from bbsreply", new ScalarHandler<Long>()).intValue();
    }
}
