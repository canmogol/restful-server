package com.fererlab.animal.restful;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonJsonProvider implements ContextResolver<ObjectMapper> {

    private ObjectMapper objectMapper;

    public JacksonJsonProvider() throws Exception {
        this.objectMapper = new ObjectMapper();
        TypeResolverBuilder<?> typeResolver = new CustomTypeResolverBuilder();
        typeResolver.init(JsonTypeInfo.Id.CLASS, null);
        typeResolver.inclusion(JsonTypeInfo.As.PROPERTY);
        typeResolver.typeProperty("@CLASS");
        this.objectMapper.setDefaultTyping(typeResolver);
    }

    public ObjectMapper getContext(Class<?> objectType) {
        return objectMapper;
    }
}