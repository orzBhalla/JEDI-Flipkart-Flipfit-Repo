package com.flipkart.business;

import com.flipkart.bean.Gym;

import java.util.Map;

public interface GymService {

    void createGym(Gym gym);

    void listAllGyms();

    void listAllGymsWithArea(String areaName);

    public static Map<Integer, Gym> getGymMap() {
        return Map.of();
    }

}
