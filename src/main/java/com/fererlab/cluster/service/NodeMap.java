package com.fererlab.cluster.service;


import java.net.InetSocketAddress;
import java.util.Map;
import java.util.TreeMap;

public class NodeMap {
    private Map<String, InetSocketAddress> nodeMap = new TreeMap<>();
    private String currentNode;

    public NodeMap() {
    }

    public NodeMap(Map<String, InetSocketAddress> nodeMap, String currentNode) {
        this.nodeMap = nodeMap;
        this.currentNode = currentNode;
    }

    public Map<String, InetSocketAddress> getNodeMap() {
        return nodeMap;
    }

    public void setNodeMap(Map<String, InetSocketAddress> nodeMap) {
        this.nodeMap = nodeMap;
    }

    public String getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(String currentNode) {
        this.currentNode = currentNode;
    }
}
