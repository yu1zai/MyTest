package org.gs.util;

import org.apache.commons.dbutils.QueryRunner;

/**
 * BaseDao的目的就是去优化dao实现类
 * @param <T>
 */
public abstract class BaseDao {
    public QueryRunner queryRunner ;

    public int pageSize = 4;

    public BaseDao(){
        queryRunner = new QueryRunner(MyDataSource.getDataSource());
    }
}
