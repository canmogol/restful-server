package com.fererlab.websocket.restful;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Singleton;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Singleton
@ServerEndpoint("/websocket-pubsub")
public class PublishSubscribeResource {

    // ************************************************************************
    // OPEN 3 INCOGNITO WINDOWS IN CHROME TO URL
    // http://localhost:8080/restful-server/pubsub.jsp
    // ************************************************************************

    private Log log = LogFactory.getLog(PublishSubscribeResource.class);
    private Set<Session> subscribers = Collections.synchronizedSet(new HashSet<Session>());

    @OnMessage
    public void message(String message, Session publisherSession) {
        log.info("will publish : " + message + ", publisher:" + publisherSession.getId());
        for (Session subscriberSession : subscribers) {
            System.out.println("publishing to " + subscriberSession.getId());
            if (!subscriberSession.getId().equals(publisherSession.getId())) {
                subscriberSession.getAsyncRemote().sendText(message);
            }
        }
    }

    @OnOpen
    public void open(final Session session) {
        log.info("client registered subscribed:" + session.getId());
        if (!subscribers.contains(session)) {
            subscribers.add(session);
        }
    }

    @OnClose
    public void close(Session session, CloseReason c) {
        log.info("client unregistered subscribed:" + session.getId());
        if (subscribers.contains(session)) {
            subscribers.remove(session);
        }
    }

    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }

}
