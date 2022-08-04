package com.interview.datamodel.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author jason.yang
 * @Description 数据传输对象
 * @Date 2021-07-09 9:28
 */
@Data
public class UserDTO {

    private String name;
    private Integer age;
    private String nickName;
    private Date birthDay;

}