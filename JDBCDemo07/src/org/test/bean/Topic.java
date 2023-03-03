package org.test.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    private Integer TID;
    private Integer TNumber;
    private Integer TSID;
    private Integer TUID;
    private Integer TReplyCount;
    private String TEmotiom;
    private String TTopic;
    private String TContents;
    private Date TTime;
    private Integer TClickCount;
    private String TFlag;
    private Date TLastClickT;
}
