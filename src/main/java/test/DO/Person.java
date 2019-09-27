package test.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zj
 * @date 2019-09-27 16:59
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    private Long id;
    private String name;
    private String age;
    private Date birthday;
    private User user;
    private String email;
}
