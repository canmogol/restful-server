package com.fererlab.restful;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.fererlab.city.CityServiceEngine;
import com.fererlab.city.model.CityIDAudited;
import com.fererlab.city.model.CityIDNoAudit;
import com.fererlab.city.model.CityOIDAudited;
import com.fererlab.city.model.CityOIDNoAudit;
import com.fererlab.city.model.CityUUIDAudited;
import com.fererlab.city.model.CityUUIDNoAudit;

@Path("/city")
@Produces({"application/json"})
@Consumes({"application/json"})
public class CityResource {


    @EJB
    CityServiceEngine cityServiceEngine;

    @GET
    @Path("/create/ID")
    public CityIDAudited createModelWithID() {
        return cityServiceEngine.createModelWithID();
    }

    @GET
    @Path("/create/IDNoAudit")
    public CityIDNoAudit createModelWithIDNoAudit() {
        return cityServiceEngine.createModelWithIDNoAudit();
    }

    @GET
    @Path("/create/OID")
    public CityOIDAudited createModelWithOID() {
        return cityServiceEngine.createModelWithOID();
    }

    @GET
    @Path("/create/OIDNoAudit")
    public CityOIDNoAudit createModelWithOIDNoAudit() {
        return cityServiceEngine.createModelWithOIDNoAudit();
    }

    @GET
    @Path("/create/UUID")
    public CityUUIDAudited createModelWithUUID() {
        return cityServiceEngine.createModelWithUUID();
    }

    @GET
    @Path("/create/UUIDNoAudit")
    public CityUUIDNoAudit createModelWithUUIDNoAudit() {
        return cityServiceEngine.createModelWithUUIDNoAudit();
    }

    @GET
    @Path("/find/ID/{id}")
    public CityIDAudited findModelWithID(@PathParam("id") Integer id) {
        return cityServiceEngine.findModelWithID(id);
    }

    @GET
    @Path("/find/UUID/{uuid}")
    public CityUUIDAudited findModelWithUUID(@PathParam("uuid") String uuid) {
        return cityServiceEngine.findModelWithUUID(uuid);
    }

    @GET
    @Path("/find/OID/{oid}")
    public CityOIDAudited findModelWithOID(@PathParam("oid") String oid) {
        return cityServiceEngine.findModelWithOID(oid);
    }

    @GET
    @Path("/updateCS/ID/{id}/{name}")
    public CityIDAudited updateModelWithIDCityService(@PathParam("id") Integer id, @PathParam("name") String name) {
        return cityServiceEngine.updateModelWithIDCityService(id, name);
    }

    @GET
    @Path("/updateGS/ID/{id}/{name}")
    public CityIDAudited updateModelWithIDGenericService(@PathParam("id") Integer id, @PathParam("name") String name) {
        return cityServiceEngine.updateModelWithIDGenericService(id, name);
    }

}
