package com.example.demo.service;

import com.example.demo.service.util.JedisPoolConfigUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * 秒杀基本实现
 */
public class MiaoSha {
    public boolean miaoKill(String uid, String prid){
        if (uid == null || prid == null){
            System.out.println("秒杀失败");
            return false;
        }

//        Jedis locolHost = new Jedis("locolHost", 90);
        JedisPool jedisPoolConfig = JedisPoolConfigUtil.getJedisPoolConfig();;
        Jedis locolHost = jedisPoolConfig.getResource();;


        String uidKey = uid+"uk";
        String pridKey = prid + "pk";

        //监视库存
        locolHost.watch(pridKey);

        // 判断库存ID是否为空
        if (locolHost.get(pridKey) == null){
            System.out.println("秒杀还没开始");
            locolHost.close();
            return false;
        }
        // 判断用户是否存在重复秒杀
        if (locolHost.sismember(uidKey,uid)){
            System.out.println("用户已经秒杀成功，不能再次秒杀");
            locolHost.close();
            return false;
        }
        // 如果库存数据是0，秒杀结束
        if(Integer.parseInt(locolHost.get(pridKey))<1){
            System.out.println("秒杀已结束");
            locolHost.close();
            return false;
        }
        //使用事务
        Transaction multi = locolHost.multi();
        // 秒杀过程，商品数量--，用户++
        //执行
        List<Object> results = multi.exec();

        if (results==null||results.size()==0){
            System.out.println("秒杀失败");
            locolHost.close();
            return false;
        }
        System.out.println("秒杀成功");
        locolHost.close();
        return true;
    }
}
