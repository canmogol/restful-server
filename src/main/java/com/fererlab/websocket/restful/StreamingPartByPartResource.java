package com.fererlab.websocket.restful;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.nio.ByteBuffer;
import java.util.Random;


@ServerEndpoint("/websocket-stream-parts")
public class StreamingPartByPartResource {

    private Log log = LogFactory.getLog(StreamingPartByPartResource.class);

    @OnMessage
    public void message(byte[] bytes, boolean last, Session session) {
        log.info("part by part - #bytes: " + bytes.length + " last: " + last + " session:" + session.getId());
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) throws InterruptedException {
        log.info("part by part - Open session:" + session.getId());
        // send client some bytes
        byte[] bytes = new byte[140960];
        new Random().nextBytes(bytes);
        session.getAsyncRemote().sendBinary(ByteBuffer.wrap(bytes));
        new Random().nextBytes(bytes);
        session.getAsyncRemote().sendBinary(ByteBuffer.wrap(bytes));
        new Random().nextBytes(bytes);
        session.getAsyncRemote().sendBinary(ByteBuffer.wrap(bytes));
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        log.info("part by part - Closing:" + session.getId());
    }

    @OnError
    public void onError(Session session, Throwable t) {
        t.printStackTrace();
    }

}
