package org.gs.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    private String name;
    private String gender;
    private double salary;
    private Date joinDate;
    private Integer deptId;
    //如果进行多表查询的话，一般是通过多这一方发起连接查询
    private Dept dept = new Dept();
}
