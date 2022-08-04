package com.interview.datamodel.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author jason.yang
 * @Description 数据库接口模型
 * @Date 2021-07-09 9:23
 */
@Data
public class UserDO {

    private Long id;
    private String name;
    private Integer age;
    private String nickName;
    private Date birthDay;

}