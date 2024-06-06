package org.example.controller;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.example.dao.JobDAO;
import org.example.dto.JobDto;
import org.example.modle.Job;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Filter;
import java.util.zip.DataFormatException;

@Path("/jobs")
public class JobController {

    JobDAO dao = new JobDAO();
    @Context
    UriInfo uriInfo;
    @Context
    HttpHeaders headers;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public Response getAllJobs() {


        try {
            GenericEntity<ArrayList<Job>> job = new GenericEntity<ArrayList<Job>>(dao.selectAll()) {
            };
            if (headers.getAcceptableMediaTypes().contains(MediaType.valueOf(MediaType.APPLICATION_XML))) {
                return Response
                        .ok(job)
                        .type(MediaType.APPLICATION_XML)
                        .build();
            }
            return Response.ok(job, MediaType.APPLICATION_JSON).build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @GET
    @Path("{jobId}")


    public Response getJob(@PathParam("jobId") int jobId) throws SQLException {
        try {
            Job job = dao.selectJob(jobId);
            if (job == null) {
                throw new DataFormatException("Job" + jobId + "not found");
            }
            JobDto dto = new JobDto();
            dto.setJob_id(job.getJob_id());
            dto.setJob_title(job.getJob_title());
            dto.setMax_salary(job.getMax_salary());
            dto.setMin_salary(job.getMin_salary());
            return Response.ok(dto).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @DELETE
    @Path("{jobId}")
    public Response deleteJob(@PathParam("jobId") int jobId, Job job) {
        try {
            dao.deleteJob(jobId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @PUT
    @Path("{jobId}")

    public Response updateJob(@PathParam("jobId") int jobId, Job job) {
        try {
            dao.updateJob(job);
            NewCookie cookie = (new NewCookie.Builder("username").value("abdullah").build());
            URI uri = uriInfo.getAbsolutePathBuilder().path(job.getJob_id() + "").build();
            return Response
                    .created(uri)
                    .cookie(cookie)
                    .header("Created by", "abdullah")
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response insertJob(Job JOBS) {
        try {
            dao.insertJob(JOBS);
            NewCookie cookie = (new NewCookie.Builder("username").value("abdullah").build());
            URI uri = uriInfo.getAbsolutePathBuilder().path(JOBS.getJob_id() + "").build();
            return Response
                    .created(uri)
                    .cookie(cookie)
                    .header("Created by", "abdullah")
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void addLinks(JobDto dto){
        URI setFUri = uriInfo.getAbsolutePath();
        URI empsUri = uriInfo.getAbsolutePathBuilder() .path(JobController.class).build();
        dto.addLink(setFUri.toString(), "self");
        dto.addLink(empsUri.toString(), "job");

    }
    @POST
    public Response insertJobFromForm(@BeanParam Job job){
        try {
            dao.insertJob(job);
            NewCookie cookie = (new NewCookie.Builder("username")).value("abdullah").build();
            URI uri = uriInfo.getAbsolutePathBuilder().path(job.getJob_id()+ " ").build();
            return Response.created(uri).cookie(cookie).header("Created by", "Wael").build();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}




