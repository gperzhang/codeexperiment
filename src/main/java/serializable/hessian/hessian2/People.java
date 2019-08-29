package serializable.hessian.hessian2;


import java.io.Serializable;

public class People implements Serializable {

    private static final long serialVersionUID = -7040561573577688598L;
    private String name;

    private String address;

    private String number;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
