package com.example.studyspringjpa.service;

import com.example.studyspringjpa.domain.User;
import com.example.studyspringjpa.common.exception.specific.CustomException;
import com.example.studyspringjpa.common.ErrorType;
import com.example.studyspringjpa.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        if(checkDuplicateUserId(user.getId())) {
            throw new CustomException(ErrorType.DUPLICATE_RESOURCE, "중복된 아이디가 존재합니다.");
        }
        User createUser = userRepository.save(user);
        if(ObjectUtils.isEmpty(createUser)) {
            throw new CustomException(ErrorType.BAD_REQUEST, "사용자 저장에 실패했습니다.");
        }
    }

    public List<User> findAllUsers() {
        List<User> userList = userRepository.findAll();
        if(ObjectUtils.isEmpty(userList)) {
            throw new CustomException(ErrorType.RESOURCE_NOT_FOUND);
        }
        return userList;
    }

    public User findUserBySeqNo(Integer seqNo) {
        return userRepository.findBySeqNo(seqNo)
                .orElseThrow(()->new CustomException(ErrorType.RESOURCE_NOT_FOUND, seqNo + "번 사용자를 찾을 수 없습니다."));
        /*
        * orElseThrow()
        *   Optional 사용 시 사용되는 메서드
        *   비어 있으면 예외처리, 아니면 해당 값 반환
        */
    }

    public boolean checkDuplicateUserId(String id) {
        return userRepository.existsById(id);
    }

    public void updateUserBySeqNo(User user) {
        // 사용자 조회
        User updateUser = findUserBySeqNo(user.getSeqNo());
        // 예외 발생하면 실행되지 않을 코드
        updateUser.setId(user.getId());
        updateUser.setName(user.getName());
        /*
        * save : 내부 트랜잭션 끝나야 반영
        * saveAndFlush : 즉시 반영
        */
        userRepository.save(updateUser);
    }

    public void deleteUserBySeqNo(Integer seqNo) {
        User deleteUser = findUserBySeqNo(seqNo);
        userRepository.deleteBySeqNo(deleteUser.getSeqNo());
    }
}
