package com.fererlab.cluster.service;

import com.fererlab.cluster.listener.GroupListener;
import org.wildfly.clustering.group.Group;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.net.InetSocketAddress;
import java.util.Map;

@Startup
@LocalBean
@Singleton(name = "ClusterNodesChangedService", mappedName = "ClusterNodesChangedService")
public class ClusterNodesChangedService {

    @Resource(lookup = "java:jboss/clustering/group/web")
    private Group channelGroup;
    private Map<String, InetSocketAddress> previousNodeMap;
    private Map<String, InetSocketAddress> currentNodeMap;
    private boolean merged = false;

    @PostConstruct
    public void registerListener() {
        channelGroup.addListener(new GroupListener(this/*'this' bean is singleton*/));
    }

    public void setPreviousNodeMap(Map<String, InetSocketAddress> previousNodeMap) {
        this.previousNodeMap = previousNodeMap;
    }

    public Map<String, InetSocketAddress> getPreviousNodeMap() {
        return previousNodeMap;
    }

    public void setCurrentNodeMap(Map<String, InetSocketAddress> currentNodeMap) {
        this.currentNodeMap = currentNodeMap;
    }

    public Map<String, InetSocketAddress> getCurrentNodeMap() {
        return currentNodeMap;
    }

    public boolean isMerged() {
        return merged;
    }

    public void setMerged(boolean merged) {
        this.merged = merged;
    }

}
