package com.flipkart.business;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.dao.FlipFitAdminDAOImplementation;

import java.util.List;

import static com.flipkart.constants.ColorConstants.*;

/**
 * Implements the AdminService interface, providing operations for viewing users, gym owners, and gyms,
 * as well as verifying gyms and gym owners. This class interacts with the DAO layer to perform database operations.
 *
 * @author Chahat, Navaratna
 */
public class AdminServiceOperations implements AdminService {

    /**
     * Instance of the DAO implementation used to interact with the database.
     */
    FlipFitAdminDAOImplementation flipFitAdminDAOImplementation = new FlipFitAdminDAOImplementation();

    /**
     * Views the list of users.
     * <p>
     * Retrieves a list of users and displays them in a formatted table. If no users are found, a message is printed.
     *
     * @author Chahat, Navaratna
     */
    public List<User> viewUsers() {
        return flipFitAdminDAOImplementation.viewUsers();
    }

    /**
     * Views the list of gym owners.
     * <p>
     * Retrieves a list of gym owners and displays them in a formatted table. If no gym owners are found, a message is printed.
     *
     * @author Chahat, Navaratna
     */
    public List<GymOwner> viewGymOwners() {
        return flipFitAdminDAOImplementation.viewGymOwners();
    }

    /**
     * Views the list of gyms.
     * <p>
     * Retrieves a list of gyms and displays them in a formatted table. If no gyms are found, a message is printed.
     *
     * @author Chahat, Navaratna
     */
    public List<Gym> viewGyms() {
        return flipFitAdminDAOImplementation.viewGyms();
    }

    /**
     * Verifies the legitimacy of a gym.
     *
     * @param gymId the unique identifier of the gym to be verified
     * @return true if the gym is verified successfully; false otherwise
     * @author Chahat, Navaratna
     */
    public boolean verifyGym(int gymId) {
        return flipFitAdminDAOImplementation.verifyGym(gymId);
    }

    /**
     * Verifies the legitimacy of a gym owner.
     *
     * @param gymOwnerId the unique identifier of the gym owner to be verified
     * @return true if the gym owner is verified successfully; false otherwise
     * @author Chahat, Navaratna
     */
    public boolean verifyGymOwner(int gymOwnerId) {
        return flipFitAdminDAOImplementation.verifyGymOwner(gymOwnerId);
    }

    /**
     * Retrieves a list of unverified gym owners.
     *
     * @return a list of GymOwner objects representing the gym owners who have not yet been verified
     * @author Chahat, Navaratna
     */
    public List<GymOwner> getUnverifiedGymOwners() {
        return flipFitAdminDAOImplementation.getUnverifiedGymOwners();
    }

    /**
     * Retrieves a list of unverified gyms.
     *
     * @return a list of Gym objects representing the gyms that have not yet been verified
     * @author Chahat, Navaratna
     */
    public List<Gym> getUnverifiedGyms() {
        return flipFitAdminDAOImplementation.getUnverifiedGyms();
    }
}


//package com.flipkart.business;
//
//import com.flipkart.bean.Gym;
//import com.flipkart.bean.GymOwner;
//import com.flipkart.bean.User;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import static com.flipkart.constants.ColorConstants.*;
//
//public class AdminServiceOperations implements AdminService {
//    Map<Integer, User> userMap = UserServiceOperations.getUserMap();
//    Map<Integer, GymOwner> gymOwnerMap = GymOwnerServiceOperations.getGymOwnerMap();
//    Map<Integer, Gym> gymMap = GymServiceOperations.getGymMap();
//
//    public void viewUsers() {
//        String leftAlignFormat = "| %-8s | %-20s | %-30s | %-15s | %-20s | %-40s |%n";
//        System.out.format(ANSI_CYAN + "+----------+----------------------+-------------------------------+---------------+--------------------+--------------------------------------+%n");
//        System.out.format("| User ID  |     Name             | Email                         | Phone Number  | Location           | Address                              |%n");
//        System.out.format("+----------+----------------------+-------------------------------+---------------+--------------------+--------------------------------------+%n" + ANSI_RESET);
//
//        // Assuming 'entries' is a collection of user entries
//        for (Map.Entry<Integer, User> entry : userMap.entrySet()) {
//            User user = entry.getValue();
//            System.out.format(leftAlignFormat, user.getUserId(), user.getUserName(), user.getEmail(), user.getPhoneNumber(), user.getLocation(), user.getAddress());
//        }
//        System.out.format("+----------+----------------------+-------------------------------+---------------+--------------------+--------------------------------------+%n");
//    }
//
//    public void viewGymOwners() {
//        String leftAlignFormat = "| %-13s | %-20s | %-30s | %-15s | %-10s | %-20s | %-20s | %-20s |%n";
//        System.out.format(ANSI_CYAN + "+---------------+----------------------+-------------------------------+---------------+------------+----------------------+----------------------+----------------------+%n");
//        System.out.format("| Gym Owner ID  |     Name             | Email                         | Phone Number  | GST        | National ID          | Verification Status  | PAN                  |%n");
//        System.out.format("+---------------+----------------------+-------------------------------+---------------+------------+----------------------+----------------------+----------------------+%n" + ANSI_RESET);
//
//        for (Map.Entry<Integer, GymOwner> entry : gymOwnerMap.entrySet()) {
//            GymOwner gymOwner = entry.getValue();
//            System.out.format(leftAlignFormat, gymOwner.getOwnerId(), gymOwner.getOwnerName(), gymOwner.getOwnerEmail(), gymOwner.getPhoneNo(), gymOwner.getGST(), gymOwner.getNationalId(), gymOwner.getVerificationStatus(), gymOwner.getPAN());
//        }
//        System.out.format("+---------------+----------------------+-------------------------------+---------------+------------+----------------------+----------------------+----------------------+%n");
//    }
//
//    public void viewGyms() {
//        String leftAlignFormat = "| %-6s | %-20s | %-40s | %-20s | %-10s | %-10s |%n";
//        System.out.format(ANSI_CYAN + "+--------+----------------------+----------------------------------------+----------------------+----------+----------+%n");
//        System.out.format("| Gym ID |     Name             | Address                                | Location             | Owner ID | Status   |%n");
//        System.out.format("+--------+----------------------+----------------------------------------+----------------------+----------+----------+%n" + ANSI_RESET);
//
//        for (Map.Entry<Integer, Gym> entry : gymMap.entrySet()) {
//            Gym gym = entry.getValue();
//            System.out.format(leftAlignFormat, gym.getGymId(), gym.getGymName(), gym.getGymAddress(), gym.getLocation(), gym.getOwnerId(), gym.getStatus());
//        }
//        System.out.format("+--------+----------------------+----------------------------------------+----------------------+----------+----------+%n");
//    }
//
//    public boolean verifyGym(int gymId) {
//        if (gymMap.containsKey(gymId)) {
//            Gym gym = gymMap.get(gymId);
//            gym.setStatus("verified");
//            gymMap.replace(gymId, gym);
//            return true;
//        }
//        return false;
//    }
//
//    public boolean verifyGymOwner(int gymOwnerId) {
//        if (gymOwnerMap.containsKey(gymOwnerId)) {
//            GymOwner gymOwner = gymOwnerMap.get(gymOwnerId);
//            gymOwner.setStatus("verified");
//            gymOwnerMap.replace(gymOwnerId, gymOwner);
//            return true;
//        }
//        return false;
//    }
//
//    public List<GymOwner> getUnverifiedGymOwners() {
//        List<GymOwner> gymOwnerList = new ArrayList<GymOwner>();
//        for (Map.Entry<Integer, GymOwner> entry : gymOwnerMap.entrySet()) {
//            if (entry.getValue().getStatus().equals("unverified")) {
//                gymOwnerList.add(entry.getValue());
//            }
//        }
//        return gymOwnerList;
//    }
//
//    public List<Gym> getUnverifiedGyms() {
//        List<Gym> gymList = new ArrayList<Gym>();
//        for (Map.Entry<Integer, Gym> entry : gymMap.entrySet()) {
//            if (entry.getValue().getStatus().equals("unverified")) {
//                gymList.add(entry.getValue());
//            }
//        }
//        return gymList;
//    }
//}
//
//package com.flipkart.business;
//
//import com.flipkart.bean.Gym;
//import com.flipkart.bean.GymOwner;
//import com.flipkart.bean.User;
//import com.flipkart.dao.FlipFitAdminDAOImplementation;
//
//import java.util.List;
//
//import static com.flipkart.constants.ColorConstants.*;
//
//public class AdminServiceOperations implements AdminService {
//
//    FlipFitAdminDAOImplementation flipFitAdminDAOImplementation = new FlipFitAdminDAOImplementation();
//
//    public void viewUsers() {
//        List<User> users = flipFitAdminDAOImplementation.viewUsers();
//        if(users.isEmpty()) {
//            System.out.println("No users found.");
//            return;
//        }
//
//        String leftAlignFormat = "| %-8s | %-20s | %-30s | %-15s | %-20s | %-40s |%n";
//        System.out.format(ANSI_CYAN + "+----------+----------------------+-------------------------------+---------------+--------------------+--------------------------------------+%n");
//        System.out.format("| User ID  |     Name             | Email                         | Phone Number  | Location           | Address                              |%n");
//        System.out.format("+----------+----------------------+-------------------------------+---------------+--------------------+--------------------------------------+%n" + ANSI_RESET);
//
//        for (User user : users) {
//            System.out.format(leftAlignFormat, user.getUserId(), user.getUserName(), user.getEmail(), user.getPhoneNumber(), user.getLocation(), user.getAddress());
//        }
//        System.out.format("+----------+----------------------+-------------------------------+---------------+--------------------+--------------------------------------+%n");
//    }
//
//    public void viewGymOwners() {
//        List<GymOwner> gymOwners = flipFitAdminDAOImplementation.viewGymOwners();
//        if(gymOwners.isEmpty()) {
//            System.out.println("No gym owners found.");
//            return;
//        }
//
//        String leftAlignFormat = "| %-13s | %-20s | %-30s | %-15s | %-10s | %-20s | %-20s | %-20s |%n";
//        System.out.format(ANSI_CYAN + "+---------------+----------------------+-------------------------------+---------------+------------+----------------------+----------------------+----------------------+%n");
//        System.out.format("| Gym Owner ID  |     Name             | Email                         | Phone Number  | GST        | National ID          | Verification Status  | PAN                  |%n");
//        System.out.format("+---------------+----------------------+-------------------------------+---------------+------------+----------------------+----------------------+----------------------+%n" + ANSI_RESET);
//
//        for (GymOwner gymOwner : gymOwners) {
//            System.out.format(leftAlignFormat, gymOwner.getOwnerId(), gymOwner.getOwnerName(), gymOwner.getOwnerEmail(), gymOwner.getPhoneNo(), gymOwner.getGST(), gymOwner.getNationalId(), gymOwner.getVerificationStatus(), gymOwner.getPAN());
//        }
//        System.out.format("+---------------+----------------------+-------------------------------+---------------+------------+----------------------+----------------------+----------------------+%n");
//    }
//
//    public void viewGyms() {
//        List<Gym> gyms = flipFitAdminDAOImplementation.viewGyms();
//        if(gyms.isEmpty()) {
//            System.out.println("No gyms found.");
//            return;
//        }
//
//        String leftAlignFormat = "| %-6s | %-20s | %-40s | %-20s | %-10s | %-10s |%n";
//        System.out.format(ANSI_CYAN + "+--------+----------------------+----------------------------------------+----------------------+----------+----------+%n");
//        System.out.format("| Gym ID |     Name             | Address                                | Location             | Owner ID | Status   |%n");
//        System.out.format("+--------+----------------------+----------------------------------------+----------------------+----------+----------+%n" + ANSI_RESET);
//
//        for (Gym gym : gyms) {
//            System.out.format(leftAlignFormat, gym.getGymId(), gym.getGymName(), gym.getGymAddress(), gym.getLocation(), gym.getOwnerId(), gym.getStatus());
//        }
//        System.out.format("+--------+----------------------+----------------------------------------+----------------------+----------+----------+%n");
//    }
//
//    public boolean verifyGym(int gymId) {
//        return flipFitAdminDAOImplementation.verifyGym(gymId);
//    }
//
//    public boolean verifyGymOwner(int gymOwnerId) {
//        return flipFitAdminDAOImplementation.verifyGymOwner(gymOwnerId);
//    }
//
//    public List<GymOwner> getUnverifiedGymOwners() {
//        return flipFitAdminDAOImplementation.getUnverifiedGymOwners();
//    }
//
//    public List<Gym> getUnverifiedGyms() {
//        return flipFitAdminDAOImplementation.getUnverifiedGyms();
//    }
//}
