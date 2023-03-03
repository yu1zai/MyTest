package org.test.util;

import java.sql.SQLException;
import java.util.List;

public interface BaseDaoInterface<T> {
    List<T> findAll() throws SQLException;

    T findById(Integer id) throws SQLException;

    void save(T t) throws SQLException;

    void updateById(T t) throws SQLException;

    void deleteById(Integer id) throws SQLException;

    List<T> page(Integer pageNumber) throws SQLException;

    Integer pageRcord() throws SQLException;
}
