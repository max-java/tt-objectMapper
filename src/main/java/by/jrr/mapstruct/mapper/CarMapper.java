package by.jrr.mapstruct.mapper;

import by.jrr.mapstruct.bean.Car;
import by.jrr.mapstruct.bean.CarDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper OF =  Mappers.getMapper(CarMapper.class);

    @Mapping (source = "numberOfSeats", target = "seatCount")
    CarDto carToCarDto(Car car);
}
