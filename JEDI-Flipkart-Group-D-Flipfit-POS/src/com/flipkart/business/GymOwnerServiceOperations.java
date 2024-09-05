package com.flipkart.business;

import java.util.*;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;


public class GymOwnerServiceOperations {
    HashMap<String,GymOwner>mp=new HashMap<>();
    HashMap<String,List<Gym>>user=new HashMap<>();
    HashMap<Integer,Gym>slot=new HashMap<>();
    HashMap<String,String>update=new HashMap<>();
    Scanner obj = new Scanner(System.in);
    int id = 0;

    static Map<Integer,GymOwner> gymOwnerMap = new HashMap<Integer,GymOwner>();
    static int counter=0;

    public void addGymWithSlots(Gym gym) {
        if(slot.containsKey(gym.getGymId())){
            return;
        }
        slot.put(gym.getGymId(),gym);

    }


    public List<Gym> viewMyGyms(String userId){
        return user.getOrDefault(userId,new ArrayList<>());
    }


    public boolean validateLogin(String email, String password) {

        if(gymOwnerMap.containsKey(email)){
            return mp.get(email).equals(password);
        }
        return false;
    }


    public void createGymOwner(GymOwner gymOwner){
        if(gymOwnerMap.containsKey(gymOwner.getOwnerId())){
            return;
        }
        gymOwner.setOwnerId(counter);
        counter++;
        gymOwnerMap.put(gymOwner.getOwnerId(), gymOwner);

    }

    public boolean verifyGymOwnerPassword(String email, String password) {
        if(mp.containsKey(email)){
            if(mp.get(email).getPassword().equals(password))
                return true;
        }
        return false;
    }

    public void updateGymOwnerPassword(String email, String password, String updatedPassword) {
        if(update.containsKey(email) && mp.get(email).equals(password)){
            update.put(email, updatedPassword);
        }
        else{
            return;
        }
    }

    public static Map<Integer, GymOwner> getGymOwnerMap() {
        return gymOwnerMap;
    }

}


