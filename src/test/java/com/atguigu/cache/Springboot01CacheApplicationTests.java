package com.atguigu.cache;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01CacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作k-v字符串

    @Autowired
    //CacheManager cacheManager;
    RedisTemplate redisTemplate;//k-v都是对象的

    //@Autowired
    //RedisTemplate<Object, Employee> employeeRedisTemplate;

    /**
     * String(字符串)、List(列表)、Set(集合)、Hash(散列)、ZSet(有序集合)
     *  stringRedisTemplate.opsForValue()【String(字符串)】
     *  stringRedisTemplate.opsForList()【List(列表)】
     *  stringRedisTemplate.opsForSet()【Set(集合)】
     *  stringRedisTemplate.opsForHash()【Hash(散列)】
     *  stringRedisTemplate.opsForZSet()【ZSet(有序集合)】
     */
    @Test
    public void test01(){
        //stringRedisTemplate.opsForValue().append("msg","wocao");
//        String msg = stringRedisTemplate.opsForValue().get("msg");
//        System.out.println("msg = " + msg);

//        stringRedisTemplate.opsForList().leftPush("mylist","可恶的");
//        stringRedisTemplate.opsForList().rightPush("mylist","大菊花");
//          List<String> list =  stringRedisTemplate.opsForList().range("mylist",0,4);
//        System.out.println("list = " + list);

//        stringRedisTemplate.opsForSet().add("myset","决胜千里");
//        Set<String> list = stringRedisTemplate.opsForSet().members("myset");
//        System.out.println("list = " + list);
    }

    @Test
    public void test02(){
        Employee employee = employeeMapper.getEmpByLastName("张三");
        System.out.println("employee1 = " + employee);
        //默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中

        //1.将数据以json的方式保存
            //1)自己将对象转换为json
            //2)redisTemplate默认的序列化规则；改变默认的序列化规则
        redisTemplate.opsForValue().set("Emp01",employee);
    }

    @Test
    public void contextLoads() {
        Employee employee = employeeMapper.getEmpByLastName("张三");
        System.out.println("employee = " + employee);
    }

}
