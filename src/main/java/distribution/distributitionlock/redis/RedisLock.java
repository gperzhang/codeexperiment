package distribution.distributitionlock.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;

public class RedisLock {

    private String id;

    public RedisLock(){

    }
    private static String LOCK_KEY = "redis_lock";

    private static long timeout = 1000;

    private SetParams setParams = SetParams.setParams().nx().px(100);

    static JedisPool jedisPool = new JedisPool("106.13.13.244", 6379);

    private static Jedis jedis;

    static {
        jedis=new JedisPool("106.13.13.244", 6379).getResource();
        jedis.auth("zj123456");
    }

    public  boolean Lock(String id){
        long start = System.currentTimeMillis();
        try {
            for(;;){
                String setex = jedis.set(LOCK_KEY, id,setParams);
                if(setex.equals("OK")){
                    return true;
                }

                long l = System.currentTimeMillis();
                if(l-start>timeout){
                    return false;
                }
                Thread.sleep(500);
            }
        }catch (Exception e){

        }
        return false;
    }

    public boolean tryLock(String id,int timeout){
        return false;
    }
    public static boolean unLock(String id){
        String script =
                "if redis.call('get',KEYS[1]) == ARGV[1] then" +
                        "   return redis.call('del',KEYS[1]) " +
                        "else" +
                        "   return 0 " +
                        "end";
        try {
            Object eval = jedis.eval(script, Collections.singletonList(LOCK_KEY), Collections.singletonList(id));
            return "1".equals(eval)?true:false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
