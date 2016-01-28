package com.fererlab.cluster.listener;

import com.fererlab.cluster.log.GroupListenerLogger;
import com.fererlab.cluster.service.ClusterNodesChangedService;
import org.wildfly.clustering.group.Group;
import org.wildfly.clustering.group.Node;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupListener implements Group.Listener {

    private final ClusterNodesChangedService service;
    private GroupListenerLogger logger = new GroupListenerLogger();

    public GroupListener(ClusterNodesChangedService service) {
        this.service = service;
    }

    @Override
    public void membershipChanged(List<Node> previousNodeList, List<Node> currentNodeList, boolean isMerged) {
        logger.membershipChangedNotified();

        // set previous nodes to service
        String previousNodes = "";
        Map<String, InetSocketAddress> previousNodeMap = new HashMap<>();
        if (previousNodeList != null) {
            for (Node node : previousNodeList) {
                previousNodeMap.put(node.getName(), node.getSocketAddress());
                previousNodes += "[" + node.getName() + " : " + node.getSocketAddress() + "] ";
            }
        }
        this.service.setPreviousNodeMap(previousNodeMap);
        logger.previousNodes(previousNodes);

        // set current nodes to service
        Map<String, InetSocketAddress> currentNodeMap = new HashMap<>();
        String currentNodes = "";
        if (currentNodeList != null) {
            for (Node node : currentNodeList) {
                currentNodeMap.put(node.getName(), node.getSocketAddress());
                currentNodes += "[" + node.getName() + " : " + node.getSocketAddress() + "] ";
            }
        }
        this.service.setCurrentNodeMap(currentNodeMap);
        logger.currentNodes(currentNodes);

        // set is this the result of a merge
        this.service.setMerged(isMerged);
        logger.isMerged(isMerged);

    }

}
