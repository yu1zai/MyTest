package org.gs.test;

import org.gs.bean.Emp;
import org.gs.dao.EmpDao;
import org.gs.dao.impl.EmpDaoImpl;
import org.junit.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class EmpDaoImplTest {
    EmpDao empDao = new EmpDaoImpl();
    @Test
    public void findAll() throws SQLException {
        List<Emp> all = empDao.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void save() throws SQLException{
        Emp emp = new Emp();
        emp.setName("明明");
        emp.setGender("男");
        emp.setSalary(12500);
        emp.setJoinDate(Date.valueOf("2002-7-5"));
        emp.setDeptId(1);
        empDao.save(emp);
    }

    @Test
    public void updateById() throws SQLException{
        Emp emp = new Emp();
        emp.setId(10);
        emp.setName("明明");
        emp.setGender("男");
        emp.setSalary(12500);
        emp.setJoinDate(Date.valueOf("2002-7-5"));
        emp.setDeptId(1);
        empDao.updateById(emp);
    }

    @Test
    public void deleteById() throws SQLException{
        empDao.deleteById(7);
    }

    @Test
    public void findById() throws SQLException{
        System.out.println(empDao.findById(4));

    }

    @Test
    public void page() throws SQLException{
        List<Emp> page = empDao.page(2);
        page.forEach(System.out::println);
    }

    @Test
    public void pageRecord() throws SQLException{
        System.out.println(empDao.pageRecord());
    }

    @Test
    public void test() throws SQLException {
        empDao.findEmpDept().forEach(System.out::println);
    }
}