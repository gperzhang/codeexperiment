package pattern.delegate;

/**
 * create by zj 2019-10-06
 */
public class EmployeeA implements IEmployee {
    @Override
    public void doWork(String command) {
        System.out.println("我是员工A,擅长业务我被分配到的任务是"+command);
    }
}
