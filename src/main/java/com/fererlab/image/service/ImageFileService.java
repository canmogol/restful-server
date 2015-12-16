package com.fererlab.image.service;

import javax.naming.NamingException;
import java.io.IOException;
import java.io.InputStream;

public interface ImageFileService {

    void save(String fileName, byte[] imageBytes) throws IOException, NamingException;

    byte[] find(String fileName) throws NamingException;

    InputStream getStream(String fileName);

}
