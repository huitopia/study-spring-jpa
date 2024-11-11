package com.example.studyspringjpa.service;

import com.example.studyspringjpa.common.ErrorType;
import com.example.studyspringjpa.common.exception.specific.CustomException;
import com.example.studyspringjpa.domain.User;
import com.example.studyspringjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@Transactional
public class UserService {
    /*
     * 필드 주입 방식
     *   인스턴스를 자동으로 주입
     *   생성자가 없고 필드에서 바로 의존성을 주입받기 때문에(런타임 시점) 테스트가 어려워짐
     *   required-false 로 설정되지 않으면 NullPointException 발생 가능성 있음
     *   클래스의 불변성 보장 못함
     *   의존성이 많아지면 관리가 어려워짐
     */
    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        System.out.println("user.getId() = " + user.getId());
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

    public User findUserByUserSeqNo(Integer userSeqNo) {
        return userRepository.findByUserSeqNo(userSeqNo)
                .orElseThrow(()->new CustomException(ErrorType.RESOURCE_NOT_FOUND, userSeqNo + "번 사용자를 찾을 수 없습니다."));
        /*
        * orElseThrow()
        *   Optional 사용 시 사용되는 메서드
        *   비어 있으면 예외처리, 아니면 해당 값 반환
        */
    }

    public boolean checkDuplicateUserId(String id) {
        return userRepository.existsById(id);
    }

    public void updateUserByUserSeqNo(User user) {
        // 사용자 조회
        User updateUser = findUserByUserSeqNo(user.getUserSeqNo());
        // 예외 발생하면 실행되지 않을 코드
        updateUser.setId(user.getId());
        updateUser.setName(user.getName());
        /*
        * save : 내부 트랜잭션 끝나야 반영
        * saveAndFlush : 즉시 반영
        */
        userRepository.save(updateUser);
    }

    public void deleteUserByUserSeqNo(Integer userSeqNo) {
        User deleteUser = findUserByUserSeqNo(userSeqNo);
        userRepository.deleteByUserSeqNo(deleteUser.getUserSeqNo());
    }
}
