package com.example.studyspringjpa.controller;

import com.example.studyspringjpa.domain.MyEntity;
import com.example.studyspringjpa.service.MyEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class MyEntityController {
    @Autowired
    private MyEntityService myEntityService;

    @GetMapping
    public List<MyEntity> getAll() {
        return myEntityService.findAll();
    }

    @PostMapping
    public MyEntity create(@RequestBody MyEntity myEntity) {
        System.out.println("myEntity.toString() = " + myEntity.toString());
        return myEntityService.save(myEntity);
    }
}
