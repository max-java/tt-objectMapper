package by.jrr.mapstruct.mapper;

import by.jrr.bean.Car;
import by.jrr.bean.CarDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper OF =  Mappers.getMapper(CarMapper.class);

    @Mapping (source = "numberOfSeats", target = "seatCount")
    CarDto carToCarDto(Car car);
}
