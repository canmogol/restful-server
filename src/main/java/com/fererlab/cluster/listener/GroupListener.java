package com.fererlab.cluster.listener;

import com.fererlab.cluster.log.GroupListenerLogger;
import com.fererlab.cluster.service.ClusterNodesChangedService;
import com.fererlab.cluster.service.NodeMap;

import java.util.List;

public class GroupListener implements org.wildfly.clustering.group.Group.Listener {

    private final ClusterNodesChangedService service;
    private GroupListenerLogger logger = new GroupListenerLogger();

    public GroupListener(ClusterNodesChangedService service) {
        this.service = service;
    }

    @Override
    public void membershipChanged(List<org.wildfly.clustering.group.Node> previousNodeList, List<org.wildfly.clustering.group.Node> currentNodeList, boolean isMerged) {
        logger.membershipChangedNotified();
        String currentNodeName = System.getProperty("jboss.node.name") + "/web";

        // set previous nodes to service
        String previousNodes = "";
        NodeMap previousNodeMap = new NodeMap();
        if (previousNodeList != null) {
            for (org.wildfly.clustering.group.Node node : previousNodeList) {
                previousNodeMap.getNodeMap().put(node.getName(), node.getSocketAddress());
                previousNodes += "[" + node.getName() + " : " + node.getSocketAddress() + "] ";
            }
        }
        this.service.setPreviousNodeMap(previousNodeMap);
        logger.previousNodes(previousNodes);

        // set current nodes to service
        NodeMap currentNodeMap = new NodeMap();
        String currentNodes = "";
        if (currentNodeList != null) {
            for (org.wildfly.clustering.group.Node node : currentNodeList) {
                currentNodeMap.getNodeMap().put(node.getName(), node.getSocketAddress());
                currentNodes += "[" + node.getName() + " : " + node.getSocketAddress() + "] ";
                if (currentNodeName.equals(node.getName())) {
                    currentNodeMap.setCurrentNode(node.getName());
                }
            }
        }
        this.service.setCurrentNodeMap(currentNodeMap);
        logger.currentNodes(currentNodes);

        // set is this the result of a merge
        this.service.setMerged(isMerged);
        logger.isMerged(isMerged);

    }

}
