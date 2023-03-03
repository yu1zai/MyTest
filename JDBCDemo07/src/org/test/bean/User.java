package org.test.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer UID;
    private String UName;
    private String UPassword;
    private String UEmail;
    private Date UBirthday;
    private String USex;
    private Integer UClass;
    private String UStatement;
    private Date URegDate;
    private String UState;
    private Integer UPoint;
}
