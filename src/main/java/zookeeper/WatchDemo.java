package zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;


public class WatchDemo {
    //PathChildCache 针对子节点的创建、删除和更新触发时间
    //NodeCache      针对当前节点的监听
    //TreeCache      以上的综合体
    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().
                connectString("192.168.25.128:2181").sessionTimeoutMs(6000).
                authorization("digest","admin:admin".getBytes()).
                retryPolicy(new ExponentialBackoffRetry(1000,5)).build();
        curatorFramework.start();
        //addListenerNode(curatorFramework);
        addListenerWithChildNode(curatorFramework);
        System.in.read();
    }
    public static void addListenerNode(CuratorFramework curatorFramework) throws Exception {
        NodeCache nodeCache = new NodeCache(curatorFramework,"/watch",false);
        NodeCacheListener nodeCacheListener = () -> {
            System.out.println("receive current Node change");
            System.out.println(nodeCache.getCurrentData().getPath()+"..."+new String(nodeCache.getCurrentData().getData(),"utf-8"));
        };
         nodeCache.getListenable().addListener(nodeCacheListener);
         nodeCache.start();
    }
    public static void addListenerWithChildNode(CuratorFramework curatorFramework) throws Exception {
        PathChildrenCache pathChildrenCache = new PathChildrenCache(curatorFramework,"/watch",true);
        PathChildrenCacheListener pathChildrenCacheListener = (curatorFramework1, pathChildrenCacheEvent) -> {
            System.out.println(curatorFramework1.getChildren());
            System.out.println(pathChildrenCacheEvent.getType()+"------"+new String(pathChildrenCacheEvent.getData().getData()));
        };
        pathChildrenCache.getListenable().addListener(pathChildrenCacheListener);
        pathChildrenCache.start(PathChildrenCache.StartMode.NORMAL);
    }
}
