package org.gs.dao.impl;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.gs.bean.Dept;
import org.gs.dao.DeptDao;
import org.gs.util.BaseDao;

import java.sql.SQLException;
import java.util.List;

public class DeptDaoImpl extends BaseDao implements DeptDao {
    @Override
    public List<Dept> findAll() throws SQLException {
        String sql = "select * from dept";
        List<Dept> depts = null;
        depts = queryRunner.query(sql, new BeanListHandler<Dept>(Dept.class));
        return depts;
    }

    @Override
    public void save(Dept dept) throws SQLException {
        String sql = "insert into dept values(null, ?)";
        //queryRunner.update(sql, dept.getName());
    }

    @Override
    public void updateById(Dept dept) throws SQLException {
        String sql = "update dept set name = ? where id = ?";
       // queryRunner.update(sql, dept.getName(), dept.getId());
    }

    @Override
    public void deleteById(Integer id) throws SQLException {
        String sql = "delete from dept where id = ?";
        queryRunner.update(sql, id);
    }

    @Override
    public Dept findById(Integer id) throws SQLException {
        String sql = "select * from dept where id = ?";
        Dept d = queryRunner.query(sql, new BeanHandler<>(Dept.class), id);

        return d;
    }

    @Override
    public List<Dept> page(Integer pageNumber) throws SQLException {
        String sql = "select * from dept limit ?, ?";
        BeanListHandler<Dept> beanListHandler = new BeanListHandler<>(Dept.class);
        List<Dept> pages = queryRunner.query(sql, beanListHandler, (pageNumber - 1) * pageSize, pageSize);
        return pages;
    }

    @Override
    public Integer pageRecord() throws SQLException {
        String sql = "select count(*) from dept";
        ScalarHandler<Long> handler = new ScalarHandler<>();
        Long i = queryRunner.query(sql, handler);
        return i.intValue();
    }

}
