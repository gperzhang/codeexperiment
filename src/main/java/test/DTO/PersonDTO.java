package test.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zj
 * @date 2019-09-27 17:05
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonDTO {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Date birth;
    private String dateFormat;

    @Override
    public String toString() {
        return "PersonDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                ", dateFormat='" + dateFormat + '\'' +
                ", birthExpression='" + birthExpression + '\'' +
                '}';
    }

    private String birthExpression;
}
