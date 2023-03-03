package org.gs.test;

import org.gs.bean.Dept;
import org.gs.dao.DeptDao;
import org.gs.dao.impl.DeptDaoImpl;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class DeptDaoImplTest {

    DeptDao deptDao = new DeptDaoImpl();

    @Test
    public void findAll() throws SQLException {
        List<Dept> all = deptDao.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void save() throws SQLException {
        Dept dept = new Dept();
        dept.setName("清洁部");
        deptDao.save(dept);
    }

    @Test
    public void updateById() throws SQLException{
        Dept dept = new Dept();
        dept.setId(1);
        dept.setName("清洁部");
        deptDao.updateById(dept);
    }

    @Test
    public void deleteById() throws SQLException {
        deptDao.deleteById(1);
    }

    @Test
    public void findById() throws SQLException{
        Dept byId = deptDao.findById(1);
        System.out.println(byId);
    }

    @Test
    public void page() throws SQLException{
        List<Dept> page = deptDao.page(1);
        page.forEach(System.out::println);
    }

    @Test
    public void pageRecord() throws SQLException{
        Integer integer = deptDao.pageRecord();
        System.out.println(integer);
    }
}