package zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

import java.util.ArrayList;
import java.util.List;

public class CuratorDemo {
        public static void main(String[] args) throws Exception {
            CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().
                    connectString("192.168.245.128:2181").sessionTimeoutMs(6000).
                    authorization("digest","admin:admin".getBytes()).
                    retryPolicy(new ExponentialBackoffRetry(1000,5)).build();
            curatorFramework.start();
            createData(curatorFramework);
  //          setData(curatorFramework);
             //deleteData(curatorFramework);
//            createDataWithAcl(curatorFramework);
            //setAclWithExistNode(curatorFramework);
            //System.out.println(selectData(curatorFramework));
        }

        public static void createData(CuratorFramework curatorFramework) throws Exception {
            curatorFramework.create().withMode(CreateMode.PERSISTENT).forPath("/pro","test".getBytes());
        }
        public static void setData(CuratorFramework curatorFramework) throws Exception {
            curatorFramework.setData().forPath("/data","up".getBytes());
        }
        public static void deleteData(CuratorFramework curatorFramework) throws Exception {
            Stat stat = new Stat();
            //版本号，可以用来做锁
            curatorFramework.delete().withVersion(stat.getVersion()).forPath("/data");
            System.out.println(stat.getVersion());
        }
        public static String selectData(CuratorFramework curatorFramework) throws Exception {
            byte[] bytes = curatorFramework.getData().forPath("/data");
            return new String(bytes,"utf-8");
        }
        public static void createDataWithAcl(CuratorFramework curatorFramework) throws Exception {
            List<ACL> aclList = new ArrayList<>();
            ACL acl = new ACL(ZooDefs.Perms.READ|ZooDefs.Perms.WRITE,new Id("digest", DigestAuthenticationProvider.generateDigest("admin:admin")));
            aclList.add(acl);
            String s = curatorFramework.create().withMode(CreateMode.PERSISTENT).withACL(aclList).forPath("/auth");
        }
        //对已经创建好的节点设置权限
        public static void setAclWithExistNode(CuratorFramework curatorFramework) throws Exception {
            List<ACL> aclList = new ArrayList<>();
            ACL acl = new ACL(ZooDefs.Perms.READ,new Id("digest", DigestAuthenticationProvider.generateDigest("admin:admin")));
            aclList.add(acl);
            curatorFramework.setACL().withACL(aclList).forPath("/auth");
        }

}

