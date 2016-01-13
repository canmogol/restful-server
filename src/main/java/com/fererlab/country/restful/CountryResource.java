package com.fererlab.country.restful;

import com.fererlab.country.serviceengine.CountryServiceEngine;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.*;

@Path("/country")
@Produces({"application/json"})
@Consumes({"application/json"})
@Stateless
@LocalBean
public class CountryResource {

    @EJB(name = "CountryServiceEngineImpl")
    CountryServiceEngine countryServiceEngine;

    @GET
    @Path("/findCapitolName/{countryName}")
    public String findCapitolName(@PathParam("countryName") String countryName) {
        return countryServiceEngine.findCapitolName(countryName);
    }


}
