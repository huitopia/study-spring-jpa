package com.example.studyspringjpa.service;

import com.example.studyspringjpa.domain.MyEntity;
import com.example.studyspringjpa.repository.MyEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyEntityService {
    /* 비즈니스 로직을 처리 */
    @Autowired
    private MyEntityRepository myEntityRepository;

    public List<MyEntity> findAll() {
        return myEntityRepository.findAll();
    }
    public MyEntity save(MyEntity myEntity) {
        return myEntityRepository.save(myEntity);
    }
}
