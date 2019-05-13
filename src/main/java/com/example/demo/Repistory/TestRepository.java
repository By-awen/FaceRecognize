package com.example.demo.Repistory;

/*
*
* 用来检测jpa
* */
import com.example.demo.pojo.User;
import com.example.demo.pojo.UserTest;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TestRepository extends JpaRepository<UserTest, Integer> {
}
