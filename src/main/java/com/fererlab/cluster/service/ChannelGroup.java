package com.fererlab.cluster.service;

import org.wildfly.clustering.group.Group;
import org.wildfly.clustering.group.Node;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean
@Stateless(name = "ChannelGroup", mappedName = "ChannelGroup")
public class ChannelGroup {

    @Resource(lookup = "java:jboss/clustering/group/web")
    private Group channelGroup;

    public NodeMap getNodes() {
        NodeMap nodeMap = new NodeMap();
        String currentNodeName = System.getProperty("jboss.node.name") + "/web";
        if (channelGroup != null) {
            for (Node node : channelGroup.getNodes()) {
                nodeMap.getNodeMap().put(node.getName(), node.getSocketAddress());
                if (currentNodeName.equals(node.getName())) {
                    nodeMap.setCurrentNode(node);
                }
            }
        }
        return nodeMap;
    }

}
