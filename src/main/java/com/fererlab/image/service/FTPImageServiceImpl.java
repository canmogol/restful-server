package com.fererlab.image.service;


import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Stateless
public class FTPImageServiceImpl implements FTPImageService {
    @Override
    public InputStream getStream(String fileName) {
        // TODO get stream from FTP server
        byte[] imageBytes = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        try {
            imageBytes = (byte[]) new InitialContext().lookup("image/" + fileName);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(imageBytes);
    }
}
