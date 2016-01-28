package com.fererlab.cluster.restful;

import com.fererlab.cluster.dto.NodeMapDTO;
import com.fererlab.cluster.group.ChannelGroup;
import com.fererlab.cluster.service.ClusterNodesChangedService;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
        return new NodeMapDTO(channelGroup.getNodes());
    }

    @GET
    @Path("/nodesNotified")
    public NodeMapDTO nodesNotified() {
        return new NodeMapDTO(clusterNodesChangedService.getCurrentNodeMap());
    }

}
