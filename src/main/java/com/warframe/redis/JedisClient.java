package com.warframe.redis;



import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JedisClient {
    private static Jedis jedis = new Jedis("127.0.0.1",6379);

    @Test
    public void testString(){
        //String
        jedis.set("name", "warframe");
        String value = jedis.get("name");
        System.out.println(value);
    }

    @Test
    public void testHash(){
        //Hash
        Map<String, String> user = new HashMap<String, String>();
        user.put("name", "warframe");
        user.put("hobby", "steam");
        jedis.hmset("user", user);
        List<String> rsmap = jedis.hmget("user", "name", "hobby");
        System.out.println(rsmap);
    }

    @Test
    public void testList(){
        //List
        jedis.del("framework");
        jedis.lpush("framework","spring");
        jedis.lpush("framework","spring mvc");
        jedis.lpush("framework","mybatis");

        System.out.println(jedis.lrange("framework",0,-1));
    }

    @Test
    public void testSet(){
        //set
        jedis.sadd("sname","warframe");
        jedis.sadd("sname","noOne");
        jedis.sadd("sname","gta");
        jedis.sadd("sname","steam");

        System.out.println(jedis.smembers("sname"));
        System.out.println(jedis.scard("sname"));
        System.out.println(jedis.srandmember("sname"));
    }




}
