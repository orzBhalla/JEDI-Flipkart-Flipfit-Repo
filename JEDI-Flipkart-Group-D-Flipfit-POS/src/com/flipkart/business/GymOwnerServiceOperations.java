//package com.flipkart.business;
//
//import java.util.*;
//
//import com.flipkart.bean.Gym;
//import com.flipkart.bean.GymOwner;
//import com.flipkart.bean.User;
//
//public class GymOwnerServiceOperations implements GymOwnerService {
//
//    static Map<Integer,GymOwner> gymOwnerMap = new HashMap<Integer,GymOwner>();
//    static int counter = 1;
//    GymServiceOperations gymServiceOperations = new GymServiceOperations();
//    Map<Integer, Gym> gymMap = GymServiceOperations.getGymMap();
//
//    public void addGymWithSlots(Gym gym) {
//        gymServiceOperations.addGym(gym);
//    }
//
//    public List<Gym> viewMyGyms(int userId){
//        List<Gym> myGyms = new ArrayList<Gym>();
//        for(Gym gym : gymMap.values()){
//            if(gym.getOwnerId() == userId){
//                myGyms.add(gym);
//            }
//        }
//        return myGyms;
//    }
//
//    public boolean createGymOwner(GymOwner gymOwner){
//        if(gymOwnerMap.containsKey(gymOwner.getOwnerId())){
//            return false;
//        }
//        gymOwner.setOwnerId(counter);
//        counter++;
//        gymOwnerMap.put(gymOwner.getOwnerId(), gymOwner);
//        return true;
//    }
//
//    public boolean validateGymOwner(String email, String password) {
//        for(GymOwner gymOwner : gymOwnerMap.values()){
//            if(gymOwner.getOwnerEmail().equals(email) && gymOwner.getPassword().equals(password)){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean updateGymOwnerPassword(String email, String password, String updatedPassword) {
//        for(GymOwner gymOwner : gymOwnerMap.values()){
//            if(gymOwner.getOwnerEmail().equals(email) && gymOwner.getPassword().equals(password)){
//                gymOwner.setPassword(updatedPassword);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean updateGymOwner(GymOwner gymOwner) {
//        for(GymOwner gymOwner1 : gymOwnerMap.values()){
//            if(gymOwner1.getOwnerEmail().equals(gymOwner.getOwnerEmail())){
//                gymOwner1.setOwnerName(gymOwner.getOwnerName());
//                gymOwner1.setPhoneNo(gymOwner.getPhoneNo());
//                gymOwnerMap.replace(gymOwner1.getOwnerId(), gymOwner1);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static Map<Integer, GymOwner> getGymOwnerMap() {
//        return gymOwnerMap;
//    }
//
//    public int getGymOwnerIdByEmail(String email) {
//        for(GymOwner gymOwner : gymOwnerMap.values()){
//            if(gymOwner.getOwnerEmail().equals(email)){
//                return gymOwner.getOwnerId();
//            }
//        }
//        return -1;
//    }
//}
//

package com.flipkart.business;

import java.util.*;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.FlipFitGymOwnerDAOImplementation;

public class GymOwnerServiceOperations implements GymOwnerService {

    FlipFitGymOwnerDAOImplementation flipFitGymOwnerDAOImplementation = new FlipFitGymOwnerDAOImplementation();

    public boolean addGym(Gym gym) {
        return flipFitGymOwnerDAOImplementation.addGym(gym);
    }

    public List<Gym> viewMyGyms(int gymOwnerId) {
        return flipFitGymOwnerDAOImplementation.viewMyGyms(gymOwnerId);
    }

    public boolean createGymOwner(GymOwner gymOwner){
        return flipFitGymOwnerDAOImplementation.createGymOwner(gymOwner);
    }

    public boolean validateGymOwner(String email, String password) {
        return flipFitGymOwnerDAOImplementation.validateGymOwner(email, password);
    }

    public boolean updateGymOwnerPassword(String email, String password, String updatedPassword) {
        return false;
    }

    public boolean updateGymOwner(GymOwner gymOwner) {
        return flipFitGymOwnerDAOImplementation.updateGymOwner(gymOwner);
    }

    public int getGymOwnerIdByEmail(String email) {
        return flipFitGymOwnerDAOImplementation.getGymOwnerIdByEmail(email);
    }

    public boolean updateSeatCount(int gymId, int startTime, int seatCount) {
        return flipFitGymOwnerDAOImplementation.updateSeatCount(gymId, startTime, seatCount);
    }
}
