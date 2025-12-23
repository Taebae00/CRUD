package com.example.crud.service;

import com.example.crud.entity.BoardEntity;
import com.example.crud.entity.BoardLikeEntity;
import com.example.crud.model.BoardDTO;
import com.example.crud.repository.BoardLikeRepo;
import com.example.crud.repository.BoardRepo;
import org.springframework.stereotype.Service;

@Service
public class BoardLikeService {

    private final BoardLikeRepo boardLikeRepo;
    private final BoardRepo boardRepo;
    private final BoardService boardService;

    public BoardLikeService(BoardLikeRepo boardLikeRepo, BoardRepo boardRepo, BoardService boardService) {
        this.boardLikeRepo = boardLikeRepo;
        this.boardRepo = boardRepo;
        this.boardService = boardService;
    }

    public int likeCheck(String user, int board_no) {

        return boardLikeRepo.existsByUserIdAndBoardNo(user, board_no) ? 1 : 0;
    }


    public BoardDTO likeUp(String user, int board_no) {

        BoardLikeEntity boardLikeEntity = new BoardLikeEntity();
        boardLikeEntity.setUserId(user);
        boardLikeEntity.setBoardNo(board_no);
        boardLikeEntity.setType("Like");

        boardLikeRepo.save(boardLikeEntity);

        boardRepo.likeUp(board_no);

        return boardService.getCont(board_no);
    }

    public BoardDTO UnlikeUp(String user, int board_no) {

        BoardLikeEntity boardLikeEntity = new BoardLikeEntity();
        boardLikeEntity.setUserId(user);
        boardLikeEntity.setBoardNo(board_no);
        boardLikeEntity.setType("Unlike");

        boardLikeRepo.save(boardLikeEntity);

        boardRepo.UnlikeUp(board_no);

        return boardService.getCont(board_no);
    }
}