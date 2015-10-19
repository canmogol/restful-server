package com.fererlab.websocket.restful;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.nio.ByteBuffer;
import java.util.Random;


@ServerEndpoint("/websocket-stream")
public class StreamingResource {

    // ************************************************************************
    // OPEN 3 INCOGNITO WINDOWS IN CHROME TO URL
    // http://localhost:8080/restful-server/stream.jsp
    // ************************************************************************

    private Log log = LogFactory.getLog(StreamingResource.class);

    @OnMessage
    public void message(byte[] bytes, boolean last, Session session) {
        log.info("#bytes: " + bytes.length + " last: " + last + " session:" + session.getId());
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) throws InterruptedException {
        log.info("Open session:" + session.getId());
        // send client some bytes
        byte[] bytes = new byte[4096];
        new Random().nextBytes(bytes);
        session.getAsyncRemote().sendBinary(ByteBuffer.wrap(bytes));
        session.getAsyncRemote().sendBinary(ByteBuffer.wrap(bytes));
        session.getAsyncRemote().sendBinary(ByteBuffer.wrap(bytes));
        session.getAsyncRemote().sendBinary(ByteBuffer.wrap(new byte[]{1}));
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        log.info("Closing:" + session.getId());
    }

    @OnError
    public void onError(Session session, Throwable t) {
        t.printStackTrace();
    }

}
