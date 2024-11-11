package com.example.studyspringjpa.repository;

import com.example.studyspringjpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /* Optional : NullPointerException 방지 */
    Optional<User> findByUserSeqNo(Integer userSeqNo);

    boolean existsById(String id);

    void deleteByUserSeqNo(Integer userSeqNo);
}
