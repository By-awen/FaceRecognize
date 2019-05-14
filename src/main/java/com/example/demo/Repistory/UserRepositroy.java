package com.example.demo.Repistory;

import com.example.demo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

/*
* 进行登陆的验证
* 进行增删查改
//* */
public interface UserRepositroy extends JpaRepository<User,Integer> {
    User findUserByFace(String image);//通过脸的信息来查找
    User findUserByNameAndPassword(String username,String password);//通过姓名和密码进行查找，不设置存错过程一样简单，只不过花费有点大
 //   List<User> findAllByRole(String Role);//查找所有的管理员，可以显示联系方式。
   User findByName(String name);


    void deleteByNameAndPassword(String username,String password);//用户可以通过姓名和密码来注销
    void deleteByName(String username);//管理员可以通过名字来删除用户
    void deleteByFace(String image);//用户也可以通过自己的面部来删除自己的信息

    //save方法进行插入
    //进行修改就是删除后重新增加
}
