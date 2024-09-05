package com.flipkart.business;

import com.flipkart.bean.User;

import java.util.*;
import java.util.*;

public class UserServiceOperations {
    Map<String,User> map=new HashMap<String,User>();

    public void createUser(User user){
        if(map.containsKey(user.getEmail())){
            return;
        }
        map.put(user.getEmail(), user);
    }

    public boolean validateUser(String email, String password){
        if(map.containsKey(email)){
            if(map.get(email).getPassword().equals(password))
                return true;
        }
        return false;
    }
}
