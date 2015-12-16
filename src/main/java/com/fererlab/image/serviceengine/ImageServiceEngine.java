package com.fererlab.image.serviceengine;

import javax.ejb.Local;
import javax.naming.NamingException;
import java.io.IOException;
import java.io.InputStream;

@Local
public interface ImageServiceEngine {

    void save(String fileName, byte[] imageBytes) throws IOException, NamingException;

    byte[] find(String fileName) throws NamingException;

    InputStream getStream(String fileName);

}
