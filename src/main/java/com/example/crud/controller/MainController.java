package com.example.crud.controller;

import com.example.crud.config.S3Config;
import com.example.crud.model.CommentDTO;
import com.example.crud.model.UserDTO;
import com.example.crud.service.*;
import com.example.crud.model.BoardDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class MainController {

    private final BoardService boardService;
    private final UserService userService;
    private final S3Service s3Service;
    private final BoardLikeService boardLikeService;
    private final CommentService commentService;

    public MainController(BoardService boardService, UserService userService, UserService userService1, S3Config s3Config, S3Service s3Service, BoardLikeService boardLikeService, CommentService commentService) {
        this.boardService = boardService;
        this.userService = userService1;
        this.s3Service = s3Service;
        this.boardLikeService = boardLikeService;
        this.commentService = commentService;
    }

    @GetMapping("/")
    public String index()  {
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

        boardService.hitUp(no);
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

    @PostMapping("/checkName")
    @ResponseBody
    public int checkName(String nickname) {

        return userService.checkName(nickname);
    }

    @PostMapping("/checkId")
    @ResponseBody
    public int checkId(String id) {

        return userService.checkId(id);
    }

    @PostMapping("/joinOk")
    public void joinOk(String nickName, String id, String password, HttpServletResponse response) throws IOException {

        System.out.println("닉네임 : "+nickName);
        System.out.println("아이디 : "+id);
        System.out.println("비번 : "+password);

        int checkJoin = userService.joinOk(nickName, id, password);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        if (checkJoin < 0) {
            out.println("<script>");
            out.println("alert('회원가입에 실패하였습니다.')</script>\"");
            out.println("history.back();");
            out.println("</script>");
        }else {
            out.println("<script>");
            out.println("alert('회원가입에 성공하였습니다.');");
            out.println("location.href='/login';");
            out.println("</script>");
        }

    }

    @PostMapping("/loginCheck")
    @ResponseBody
    public Object loginCheck(String id, String password, HttpSession session) {

        UserDTO dto = userService.loginCheck(id, password);

        if(dto == null) {
            return 0;
        }

        session.setAttribute("user", dto);

        return dto;
    }

    @GetMapping("/loginOk")
    public String loginOk(){
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/write")
    public String write() {
        return "write";
    }

    @PostMapping("/writeOk")
    public String writeOk(@RequestParam String title,
                          @RequestParam String cont,
                          @RequestParam String writer,
                          @RequestParam(required = false) MultipartFile image) throws IOException {

        String image_url = s3Service.upload(image);

        boardService.write(title, cont, writer, image_url);

        return "redirect:/";
    }

    @PostMapping("/likeCheck")
    @ResponseBody
    public int likeCheck(String user, int board_no){

        return boardLikeService.likeCheck(user, board_no);
    }

    @PostMapping("/likeUp")
    @ResponseBody
    public BoardDTO likeUp(String user, int board_no){

        return boardLikeService.likeUp(user,board_no);
    }

    @PostMapping("/unlikeUp")
    @ResponseBody
    public BoardDTO UnlikeUp(String user, int board_no){

        return boardLikeService.UnlikeUp(user,board_no);
    }

    @PostMapping("/get_comments")
    @ResponseBody
    public List<CommentDTO> getComments(int board_no){

        return commentService.getComments(board_no);
    }

    @PostMapping("/write_comment")
    @ResponseBody
    public List<CommentDTO> writeComment(String cont, String writer, int board_no){

        commentService.writeComment(cont,writer,board_no);

        return commentService.getComments(board_no);
    }
}
