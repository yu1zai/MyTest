package org.test.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

public class MyDataSource {
    private static DataSource dataSource = null;

    private MyDataSource(){

    }
    public static DataSource getDataSuorce(){
        if(dataSource == null){
            Properties pro = new Properties();
            try {
                pro.load(MyDataSource.class.getClassLoader().getResourceAsStream("druid.properties"));
                dataSource = DruidDataSourceFactory.createDataSource(pro);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return dataSource;
    }

}
