package com.flipkart.rest;

import com.flipkart.bean.Credentials;
import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.GymOwnerService;
import com.flipkart.business.GymOwnerServiceOperations;
import com.flipkart.bean.AddSlotsRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.validation.Validator;
import java.util.List;

@Path("/gymOwner")
@Produces(MediaType.APPLICATION_JSON)
public class GymOwnerController {
    Validator validator;
    GymOwnerServiceOperations gymOwnerService;

    public GymOwnerController( GymOwnerServiceOperations gymOwnerService) {
//        this.validator = validator;
        this.gymOwnerService = gymOwnerService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response login(Credentials credentials){
        if(gymOwnerService.validateGymOwner(credentials.getUser(), credentials.getPassword())){
            return Response.ok().build();
        }
        else return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addgymwithslots")
    public Response addGymWithSlots(Gym gym){
        gymOwnerService.addGym(gym);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response createGymOwner(GymOwner gymOwner){
        gymOwnerService.createGymOwner(gymOwner);
        return Response.ok().build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/viewMyGyms/{id}")
    public Response viewMyGyms(@PathParam("id") int id){
        List<Gym> gymList = gymOwnerService.viewMyGyms(id);
        return Response.ok(gymList).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/updateGymOwnerPassword")
    public Response updateGymOwnerPassword(@FormParam("email") String email,
                                           @FormParam("password") String password,
                                           @FormParam("updatedPassword") String updatedPassword) {
        boolean isUpdated = gymOwnerService.updateGymOwnerPassword(email, password, updatedPassword);

        if (isUpdated) {
            return Response.ok("Password updated successfully").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Failed to update password. Please check your current credentials.")
                    .build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response updateGymOwner(GymOwner gymOwner) {
        boolean isUpdated = gymOwnerService.updateGymOwner(gymOwner);

        if (isUpdated) {
            return Response.ok("Gym owner updated successfully").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Failed to update gym owner. Please check the provided information.")
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addSlots")
    public Response addSlots(AddSlotsRequest request) {
        boolean isAdded = gymOwnerService.addSlots(request.getGymId(), request.getSlots());

        if (isAdded) {
            return Response.ok("Slots added successfully").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Failed to add slots. Please check the provided information.")
                    .build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updateDetails")
    public Response updateGymDetails(Gym gymRequest) {
        boolean isUpdated = gymOwnerService.updateGymDetails(gymRequest);

        if (isUpdated) {
            return Response.ok("Gym details updated successfully").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Failed to update gym details. Please check the provided information.")
                    .build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updateSeatCount")
    public Response updateSeatCount(@QueryParam("gymId") int gymId,
                                    @QueryParam("startTime") int startTime,
                                    @QueryParam("seatCount") int seatCount) {
        boolean isUpdated = gymOwnerService.updateSeatCount(gymId, startTime, seatCount);

        if (isUpdated) {
            return Response.ok("Seat count updated successfully").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Failed to update seat count. Please check the provided information.")
                    .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getGymOwnerId")
    public Response getGymOwnerIdByEmail(@QueryParam("email") String email) {
        int ownerId = gymOwnerService.getGymOwnerIdByEmail(email);

        if (ownerId > 0) {
            return Response.ok(ownerId).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Gym owner not found with the provided email.")
                    .build();
        }
    }

}