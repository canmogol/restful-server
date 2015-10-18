package com.fererlab.async.restful;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Path("/async")
@Produces({"application/json"})
@Consumes({"application/json"})
public class AsyncResource {

    private Log log = LogFactory.getLog(AsyncResource.class);

    private ExecutorService executor = Executors.newSingleThreadExecutor();

    @GET
    @Path("/executorRunnable")
    public void executorRunnable(@Suspended final AsyncResponse asyncResponse) {
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
                String result = "Hi There!";
                log.info("executorRunnable done will send response");
                asyncResponse.resume(result);
            }
        });
        log.info("executorRunnable end");
    }
}
