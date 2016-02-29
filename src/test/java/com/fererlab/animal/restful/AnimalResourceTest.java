package com.fererlab.animal.restful;

import com.fererlab.animal.dto.GenericList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AnimalResourceTest {

    private AnimalResource animalResource;

    @Before
    public void prepare() {
        animalResource = new AnimalResource();
    }

    @Test
    public void testHi() throws Exception {
        Assert.assertEquals(animalResource.hi(), "Hello");
    }

    @Test
    public void testList() throws Exception {
        GenericList list = animalResource.list();
        Assert.assertNotNull(list);
        Assert.assertEquals(list.getList().size(), 2);
    }
}