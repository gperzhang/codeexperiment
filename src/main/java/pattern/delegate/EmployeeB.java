package pattern.delegate;

/**
 * create by zj 2019-10-06
 */
public class EmployeeB implements IEmployee {
    @Override
    public void doWork(String command) {
        System.out.println("我是员工B，擅长项目架构,我被分配到的任务是"+command);
    }
}
