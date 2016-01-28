package com.fererlab.cluster.service;

import org.wildfly.clustering.group.Node;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class NodeMap {
    private Map<String, InetSocketAddress> nodeMap = new HashMap<>();
    private Node currentNode;

    public NodeMap() {
    }

    public NodeMap(Map<String, InetSocketAddress> nodeMap, Node currentNode) {
        this.nodeMap = nodeMap;
        this.currentNode = currentNode;
    }

    public Map<String, InetSocketAddress> getNodeMap() {
        return nodeMap;
    }

    public void setNodeMap(Map<String, InetSocketAddress> nodeMap) {
        this.nodeMap = nodeMap;
    }

    public Node getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }
}
