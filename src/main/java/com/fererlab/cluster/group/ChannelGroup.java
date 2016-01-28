package com.fererlab.cluster.group;

import org.wildfly.clustering.group.Group;
import org.wildfly.clustering.group.Node;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

@LocalBean
@Stateless(name = "ChannelGroup", mappedName = "ChannelGroup")
public class ChannelGroup {

    @Resource(lookup = "java:jboss/clustering/group/web")
    private Group channelGroup;

    public Map<String, InetSocketAddress> getNodes() {
        Map<String, InetSocketAddress> nodeMap = new HashMap<>();
        if (channelGroup != null) {
            for (Node node : channelGroup.getNodes()) {
                nodeMap.put(node.getName(), node.getSocketAddress());
            }
        }
        return nodeMap;
    }

}
