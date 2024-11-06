package com.example.studyspringjpa.repository;

import com.example.studyspringjpa.domain.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;

@Repository
public interface MyEntityRepository extends JpaRepository<MyEntity, Long> {
    /*
     * JpaRepository
     *   Spring Data JPA 에서 제공하는 인터페이스
     *   기본 CRUD, 페이징, 정렬 제공
     * <MyEntity, Long>
     *   MyEntity : 엔티티 클래스 이름 지정 (레포가 처리 할 엔티티의 타입)
     *   Long : 기본 키 타입 지정(@Id)
     */
    /* 기본적인 메소드는 작성하지 않고 복잡한 쿼리 필요할 경우 작성함 */
}
