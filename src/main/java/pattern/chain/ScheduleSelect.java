package pattern.chain;

import java.text.SimpleDateFormat;
import java.util.*;

public class ScheduleSelect {

    private LinkedList<String> vinListOwner;

    private LinkedList<String> vinListSales;


    public void selectFromCarOwnerDB(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,-1);
        Date time1 = calendar.getTime();
        String format = dateFormat.format(time1);
        String beginTime = format+" 00:00:00";
        String endTime = format+" 23:59:59";
        Map<String,String> params = new HashMap<>();
        params.put("beginTime",beginTime);
        params.put("endTime",endTime);


        LinkedList<String> listOwner = new LinkedList<>();
        LinkedList<String> listSales = new LinkedList<>();
        vinListOwner = listOwner;
        vinListSales = listSales;
        startMonitor();
    }

    private void startMonitor(){
        new DataLinkMonitor(vinListOwner, vinListSales);
    }

}
