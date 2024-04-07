package com.example.demo.service.util;

import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolConfigUtil {
    @Value("${jedis.pool.maxTotle}")
    static Integer maxTotle;

    @Value("${jedis.pool.maxIdle}")
    static Integer maxIdle;

    @Value("${jedis.pool.maxWaitMillis}")
    static Long maxWaitMillis;

    private static volatile JedisPool jedisPool= null;
    private JedisPoolConfigUtil(){}
    public static JedisPool getJedisPoolConfig(){
        if (jedisPool==null){
            synchronized (JedisPoolConfigUtil.class){
                if(jedisPool==null){
                    JedisPoolConfig poolConfig = new JedisPoolConfig();
                    poolConfig.setMaxTotal(maxTotle);//总连接的最大连接数
                    poolConfig.setMaxIdle(maxIdle);//空闲连接的最大数量
                    poolConfig.setMaxWaitMillis(maxWaitMillis);//等待时间
                    poolConfig.setBlockWhenExhausted(true);//超过等待时间是否等待
                    poolConfig.setTestOnBorrow(true);
                    //60000是超时时间
                    jedisPool=new JedisPool(poolConfig,"localhost",6379,60000);
                }
            }
        }
        return jedisPool;
    }

    public static void release(Jedis jedis){
        if (jedis!=null){
            jedis.close();
        }
    }

}
