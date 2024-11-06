package com.example.studyspringjpa.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class MyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가
    /*
    * GenerationType
    *   IDENTITY : 데이터베이스 자동 증가 기능 > 기본키 생성을 DB에게 위임 (MYSQL)
    *   SEQUENCE : 시퀀스 객체를 사용하여 기본 키 생성 (Oracle)
    *   TABLE : 키 생성 전용 테이블을 사용하여 기본 키 생성 > @TableGenerator 함께 사용 가능
    *   AUTO : 적합한 전략 자동 선택
    *
    *   SEQUENCE & TABLE 선택 시 sequence or key table 생성해두어야함
    *
    * @GeneratedValue 두 개 이상의 strategy 옵션을 동시에 사용하는 것은 불가능하다.
    */
    private Long id;
    private String name;

    /*
    * @OneToMany(mappedBy = "")
    *
    * @ManyToOne
    * @JoinColumn(name = " ") : 외래 키 설정
    */
}
