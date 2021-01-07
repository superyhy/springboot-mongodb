package com.yhy.mongodb.controller;


import com.yhy.mongodb.dao.DemoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoController {
    @Autowired
    DemoDAO demoDAO;

    @GetMapping("/test")
    public void getMongoData(){
        demoDAO.getMongoData();
    }
}
