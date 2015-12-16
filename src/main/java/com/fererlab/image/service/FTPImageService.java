package com.fererlab.image.service;


import javax.ejb.Local;
import java.io.InputStream;

@Local
public interface FTPImageService {
    InputStream getStream(String fileName);
}
