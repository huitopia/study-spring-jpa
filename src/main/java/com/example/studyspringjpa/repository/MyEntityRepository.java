package com.example.studyspringjpa.repository;

import com.example.studyspringjpa.domain.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyEntityRepository extends JpaRepository<MyEntity, Long> {
    /* JPA의 JpaRepository를 상속받아 CRUD 작업을 수행 */
}
