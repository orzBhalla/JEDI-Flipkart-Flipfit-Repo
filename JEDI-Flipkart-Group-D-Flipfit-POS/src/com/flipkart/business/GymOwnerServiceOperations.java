package com.flipkart.business;

import java.util.*;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;

public class GymOwnerServiceOperations implements GymOwnerService {

    static Map<Integer,GymOwner> gymOwnerMap = new HashMap<Integer,GymOwner>();
    static int counter=0;
    GymServiceOperations gymServiceOperations = new GymServiceOperations();
    Map<Integer, Gym> gymMap = GymServiceOperations.getGymMap();

    public void addGymWithSlots(Gym gym) {
        gymServiceOperations.addGym(gym);
    }

    public List<Gym> viewMyGyms(int userId){
        List<Gym> myGyms = new ArrayList<Gym>();
        for(Gym gym : gymMap.values()){
            if(gym.getOwnerId() == userId){
                myGyms.add(gym);
                break;
            }
        }
        return myGyms;
    }

    public boolean createGymOwner(GymOwner gymOwner){
        if(gymOwnerMap.containsKey(gymOwner.getOwnerId())){
            return false;
        }
        gymOwner.setOwnerId(counter);
        counter++;
        gymOwnerMap.put(gymOwner.getOwnerId(), gymOwner);
        return true;
    }

    public boolean validateGymOwner(String email, String password) {
        for(GymOwner gymOwner : gymOwnerMap.values()){
            if(gymOwner.getOwnerEmail().equals(email) && gymOwner.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public boolean updateGymOwnerPassword(String email, String password, String updatedPassword) {
        for(GymOwner gymOwner : gymOwnerMap.values()){
            if(gymOwner.getOwnerEmail().equals(email) && gymOwner.getPassword().equals(password)){
                gymOwner.setPassword(updatedPassword);
                return true;
            }
        }
        return false;
    }

    public boolean updateGymOwner(GymOwner gymOwner) {
        for(GymOwner gymOwner1 : gymOwnerMap.values()){
            if(gymOwner1.getOwnerEmail().equals(gymOwner.getOwnerEmail())){
                gymOwner1.setOwnerName(gymOwner.getOwnerName());
                gymOwner1.setPhoneNo(gymOwner.getPhoneNo());
                gymOwnerMap.replace(gymOwner1.getOwnerId(), gymOwner1);
                return true;
            }
        }
        return false;
    }

    public static Map<Integer, GymOwner> getGymOwnerMap() {
        return gymOwnerMap;
    }
}


