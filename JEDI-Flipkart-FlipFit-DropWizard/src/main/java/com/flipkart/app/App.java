package com.flipkart.app;

import com.flipkart.business.AdminServiceOperation;
import com.flipkart.business.GymOwnerServiceOperation;
import com.flipkart.business.UserServiceOperations;
import com.flipkart.rest.AdminController;
import com.flipkart.rest.CustomerController;
import com.flipkart.rest.GymOwnerController;
import com.flipkart.rest.HelloController;
import io.dropwizard.*;

import io.dropwizard.core.Application;
import io.dropwizard.core.Configuration;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
        //  e.jersey().register(new EmployeeRESTController(e.getValidator()));
        e.jersey().register(new HelloController());
        e.jersey().register(new AdminController(e.getValidator(),new AdminServiceOperation()));
        e.jersey().register(new GymOwnerController(e.getValidator(), new GymOwnerServiceOperation()));
        e.jersey().register(new CustomerController(e.getValidator(), new UserServiceOperations()));
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}