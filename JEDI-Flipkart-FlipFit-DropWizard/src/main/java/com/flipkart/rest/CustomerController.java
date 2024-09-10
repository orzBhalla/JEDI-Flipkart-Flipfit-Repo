package com.flipkart.rest;


import com.flipkart.bean.Bookings;
import com.flipkart.bean.Credentials;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;
import com.flipkart.business.UserServiceOperations;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.validation.Validator;

import java.util.List;

@Path("/customer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerController {
    Validator validator;
    UserServiceOperations userServiceOperations;

    public CustomerController(Validator validator, UserServiceOperations userServiceOperations) {
        this.validator = validator;
        this.userServiceOperations = userServiceOperations;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response login(Credentials credentials) {
        if (userServiceOperations.validateUser(credentials.getUser(), credentials.getPassword())) {
            return Response.ok("Login successful! (Gym Customer)").build();
        } else return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllGymsWithSlots")
    public Response getAllGymsWithSlots() {
        List<Gym> gymList = userServiceOperations.viewAllGymsWithSlots();
        if (!gymList.isEmpty())
            return Response.ok(gymList).build();
        else return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("bookSlot/gymId/{gymId}/startTime/{startTime}/email/{email}")
    public Response bookSlot(@PathParam("gymId") Integer gymId, @PathParam("startTime") Integer startTime, @PathParam("email") String email) {
        boolean booked = userServiceOperations.bookSlot(gymId, startTime, email);
        if (booked)
            return Response.ok("Slot booked successfully!").build();
        else return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/cancelSlot/{bookingId}")
    public Response cancelSlot(@PathParam("bookingId") Integer bookingId) {
        boolean cancelled = userServiceOperations.cancelSlot(bookingId);
        if (cancelled)
            return Response.ok("Booking cancelled successfully!").build();
        else return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllBookings/{userId}")
    public Response getAllBookings(@PathParam("userId") int userId) {
        List<Bookings> myBookings = userServiceOperations.viewAllBookings(userId);
        if (!myBookings.isEmpty())
            return Response.ok(myBookings).build();
        else return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllGymsByArea/{area}")
    public Response getAllGymsByArea(@PathParam("area") String area) {
        List<Gym> gymList = userServiceOperations.viewAllGymsByArea(area);
        if (!gymList.isEmpty())
            return Response.ok(gymList).build();
        else return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response createCustomer(User user) {
        boolean success = userServiceOperations.createUser(user);
        if (success)
            return Response.ok("Customer created successfully!").build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}