package com.qf.qfv9index.service;

import com.google.common.collect.Lists;
import com.qf.qfv9index.pojo.Node;
import com.qf.v9.entity.DO.TProductTypeDO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;


public class NodeTree {


    private static final Long ROOT_NODE_PID = -1L;

    private List<Node> nodeTree = Lists.newArrayList();

    //构造函数 直接初始化nodeTree
    public NodeTree(List<TProductTypeDO> list) {

        for (int i = 0; i < list.size(); i++) {
            Node node = new Node();
            BeanUtils.copyProperties(list.get(i), node);
            nodeTree.add(node);
        }
    }

    //获取根节点List
    private List<Node> getRootList() {

        List<Node> rootList = new ArrayList<>();

        for (int i = 0; i < nodeTree.size(); i++) {
            if (ROOT_NODE_PID.equals(nodeTree.get(i).getPid())) {
                rootList.add(nodeTree.get(i));
            }
        }
        return rootList;
    }

    //构造城Tree
    public List<Node> getTree() {
        List<Node> list = new ArrayList<>();
        for (Node node : getRootList()) {
            list.add(getSonTree(node));
        }
        return list;
    }

    private Node getSonTree(Node pNode) {
        List<Node> childNode = new ArrayList<>();

        for (Node node : nodeTree) {
            if (node.getPid().equals(pNode.getId())) {
                childNode.add(getSonTree(node));
            }
        }
        pNode.setList(childNode);
        return pNode;
    }


}
