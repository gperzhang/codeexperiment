package pattern.chain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

public class CarSalesProcessor extends Processor {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarSalesProcessor.class);

    private Processor nextProcessor;

    public CarSalesProcessor(Processor nextProcessor){
        this.nextProcessor = nextProcessor;
    }

    @Override
    protected LinkedList<String> selectData(LinkedList<String> linkedList) {
            LinkedList<String> salesResults = selectFromDB(linkedList);
            if (salesResults == null || salesResults.size() != linkedList.size()) {
                LOGGER.warn("数据链路监控异常，部分数据销售信息缺失");
                //推送报警
            } else {
                nextProcessor.selectData(salesResults);
            }
        return null;
    }
    private LinkedList<String> selectFromDB(LinkedList<String> linkedList) {
        return null;
    }

}
