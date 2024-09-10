package com.flipkart.app;

import com.flipkart.rest.DemoController;
import io.dropwizard.*;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 */
public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources: ");
        //  e.jersey().register(new EmployeeRESTController(e.getValidator()));
        e.jersey().register(new DemoController());
        // e.jersey().register(new AdminController(e.getValidator(),new AdminServiceOperation()));
        // e.jersey().register(new GymOwnerController(e.getValidator(), new GymOwnerServiceOperation()));
        // e.jersey().register(new CustomerController(e.getValidator(), new UserServiceOperations()));
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}