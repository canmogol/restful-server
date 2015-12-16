package com.fererlab.image.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.io.InputStream;

@Stateless
public class ImageFileServiceImpl implements ImageFileService {

    @EJB(beanName = "FTPImageServiceImpl")
    private FTPImageService ftpImageService;

    @Override
    public void save(String fileName, byte[] imageBytes) throws IOException, NamingException {
        new InitialContext().bind("image/" + fileName, imageBytes);
    }

    @Override
    public byte[] find(String fileName) throws NamingException {
        byte[] imageBytes = (byte[]) new InitialContext().lookup("image/" + fileName);
        return imageBytes;
    }

    @Override
    public InputStream getStream(String fileName) {
        return ftpImageService.getStream(fileName);
    }

}
