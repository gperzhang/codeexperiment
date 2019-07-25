package pattern.chain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.LinkedList;

public class CarBasicProcessor extends Processor {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarBasicProcessor.class);
    @Override
    protected LinkedList<String> selectData(LinkedList<String> linkedList) {
            LinkedList<String> basicFromDB = selectCarBasicFromDB(linkedList);
            if(basicFromDB ==null){
                if(basicFromDB.size()!=linkedList.size()){
                    linkedList.removeAll(basicFromDB);
                }
                //微信推送报警
                LOGGER.warn("数据链路监控异常,部分数据五码信息尚未接入"+linkedList);
            } else {
                LOGGER.info("数据链路监控正常");
            }
        return null;
    }

    private LinkedList<String> selectCarBasicFromDB(LinkedList<String> linkedList) {

        return null;
    }
}
