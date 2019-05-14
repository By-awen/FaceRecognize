package com.example.demo.controller;


import com.example.demo.Repistory.TestRepository;
import com.example.demo.pojo.UserTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//用来检测jpa的controller
@RestController
@RequestMapping(value = {"/userTest"})
public class TestController {
    @Autowired
    TestRepository testRepository;

    @GetMapping(value = "findall")
    public List<UserTest>findall(){
        return testRepository.findAll();
    }
}
