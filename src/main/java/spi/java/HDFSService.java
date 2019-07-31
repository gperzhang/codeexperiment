package spi.java;

public class HDFSService implements IService {
    @Override
    public String sayHello() {
        return "hello HDFSService";
    }

    @Override
    public String getScheme() {
        return "hdfs";
    }
}
