package com.example.studyspringjpa.service;

import com.example.studyspringjpa.common.ErrorType;
import com.example.studyspringjpa.common.exception.specific.CustomException;
import com.example.studyspringjpa.domain.Board;
import com.example.studyspringjpa.repository.BoardRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@Transactional
public class BoardService {
    /*
     * 생성자 주입 방식
     *   객체 생성 시, 해당 생성자 호출 후 의존성 전달
     *   final 키워드 사용으로 의존성이 변경될 수 없음을 보장 > 불변성
     *   생성자를 통해 의존성 주입이 가능하여 테스트 용이
     *   컴파일 시점에서 누락된 의존성 확인 어려움
     */
    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> findAllBoards() {
        List<Board> boardList = boardRepository.findAll();
        if (ObjectUtils.isEmpty(boardList)) {
            throw new CustomException(ErrorType.RESOURCE_NOT_FOUND, "등록된 게시물이 없습니다.");
        }
        return boardList;
    }

    public void createBoard(@Valid Board board) {
        // findUserBySeqNo
        Board createBoard = boardRepository.save(board);
        if(ObjectUtils.isEmpty(createBoard)) {
            throw new CustomException(ErrorType.BAD_REQUEST, "게시물 등록에 실패했습니다.");
        }
    }
}
