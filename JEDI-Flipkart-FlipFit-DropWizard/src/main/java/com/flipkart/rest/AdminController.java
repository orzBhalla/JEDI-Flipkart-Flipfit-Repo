package com.flipkart.rest;

import com.flipkart.bean.Credentials;
import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.business.AdminServiceOperations;


import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.validation.Validator;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public class AdminController {
    private AdminServiceOperations adminService;
    private Validator validator;
    public AdminController(AdminServiceOperations adminService) {
        this.adminService = adminService;
//        this.validator = validator;
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Credentials credentials) {
        System.out.println("Login called");
//        Properties prop = new Properties(); // Properties is used to read files
//        java.net.URL url = ClassLoader.getSystemResource("./config.properties");
//        try {
//            prop.load(url.openStream());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        String admin_id = "admin";
        String admin_password = "admin";
        System.out.println(admin_id);
        System.out.println(admin_password);

        if (credentials.getUser().equals(admin_id) && credentials.getPassword().equals(admin_password)){
            return Response.ok().build();
        }
        else return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @GET
    @Path("/viewGymOwners")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewGymOwners(){
        List<GymOwner> gymOwnerList =  adminService.viewGymOwners();
        return Response.ok(gymOwnerList).build();
    }

    @GET
    @Path("/viewGyms")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewGyms(){
        List<Gym> gyms =  adminService.viewGyms();

        return Response.ok(gyms).build();
    }

    @GET
    @Path("/viewUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewUsers(){
        List<User> users = adminService.viewUsers();
        return Response.ok(users).build();
    }

    @PUT
    @Path("/verifyGym/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response verifyGym(@PathParam("id") Integer id){
        Boolean res =  adminService.verifyGym(id);
        return Response.ok(res).build();
    }

    @PUT
    @Path("/verifyGymOwner/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response verifyGymOwner(@PathParam("id") Integer id){
        Boolean res =adminService.verifyGymOwner(id);
        return Response.ok(res).build();
    }

    @GET
    @Path("/getUnverifiedGymOwners")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUnverifiedGymOwners(){
        List<GymOwner> uv =  adminService.getUnverifiedGymOwners();
        return Response.ok(uv).build();
    }

    @GET
    @Path("/getUnverifiedGyms")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUnverifiedGyms(){
        List<Gym> gym = adminService.getUnverifiedGyms();
        return Response.ok(gym).build();
    }

}
