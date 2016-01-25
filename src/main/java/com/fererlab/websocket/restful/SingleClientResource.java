package com.fererlab.websocket.restful;

import com.fererlab.websocket.configurator.HttpSessionConfigurator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@Stateless
@ServerEndpoint(value = "/websocket-single", configurator = HttpSessionConfigurator.class)
public class SingleClientResource {

    // ************************************************************************
    // OPEN 3 INCOGNITO WINDOWS IN CHROME TO URL
    // http://localhost:8080/restful-server/single-client.jsp
    // ************************************************************************

    private Log log = LogFactory.getLog(SingleClientResource.class);

    @Resource
    private ManagedExecutorService mes;

    private Session wsSession;
    private HttpSession httpSession;


    @OnMessage
    public String receiveMessage(String message, Session session) {
        log.info("Received : " + message + ", session:" + session.getId());
        System.out.println("session = " + session);
        System.out.println("wsSession = " + wsSession);
        System.out.println("httpSession = " + httpSession);
        if (httpSession != null) {
            while (httpSession.getAttributeNames().hasMoreElements()) {
                Object attribute = httpSession.getAttributeNames().nextElement();
                Object value = httpSession.getAttribute(String.valueOf(attribute));
                System.out.println("attribute = " + attribute + " value = " + value);
            }
        }
        return "you said: " + message;
    }

    @OnOpen
    public void onOpen(final Session session, EndpointConfig config) {
        log.info("Open session: " + session.getId());
        this.wsSession = session;
        this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
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
