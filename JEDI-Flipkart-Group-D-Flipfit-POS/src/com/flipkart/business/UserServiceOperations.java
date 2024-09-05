package com.flipkart.business;

import com.flipkart.bean.User;

import java.util.*;
import java.util.*;

public class UserServiceOperations {
    Map<Integer,User> map=new HashMap<Integer,User>();

    public void createUser(User user){
        if(map.containsKey(user.getUserId())){
            return;
        }
        map.put(user.getUserId(), user);
    }

    public boolean validateUser(String username, String password){

    }
}
