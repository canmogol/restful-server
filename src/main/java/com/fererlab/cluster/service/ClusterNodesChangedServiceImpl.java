package com.fererlab.cluster.service;


import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.InitialContext;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

@Startup
@Singleton(name = "ClusterNodesChangedServiceImpl", mappedName = "ClusterNodesChangedServiceImpl")
public class ClusterNodesChangedServiceImpl implements ClusterNodesChangedService {

//    @EJB(beanName = "ChannelGroupLocator")
//    private ChannelGroupLocator channelGroupLocator;
//
//    private NodeMap previousNodeMap;
//    private NodeMap currentNodeMap;
//    private boolean merged = false;

    //    @Resource(lookup = "java:jboss/clustering/group/web")
//    private Group channelGroup;
    private NodeMap previousNodeMap;
    private NodeMap currentNodeMap;
    private boolean merged = false;

    @PostConstruct
    public void registerListener() {
        try {
            // we expect this call to raise an exception if this is not a cluster deployment
            Object groupChannelObject = new InitialContext().lookup("java:jboss/clustering/group/web");

            // find if the wildfly cluster available, Group and Group$Listener types are not available in non-cluster deployments
            Class groupClass = Class.forName("org.wildfly.clustering.group.Group");
            Class groupListenerClass = Class.forName("org.wildfly.clustering.group.Group$Listener");
            // find if the addListener method available of Group type
            Method addListener = groupClass.getMethod("addListener", groupListenerClass);

            // prepare our GroupListener
            Class groupListenerInternalClass = Class.forName("com.fererlab.cluster.listener.GroupListener");
            Constructor groupListenerConstructor = groupListenerInternalClass.getConstructor(ClusterNodesChangedService.class);
            Object groupListenerObject = groupListenerConstructor.newInstance(this/*'this' bean is singleton*/);

            // add our GroupListener as a listener to cluster nodes
            addListener.invoke(groupChannelObject, groupListenerObject);

        } catch (Exception e) {
            System.out.println("got exception: " + e.getMessage());
        }
    }


//    @PostConstruct
//    @SuppressWarnings("unchecked")
//    public void registerListener() {
//        try {
//            Class groupListenerClass = Class.forName("com.fererlab.cluster.listener.GroupListener");
//            Constructor groupListenerConstructor = groupListenerClass.getConstructor(ClusterNodesChangedService.class);
//            Object groupListenerObject = groupListenerConstructor.newInstance(this/*'this' bean is singleton*/);
//            Object groupObject = channelGroupLocator.getChannelGroup();
//            Method addListener = groupObject.getClass().getMethod("addListener", groupListenerClass);
//            addListener.invoke(groupObject, groupListenerObject);
////
////            org.wildfly.clustering.group.Group channelGroup = (org.wildfly.clustering.group.Group) channelGroupLocator.getChannelGroup();
////            if (channelGroup != null) {
////                channelGroup.addListener(new com.fererlab.cluster.listener.GroupListener(this/*'this' bean is singleton*/));
////            }
//        } catch (Exception e) {
//            System.out.println("got exception: " + e.getMessage());
//        }
//    }

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
