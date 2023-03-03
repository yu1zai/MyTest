package org.gs.test;

import org.gs.bean.Route;
import org.gs.dao.RouteDao;
import org.gs.dao.impl.RouteDaoImpl;
import org.junit.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class RouteDaoImplTest {

    RouteDao routeDao = new RouteDaoImpl();

    @Test
    public void findAll() throws SQLException{
        List<Route> all = routeDao.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void save() throws SQLException {
        Route route = new Route();
        route.setRname("宜昌");
        route.setPrice(1111111.0);
        route.setRdate(Date.valueOf("2002-7-5"));
        route.setRid(1);
        routeDao.save(route);
    }

    @Test
    public void updateById() throws SQLException{
        Route route = new Route();
        route.setRid(21);
        route.setRname("长江");
        route.setPrice(1111111.0);
        route.setRdate(Date.valueOf("2002-7-5"));
        route.setRid(1);
        routeDao.updateById(route);
    }

    @Test
    public void deleteById() throws SQLException{
        routeDao.deleteById(20);
    }

    @Test
    public void findById() throws SQLException{
        System.out.println(routeDao.findById(1));

    }

    @Test
    public void page() throws SQLException{
        routeDao.page(2).forEach(System.out::println);
    }

    @Test
    public void pageRecord() throws SQLException{
        System.out.println(routeDao.pageRecord());
    }
}