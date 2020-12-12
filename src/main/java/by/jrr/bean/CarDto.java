package by.jrr.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    private String make;
    private int seatCount;
    private String type;

    //constructor, getters, setters etc.
}
