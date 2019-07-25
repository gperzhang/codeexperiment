package pattern.chain;

import java.util.LinkedList;

public class FromOwnerData {

    private LinkedList<String> vinList;

    public FromOwnerData(LinkedList<String> vinListOwner) {
        this.vinList = vinListOwner;
    }

    public void setProcessor(){
        CarBasicProcessor carBasicProcessor = new CarBasicProcessor();
        CarSalesProcessor carSalesProcessor = new CarSalesProcessor(carBasicProcessor);
        carSalesProcessor.selectData(vinList);
    }
}
