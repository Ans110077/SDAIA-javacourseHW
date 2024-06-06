package org.example.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.dao.EmployeeDAO;
import org.example.models.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/employees")
public class EmployeeController {

    EmployeeDAO dao = new EmployeeDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Employee> getAllEmployees() {
        try {
            return dao.selectAllEmployees();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("{empId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee(@PathParam("empId") int empId) {
        try {
            return dao.selectEmployee(empId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DELETE
    @Path("{empId}")
    public void deleteEmployee(@PathParam("empId") int empId) {
        try {
            dao.deleteEmployee(empId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertEmployee(Employee emp) {
        try {
            dao.insertEmployee(emp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("{empId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateEmployee(@PathParam("empId") int empId, Employee emp) {
        try {
            emp.setEmployeeId(empId);
            dao.updateEmployee(emp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
