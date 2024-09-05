package com.flipkart.business;

import com.flipkart.bean.Gym;

import java.util.List;

public interface GymService {

    void createGym(Gym gym);
    void updateGym(Gym gym);
    void deleteGym(Gym gym);
    List<Gym> getAllGyms();
    Gym getGymById(int gymId);

}
