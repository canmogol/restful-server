package com.fererlab.client.restful;

import com.fererlab.client.dto.AuthenticateDTO;
import com.fererlab.client.dto.AuthorizeDTO;
import com.fererlab.client.dto.ClientDTO;
import com.fererlab.client.dto.HttpSessionDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/client")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class ClientResource {

    @POST
    @Path("/authorize")
    public AuthorizeDTO authorize(ClientDTO client) {
        AuthorizeDTO authorizeDTO = new AuthorizeDTO();
        authorizeDTO.setAuthorized(true);
        authorizeDTO.setUuid(client.getUniqueId());
        return authorizeDTO;
    }

    @POST
    @Path("/authenticate")
    public AuthenticateDTO authenticate(HttpSessionDTO httpSessionDTO) {
        AuthenticateDTO authenticateDTO = new AuthenticateDTO();
        authenticateDTO.setAuthenticated(true);
        authenticateDTO.setUuid(httpSessionDTO.getUniqueId());
        return authenticateDTO;
    }

}

