package org.test.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply {
    private Integer TID;
    private Integer RNumber;
    private Integer RTID;
    private Integer RSID;
    private Integer RUID;
    private String REmotion;
    private String RTopic;
    private String RContents;
    private Date RTime;
}
