package com.flipkart.business;

import com.flipkart.bean.User;

import java.util.*;

public class UserServiceOperations {
    Map<String,User> userMap=new HashMap<String,User>();

    public void createUser(User user){
        if(userMap.containsKey(user.getEmail())){
            return;
        }
        userMap.put(user.getEmail(), user);
    }

    public boolean validateUser(String email, String password){
        if(userMap.containsKey(email)){
            if(userMap.get(email).getPassword().equals(password))
                return true;
        }
        return false;
    }

    public void updateGymUserPassword(String email, String password, String updatedPassword) {
        if(userMap.containsKey(email)){
            if(userMap.get(email).getPassword().equals(password)){
                userMap.get(email).setPassword(updatedPassword);
            }
        }
    }

    public void updateUserDetails(User user) {
        if(userMap.containsKey(user.getEmail())){
            userMap.put(user.getEmail(), user);
        }
    }
}
