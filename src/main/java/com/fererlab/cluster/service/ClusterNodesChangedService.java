package com.fererlab.cluster.service;

import javax.ejb.Local;

@Local
public interface ClusterNodesChangedService {

    void setPreviousNodeMap(NodeMap previousNodeMap);

    void setCurrentNodeMap(NodeMap currentNodeMap);

    void setMerged(boolean isMerged);

    NodeMap getCurrentNodeMap();

}
