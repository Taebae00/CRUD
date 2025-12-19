package com.example.crud.controller;

import com.example.crud.controller.service.BoardService;
import com.example.crud.model.BoardDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    private final BoardService boardService;

    public MainController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String index() {
        return "board";
    }

    @PostMapping("/get_board_list")
    @ResponseBody
    public List<BoardDTO> getBoardList() {

        List<BoardDTO> list = boardService.getBoardList();

        return list;
    }

    @GetMapping("/cont")
    public String cont(int no, Model model) {
        BoardDTO cont = boardService.getCont(no);
        model.addAttribute("cont", cont);

        return "cont";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }
}
