package com.fererlab.websocket.restful;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@Stateless
@ServerEndpoint("/websocket-single")
public class SingleClientResource {

    // ************************************************************************
    // OPEN 3 INCOGNITO WINDOWS IN CHROME TO URL
    // http://localhost:8080/restful-server/single-client.jsp
    // ************************************************************************

    private Log log = LogFactory.getLog(SingleClientResource.class);

    @Resource
    ManagedExecutorService mes;

    @OnMessage
    public String receiveMessage(String message, Session session) {
        log.info("Received : " + message + ", session:" + session.getId());
        return "you said: " + message;
    }

    @OnOpen
    public void onOpen(final Session session, EndpointConfig config) {
        log.info("Open session: " + session.getId());
        mes.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 3; i++) {
                        Thread.sleep(10000);
                        session.getAsyncRemote().sendText("server session: " + session.getId());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        log.info("Closing: " + session.getId());
    }

    @OnError
    public void onError(Session session, Throwable t) {
        log.info("Error exception:" + t.getMessage() + " session: " + session.getId());
        t.printStackTrace();
    }

}
