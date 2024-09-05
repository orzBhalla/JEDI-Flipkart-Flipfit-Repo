package com.flipkart.business;

import com.flipkart.bean.User;

import java.util.*;

public class UserServiceOperations {
    static Map<Integer,User> userMap=new HashMap<Integer,User>();

    static int counter = 1; // for generating user ID

    public void createUser(User user){
        if (userMap.containsKey(user.getUserId())) {
            return;
        }
        user.setUserId(counter);
        counter++;
        userMap.put(user.getUserId(), user);
    }

    public boolean validateUser(String email, String password){
        for(User user : userMap.values()){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public void updateGymUserPassword(String email, String password, String updatedPassword) {
        for(User user : userMap.values()){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                user.setPassword(updatedPassword);
            }
        }
    }

    public void updateUserDetails(User user) {
        if(userMap.containsKey(user.getUserId())){
            userMap.replace(user.getUserId(), user);
        }
    }

    public static Map<Integer,User> getUserMap() {
        return userMap;
    }
}
