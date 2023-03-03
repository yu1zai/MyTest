package org.gs.dao.impl;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.gs.bean.Route;
import org.gs.dao.RouteDao;
import org.gs.util.BaseDao;

import java.sql.SQLException;
import java.util.List;

public class RouteDaoImpl extends BaseDao implements RouteDao {

    @Override
    public List<Route> findAll() throws SQLException {
        String sql = "select * from tab_route";
        List<Route> routes = queryRunner.query(sql, new BeanListHandler<>(Route.class));
        return routes;
    }

    @Override
    public void save(Route route) throws SQLException {
        String sql = "insert into tab_route values(null, ?, ?, ?, ?)";
        queryRunner.update(sql, route.getRname(), route.getPrice(), route.getRdate(), route.getCid());
    }

    @Override
    public void updateById(Route route) throws SQLException {
        String sql = "update tab_route set rname = ?, price = ?, rdate = ?, cid = ? where rid = ?";
        queryRunner.update(sql, route.getRname(), route.getPrice(), route.getRdate(), route.getCid(), route.getRid());
    }

    @Override
    public void deleteById(Integer id) throws SQLException {
        String sql = "delete from tab_route where rid = ?";
        queryRunner.update(sql, id);
    }

    @Override
    public Route findById(Integer id) throws SQLException {
        String sql = "select * from tab_route where rid = ?";
        Route r = queryRunner.query(sql, new BeanHandler<>(Route.class), id);
        return r;
    }

    @Override
    public List<Route> page(Integer pageNumber) throws SQLException {
        String sql = "select * from tab_route limit ?, ?";
        List<Route> pages = queryRunner.query(sql, new BeanListHandler<>(Route.class), (pageNumber - 1) * pageSize, pageSize);
        return pages;
    }

    @Override
    public Integer pageRecord() throws SQLException {
        String sql = "select count(*) from tab_route";
        Long query = queryRunner.query(sql, new ScalarHandler<Long>());
        return query.intValue();
    }
}
