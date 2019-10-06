package pattern.delegate;

/**
 * create by zj 2019-10-06
 */
public class Boss {
    private Manager manager;
    public Boss(Manager manager){
        this.manager = manager;
    }
    void command(String command){
        manager.doing(command);
    }
}
