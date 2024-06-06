


package org.example.controller;
import org.example.Dao.*;
import org.example.models.*;

import jakarta.ws.rs.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/jobs")
public class jobController {

    JobDAO dao = new JobDAO();

    @GET
    public ArrayList<job> getAllJobs() {

        try {
            return dao.selectAlljobs();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("{jobtId}")
    public job getJob(@PathParam("jobtId") int jobId) {

        try {
            return dao.selectJob(jobId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DELETE
    @Path("{jobId}")
    public void deletejob(@PathParam("jobId") int jobId) {

        try {
            dao.deletejob(jobId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    public void insertjob(job tJob) {

        try {
            dao.insertJob(tJob);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("{jobId}")
    public void updateJob(@PathParam("jobId") int jobId, job tJob) {

        try {
            tJob.setJobId(jobId);
            dao.updateJob(tJob);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
