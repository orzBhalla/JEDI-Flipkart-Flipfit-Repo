package com.flipkart.app;

import com.flipkart.business.UserServiceOperations;
import com.flipkart.rest.CustomerController;
import com.flipkart.rest.GymOwnerController;
import com.flipkart.rest.HelloController;
import com.flipkart.rest.AdminController;
import com.flipkart.business.AdminServiceOperations;
import com.flipkart.business.GymOwnerServiceOperations;
import io.dropwizard.*;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.validation.Validator;

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
        e.jersey().register(new AdminController(new AdminServiceOperations()));
        e.jersey().register(new GymOwnerController(new GymOwnerServiceOperations()));
        e.jersey().register(new CustomerController(new UserServiceOperations()));
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}