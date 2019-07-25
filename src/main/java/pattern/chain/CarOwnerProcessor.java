//package pattern.chain;
//
//import java.util.LinkedList;
//
//public class CarOwnerProcessor extends Processor {
//
//    private Processor nextProcessor;
//
//    public CarOwnerProcessor(Processor nextProcessor){
//        this.nextProcessor = nextProcessor;
//    }
//    //从车主数据开始的链路，没有查到新增的车主数据，则链路不再往下传递
//    public void selectData() {
//        LinkedList<String> linkedList = selectYesterday();
//
//    }
//
//    @Override
//    protected LinkedList<String> selectData(LinkedList<String> linkedList) {
//        if(linkedList!=null && linkedList.size()>0){
//            nextProcessor.selectData(linkedList);
//        }else
//    }
//
//    private LinkedList<String> selectYesterday() {
//        LinkedList<String> linkedList = new LinkedList<>();
//        return linkedList;
//    }
//}
