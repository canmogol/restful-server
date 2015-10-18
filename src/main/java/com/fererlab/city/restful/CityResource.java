package com.fererlab.city.restful;

import com.fererlab.city.serviceengine.CityServiceEngine;
import com.fererlab.city.serviceengine.dto.CityIdIntegerDTO;
import com.fererlab.city.serviceengine.dto.CityIdLongDTO;
import com.fererlab.city.serviceengine.dto.CityOidDTO;
import com.fererlab.city.serviceengine.dto.CityUuidDTO;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.*;

@Path("/city")
@Produces({"application/json"})
@Consumes({"application/json"})
@Stateless
@LocalBean
public class CityResource {

    @EJB(name = "CityServiceEngineImpl")
    CityServiceEngine cityServiceEngine;

    @GET
    @Path("/create/ID")
    public CityIdIntegerDTO createModelWithID() {
        return cityServiceEngine.createModelWithID();
    }

    @GET
    @Path("/create/IDNoAudit")
    public CityIdLongDTO createModelWithIDNoAudit() {
        return cityServiceEngine.createModelWithIDNoAudit();
    }

    @GET
    @Path("/create/OID")
    public CityOidDTO createModelWithOID() {
        return cityServiceEngine.createModelWithOID();
    }

    @GET
    @Path("/create/OIDNoAudit")
    public CityOidDTO createModelWithOIDNoAudit() {
        return cityServiceEngine.createModelWithOIDNoAudit();
    }

    @GET
    @Path("/create/UUID")
    public CityUuidDTO createModelWithUUID() {
        return cityServiceEngine.createModelWithUUID();
    }

    @GET
    @Path("/create/UUIDNoAudit")
    public CityUuidDTO createModelWithUUIDNoAudit() {
        return cityServiceEngine.createModelWithUUIDNoAudit();
    }

    @GET
    @Path("/find/ID/{id}")
    public CityIdIntegerDTO findModelWithID(@PathParam("id") Integer id) {
        return cityServiceEngine.findModelWithID(id);
    }

    @GET
    @Path("/find/UUID/{uuid}")
    public CityUuidDTO findModelWithUUID(@PathParam("uuid") String uuid) {
        return cityServiceEngine.findModelWithUUID(uuid);
    }

    @GET
    @Path("/find/OID/{oid}")
    public CityOidDTO findModelWithOID(@PathParam("oid") String oid) {
        return cityServiceEngine.findModelWithOID(oid);
    }

    @GET
    @Path("/updateCS/ID/{id}/{name}")
    public CityIdIntegerDTO updateModelWithIDCityService(@PathParam("id") Integer id, @PathParam("name") String name) {
        return cityServiceEngine.updateModelWithIDCityService(id, name);
    }

    @GET
    @Path("/updateGS/ID/{id}/{name}")
    public CityIdIntegerDTO updateModelWithIDGenericService(@PathParam("id") Integer id, @PathParam("name") String name) {
        return cityServiceEngine.updateModelWithIDGenericService(id, name);
    }

}
