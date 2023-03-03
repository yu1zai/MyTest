package org.gs.util;


import org.gs.bean.Dept;

import java.sql.SQLException;
import java.util.List;

/**
 * BaseInterface优化Dao接口
 * @param <T>
 */
public interface BaseInterface<T> {
    /*查询表中所有数据*/
    public List<T> findAll() throws SQLException;
    /*添加数据*/
    public void save(T t) throws SQLException;
    /*根据主键id进行数据的修改*/
    public void updateById(T t) throws SQLException;
    /*根据主键id删除数据*/
    public void deleteById(Integer id) throws SQLException;
    /*根据主键id查询数据*/
    public T findById(Integer id) throws SQLException;
    /*无条件分页查询*/
    public List<T> page(Integer pageNumber) throws SQLException;
    /*求表中的记录数*/
    public Integer pageRecord() throws SQLException;
}
