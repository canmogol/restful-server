package com.fererlab.cluster.service;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean
@Stateless(name = "ChannelGroup", mappedName = "ChannelGroup")
public class ChannelGroup {

    @EJB(beanName = "ChannelGroupLocator")
    private ChannelGroupLocator channelGroupLocator;

    public NodeMap getNodes() {
        NodeMap nodeMap = new NodeMap();
        try {
            org.wildfly.clustering.group.Group channelGroup = (org.wildfly.clustering.group.Group) channelGroupLocator.getChannelGroup();
            if (channelGroup != null) {
                String currentNodeName = System.getProperty("jboss.node.name") + "/web";
                for (org.wildfly.clustering.group.Node node : channelGroup.getNodes()) {
                    nodeMap.getNodeMap().put(node.getName(), node.getSocketAddress());
                    if (currentNodeName.equals(node.getName())) {
                        nodeMap.setCurrentNode(node.getName());
                    }
                }
            }
        } catch (Exception classNotFoundException) {
            System.out.println("classNotFoundException: " + classNotFoundException.getMessage());
        }
        return nodeMap;
    }
}
