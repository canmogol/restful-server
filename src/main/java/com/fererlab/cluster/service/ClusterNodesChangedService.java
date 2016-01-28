package com.fererlab.cluster.service;

import com.fererlab.cluster.listener.GroupListener;
import org.wildfly.clustering.group.Group;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@LocalBean
@Singleton(name = "ClusterNodesChangedService", mappedName = "ClusterNodesChangedService")
public class ClusterNodesChangedService {

    @Resource(lookup = "java:jboss/clustering/group/web")
    private Group channelGroup;
    private NodeMap previousNodeMap;
    private NodeMap currentNodeMap;
    private boolean merged = false;

    @PostConstruct
    public void registerListener() {
        channelGroup.addListener(new GroupListener(this/*'this' bean is singleton*/));
    }

    public NodeMap getPreviousNodeMap() {
        return previousNodeMap;
    }

    public void setPreviousNodeMap(NodeMap previousNodeMap) {
        this.previousNodeMap = previousNodeMap;
    }

    public NodeMap getCurrentNodeMap() {
        return currentNodeMap;
    }

    public void setCurrentNodeMap(NodeMap currentNodeMap) {
        this.currentNodeMap = currentNodeMap;
    }

    public boolean isMerged() {
        return merged;
    }

    public void setMerged(boolean merged) {
        this.merged = merged;
    }

}
