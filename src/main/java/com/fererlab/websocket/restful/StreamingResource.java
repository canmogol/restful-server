package com.fererlab.websocket.restful;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/websocket-stream")
public class StreamingResource extends Endpoint {

    // ************************************************************************
    // OPEN 3 INCOGNITO WINDOWS IN CHROME TO URL
    // http://localhost:8080/restful-server/stream.jsp
    // ************************************************************************

    private Log log = LogFactory.getLog(StreamingResource.class);

    @OnMessage
    public String message(String message, Session session) {
        log.info("message: " + message + " session:" + session.getId());
        return "Hi from server";
    }

    public void onOpen(Session session, EndpointConfig config) {
        log.info("Open session:" + session.getId());
    }

    public void onClose(Session session, CloseReason closeReason) {
        log.info("Closing:" + session.getId());
    }

    public void onError(Session session, Throwable t) {
        t.printStackTrace();
    }

}
