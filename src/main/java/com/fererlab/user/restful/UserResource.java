package com.fererlab.user.restful;

import com.fererlab.user.serviceengine.UserServiceEngine;
import com.fererlab.user.serviceengine.dto.UserDTO;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.*;

@Path("/user")
@Produces({"application/json"})
@Consumes({"application/json"})
@Stateless
@LocalBean
public class UserResource {

    @EJB(name = "UserServiceEngineImpl")
    private UserServiceEngine userServiceEngine;

    @GET
    public UserDTO find(@QueryParam("id") Integer id) {
        return userServiceEngine.find(id);
    }

    @POST
    public UserDTO create(UserDTO dto) {
        return userServiceEngine.create(dto);
    }

    @PUT
    public UserDTO update(UserDTO dto) {
        return userServiceEngine.update(dto);
    }

    @DELETE
    public UserDTO delete(@QueryParam("id") Integer id) {
        return userServiceEngine.delete(id);
    }

}
