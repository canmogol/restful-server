package com.fererlab.animal.restful;

import org.junit.Assert;
import org.junit.Test;


public class AnimalResourceTest {

    @Test
    public void testHi() throws Exception {
        AnimalResource animalResource = new AnimalResource();
        Assert.assertEquals(animalResource.hi(), "Hello");
    }

}