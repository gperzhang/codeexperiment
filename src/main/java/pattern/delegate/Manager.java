package pattern.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * create by zj 2019-10-06
 */
public class Manager {
    private Map<String,IEmployee> map = new HashMap<>();
    public Manager(){
        map.put("实现业务",new EmployeeA());
        map.put("搭建架构",new EmployeeB());
    }
    void doing(String commamd){
        IEmployee iEmployee = map.get(commamd);
        iEmployee.doWork(commamd);

    }
}
