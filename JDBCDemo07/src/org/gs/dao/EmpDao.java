package org.gs.dao;

import org.gs.bean.Emp;
import org.gs.util.BaseInterface;

import java.sql.SQLException;
import java.util.List;

public interface EmpDao extends BaseInterface<Emp>{
    List<Emp> findEmpDept() throws SQLException;
}
