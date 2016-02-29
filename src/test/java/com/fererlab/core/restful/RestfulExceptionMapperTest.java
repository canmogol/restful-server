package com.fererlab.core.restful;

import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RestfulExceptionMapperTest {

    private RestfulExceptionMapper restfulExceptionMapper = null;

    @Before
    public void prepare() {
        restfulExceptionMapper = new RestfulExceptionMapper();
    }

    @Test
    public void testToResponse() throws Exception {
        Exception exception = new Exception();
        Response response = restfulExceptionMapper.toResponse(exception);
        assertNotNull(response);
        assertNotNull(response.getHeaderString("ErrorMessage"));
        assertEquals(response.getHeaderString("ErrorMessage"), "");
    }

}