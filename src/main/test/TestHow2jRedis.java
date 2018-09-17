/**
 * #Title: TestHow2jRedis
 * #ProjectName task6_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/17-13:35
 */

import java.util.HashMap;
import java.util.Map;

import com.lihoo.ssm.util.RedisUtil;
import com.lihoo.ssm.util.commonUtil.Log2Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class TestHow2jRedis {

    @Autowired
    RedisUtil redisUtil;

    @Test
    public void testString() {
        Log2Util.logger.info("添加键值对");
        redisUtil.set("name", "火拳艾斯");
        Log2Util.logger.info(redisUtil.get("name"));
        redisUtil.del("name");
        Log2Util.logger.info(redisUtil.get("name"));
        Log2Util.logger.info("Over!!!!");
    }

    @Test
    public void testNumber() {
        long incr = redisUtil.incr("number", 1);
        Log2Util.logger.info(incr);
        incr = redisUtil.incr("number", 1);
        Log2Util.logger.info(incr);
    }

    @Test
    public void testHashMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "meepo");
        map.put("pwd", "45612399+");
        redisUtil.hmset("user", map);
        Log2Util.logger.info(redisUtil.hget("user", "pwd"));
    }
    //    public static void main(String[] args) throws Exception {
//
//        //=====================testString======================
//        redisUtil.set("name", "how2java");
//        System.out.println(redisUtil.get("name"));
//        redisUtil.del("name");
//        System.out.println(redisUtil.get("name"));
//
//        //=====================testNumber======================
//        long incr = redisUtil.incr("number", 1);
//        System.out.println(incr);
//        incr =redisUtil.incr("number", 1);
//        System.out.println(incr);
//
//        //=====================testMap======================
//        Map<String,Object> map=new HashMap<>();
//        map.put("name", "meepo");
//        map.put("pwd", "password");
//        redisUtil.hmset("user", map);
//        System.out.println(redisUtil.hget("user","name"));
//    }
}
