package pattern.chain;

import java.util.LinkedList;

public class FromSalesData {

    private LinkedList<String> vinListSales;

    public FromSalesData(LinkedList<String> vinListSales) {
        this.vinListSales = vinListSales;
    }

    public void setProcessor(){
        CarBasicProcessor carBasicProcessor = new CarBasicProcessor();
        carBasicProcessor.selectData(vinListSales);
    }
}
