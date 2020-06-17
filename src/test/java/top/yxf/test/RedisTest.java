package top.yxf.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;
import top.yxf.redis.App;
import top.yxf.redis.entity.BuryPoint;
import top.yxf.redis.entity.User;
import top.yxf.redis.service.BuryPointService;
import top.yxf.redis.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={App.class})
public class RedisTest {

    @Autowired
    private BuryPointService buryPointService;

    @Autowired
    private UserService userService;



    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void testListUser(){

        final List<User> users = userService.listUser();

        System.out.println(users.size() + "==================");

        userService.listUser();


    }


    @Test
    public void testQueryBuryPointAll(){
//        buryPointService.list().forEach(buryPoint -> System.out.println(buryPoint));

//        buryPointService.list();

        System.out.println("==================");

        final List<BuryPoint> list = buryPointService.list();

        System.out.println(list.size());
    }

    @Test
    public void testRedisTemplate(){

//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
//
//        redisTemplate.opsForValue().set("name","小小吴");
//
        final Set keys = redisTemplate.keys("*");


        System.out.println(keys);
//        System.out.println("是否存这个key ----> " + redisTemplate.hasKey("name"));



    }

    @Test
    public void saveBuryPoint(){

        BuryPoint buryPoint = new BuryPoint();
        buryPoint.setCreateTime(new Date()).setStatus(0).setUserUnionid(UUID.randomUUID().toString().replace("-",""));

        for (int i = 0; i < 10 ; i++) {
            buryPointService.save(buryPoint);

        }

//        buryPointService.list();





    }




}
