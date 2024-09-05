package com.flipkart.business;

import java.util.*;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;

public class GymOwnerServiceOperations {

    static Map<Integer,GymOwner> gymOwnerMap = new HashMap<Integer,GymOwner>();
    static int counter=0;
    GymServiceOperations gymServiceOperations = new GymServiceOperations();

    public void addGymWithSlots(Gym gym) {
        gymServiceOperations.addGym(gym);
    }

    public List<Gym> viewMyGyms(String userId){
        Map<Integer, Gym> gymMap = GymServiceOperations.getGymMap();
        List<Gym> myGyms = new ArrayList<Gym>();
        for(Gym gym : gymMap.values()){
            if(gym.getOwnerId().equals(userId)){
                myGyms.add(gym);
                break;
            }
        }
        return myGyms;
    }

    public void createGymOwner(GymOwner gymOwner){
        if(gymOwnerMap.containsKey(gymOwner.getOwnerId())){
            return;
        }
        gymOwner.setOwnerId(counter);
        counter++;
        gymOwnerMap.put(gymOwner.getOwnerId(), gymOwner);
    }

    public boolean validateGymOwner(String email, String password) {
        for(GymOwner gymOwner : gymOwnerMap.values()){
            if(gymOwner.getOwnerEmail().equals(email) && gymOwner.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public void updateGymOwnerPassword(String email, String password, String updatedPassword) {
        for(GymOwner gymOwner : gymOwnerMap.values()){
            if(gymOwner.getOwnerEmail().equals(email) && gymOwner.getPassword().equals(password)){
                gymOwner.setPassword(updatedPassword);
                break;
            }
        }
    }

    public static Map<Integer, GymOwner> getGymOwnerMap() {
        return gymOwnerMap;
    }
}


