package com.fererlab.websocket.restful;

import com.fererlab.websocket.dto.WebsocketRequestDTO;
import com.fererlab.websocket.dto.WebsocketResponseDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@Stateless
@ServerEndpoint("/websocket-complex")
public class ComplexTypeResource {

    private Log log = LogFactory.getLog(ComplexTypeResource.class);

    @OnMessage
    public String receiveMessage(String message, Session session) {
        WebsocketRequestDTO requestDTO = new WebsocketRequestDTO();
        WebsocketResponseDTO responseDTO = handle(requestDTO);
        return "";
    }

    private WebsocketResponseDTO handle(WebsocketRequestDTO requestDTO) {
        return new WebsocketResponseDTO();
    }

    @OnOpen
    public void onOpen(final Session session, EndpointConfig config) {
        log.info("Open session: " + session.getId());
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
