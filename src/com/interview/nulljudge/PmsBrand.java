package com.interview.nulljudge;


import lombok.Data;

import java.io.Serializable;

@Data
public class PmsBrand implements Serializable {
    private Long id;

    private String name;

    private String firstLetter;

    private Integer sort;

    private Integer factoryStatus;

    private Integer showStatus;

    private Integer productCount;

    private Integer productCommentCount;

    private String logo;

    private String bigPic;

    private String brandStory;

    private static final long serialVersionUID = 1L;
}