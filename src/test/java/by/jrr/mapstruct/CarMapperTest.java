package by.jrr.mapstruct;

import by.jrr.mapstruct.bean.Car;
import by.jrr.mapstruct.bean.CarDto;
import by.jrr.mapstruct.bean.CarType;
import by.jrr.mapstruct.mapper.CarMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarMapperTest {

    @Test
    public void carMapper() {
        //given
        Car car = new Car("Morris", 5, CarType.SEDAN);

        //when
        CarDto carDto = CarMapper.OF.carToCarDto(car);

        //then
        assertThat(carDto).isNotNull();
        assertThat(carDto.getMake()).isEqualTo("Morris");
        assertThat(carDto.getSeatCount()).isEqualTo(5);
        assertThat(carDto.getType()).isEqualTo("SEDAN");
    }
}
