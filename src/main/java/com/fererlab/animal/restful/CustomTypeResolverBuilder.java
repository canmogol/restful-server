package com.fererlab.animal.restful;


import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomTypeResolverBuilder extends ObjectMapper.DefaultTypeResolverBuilder {
    public CustomTypeResolverBuilder() {
        super(ObjectMapper.DefaultTyping.NON_FINAL);
    }

    @Override
    public boolean useForType(JavaType t) {
        return true;
    }
}