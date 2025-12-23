package com.example.crud.service;

import com.example.crud.entity.BoardEntity;
import com.example.crud.model.BoardDTO;
import com.example.crud.repository.BoardRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private final BoardRepo boardRepo;

    public BoardService(BoardRepo boardRepo) {
        this.boardRepo = boardRepo;
    }

    public List<BoardDTO> getBoardList(){

        List<BoardEntity> list = boardRepo.findAll();
        List<BoardDTO> boardList = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){
            BoardDTO dto = new BoardDTO();

            dto.setBoard_no(list.get(i).getBoardNo());
            dto.setTitle(list.get(i).getTitle());
            dto.setContent(list.get(i).getContent());
            dto.setWriter(list.get(i).getWriter());
            dto.setBoard_like(list.get(i).getBoardLike());
            dto.setBoard_unlike(list.get(i).getBoardUnlike());
            dto.setHit(list.get(i).getHit());

            if(list.get(i).getImageUrl() != null){
                dto.setImage_url(list.get(i).getImageUrl());
            }

            boardList.add(dto);
        }

        return boardList;
    }

    public BoardDTO getCont(int no) {

        BoardEntity cont = boardRepo.findByBoardNo(no);
        BoardDTO dto = new BoardDTO();

        dto.setBoard_no(cont.getBoardNo());
        dto.setTitle(cont.getTitle());
        dto.setContent(cont.getContent());
        dto.setWriter(cont.getWriter());
        dto.setBoard_like(cont.getBoardLike());
        dto.setBoard_unlike(cont.getBoardUnlike());
        dto.setHit(cont.getHit());

        if(cont.getImageUrl() != null){
            dto.setImage_url(cont.getImageUrl());
        }

        return dto;
    }

    public void hitUp(int no) {
        boardRepo.hitUp(no);
    }

    public void write(String title, String cont, String writer, String image_url){

        BoardEntity dto = new BoardEntity();
        dto.setTitle(title);
        dto.setContent(cont);
        dto.setWriter(writer);

        if(image_url != null){
            dto.setImageUrl(image_url);
        }

        boardRepo.save(dto);
    }
}
