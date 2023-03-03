package org.test.dao.impl;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.test.bean.User;
import org.test.dao.UserDao;
import org.test.util.BaseDao;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public List<User> findAll() throws SQLException {
        return queryRunner.query("select * from bbsuser", new BeanListHandler<>(User.class));
    }
    @Override
    public User findById(Integer id) throws SQLException {
        return queryRunner.query("select * from bbsuser where UID = ?", new BeanHandler<>(User.class), id);
    }
    @Override
    public void save(User user) throws SQLException {
        queryRunner.update("insert into bbsuser values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                user.getUID(), user.getUName(), user.getUPassword(), user.getUEmail(), user.getUBirthday(), user.getUSex(),
                user.getUClass(), user.getUStatement(), user.getURegDate(), user.getUState(), user.getUPoint());
    }
    @Override
    public void updateById(User user) throws SQLException {
        queryRunner.update("update bbsuser set UStatement = ?, UState = ? where UID = ?", user.getUStatement(),
                user.getUState(), user.getUID());
    }
    @Override
    public void deleteById(Integer id) throws SQLException {
        queryRunner.update("delete from bbsuser where UID = ?", id);
    }
    @Override
    public List<User> page(Integer pageNumber) throws SQLException {
        return queryRunner.query("select * from bbsuser limit ?, ?", new BeanListHandler<>(User.class), (pageNumber - 1) * pageSize, pageSize);
    }
    @Override
    public Integer pageRcord() throws SQLException {
        return queryRunner.query("select count(*) from bbsuser", new ScalarHandler<Long>()).intValue();
    }
}
