package com.fererlab.cluster.dto;

import java.util.Map;
import java.util.TreeMap;

public class NodeMapDTO {

    private Map<String, String> nodeMap = new TreeMap<>();
    private String currentNode;

    public Map<String, String> getNodeMap() {
        return nodeMap;
    }

    public void setNodeMap(Map<String, String> nodeMap) {
        this.nodeMap = nodeMap;
    }

    public String getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(String currentNode) {
        this.currentNode = currentNode;
    }
}
