package by.jrr;

import by.jrr.bean.Human;
import by.jrr.bean.Person;
import by.jrr.bean.UserDTO;
import by.jrr.objectmapper.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ObjectMapperApplication {

	public static final String RESOURCES = "./src/main/resources/";

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ObjectMapperApplication.class, args);
		UserService userService = ctx.getBean(UserService.class);
		ObjectMapper objectMapper = ctx.getBean(ObjectMapper.class);

		var person = Person.builder().id(2l).name("Max").lastName("Guru").build();
		UserDTO userDTO = userService.mapPersonToUserWithMapper(person);
		System.out.println(userDTO);

		var user = UserDTO.builder().userName("Tema").userLastName("Tank").build();
		Person personFromDto = userService.mapUserToPersonWithMapper(user);
		System.out.println(personFromDto);


		Human humanFromUserDto = userService.mapUserToHumanWithMapper(user);
		System.out.println(humanFromUserDto);
	}
}
