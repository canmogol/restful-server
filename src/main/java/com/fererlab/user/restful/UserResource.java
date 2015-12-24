package com.fererlab.user.restful;

import com.fererlab.user.exception.UserDatabaseException;
import com.fererlab.user.exception.UserException;
import com.fererlab.user.exception.UserIOException;
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
    @Path("/throwNullPointer")
    public UserDTO throwNullPointer(@QueryParam("id") Integer id) {
        return userServiceEngine.throwNullPointerException(id);
    }

    @GET
    @Path("/throwUser")
    public UserDTO throwUser(@QueryParam("id") Integer id) throws UserException {
        return userServiceEngine.throwUserException(id);
    }

    @GET
    @Path("/throwUserDatabase")
    public UserDTO throwUserDatabase(@QueryParam("id") Integer id) throws UserDatabaseException {
        return userServiceEngine.throwUserDatabaseException(id);
    }

    @GET
    @Path("/throwUserIO")
    public UserDTO throwUserIO(@QueryParam("id") Integer id) throws UserIOException {
        return userServiceEngine.throwUserIOException(id);
    }

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
