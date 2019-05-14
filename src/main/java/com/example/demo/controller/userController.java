package com.example.demo.controller;


import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
*
* 用来处理用户的请求
*
* */
//
@Api
@EnableSwagger2
@RestController
@RequestMapping(value = {"/user"})
public class userController {

    User user = new User();//进行缓存，学习了Redis可以进行改进

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/login"},method = RequestMethod.GET)
    @ApiOperation(value = "login",tags = {"用来进行用户的登陆"})
    public String login(String name,String password){
        if(userService.loginBynameAndPassword(name,password)){
            return "Success";
        }
        return "failed";
    }
//    @RequestMapping(value = {"/update"},method = RequestMethod.GET)
//    public String Update(User user){//只能通过每次的验证，因为没有缓存,如果缓存了信息，就不用每次都重新
//        if(userService.Update(user.getId(),user)){
//            return "Success";
//        }
//        return "failed";
//    }
    @RequestMapping(value = {"/loginByFace"},method = RequestMethod.GET)
    public String loginByFace(){
        if(userService.loginByFace()){
            return "Success";
        }
        return "failed";
    }
}
