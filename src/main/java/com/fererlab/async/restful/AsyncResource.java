package com.fererlab.async.restful;

import com.fererlab.async.restful.dto.AsyncRequestDTO;
import com.fererlab.async.restful.dto.AsyncResponseDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Path("/async")
@Produces({"application/json"})
@Consumes({"application/json"})
public class AsyncResource {

    private Log log = LogFactory.getLog(AsyncResource.class);

    private ExecutorService executor = Executors.newSingleThreadExecutor();

    @POST
    @Path("/executorRunnable")
    public void executorRunnable(@QueryParam("name") final String name, @Suspended final AsyncResponse asyncResponse) {
        log.info("executorRunnable begin");
        executor.execute(new Runnable() {
            @Override
            public void run() {
                log.info("executorRunnable doing work");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    log.error("could not sleep, exception: " + e.getMessage());
                }
                String result = "Hi There! " + name;
                log.info("executorRunnable done will send response");
                asyncResponse.resume(result);
            }
        });
        log.info("executorRunnable end");
    }


    @POST
    @Path("/sayHi")
    public void sayHi(@Suspended final AsyncResponse asyncResponse,
                      @Context final Request request,
                      final AsyncRequestDTO asyncRequestDTO) {
        new Thread() {
            @Override
            public void run() {
                AsyncResponseDTO asyncResponseDTO = new AsyncResponseDTO();
                asyncResponseDTO.setResponse("Hi " + asyncRequestDTO.getRequest());
                asyncResponse.resume(asyncResponseDTO);
            }
        }.start();
    }

}
