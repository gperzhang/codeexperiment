package pattern.chain;

import java.util.LinkedList;

public class DataLinkMonitor {

    private FromOwnerData fromOwnerData;

    private FromSalesData fromSalesData;

    private FromOwner2Basic fromOwner2Basic;

    public DataLinkMonitor(LinkedList<String> vinListOwner, LinkedList<String> vinListSales){
        if(vinListOwner !=null && vinListOwner.size()>0){
            fromOwnerData = new FromOwnerData(vinListOwner);
            fromOwner2Basic = new FromOwner2Basic(vinListOwner);
            //设置链路顺序
            fromOwnerData.setProcessor();
            fromOwner2Basic.setProcessor();
        }if(vinListSales !=null && vinListSales.size()>0){
            fromSalesData = new FromSalesData(vinListSales);
            fromSalesData.setProcessor();
        }
    }
}
