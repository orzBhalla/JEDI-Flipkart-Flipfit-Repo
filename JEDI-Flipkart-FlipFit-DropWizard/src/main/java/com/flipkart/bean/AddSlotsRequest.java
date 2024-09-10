package com.flipkart.bean;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddSlotsRequest {
    // Getters and setters
    private int gymId;
    private List<Slots> slots;

}
