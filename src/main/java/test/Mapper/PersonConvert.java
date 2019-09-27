package test.Mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import test.DO.Person;
import test.DTO.PersonDTO;

import java.util.List;

/**
 * @author zj
 * @date 2019-09-27 17:12
 */
@Mapper
public interface PersonConvert {

    PersonConvert pesonConvert = Mappers.getMapper(PersonConvert.class);

    @Mappings({
            @Mapping(source = "birthday",target = "birth"),
            @Mapping(source = "birthday",target = "dateFormat",dateFormat = "yyyy-MM-dd HH:mm:ss"),

            @Mapping(source = "user.age",target = "age"),
            @Mapping(target = "email", ignore = true)
    })
    PersonDTO domain2dto(Person person);

    List<PersonDTO> domain2dto(List<Person> people);
}
