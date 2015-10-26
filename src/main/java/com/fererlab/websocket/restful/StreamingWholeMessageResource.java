package com.fererlab.websocket.restful;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.nio.ByteBuffer;
import java.util.Random;


@ServerEndpoint("/websocket-stream-whole")
public class StreamingWholeMessageResource {

    private Log log = LogFactory.getLog(StreamingWholeMessageResource.class);

    @OnMessage
    public void message(byte[] bytes, Session session) {
        log.info("whole message - #bytes: " + bytes.length + " session:" + session.getId());
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) throws InterruptedException {
        log.info("whole message - Open session:" + session.getId());
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
        log.info("whole message - Closing:" + session.getId());
    }

    @OnError
    public void onError(Session session, Throwable t) {
        t.printStackTrace();
    }

}
