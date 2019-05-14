package com.example.demo;

import com.baidu.aip.util.Base64Util;
import com.baidu.aip.util.Util;
import com.example.demo.Repistory.UserRepositroy;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    UserRepositroy userRepositroy;

    @Autowired
    UserService userService;
    @Test
    public void contextLoads() {
        User user = new User();
        user.setName("fuzekun");
        user.setPassword("123");
        try{
            user.setFace("E:\\image\\test.jpg");
           // System.out.println(Base64Util.encode(Util.readFileByBytes("E:\\image\\test.jpg")));//结果就是太大，保存不下
        }catch (Exception e){
            e.printStackTrace();
        }

        user.setRole("超管");
        userRepositroy.save(user);//其实该调用userService
    }

}
