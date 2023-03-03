package org.test.util;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;
import org.gs.util.MyDataSource;

public class BaseDao {

    public QueryRunner queryRunner ;

    public Integer pageSize = 4;

    public BaseDao(){
        queryRunner = new QueryRunner(MyDataSource.getDataSource());
    }


    public RowProcessor getProcess(){
        BeanProcessor bean = new BeanProcessor();
        RowProcessor processor = new BasicRowProcessor();
        return processor;
    }

}
