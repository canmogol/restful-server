package com.fererlab.car.restful;

import com.fererlab.car.model.Car;
import com.fererlab.car.dto.CarDTO;
import com.fererlab.generic.restful.GenericResource;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.*;

@Path("/car")
@Produces({"application/json"})
@Consumes({"application/json"})
@Stateless
@LocalBean
public class CarResource extends GenericResource<CarDTO, Car, Integer> {

    public CarResource() {
        super(Car.class, CarDTO.class);
    }

    @GET
    public CarDTO find(@QueryParam("id") Integer id) {
        return _find(id);
    }

    @POST
    public CarDTO create(CarDTO dto) {
        return _create(dto);
    }

    @PUT
    public CarDTO update(CarDTO dto) {
        return _update(dto);
    }

    @DELETE
    public CarDTO delete(@QueryParam("id") Integer id) {
        return _delete(id);
    }

}
