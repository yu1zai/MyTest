package org.test.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Section {
    private Integer SID;
    private String SName;
    private Integer SMasterID;
    private String SStatement;
    private Integer SClickCount;
    private Integer STopicCount;
}
