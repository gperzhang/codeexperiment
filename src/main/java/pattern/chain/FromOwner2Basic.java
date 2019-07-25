package pattern.chain;

import java.util.LinkedList;

public class FromOwner2Basic {

    private LinkedList<String> vinOwnerList;
    public FromOwner2Basic(LinkedList<String> vinOwnerList){
        this.vinOwnerList = vinOwnerList;
    }
    public void setProcessor(){
        CarBasicProcessor carBasicProcessor = new CarBasicProcessor();
        carBasicProcessor.selectData(vinOwnerList);
    }
}
