package com.interview.arithmetic.nodeformat;

import lombok.Data;

import java.util.List;

/**
 * @author jason.yang
 * @Description node节点类
 * @Date 2021-05-16
 */
@Data
public class Node {

    private String path;

    private String value;

    private List<Node> children;




}