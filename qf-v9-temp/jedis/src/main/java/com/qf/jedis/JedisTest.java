package com.qf.jedis;


import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {


    @Test
    public void StringTest(){
        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.set("target","redis");

        String target = jedis.get("target");
        System.out.println(target);

    }
}
