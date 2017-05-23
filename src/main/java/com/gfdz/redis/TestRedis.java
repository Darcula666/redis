package com.gfdz.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by Administrator on 2017/5/12.
 */
public class TestRedis {
    @Test
    public void connRedis(){
        //连接本地Redis服务
        Jedis jedis=new Jedis("localhost",6379);
        System.out.println("Connection to server sucessfully");
        //查看服务是否运行
        System.out.println("Server is running: "+jedis.ping());
        jedis.set("runoobkey", "Redis tutorial");
        // 获取存储的数据并输出
        System.out.println("Stored string in redis:: "+ jedis.get("runoobkey"));
        //存储数据到列表中
        jedis.lpush("tutorial-list", "Redis");
        jedis.lpush("tutorial-list", "Mongodb");
        jedis.lpush("tutorial-list", "Mysql");
        List<String> list = jedis.lrange("tutorial-list", 0 ,5);
        for(int i=0; i<list.size(); i++) {
            System.out.println("Stored string in redis:: "+list.get(i));
        }
        //释放资源
         jedis.close();
    }
}
