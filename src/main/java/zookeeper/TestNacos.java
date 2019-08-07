package zookeeper;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.stereotype.Controller;

import java.util.Properties;
import java.util.concurrent.Executor;

@Controller
public class TestNacos {
    public static void main(String[] args) throws NacosException, InterruptedException {
        String serverAddr = "127.0.0.1";
        String dataId = "example";
        String group = "DEFAULT_GROUP";
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR,serverAddr);

            ConfigService configService = NacosFactory.createConfigService(properties);
            String config = configService.getConfig(dataId, group, 5000);
            System.out.println(config);
            configService.addListener(dataId, group, new Listener() {
                @Override
                public Executor getExecutor() {
                    return null;
                }

                @Override
                public void receiveConfigInfo(String s) {
                    System.out.println("recevie :"+s);
                }
            });

        boolean isPublishOk = configService.publishConfig(dataId, group, "content");
        System.out.println(isPublishOk);

        boolean isRemoveOk = configService.removeConfig(dataId, group);
        System.out.println(isRemoveOk);
        Thread.sleep(30000);



    }
}
