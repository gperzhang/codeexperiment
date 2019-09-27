package test;

import org.mapstruct.factory.Mappers;
import test.DO.Person;
import test.DO.User;
import test.DTO.PersonDTO;
import test.Mapper.PersonConvert;

import java.util.Date;

/**
 * @author zj
 * @date 2019-09-27 17:27
 */
public class PersonConvertTest {
    public static void main(String[] args) {
        Person person = new Person(1L,"ZHANGJIE","17",new Date(),new User(1),"2099487761@qq.com");

        PersonConvert pesonConvert = Mappers.getMapper(PersonConvert.class);

        PersonDTO personDTO = pesonConvert.domain2dto(person);

        System.out.println(personDTO);
    }
}
