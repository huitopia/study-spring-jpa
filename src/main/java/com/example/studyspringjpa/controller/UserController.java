package com.example.studyspringjpa.controller;

import com.example.studyspringjpa.common.SuccessResult;
import com.example.studyspringjpa.common.SuccessType;
import com.example.studyspringjpa.common.utils.SuccessResultUtil;
import com.example.studyspringjpa.domain.User;
import com.example.studyspringjpa.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<SuccessResult<List<User>>> findAllUsers() {
        List<User> userList = userService.findAllUsers();
        return SuccessResultUtil.success(SuccessType.DATA_RETRIEVED, userList);
    }

    @PostMapping
    public ResponseEntity<SuccessResult<Void>> createUser(@Valid @RequestBody User user) {
        userService.createUser(user);
        return SuccessResultUtil.success(SuccessType.DATA_SAVED);
    }

    @GetMapping("/{seqNo}")
    public ResponseEntity<SuccessResult<User>> findUserBySeqNo(@PathVariable Integer seqNo) {
        User user = userService.findUserBySeqNo(seqNo);
        return SuccessResultUtil.success(SuccessType.DATA_RETRIEVED, user);
    }

    @PutMapping("/{seqNo}")
    public ResponseEntity<SuccessResult<Void>> updateUserBySeqNo(@Valid @RequestBody User user
            , @PathVariable Integer seqNo) {
        user.setSeqNo(seqNo);
        userService.updateUserBySeqNo(user);
        return SuccessResultUtil.success(SuccessType.DATA_UPDATED);
    }

    @DeleteMapping("/{seqNo}")
    public ResponseEntity<SuccessResult<Void>> deleteUserBySeqNo(@PathVariable Integer seqNo) {
        userService.deleteUserBySeqNo(seqNo);
        return SuccessResultUtil.success(SuccessType.DATA_DELETED);
    }
}