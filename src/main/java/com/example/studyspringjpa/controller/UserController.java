package com.example.studyspringjpa.controller;

import com.example.studyspringjpa.common.SuccessResult;
import com.example.studyspringjpa.common.SuccessType;
import com.example.studyspringjpa.common.utils.SuccessResultUtil;
import com.example.studyspringjpa.domain.User;
import com.example.studyspringjpa.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<SuccessResult<List<User>>> findAllUsers() {
        List<User> userList = userService.findAllUsers();
        return SuccessResultUtil.success(SuccessType.DATA_RETRIEVED, userList);
    }

    @PostMapping
    public ResponseEntity<SuccessResult<Void>> createUser(@RequestBody User user) {
        userService.createUser(user);
        return SuccessResultUtil.success(SuccessType.DATA_SAVED);
    }

    @GetMapping("/{userSeqNo}")
    public ResponseEntity<SuccessResult<User>> findUserBySeqNo(@PathVariable Integer userSeqNo) {
        User user = userService.findUserByUserSeqNo(userSeqNo);
        return SuccessResultUtil.success(SuccessType.DATA_RETRIEVED, user);
    }

    @PutMapping("/{userSeqNo}")
    public ResponseEntity<SuccessResult<Void>> updateUserBySeqNo(@RequestBody User user
            , @PathVariable Integer userSeqNo) {
        user.setUserSeqNo(userSeqNo);
        userService.updateUserByUserSeqNo(user);
        return SuccessResultUtil.success(SuccessType.DATA_UPDATED);
    }

    @DeleteMapping("/{userSeqNo}")
    public ResponseEntity<SuccessResult<Void>> deleteUserBySeqNo(@PathVariable Integer userSeqNo) {
        userService.deleteUserByUserSeqNo(userSeqNo);
        return SuccessResultUtil.success(SuccessType.DATA_DELETED);
    }
}