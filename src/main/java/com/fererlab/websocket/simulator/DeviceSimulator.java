package com.fererlab.websocket.simulator;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.websocket.Session;
import java.nio.ByteBuffer;
import java.util.Random;

@Startup
@Singleton
public class DeviceSimulator {

    private Log log = LogFactory.getLog(DeviceSimulator.class);

    private Session client;

    @PostConstruct
    public void init() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (client != null) {
                            // send client some bytes
                            byte[] bytes = new byte[128];
                            new Random().nextBytes(bytes);
                            client.getAsyncRemote().sendBinary(ByteBuffer.wrap(bytes));
                            log.info("device simulator - #bytes " + bytes.length + " sent to client: " + client.getId());
                        }
                        // wait before resending
                        Thread.sleep(250);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public void setClient(Session client) {
        this.client = client;
        log.info("device simulator - set client: " + client);
    }

    public void removeClient() {
        this.client = null;
        log.info("device simulator - there is no client");
    }

    public void sendMessageToDevice(byte[] bytes) {
        log.info("device simulator - whole message arrived #bytes: " + bytes.length + "  session:" + client.getId());
    }
}
