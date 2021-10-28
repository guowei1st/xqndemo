package com.xqn.Dto;

import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetContent {
    private Integer id;
    private String content;

}
