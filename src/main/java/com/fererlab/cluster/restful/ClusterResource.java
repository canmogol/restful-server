package com.fererlab.cluster.restful;

import com.fererlab.cluster.dto.NodeMapDTO;
import com.fererlab.cluster.service.ChannelGroup;
import com.fererlab.cluster.service.ClusterNodesChangedService;
import com.fererlab.cluster.service.NodeMap;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.net.InetSocketAddress;

@Path("/cluster")
@Produces({"application/json"})
@Consumes({"application/json"})
public class ClusterResource {

    @EJB(beanName = "ChannelGroup")
    private ChannelGroup channelGroup;

    @EJB(beanName = "ClusterNodesChangedService")
    private ClusterNodesChangedService clusterNodesChangedService;

    @GET
    @Path("/nodesCheck")
    public NodeMapDTO nodesCheck() {
        NodeMap nodeMap = channelGroup.getNodes();
        NodeMapDTO nodeMapDTO = new NodeMapDTO();
        for (String nodeName : nodeMap.getNodeMap().keySet()) {
            InetSocketAddress address = nodeMap.getNodeMap().get(nodeName);
            nodeMapDTO.getNodeMap().put(nodeName, address.toString());
        }
        nodeMapDTO.setCurrentNode(nodeMap.getCurrentNode().getName());
        return nodeMapDTO;
    }

    @GET
    @Path("/nodesNotified")
    public NodeMapDTO nodesNotified() {
        NodeMap nodeMap = clusterNodesChangedService.getCurrentNodeMap();
        NodeMapDTO nodeMapDTO = new NodeMapDTO();
        for (String nodeName : nodeMap.getNodeMap().keySet()) {
            InetSocketAddress address = nodeMap.getNodeMap().get(nodeName);
            nodeMapDTO.getNodeMap().put(nodeName, address.toString());
        }
        nodeMapDTO.setCurrentNode(nodeMap.getCurrentNode().getName());
        return nodeMapDTO;
    }

}
