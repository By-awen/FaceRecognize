package com.example.demo.service;

import com.example.demo.pojo.User;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface UserService {
    public boolean loginBynameAndPassword(String name,String password);//用户名密码登陆，刷脸登陆
    public boolean loginByFace(String name);//刷脸登陆
    //public List<User> findAllRole(String role);//用户找到所有的管理员，管理员找到所有的用户。
//    public boolean Register(User user);//注册，用户自己注册就需要管理员的审核，否则无法进行一些权限的操作，只能找到自己的信息
    public boolean RegistrrOut(String name,String password,String face);//注销,可以是用户自己注销，也可以是管理员通过名字找到用户后注销
//    public boolean Update(int id,User newU);//修改信息，先登录后刷脸或者输入登陆密码进行登陆
//    public boolean deleteByName(String name);//通过名字删除，仅限管理员的权限
//    public User findByName(String name);//用于用户自己修改密码，用户查找管理员，或者管理员查找用户
//    public String findRole(String name);
}
