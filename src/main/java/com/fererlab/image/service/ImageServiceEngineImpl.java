package com.fererlab.image.service;

import com.fererlab.image.serviceengine.ImageServiceEngine;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.NamingException;
import java.io.IOException;
import java.io.InputStream;

@Stateless
public class ImageServiceEngineImpl implements ImageServiceEngine {

    @EJB(beanName = "ImageFileServiceImpl")
    private ImageFileService imageFileService;

    @Override
    public void save(String fileName, byte[] imageBytes) throws IOException, NamingException {
        imageFileService.save(fileName, imageBytes);
    }

    @Override
    public byte[] find(String fileName) throws NamingException {
        return imageFileService.find(fileName);
    }

    @Override
    public InputStream getStream(String fileName) {
        return imageFileService.getStream(fileName);
    }
}
