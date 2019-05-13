package com.example.demo.controller;


import com.example.demo.Repistory.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//用来检测jpa的controller
@RestController
@RequestMapping(value = {"user"})
public class TestController {
    @Autowired
    TestRepository testRepository;

    @GetMapping(value = "findall")
    public void findall(){
        testRepository.findAll();
    }
}
