package com.fererlab.cluster.dto;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class NodeMapDTO {

    private Map<String, String> nodeMap = new HashMap<>();

    public NodeMapDTO() {
    }

    public NodeMapDTO(Map<String, InetSocketAddress> nodes) {
        if (nodes != null) {
            for (String nodeName : nodes.keySet()) {
                InetSocketAddress address = nodes.get(nodeName);
                this.nodeMap.put(nodeName, address.toString());
            }
        }
    }

    public Map<String, String> getNodeMap() {
        return nodeMap;
    }

    public void setNodeMap(Map<String, String> nodeMap) {
        this.nodeMap = nodeMap;
    }
}
