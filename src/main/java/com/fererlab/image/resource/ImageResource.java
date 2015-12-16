package com.fererlab.image.resource;

import com.fererlab.image.serviceengine.ImageServiceEngine;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.NamingException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@Stateless
@LocalBean
@Path("/image")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class ImageResource {

    @EJB(name = "ImageServiceEngineImpl")
    private ImageServiceEngine imageServiceEngine;

    @POST
    @Path("/upload/{name}")
    @Consumes("multipart/form-data")
    public void upload(MultipartFormDataInput multipartFormDataInput, @PathParam("name") String fileName) throws IOException, NamingException {
        Map<String, List<InputPart>> map = multipartFormDataInput.getFormDataMap();
        List<InputPart> inputPartList = map.get("file");
        if (inputPartList.size() == 1 && inputPartList.get(0) != null) {
            InputStream inputStream = inputPartList.get(0).getBody(InputStream.class, null);
            byte[] bytes = IOUtils.toByteArray(inputStream);
            imageServiceEngine.save(fileName, bytes);
            System.out.println("file uploaded, file name: " + fileName);
        }
    }

    @GET
    @Path("/download/{name}")
    @Produces({"image/png"})
    public byte[] download(@PathParam("name") String fileName) throws NamingException {
        byte[] imageBytes = imageServiceEngine.find(fileName);
        System.out.println("file downloaded, file name: " + fileName);
        return imageBytes;
    }

    @GET
    @Path("/downloadStream/{name}")
    @Produces({MediaType.APPLICATION_OCTET_STREAM})
    public StreamingOutput downloadStream(@PathParam("name") final String fileName) throws Exception {
        return new StreamingOutput() {
            @Override
            public void write(OutputStream outputStream) throws IOException, WebApplicationException {
                InputStream inputStream = imageServiceEngine.getStream(fileName);
                int b = 0;
                while ((b = inputStream.read()) != -1) {
                    outputStream.write(b);
                }
                System.out.println("file streamed, file name: " + fileName);
                outputStream.flush();
                outputStream.close();
                inputStream.close();
            }
        };
    }


}
