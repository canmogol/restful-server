package com.fererlab.websocket.restful;

import com.fererlab.websocket.simulator.DeviceSimulator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;


@Stateless
@LocalBean
@ServerEndpoint("/websocket-stream-device")
public class StreamingDeviceResource {

    private Log log = LogFactory.getLog(StreamingDeviceResource.class);

    @Inject
    private DeviceSimulator deviceSimulator;

    @OnMessage
    public void message(byte[] bytes, Session session) {
        log.info("device resource - #whole message bytes: " + bytes.length + "  session:" + session.getId());
        deviceSimulator.sendMessageToDevice(bytes);
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) throws InterruptedException {
        log.info("device resource - Open session:" + session.getId());
        deviceSimulator.setClient(session);
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        log.info("device resource - Closing:" + session.getId());
        deviceSimulator.removeClient();
    }

    @OnError
    public void onError(Session session, Throwable t) {
        t.printStackTrace();
    }

}
