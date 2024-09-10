package com.flipkart.rest;


import com.flipkart.bean.*;
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

    public CustomerController(UserServiceOperations userServiceOperations) {
        this.userServiceOperations = userServiceOperations;
    }

//    POST localhost:8080/customer/login
//    {
//        "user": "alice.johnson@example.com",
//            "password": "alicepassword"
//    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response login(Credentials credentials) {
        if (userServiceOperations.validateUser(credentials.getUser(), credentials.getPassword())) {
            return Response.ok("Login successful! (Gym Customer)").build();
        } else return Response.status(Response.Status.UNAUTHORIZED).build();
    }

//    GET localhost:8080/customer/getAllGymsWithSlots

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllGymsWithSlots")
    public Response getAllGymsWithSlots() {
        List<Gym> gymList = userServiceOperations.viewAllGymsWithSlots();
        if (!gymList.isEmpty())
            return Response.ok(gymList).build();
        else return Response.status(Response.Status.NOT_FOUND).build();
    }

//    POST localhost:8080/customer/bookSlot/gymId/1/startTime/9/email/alice.johnson@example.com

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("bookSlot/gymId/{gymId}/startTime/{startTime}/email/{email}")
    public Response bookSlot(@PathParam("gymId") Integer gymId, @PathParam("startTime") Integer startTime, @PathParam("email") String email) {
        boolean booked = userServiceOperations.bookSlot(gymId, startTime, email);
        if (booked)
            return Response.ok("Slot booked successfully!").build();
        else return Response.status(Response.Status.NOT_FOUND).build();
    }

//    DELETE localhost:8080/customer/cancelSlot/13

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/cancelSlot/{bookingId}")
    public Response cancelSlot(@PathParam("bookingId") Integer bookingId) {
        boolean cancelled = userServiceOperations.cancelSlot(bookingId);
        if (cancelled)
            return Response.ok("Booking cancelled successfully!").build();
        else return Response.status(Response.Status.NOT_FOUND).build();
    }

//    GET localhost:8080/customer/getAllBookings/1

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllBookings/{userId}")
    public Response getAllBookings(@PathParam("userId") int userId) {
        List<Bookings> myBookings = userServiceOperations.viewAllBookings(userId);
        if (!myBookings.isEmpty())
            return Response.ok(myBookings).build();
        else return Response.status(Response.Status.NOT_FOUND).build();
    }

//    GET localhost:8080/customer/getAllGymsByArea/New%20Yo

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllGymsByArea/{area}")
    public Response getAllGymsByArea(@PathParam("area") String area) {
        List<Gym> gymList = userServiceOperations.viewAllGymsByArea(area);
        if (!gymList.isEmpty())
            return Response.ok(gymList).build();
        else return Response.status(Response.Status.NOT_FOUND).build();
    }

//    POST localhost:8080/customer/create
//    {
//        "userName": "Adarsh",
//            "phoneNumber": "7080004448",
//            "address": "bellandur",
//            "location": "bangalore",
//            "email": "adarsh@flipkart.com",
//            "password": "12345678"
//    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response createCustomer(User user) {
        boolean success = userServiceOperations.createUser(user);
        if (success)
            return Response.ok("Customer created successfully!").build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

//    PUT localhost:8080/customer/updateCustomerPassword
//    email   adarsh@flipkart.com
//    password    12345678
//    updatedPassword 123456

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/updateCustomerPassword")
    public Response updateCustomerPassword(@FormParam("email") String email,
                                           @FormParam("password") String password,
                                           @FormParam("updatedPassword") String updatedPassword) {
        boolean isUpdated = userServiceOperations.updateGymUserPassword(email, password, updatedPassword);

        if (isUpdated) {
            return Response.ok("Password updated successfully").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Failed to update password. Please check your current credentials.")
                    .build();
        }
    }

//    GET localhost:8080/customer/getSeatCount/gymId/1/startTime/9

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getSeatCount/gymId/{gymId}/startTime/{startTime}")
    public Response getAllGymsByArea(@PathParam("gymId") int gymId, @PathParam("startTime") int startTime) {
        int seatCount = userServiceOperations.getSeatCount(gymId, startTime);
        if (seatCount != -1)
            return Response.ok("Seat count: " + seatCount).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}