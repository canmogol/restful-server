package com.fererlab.websocket.restful;

import com.fererlab.websocket.dto.WebsocketRequestDTO;
import com.fererlab.websocket.dto.WebsocketResponseDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@Stateless
@ServerEndpoint(value = "/websocket-complex")
public class ComplexTypeResource {

    private Log log = LogFactory.getLog(ComplexTypeResource.class);

    @OnMessage
    public void receiveMessage(String message, Session session) throws IOException, EncodeException {
        WebsocketRequestDTO requestDTO = new WebsocketRequestDTO();
        requestDTO.setMessage(message);
        WebsocketResponseDTO responseDTO = handle(requestDTO);
        session.getBasicRemote().sendObject(responseDTO);
    }

    private WebsocketResponseDTO handle(WebsocketRequestDTO requestDTO) {
        WebsocketResponseDTO websocketResponseDTO = new WebsocketResponseDTO();
        websocketResponseDTO.setResponse(requestDTO.getMessage());
        return websocketResponseDTO;
    }

    @OnOpen
    public void onOpen(final Session session, EndpointConfig config) {
        log.info("Open session: " + session.getId());
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        log.info("Closing: " + session.getId() + " closeReason: " + closeReason);
    }

    @OnError
    public void onError(Session session, Throwable t) {
        log.info("Error exception:" + t.getMessage() + " session: " + session.getId());
        t.printStackTrace();
    }

}
