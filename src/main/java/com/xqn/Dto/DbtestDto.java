package com.xqn.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.build.ToStringPlugin;

@Getter
@Setter
@ToString
public class DbtestDto {
    private String studentId;
    private String subjectId;
    private String score;
    private String newScore;
    private String week;
    private String termId;

}
