package com.fererlab.city.restful;

import com.fererlab.city.serviceengine.CityServiceEngine;
import com.fererlab.city.serviceengine.dto.CityIdIntegerDTO;
import com.fererlab.city.serviceengine.dto.CityIdLongDTO;
import com.fererlab.city.serviceengine.dto.CityOidDTO;
import com.fererlab.city.serviceengine.dto.CityUuidDTO;
import com.fererlab.country.service.CityServiceSelector;

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

    @EJB(name = "CityServiceSelector")
    private CityServiceSelector cityServiceSelector;

    private CityServiceEngine getCityServiceEngine() {
        return cityServiceSelector.select();
    }

    @GET
    @Path("/create/ID")
    public CityIdIntegerDTO createModelWithID() {
        return getCityServiceEngine().createModelWithID();
    }

    @GET
    @Path("/create/IDNoAudit")
    public CityIdLongDTO createModelWithIDNoAudit() {
        return getCityServiceEngine().createModelWithIDNoAudit();
    }

    @GET
    @Path("/create/OID")
    public CityOidDTO createModelWithOID() {
        return getCityServiceEngine().createModelWithOID();
    }

    @GET
    @Path("/create/OIDNoAudit")
    public CityOidDTO createModelWithOIDNoAudit() {
        return getCityServiceEngine().createModelWithOIDNoAudit();
    }

    @GET
    @Path("/create/UUID")
    public CityUuidDTO createModelWithUUID() {
        return getCityServiceEngine().createModelWithUUID();
    }

    @GET
    @Path("/create/UUIDNoAudit")
    public CityUuidDTO createModelWithUUIDNoAudit() {
        return getCityServiceEngine().createModelWithUUIDNoAudit();
    }

    @GET
    @Path("/find/ID/{id}")
    public CityIdIntegerDTO findModelWithID(@PathParam("id") Integer id) {
        return getCityServiceEngine().findModelWithID(id);
    }

    @GET
    @Path("/find/UUID/{uuid}")
    public CityUuidDTO findModelWithUUID(@PathParam("uuid") String uuid) {
        return getCityServiceEngine().findModelWithUUID(uuid);
    }

    @GET
    @Path("/find/OID/{oid}")
    public CityOidDTO findModelWithOID(@PathParam("oid") String oid) {
        return getCityServiceEngine().findModelWithOID(oid);
    }

    @GET
    @Path("/updateCS/ID/{id}/{name}")
    public CityIdIntegerDTO updateModelWithIDCityService(@PathParam("id") Integer id, @PathParam("name") String name) {
        return getCityServiceEngine().updateModelWithIDCityService(id, name);
    }

    @GET
    @Path("/deleteCS/ID/{id}")
    public CityIdIntegerDTO deleteModelWithIDCityService(@PathParam("id") Integer id) {
        return getCityServiceEngine().deleteModelWithIDCityService(id);
    }

    @GET
    @Path("/updateGS/ID/{id}/{name}")
    public CityIdIntegerDTO updateModelWithIDGenericService(@PathParam("id") Integer id, @PathParam("name") String name) {
        return getCityServiceEngine().updateModelWithIDGenericService(id, name);
    }

}
