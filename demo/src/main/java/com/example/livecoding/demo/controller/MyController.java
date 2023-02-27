package com.example.livecoding.demo.controller;

import com.example.livecoding.demo.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

@Autowired
MyService myService;

@GetMapping("/get")
public String getService(){
    return myService.printMyString();
}

}
