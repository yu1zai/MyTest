package org.gs.dao.impl;

import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.gs.bean.Emp;
import org.gs.dao.EmpDao;
import org.gs.util.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl extends BaseDao implements EmpDao {
    @Override
    public List<Emp> findAll() throws SQLException {
        String sql = "select * from emp";
        BeanProcessor bean = new BeanProcessor();
        RowProcessor processor = new BasicRowProcessor();
        List<Emp> emps = queryRunner.query(sql, new BeanListHandler<>(Emp.class, processor));
        return emps;
    }

    @Override
    public void save(Emp emp) throws SQLException {
        String sql = "insert into emp values(null, ?, ?, ?, ?, ?)";
        queryRunner.update(sql, emp.getName(), emp.getGender(), emp.getSalary(), emp.getJoinDate(), emp.getDeptId());
    }

    @Override
    public void updateById(Emp emp) throws SQLException{
        String sql = "update emp set name = ?, gender = ?, salary = ?, join_date = ?, dept_id = ? where id = ?";
        queryRunner.update(sql, emp.getName(), emp.getGender(), emp.getSalary(), emp.getJoinDate(), emp.getDeptId(), emp.getId());
    }

    @Override
    public void deleteById(Integer id) throws SQLException{
        String sql = "delete from emp where id = ?";
        queryRunner.update(sql, id);
    }

    @Override
    public Emp findById(Integer id) throws SQLException{
        String sql = "select * from emp where id = ?";

        BeanProcessor bean = new BeanProcessor();
        RowProcessor processor = new BasicRowProcessor();
        BeanHandler<Emp> handler = new BeanHandler<>(Emp.class, processor);

        return queryRunner.query(sql, handler, id);
    }

    @Override
    public List<Emp> page(Integer pageNumber) throws SQLException{

        String sql = "select * from emp limit ?, ?";

        BeanProcessor bean = new BeanProcessor();
        RowProcessor processor = new BasicRowProcessor();
        BeanListHandler<Emp> handler = new BeanListHandler<>(Emp.class, processor);

        return queryRunner.query(sql, handler, (pageNumber - 1) * pageSize, pageSize);
    }

    @Override
    public Integer pageRecord() throws SQLException{
        String sql = "select count(*) from emp";
        Long i = queryRunner.query(sql, new ScalarHandler<Long>());

        return i.intValue();
    }

    @Override
    public List<Emp> findEmpDept() throws SQLException {
        String sql = "select e.*, d.name as dname, d.id as did from emp e, dept d where e.dept_id = d.id";
        ResultSetHandler<List<Emp>> handler = new ResultSetHandler<>() {
            @Override
            public List<Emp> handle(ResultSet rs) throws SQLException {
                ArrayList<Emp> empList = new ArrayList<>();
                while(rs.next()){
                    Emp emp = new Emp();
                    emp.setId(rs.getInt("id"));
                    emp.setName(rs.getString("name"));
                    emp.setGender(rs.getString("gender"));
                    emp.setJoinDate(rs.getDate("join_date"));
                    emp.setDeptId(rs.getInt("dept_id"));
                    emp.setSalary(rs.getDouble("salary"));

                    emp.getDept().setId(rs.getInt("did"));
                    emp.getDept().setName(rs.getString("dname"));

                    empList.add(emp);
                }
                return empList;
            }
        };

        return  queryRunner.query(sql,handler);
    }
}
