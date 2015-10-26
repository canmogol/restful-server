package com.fererlab.animal.restful;

import com.fererlab.animal.dto.Animal;
import com.fererlab.animal.dto.Elephant;
import com.fererlab.animal.dto.Lion;
import com.fererlab.animal.dto.Zoo;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Path("/animal")
@Produces({"application/json"})
@Consumes({"application/json"})
public class AnimalResource {

    @GET
    @Path("/hi")
    public String hi() {
        return "Hello";
    }

    @GET
    @Path("/list")
    public ArrayList<String> list() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("test");
        strings.add("123");
        return strings;
    }

    @GET
    @Path("/zoo")
    public Zoo get() {
        Zoo zoo = new Zoo();
        zoo.setCity("Paz");
        zoo.setName("Samba Wild Park");

        Lion lion = new Lion();
        lion.setName("Simba");
        lion.setEndangered(true);
        lion.setSound("Roar");
        lion.setType("carnivorous");
        lion.setWeight(33.2D);

        Elephant elephant = new Elephant();
        elephant.setName("Manny");
        elephant.setEndangered(false);
        elephant.setSound("trumpet");
        elephant.setType("herbivorous");
        elephant.setAge(12);

        List<Animal> animals = new ArrayList<>();
        animals.add(lion);
        animals.add(elephant);
        zoo.setAnimals(animals);

        return zoo;
    }

}
