package com.example.crud.service;

import com.example.crud.entity.CommentEntity;
import com.example.crud.model.CommentDTO;
import com.example.crud.repository.CommentRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepo commentRepo;

    public CommentService(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    public List<CommentDTO> getComments(int board_no){

        List<CommentEntity> commnet = commentRepo.findByBoardNo(board_no);
        ArrayList<CommentDTO> list = new ArrayList<>();

        for(int i = 0; i<commnet.size(); i++){
            CommentDTO dto = new CommentDTO();

            dto.setComment_no(commnet.get(i).getCommentNo());
            dto.setBoard_no(commnet.get(i).getBoardNo());
            dto.setWriter(commnet.get(i).getWriter());
            dto.setContent(commnet.get(i).getContent());
            dto.setComment_date(commnet.get(i).getCommentDate());

            list.add(dto);
        }


        return list;
    }

    public void writeComment(String cont, String writer,int board_no){

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = now.format(formatter);

        CommentEntity comment = new CommentEntity();
        comment.setBoardNo(board_no);
        comment.setWriter(writer);
        comment.setContent(cont);
        comment.setCommentDate(time);

        commentRepo.save(comment);
    }
}
