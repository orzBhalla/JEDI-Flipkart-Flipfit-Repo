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

package com.flipkart.business;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.dao.FlipFitAdminDAOImplementation;

import java.util.List;

import static com.flipkart.constants.ColorConstants.*;

public class AdminServiceOperations implements AdminService {

    FlipFitAdminDAOImplementation flipFitAdminDAOImplementation = new FlipFitAdminDAOImplementation();

    public void viewUsers() {
        String leftAlignFormat = "| %-8s | %-20s | %-30s | %-15s | %-20s | %-40s |%n";
        System.out.format(ANSI_CYAN + "+----------+----------------------+-------------------------------+---------------+--------------------+--------------------------------------+%n");
        System.out.format("| User ID  |     Name             | Email                         | Phone Number  | Location           | Address                              |%n");
        System.out.format("+----------+----------------------+-------------------------------+---------------+--------------------+--------------------------------------+%n" + ANSI_RESET);

        for (User user : flipFitAdminDAOImplementation.viewUsers()) {
            System.out.format(leftAlignFormat, user.getUserId(), user.getUserName(), user.getEmail(), user.getPhoneNumber(), user.getLocation(), user.getAddress());
        }
        System.out.format("+----------+----------------------+-------------------------------+---------------+--------------------+--------------------------------------+%n");
    }

    public void viewGymOwners() {
        String leftAlignFormat = "| %-13s | %-20s | %-30s | %-15s | %-10s | %-20s | %-20s | %-20s |%n";
        System.out.format(ANSI_CYAN + "+---------------+----------------------+-------------------------------+---------------+------------+----------------------+----------------------+----------------------+%n");
        System.out.format("| Gym Owner ID  |     Name             | Email                         | Phone Number  | GST        | National ID          | Verification Status  | PAN                  |%n");
        System.out.format("+---------------+----------------------+-------------------------------+---------------+------------+----------------------+----------------------+----------------------+%n" + ANSI_RESET);

        for (GymOwner gymOwner : flipFitAdminDAOImplementation.viewGymOwners()) {
            System.out.format(leftAlignFormat, gymOwner.getOwnerId(), gymOwner.getOwnerName(), gymOwner.getOwnerEmail(), gymOwner.getPhoneNo(), gymOwner.getGST(), gymOwner.getNationalId(), gymOwner.getVerificationStatus(), gymOwner.getPAN());
        }
        System.out.format("+---------------+----------------------+-------------------------------+---------------+------------+----------------------+----------------------+----------------------+%n");
    }

    public void viewGyms() {
        String leftAlignFormat = "| %-6s | %-20s | %-40s | %-20s | %-10s | %-10s |%n";
        System.out.format(ANSI_CYAN + "+--------+----------------------+----------------------------------------+----------------------+----------+----------+%n");
        System.out.format("| Gym ID |     Name             | Address                                | Location             | Owner ID | Status   |%n");
        System.out.format("+--------+----------------------+----------------------------------------+----------------------+----------+----------+%n" + ANSI_RESET);

        for (Gym gym : flipFitAdminDAOImplementation.viewGyms()) {
            System.out.format(leftAlignFormat, gym.getGymId(), gym.getGymName(), gym.getGymAddress(), gym.getLocation(), gym.getOwnerId(), gym.getStatus());
        }
        System.out.format("+--------+----------------------+----------------------------------------+----------------------+----------+----------+%n");
    }

    public boolean verifyGym(int gymId) {
        return flipFitAdminDAOImplementation.verifyGym(gymId);
    }

    public boolean verifyGymOwner(int gymOwnerId) {
        return flipFitAdminDAOImplementation.verifyGymOwner(gymOwnerId);
    }

    public List<GymOwner> getUnverifiedGymOwners() {
        return flipFitAdminDAOImplementation.getUnverifiedGymOwners();
    }

    public List<Gym> getUnverifiedGyms() {
        return flipFitAdminDAOImplementation.getUnverifiedGyms();
    }
}
