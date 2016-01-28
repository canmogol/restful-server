package com.fererlab.cluster.log;

import java.util.logging.Logger;

public class GroupListenerLogger {

    Logger logger = Logger.getLogger(GroupListenerLogger.class.getName());

    public void membershipChangedNotified() {
        logger.info("new membership changed notification arrived");
    }

    public void previousNodes(String previousNodes) {
        logger.info("previous nodes in the cluster: " + previousNodes);
    }

    public void currentNodes(String currentNodes) {
        logger.info("current nodes in the cluster: " + currentNodes);
    }

    public void isMerged(boolean isMerged) {
        if (isMerged) {
            logger.info("this is the result of a merge");
        } else {
            logger.info("this is not a result of a merge");
        }
    }
}
