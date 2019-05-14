package com.example.demo.service.Serviceiml;

import com.baidu.aip.util.Base64Util;
import com.baidu.aip.util.Util;
import com.example.demo.Repistory.UserRepositroy;
import com.example.demo.pojo.User;
import com.example.demo.util.Sample;
import com.example.demo.util.SolvePicture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/*
*
* 控制层应该是使用dto接收数据，但是数据比较少，没必要了就。
*
//* */
@Service
@Slf4j
public class UserService implements com.example.demo.service.UserService {
    @Autowired
    UserRepositroy userRepositroy;


    @Override
    public boolean loginByFace()  {//最主要的实现点
//        List<User>users = userRepositroy.findAll();
//        try {
//            SolvePicture.getPicture();
//            String img2 = "E:\\image\\test.jpg";
//            for(User user :users){
//                Sample.sample(user.getFace(),img2);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        SolvePicture.getPicture();
        return true;
    }

    @Override
    public boolean loginBynameAndPassword(String name, String password) {
        //这里可能是一个bug，如果找不到会怎么样，是不是会返回null还是直接报错
        boolean flag = false;
        try{
            User user = userRepositroy.findUserByNameAndPassword(name,password);//
            if(user != null){
                flag = true;
            }
        }catch (Exception e){
            flag = false;
            log.error("用户不存在");//通过try...catch语句进行说明，如果报错就不存在,解决bug
        }finally {
            return flag;
        }
    }

  //  @Override
    public boolean deleteByName(String name) {//在controller层进行处理是否为管理员
        User  user = userRepositroy.findByName(name);
        if(user != null){
            userRepositroy.deleteByName(name);
            return true;
        }
        else return false;
    }

//    @Override
//    public List<User> findAllRole(String role) {
//        return userRepositroy.findAllByRole(role);
//    }

 //   @Override
    public User findByName(String name) {//如果是空的应该抛出报错
        return userRepositroy.findByName(name);
    }

   // @Override
    public boolean Register(User user) {//注册出错只有一种可能，那就是传过来的数据是空的,或者数据不符合范围
        if(user != null){
            userRepositroy.save(user);//不使用dto层传输，原因就是数据不是很多。
            return true;
        }
        return false;
    }

    //@Override
    public boolean Update(int id,User newU) {//先删除用户，后更新用户，用户的id仍旧不变
        if(deleteByName(userRepositroy.findById(id).get().getName())){
            newU.setId(id);
            userRepositroy.save(newU);
            return true;
        }
        return true;
    }

    //@Override
    public boolean RegistrrOut(String name,String password,String face) {//注销
        User user = userRepositroy.findUserByNameAndPassword(name,password);
        if(user.getFace().equals(face)){
            userRepositroy.deleteByName(name);//不用调用service方法中的
            return true;
        }
        return false;
    }


    //@Override
    public String findRole(String name) {
        return findByName(name).getRole();
    }//从这里查找用来判断是否有权限
}
