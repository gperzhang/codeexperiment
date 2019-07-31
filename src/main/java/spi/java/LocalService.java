package spi.java;

public class LocalService implements IService {
    @Override
    public String sayHello() {
        return "hello LocalService";
    }

    @Override
    public String getScheme() {
        return "local";
    }
}
