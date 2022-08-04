package com.interview.arithmetic.nodeformat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jason.yang
 * @Description 工具类
 * @Date 2021-05-16
 */
public class NodeUtils {

    public static List<Node> getNode(List<Node> nodes, String path) {
        List<Node> nodeList = new ArrayList<>();
        if(nodes != null && nodes.size() >0) {
            //递归获取相同的节点
            for (Node node : nodes) {
                if(node.getPath() != null && !"".equals(node.getPath())) {
                    if(node.getPath().equals(path)) {
                        nodeList.add(node);
                    }
                }
            }
        }
        return nodeList;
    }

}