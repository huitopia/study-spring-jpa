package com.example.studyspringjpa.controller;

import com.example.studyspringjpa.common.SuccessResult;
import com.example.studyspringjpa.common.SuccessType;
import com.example.studyspringjpa.common.utils.SuccessResultUtil;
import com.example.studyspringjpa.domain.Board;
import com.example.studyspringjpa.service.BoardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping
    public ResponseEntity<SuccessResult<List<Board>>> findAllBoards(){
        List<Board> boardList = boardService.findAllBoards();
        return SuccessResultUtil.success(SuccessType.DATA_RETRIEVED, boardList);
    }

    @PostMapping
    public ResponseEntity<SuccessResult<Void>> createBoard(@Valid @RequestBody Board board){
        boardService.createBoard(board);
        return SuccessResultUtil.success(SuccessType.DATA_SAVED);
    }
}
